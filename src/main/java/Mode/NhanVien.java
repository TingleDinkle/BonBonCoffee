/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class NhanVien {
    String MaNV, HoTenNV, VaiTro, SDT;
    int Tuoi, GioiTinh;

    

    public NhanVien() {
    }

    public NhanVien(String MaNV, String HoTenNV, String VaiTro, String SDT, int Tuoi, int GioiTinh) {
        this.MaNV = MaNV;
        this.HoTenNV = HoTenNV;
        this.VaiTro = VaiTro;
        this.SDT = SDT;
        this.Tuoi = Tuoi;
        this.GioiTinh = GioiTinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    
    
}
