/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class HoaDon {
    String MaHD,MaNV,MaDH,NgayLapHD;
    int GiaTien;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaNV, String MaDH, String NgayLapHD, int GiaTien) {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaDH = MaDH;
        this.NgayLapHD = NgayLapHD;
        this.GiaTien = GiaTien;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getNgayLapHD() {
        return NgayLapHD;
    }

    public void setNgayLapHD(String NgayLapHD) {
        this.NgayLapHD = NgayLapHD;
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }

     
}
