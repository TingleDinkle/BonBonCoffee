/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Mode.HoaDonChiTiet;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class HoaDonChiTietServices {
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    public static List<HoaDonChiTiet> getAll() {
        String sql = "select MaHDCT, MaHD, TenSP, SoLuongMua, TongTienThanhToan from HoaDonChiTiet join SanPham on SanPham.MaSP = HoaDonChiTiet.MaSP";
        try(Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            List<HoaDonChiTiet> list = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHDCT(rs.getString("MaHDCT"));
                hdct.setMaHD(rs.getString("MaHD"));
                hdct.setMaSP(rs.getString("TenSP"));
                hdct.setSoLuongMua(rs.getInt("SoLuongMua"));
                hdct.setTongTienThanhToan(rs.getFloat("TongTienThanhToan"));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<HoaDonChiTiet> TimKiem(String key,String chon){
        List<HoaDonChiTiet> hdctList = new ArrayList<>();
        String column = switch(chon){
            case"Mã hóa đơn chi tiết"->"MaHDCT";
            case"Mã hóa đơn"->"MaHD";
            case"Tên sản phẩm"->"SanPham.TenSP";
            default->null;
        };
        String sql = "select MaHDCT, MaHD, SanPham.TenSP, SoLuongMua, TongTienThanhToan from HoaDonChiTiet join SanPham on SanPham.MaSP = HoaDonChiTiet.MaSP WHERE " + column + " LIKE ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,"%"+key+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setMaHDCT(rs.getString("MaHDCT"));
                hdct.setMaHD(rs.getString("MaHD"));
                hdct.setMaSP(rs.getString("TenSP"));
                hdct.setSoLuongMua(rs.getInt("SoLuongMua"));
                hdct.setTongTienThanhToan(rs.getFloat("TongTienThanhToan"));
                hdctList.add(hdct);
            }
            return hdctList;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
