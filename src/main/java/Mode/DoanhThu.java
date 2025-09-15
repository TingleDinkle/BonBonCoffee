/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author phonga
 */
public class DoanhThu {
    String Thang,SanPham,TongTien;
    int SoLuong;

    public DoanhThu() {
    }

    public DoanhThu(String Thang, String SanPham, String TongTien, int SoLuong) {
        this.Thang = Thang;
        this.SanPham = SanPham;
        this.TongTien = TongTien;
        this.SoLuong = SoLuong;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public String getSanPham() {
        return SanPham;
    }

    public void setSanPham(String SanPham) {
        this.SanPham = SanPham;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
}
