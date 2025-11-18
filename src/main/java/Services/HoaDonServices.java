/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Mode.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Secure HoaDon service with proper SQL injection prevention
 *
 * @author Admin, Security Refactor
 */
public class HoaDonServices {
    private static final Logger LOGGER = Logger.getLogger(HoaDonServices.class.getName());
    public static List<HoaDon> getAll() {
        String sql = "select MaHD,HoTenNV,MaDH,NgayLapHD,GiaTien from HoaDon join NhanVien on NhanVien.MaNV = HoaDon.MaNV";
        try(Connection conn = DatabaseConfig.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            List<HoaDon> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("HoTenNV"));
                hd.setMaDH(rs.getString("MaDH"));
                hd.setNgayLapHD(rs.getString("NgayLapHD"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error getting all HoaDon records", e);
        }
        return null;
    }

    public static List<HoaDon> TimKiem(String key, String chon) {
        // Validate input to prevent SQL injection
        if (key == null || key.trim().isEmpty() || chon == null || chon.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Use pre-validated column names instead of string concatenation
        String column;
        String sql;
        switch (chon.trim()) {
            case "Mã hóa đơn":
                column = "MaHD";
                sql = "select MaHD,NhanVien.HoTenNV,MaDH,NgayLapHD,GiaTien from HoaDon join NhanVien on NhanVien.MaNV = HoaDon.MaNV WHERE MaHD LIKE ?";
                break;
            case "Tên nhân viên":
                column = "NhanVien.HoTenNV";
                sql = "select MaHD,NhanVien.HoTenNV,MaDH,NgayLapHD,GiaTien from HoaDon join NhanVien on NhanVien.MaNV = HoaDon.MaNV WHERE NhanVien.HoTenNV LIKE ?";
                break;
            case "Mã đơn hàng":
                column = "MaDH";
                sql = "select MaHD,NhanVien.HoTenNV,MaDH,NgayLapHD,GiaTien from HoaDon join NhanVien on NhanVien.MaNV = HoaDon.MaNV WHERE MaDH LIKE ?";
                break;
            default:
                LOGGER.warning("Invalid search column specified: " + chon);
                return new ArrayList<>();
        }

        try (Connection con = DatabaseConfig.getConnection();
             PreparedStatement stm = con.prepareStatement(sql)) {

            // Sanitize search key and use parameterized query
            String sanitizedKey = SecurityService.sanitizeString(key);
            stm.setString(1, "%" + sanitizedKey + "%");

            List<HoaDon> hdList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setMaNV(rs.getString("HoTenNV"));
                hd.setMaDH(rs.getString("MaDH"));
                hd.setNgayLapHD(rs.getString("NgayLapHD"));
                hd.setGiaTien(rs.getInt("GiaTien"));
                hdList.add(hd);
            }
            return hdList;

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error searching HoaDon records", e);
        }
        return null;
    }
}
