/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Mode.DonHang;
import Mode.KhachHang;
import Mode.NhanVien;
import Mode.SanPham;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class DonHangServices {

    static String connectionUrl = "jdbc:sqlserver://26.107.57.204:1433;databaseName=DATN_PRO230;user=datn;password=123;trustServerCertificate=true";

    public static boolean Insert(DonHang dh) {
        String sql = "INSERT INTO DonHang (MaDH,MaNV, MaKH, MaSP, Size, SoLuong, NgayDatHang, HinhThucThanhToan, TongTien) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, dh.getMaDH());
            ps.setString(2, dh.getMaNV());
            ps.setString(3, dh.getMaKH());
            ps.setString(4, dh.getMaSP());
            ps.setString(5, dh.getSize());
            ps.setInt(6, dh.getSoLuong());
            ps.setDate(7, new java.sql.Date(dh.getNgayDatHang().getTime()));
            ps.setString(8, dh.getHinhThucThanhToan());
            ps.setInt(9, dh.getTongTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean Update(DonHang dh) {
        String sql = "update DonHang set MaNV = ?, MaKH = ?, MaSP = ?, Size = ?, SoLuong = ?, NgayDatHang = ?, HinhThucThanhToan = ?, TongTien = ?  WHERE MaDH = ?";
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(9, dh.getMaDH());
            ps.setString(1, dh.getMaNV());
            ps.setString(2, dh.getMaKH());
            ps.setString(3, dh.getMaSP());
            ps.setString(4, dh.getSize());
            ps.setInt(5, dh.getSoLuong());
            ps.setDate(6, new java.sql.Date(dh.getNgayDatHang().getTime()));
            ps.setString(7, dh.getHinhThucThanhToan());
            ps.setInt(8, dh.getTongTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean Delete(DonHang dh) {
        String sql = "delete from DonHang where MaDH=?";
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, dh.getMaDH());
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<DonHang> getAll() {
        String sql = "select MaDH,HoTenNV, TenKH, TenSP, Size, SoLuong, NgayDatHang, HinhThucThanhToan, TongTien from DonHang \n"
                + "join NhanVien on NhanVien.MaNV = DonHang.MaNV\n"
                + "join KhachHang on KhachHang.MaKH = DonHang.MaKH\n"
                + "join SanPham on SanPham.MaSP = DonHang.MaSP";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql);) {
            List<DonHang> dhlist = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("HoTenNV"));
                dh.setMaKH(rs.getString("TenKH"));
                dh.setMaSP(rs.getString("TenSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getDate("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
                dhlist.add(dh);
            }
            return dhlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DonHang getByName(String MaDH) {
        String sql = "select * from DonHang where MaDH = ?";
        DonHang dh = new DonHang();
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaDH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("MaNV"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setMaSP(rs.getString("MaSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getDate("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
            }
            return dh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<DonHang> getById(String MaDH) {
        String sql = "select * from DonHang where MaDH = ?";
        DonHang dh = new DonHang();
        try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaDH);
            List<DonHang> dhList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dh.setMaDH(rs.getString("MaDH"));
                dh.setMaNV(rs.getString("MaNV"));
                dh.setMaKH(rs.getString("MaKH"));
                dh.setMaSP(rs.getString("MaSP"));
                dh.setSize(rs.getString("Size"));
                dh.setSoLuong(rs.getInt("SoLuong"));
                dh.setNgayDatHang(rs.getDate("NgayDatHang"));
                dh.setHinhThucThanhToan(rs.getString("HinhThucThanhToan"));
                dh.setTongTien(rs.getInt("TongTien"));
                dhList.add(dh);
            }
            return dhList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getGiaSanPham(String maSP) {
        int gia = 0;
        String query = "SELECT GiaTien FROM SanPham WHERE MaSP = ?";

        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, maSP);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                gia = rs.getInt("GiaTien");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return gia;
    }

    public static boolean checkStockBeforeAdd(String maSP, int soLuongMua) {
        String query = "SELECT k.SoLuong FROM Kho k JOIN SanPham sp ON k.MaNL = sp.MaNL WHERE sp.MaSP = ?";

        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maSP);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int soLuongTrongKho = rs.getInt("SoLuong");
                return soLuongMua <= soLuongTrongKho;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<NhanVien> getTenNhanVienThuNgan() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT MaNV, HoTenNV FROM NhanVien WHERE VaiTro = 'Thu ngân'";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<KhachHang> getTenKhach() {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT MaKH, TenKH FROM KhachHang";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<SanPham> getTenSP() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT MaSp, TenSP FROM SanPham";
        try (Connection conn = DriverManager.getConnection(connectionUrl); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SanPham kh = new SanPham();
                kh.setMaSP(rs.getString("MaSP"));
                kh.setTenSP(rs.getString("TenSP"));
                list.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
