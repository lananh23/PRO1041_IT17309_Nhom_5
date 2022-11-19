/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author caoxu
 */
public class QLNPP {

    private String MaNPP;
    private String TenNPP;
    private String DiaChi;
    private String Sdt;

    public QLNPP() {
    }

    public QLNPP(String MaNPP, String TenNPP, String DiaChi, String Sdt) {
        this.MaNPP = MaNPP;
        this.TenNPP = TenNPP;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
    }

    public String getMaNPP() {
        return MaNPP;
    }

    public void setMaNPP(String MaNPP) {
        this.MaNPP = MaNPP;
    }

    public String getTenNPP() {
        return TenNPP;
    }

    public void setTenNPP(String TenNPP) {
        this.TenNPP = TenNPP;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    @Override
    public String toString() {
        return "QLNPP{" + "MaNPP=" + MaNPP + ", TenNPP=" + TenNPP + ", DiaChi=" + DiaChi + ", Sdt=" + Sdt + '}';
    }
    
    
}
