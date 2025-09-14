/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author Admin
 */
public class Kho {
    String MaNL,TenNL,DonVi;
    float SoLuong;

    public Kho() {
    }

    public Kho(String MaNL, String TenNL, String DonVi, float SoLuong) {
        this.MaNL = MaNL;
        this.TenNL = TenNL;
        this.DonVi = DonVi;
        this.SoLuong = SoLuong;
    }

    public String getMaNL() {
        return MaNL;
    }

    public void setMaNL(String MaNL) {
        this.MaNL = MaNL;
    }

    public String getTenNL() {
        return TenNL;
    }

    public void setTenNL(String TenNL) {
        this.TenNL = TenNL;
    }

    public String getDonVi() {
        return DonVi;
    }

    public void setDonVi(String DonVi) {
        this.DonVi = DonVi;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
