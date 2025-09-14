/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class SanPham {
    String MaSP,MaNL,TenSP,MoTa,LoaiSP;
    int GiaTien;

    public SanPham() {
    }

    public SanPham(String MaSP, String MaNL, String TenSP, String MoTa, String LoaiSP, int GiaTien) {
        this.MaSP = MaSP;
        this.MaNL = MaNL;
        this.TenSP = TenSP;
        this.MoTa = MoTa;
        this.LoaiSP = LoaiSP;
        this.GiaTien = GiaTien;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMaNL() {
        return MaNL;
    }

    public void setMaNL(String MaNL) {
        this.MaNL = MaNL;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }

    
}
