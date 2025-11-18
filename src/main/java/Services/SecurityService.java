/*
 * Security Service
 * Handles authentication, authorization, and security operations
 */
package Services;

import Mode.NguoiDung;
import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.regex.Pattern;

/**
 * Security service for authentication and authorization
 *
 * @author Security Refactor
 */
public class SecurityService {

    private static final Logger LOGGER = Logger.getLogger(SecurityService.class.getName());

    // Password security constants
    private static final int BCRYPT_COST = 12;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final Pattern PASSWORD_PATTERN =
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");

    // Session management (simple in-memory for now)
    private static String currentUser = null;
    private static String currentUserRole = null;

    /**
     * Authenticate user with secure password verification
     */
    public static boolean authenticateUser(String username, String plainPassword) {
        if (username == null || username.trim().isEmpty() || plainPassword == null) {
            return false;
        }

        String sql = "SELECT VaiTro, MatKhau FROM NguoiDung WHERE TenDangNhap = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username.trim());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("MatKhau");
                boolean role = rs.getBoolean("VaiTro");

                // Check if password is hashed (starts with $2) or plain text
                boolean passwordValid = false;
                if (hashedPassword.startsWith("$2")) {
                    // BCrypt hash
                    passwordValid = BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified;
                } else {
                    // Legacy plain text for backward compatibility (should be migrated)
                    passwordValid = hashedPassword.equals(plainPassword);
                    if (passwordValid) {
                        LOGGER.warning("Plain text password detected for user: " + username +
                                     ". Password should be upgraded to hashed format.");
                    }
                }

                if (passwordValid) {
                    currentUser = username;
                    currentUserRole = role ? "Manager" : "Employee";
                    LOGGER.info("User authenticated: " + username + " with role: " + currentUserRole);
                    return true;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Authentication error for user: " + username, e);
        }

        LOGGER.warning("Authentication failed for user: " + username);
        return false;
    }

    /**
     * Validate password strength
     */
    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    /**
     * Hash password using BCrypt
     */
    public static String hashPassword(String plainPassword) {
        if (plainPassword == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        return BCrypt.withDefaults().hashToString(BCRYPT_COST, plainPassword.toCharArray());
    }

    /**
     * Update user password (with hashing)
     */
    public static boolean changePassword(String username, String oldPassword, String newPassword) {
        // First verify old password
        if (!authenticateUser(username, oldPassword)) {
            return false;
        }

        // Validate new password
        if (!isPasswordValid(newPassword)) {
            return false;
        }

        String sql = "UPDATE NguoiDung SET MatKhau = ? WHERE TenDangNhap = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String hashedPassword = hashPassword(newPassword);
            ps.setString(1, hashedPassword);
            ps.setString(2, username);

            int rowsAffected = ps.executeUpdate();
            boolean success = rowsAffected > 0;

            if (success) {
                LOGGER.info("Password changed successfully for user: " + username);
            }

            return success;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Password change error for user: " + username, e);
        }

        return false;
    }

    /**
     * Get current logged-in user
     */
    public static String getCurrentUser() {
        return currentUser;
    }

    /**
     * Get current user role
     */
    public static String getCurrentUserRole() {
        return currentUserRole;
    }

    /**
     * Check if current user has manager privileges
     */
    public static boolean isCurrentUserManager() {
        return "Manager".equals(currentUserRole);
    }

    /**
     * Logout current user
     */
    public static void logout() {
        LOGGER.info("User logged out: " + currentUser);
        currentUser = null;
        currentUserRole = null;
    }

    /**
     * Secure input validation
     */
    public static String sanitizeString(String input) {
        if (input == null) {
            return null;
        }
        // Remove potentially dangerous characters
        return input.trim().replaceAll("[<>\"';&]", "");
    }

    /**
     * Validate integer input
     */
    public static Integer validateInteger(String input) {
        try {
            return Integer.parseInt(sanitizeString(input));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Validate phone number
     */
    public static boolean isValidPhoneNumber(String phone) {
        if (phone == null) {
            return false;
        }
        return phone.matches("^\\d{10}$");
    }
}
