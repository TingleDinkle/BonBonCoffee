/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {
    String MaHDCT,MaHD,MaSP;
    int SoLuongMua;
    float TongTienThanhToan;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String MaHDCT, String MaHD, String MaSP, int SoLuongMua, float TongTienThanhToan) {
        this.MaHDCT = MaHDCT;
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.SoLuongMua = SoLuongMua;
        this.TongTienThanhToan = TongTienThanhToan;
    }

    public String getMaHDCT() {
        return MaHDCT;
    }

    public void setMaHDCT(String MaHDCT) {
        this.MaHDCT = MaHDCT;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getSoLuongMua() {
        return SoLuongMua;
    }

    public void setSoLuongMua(int SoLuongMua) {
        this.SoLuongMua = SoLuongMua;
    }

    public float getTongTienThanhToan() {
        return TongTienThanhToan;
    }

    public void setTongTienThanhToan(float TongTienThanhToan) {
        this.TongTienThanhToan = TongTienThanhToan;
    }
    
    
}
