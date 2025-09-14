/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;


import Mode.Kho;
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
public class KhoServices {
    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";
    
    public static List<Kho> getAll(){
        String sql = "select * from Kho";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            List<Kho> kList = new ArrayList<>();
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Kho k = new Kho();
                k.setMaNL(rs.getString("MaNL"));
                k.setTenNL(rs.getString("TenNL"));
                k.setSoLuong(rs.getFloat("SoLuong"));
                k.setDonVi(rs.getString("DonVi"));
                kList.add(k);
            }
            return kList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Kho getByName(String MaNL){
        String sql = "select * from Kho where MaNL = ?";
        Kho k = new Kho();
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,MaNL);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                k.setMaNL(rs.getString("MaNL"));
                k.setTenNL(rs.getString("TenNL"));
                k.setSoLuong(rs.getFloat("SoLuong"));
                k.setDonVi(rs.getString("DonVi"));
            }
            return k;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Kho> TimKiem(String key,String chon){
        List<Kho> kList = new ArrayList<>();
        String column = switch(chon){
            case"Mã nguyên liệu"->"MaNL";
            case"Tên nguyên liệu"->"TenNL";
            default->null;
        };
        String sql = "SELECT * FROM Kho WHERE " + column + " LIKE ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,"%"+key+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Kho k = new Kho();
                k.setMaNL(rs.getString("MaNL"));
                k.setTenNL(rs.getString("TenNL"));
                k.setSoLuong(rs.getFloat("SoLuong"));
                k.setDonVi(rs.getString("DonVi"));
                kList.add(k);
            }
            return kList;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean Create(Kho k){
        String sql = "insert into Kho(MaNL,TenNL,SoLuong,DonVi) values(?,?,?,?)";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,k.getMaNL());
            stm.setString(2,k.getTenNL());
            stm.setString(3,String.valueOf(k.getSoLuong()));
            stm.setString(4,k.getDonVi());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Update(Kho k){
        String sql = "update Kho set TenNL = ?, SoLuong = ?, DonVi = ? WHERE MaNL = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(4,k.getMaNL());
            stm.setString(1,k.getTenNL());
            stm.setString(2,String.valueOf(k.getSoLuong()));
            stm.setString(3,k.getDonVi());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean Delete(Kho k){
        String sql = "delete from Kho where MaNL=?";
        try (Connection con = DriverManager.getConnection(connectionUrl);PreparedStatement stm = con.prepareStatement(sql)){
            stm.setString(1,k.getMaNL());
            return stm.executeUpdate()>0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
