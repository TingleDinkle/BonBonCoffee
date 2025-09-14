/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


import Mode.NhanVien;
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
public class NhanVienSevices {
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    
    public static List<NhanVien> getAll(){
        String sql = "select MaNV, HoTenNV, VaiTro, YEAR(GETDATE()) - Tuoi AS Tuoi, SDT, GioiTinh from NhanVien";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            List<NhanVien> nvList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                nv.setVaiTro(rs.getString("VaiTro"));
                nv.setTuoi(rs.getInt("Tuoi"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setSDT(rs.getString("SDT"));
                nvList.add(nv);
            }
            return nvList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static NhanVien getByName(String MaNV){
        String sql = "select MaNV, HoTenNV, VaiTro,Tuoi, SDT, GioiTinh from NhanVien where MaNV = ?";
        NhanVien nv = new NhanVien();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,MaNV);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                nv.setVaiTro(rs.getString("VaiTro"));
                nv.setTuoi(rs.getInt("Tuoi"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setSDT(rs.getString("SDT"));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<NhanVien> TimKiem(String key,String chon){
        List<NhanVien> nvList = new ArrayList<>();
        String column = switch(chon){
            case"Mã nhân viên"->"MaNV";
            case"Tên nhân viên"->"HoTenNV";
            default->null;
        };
        String sql = "SELECT * FROM NhanVien WHERE " + column + " LIKE ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,"%"+key+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                nv.setVaiTro(rs.getString("VaiTro"));
                nv.setTuoi(rs.getInt("Tuoi"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setSDT(rs.getString("SDT"));
                nvList.add(nv);
            }
            return nvList;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean Create(NhanVien nv){
        String sql = "insert into NhanVien(MaNV,HoTenNV,VaiTro,Tuoi,SDT,GioiTinh) values(?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,nv.getMaNV());
            stm.setString(2,nv.getHoTenNV());
            stm.setString(3,nv.getVaiTro());
            stm.setString(4,String.valueOf(nv.getTuoi()));
            stm.setString(5,String.valueOf(nv.getSDT()));
            stm.setString(6,String.valueOf(nv.getGioiTinh()));
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Update(NhanVien nv){
        String sql = "update NhanVien set HoTenNV = ?, VaiTro = ?, Tuoi = ?, SDT=?, GioiTinh=?  WHERE MaNV = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(6,nv.getMaNV());
            stm.setString(1,nv.getHoTenNV());
            stm.setString(2,nv.getVaiTro());
            stm.setString(3,String.valueOf(nv.getTuoi()));
            stm.setString(4,String.valueOf(nv.getSDT()));
            stm.setString(5,String.valueOf(nv.getGioiTinh()));
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Delete(NhanVien nv){
        String sql = "delete from NhanVien where MaNV=?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,nv.getMaNV());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
