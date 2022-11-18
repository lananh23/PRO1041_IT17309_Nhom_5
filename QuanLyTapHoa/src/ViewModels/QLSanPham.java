package ViewModels;

import java.util.Date;

public class QLSanPham {

    private String maSP;
    private String idLSP;
    private String idNPP;
    private String tenSP;
    private int soLuong;
    private float giaNhap;
    private float giaBan;
    private Date hanSuDung;
    private String moTa;

    public QLSanPham() {
    }

    public QLSanPham(String maSP, String idLSP, String idNPP, String tenSP, int soLuong, float giaNhap, float giaBan, Date hanSuDung, String moTa) {
        this.maSP = maSP;
        this.idLSP = idLSP;
        this.idNPP = idNPP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.hanSuDung = hanSuDung;
        this.moTa = moTa;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getIdLSP() {
        return idLSP;
    }

    public void setIdLSP(String idLSP) {
        this.idLSP = idLSP;
    }

    public String getIdNPP() {
        return idNPP;
    }

    public void setIdNPP(String idNPP) {
        this.idNPP = idNPP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
