/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import Utilities.DBConnection;
import ViewModels.QLHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caoxu
 */
public class HoaDonRepository {

<<<<<<< Updated upstream
    public List<HoaDon> insert(String MaHD, String MaND, String MaKH, String NgayTao, float TongTien, int TrangThai) throws SQLException {
        ArrayList<HoaDon> k = new ArrayList<>();
=======
//    public List<HoaDon> insert(String MaHD, String MaND, String MaKH, String NgayTao, float TongTien, int TrangThai) throws SQLException {
//        ArrayList<HoaDon> k = new ArrayList<>();
//        try {
//            Connection con = DBConnection.getConnection();
//            String sql = "insert HoaDon (MaKH,MaND,MaHD,NgayTao,TongTien,TrangThai) values (?,?,?,?,?,?)";
//            PreparedStatement st = con.prepareStatement(sql);
//            st.setString(1, MaHD);
//            st.setString(2, MaND);
//            st.setString(3, MaKH);
//            st.setString(4, NgayTao);
//            st.setFloat(5, TongTien);
//            st.setInt(6, TrangThai);
//            HoaDon hd = new HoaDon();
//            hd.setMaHD(MaHD);
//            hd.setMaND(MaND);
//            hd.setMaKH(MaKH);
//            hd.setNgayTao(NgayTao);
//            hd.setTongTien(TongTien);
//            hd.setTrangThai(TrangThai);
//            k.add(hd);
//        } catch (Exception e) {
//            return null;
//        }
//        return k;
//    }

    public List<KhachHang> tim(String Sdt) throws SQLException {
        ArrayList<KhachHang> k = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
                String sql = "Select HoaDon.MaHD,HoaDon.MaND,HoaDon.NgayTao,KhachHang.MaKH,HoaDon.TrangThai,HoaDon.TongTien from KhachHang \n"
                    + "					join HoaDon on HoaDon.MaKH=KhachHang.MaKH where SDT=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, Sdt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String MaKH = rs.getString("MaKH");
                KhachHang kh = new KhachHang();
                kh.setMaKH(MaKH);
                k.add(kh);
            }
        } catch (Exception e) {
            return null;
        }
        return k;
    }

    public void insert(HoaDon sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO HoaDon (MaHD, MaND, MaKH, NgayTao, TongTien, TrangThai) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaHD());
            ps.setString(2, sp.getMaND());
            ps.setString(3, sp.getMaKH());
            java.sql.Date date = new java.sql.Date(sp.getNgayTao().getTime());
            ps.setDate(4, date);
            ps.setFloat(5, sp.getTongTien());
            ps.setInt(6, sp.getTrangThai());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<HoaDon> All() {
        ArrayList<HoaDon> list = new ArrayList<>();
>>>>>>> Stashed changes
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert HoaDon (MaKH,MaND,MaHD,NgayTao,TongTien,TrangThai) values (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaHD);
            st.setString(2, MaND);
            st.setString(3, MaKH);
            st.setString(4, NgayTao);
            st.setFloat(5, TongTien);
            st.setInt(6, TrangThai);
            HoaDon hd = new HoaDon();
            hd.setMaHD(MaHD);
            hd.setMaND(MaND);
            hd.setMaKH(MaKH);
            hd.setNgayTao(NgayTao);
            hd.setTongTien(TongTien);
            hd.setTrangThai(TrangThai);
            k.add(hd);
        } catch (Exception e) {
            return null;
        }
        return k;
    }

    public List<HoaDon> tim(String Sdt) throws SQLException {
        ArrayList<HoaDon> k = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Select HoaDon.MaHD,HoaDon.MaND,HoaDon.NgayTao,KhachHang.MaKH,HoaDon.TrangThai,HoaDon.TongTien from KhachHang \n"
                    + "					join HoaDon on HoaDon.MaKH=KhachHang.MaKH where SDT=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, Sdt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String MaHD = rs.getString("MaHD");
                String MaND = rs.getString("MaND");
                String MaKH = rs.getString("MaKH");
                String NgayTao = rs.getString("NgayTao");
                float TongTien = rs.getFloat("TongTien");
                int TrangThai = rs.getInt("TrangThai");
                HoaDon hd = new HoaDon();
                hd.setMaHD(MaHD);
                hd.setMaND(MaND);
                hd.setMaKH(MaKH);
                hd.setNgayTao(NgayTao);
                hd.setTongTien(TongTien);
                hd.setTrangThai(TrangThai);
                k.add(hd);
            }
        } catch (Exception e) {
            return null;
        }
        return k;
    }

}
