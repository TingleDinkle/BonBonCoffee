/*
 * Database Configuration Utility
 * Secure database connection management
 */
package Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Secure database configuration and connection utility
 *
 * @author Security Refactor
 */
public class DatabaseConfig {

    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());
    private static final String CONFIG_FILE = "/database.properties";
    private static Properties properties;

    // Load properties file at class loading time
    static {
        Properties tempProperties = new Properties();
        InputStream input = null;
        try {
            input = DatabaseConfig.class.getResourceAsStream(CONFIG_FILE);
            if (input == null) {
                LOGGER.log(Level.SEVERE, "Database configuration file not found: " + CONFIG_FILE);
                throw new RuntimeException("Database configuration file not found: " + CONFIG_FILE);
            }
            tempProperties.load(input);
            LOGGER.info("Database configuration loaded successfully");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error loading database configuration", e);
            throw new RuntimeException("Failed to load database configuration", e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Failed to close input stream", e);
                }
            }
        }
        properties = tempProperties;
    }

    /**
     * Get database connection URL
     */
    public static String getConnectionUrl() {
        String server = properties.getProperty("db.server");
        String port = properties.getProperty("db.port");
        String database = properties.getProperty("db.database");
        String encrypt = properties.getProperty("db.encrypt", "true");
        String trustServer = properties.getProperty("db.trustServerCertificate", "false");

        return String.format("jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=%s;trustServerCertificate=%s",
                           server, port, database, encrypt, trustServer);
    }

    /**
     * Get database username
     */
    public static String getUsername() {
        return properties.getProperty("db.username");
    }

    /**
     * Get database password
     */
    public static String getPassword() {
        return properties.getProperty("db.password");
    }

    /**
     * Get a database connection
     */
    public static Connection getConnection() throws SQLException {
        try {
            String url = getConnectionUrl();
            String username = getUsername();
            String password = getPassword();

            Connection conn = DriverManager.getConnection(url, username, password);
            LOGGER.fine("Database connection established successfully");
            return conn;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to establish database connection", e);
            throw e;
        }
    }
}
