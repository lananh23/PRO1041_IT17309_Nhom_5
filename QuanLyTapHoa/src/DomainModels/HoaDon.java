package DomainModels;

import java.math.BigDecimal;
import java.util.Date;


public class HoaDon {
    private String maHD;
    private String maND;
    private String maKH;
    private String maHD_2;
    private Date ngayTao;
    private float tongTien;
    private int trangThai;

    public HoaDon(String maHD, String maND, String maKH, Date ngayTao, float tongTien, int trangThai) {
        this.maHD = maHD;
        this.maND = maND;
        this.maKH = maKH;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHD, String maND, String maKH) {
        this.maHD = maHD;
        this.maND = maND;
        this.maKH = maKH;
    }

    public HoaDon(String maHD, String maND, String maKH, String maHD_2) {
        this.maHD = maHD;
        this.maND = maND;
        this.maKH = maKH;
        this.maHD_2 = maHD_2;
    }

    public String getMaHD_2() {
        return maHD_2;
    }

    public void setMaHD_2(String maHD_2) {
        this.maHD_2 = maHD_2;
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }
    

    public HoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

   
    
}
