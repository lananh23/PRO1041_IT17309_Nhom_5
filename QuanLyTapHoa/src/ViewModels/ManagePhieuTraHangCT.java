
package ViewModels;


public class ManagePhieuTraHangCT {
    private String maPTH;
    private String maSP;
    private int soLuong;
    private double donGia ;
    private double thanhTien;

    public ManagePhieuTraHangCT() {
    }

    public ManagePhieuTraHangCT(String maPTH, String maSP, int soLuong, double donGia, double thanhTien) {
        this.maPTH = maPTH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public String getMaPTH() {
        return maPTH;
    }

    public void setMaPTH(String maPTH) {
        this.maPTH = maPTH;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
