/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mode;

/**
 *
 * @author hongd
 */
public class NguoiDung {
    String TenDangNhap,MatKhau;
    int VaiTro;

    public NguoiDung() {
    }

    public NguoiDung(String TenDangNhap, String MatKhau, int VaiTro) {
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(int VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
