package Repositories;

import DomainModels.HoaDon;
import Utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonRepository {
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
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM HoaDon";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maHD = rs.getString("MaHD");
                String maND = rs.getString("MaND");
                String maKH = rs.getString("MaKH");
                Date ngTao = rs.getDate("NgayTao");
                float tongTien = rs.getFloat("TongTien");
                int tt = rs.getInt("TrangThai");
                HoaDon sp = new HoaDon(maHD, maND, maKH, ngTao, tongTien, tt);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<HoaDon> AllCho() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT MaHD FROM HoaDon WHERE TrangThai =0 ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maHD = rs.getString("MaHD");
                HoaDon sp = new HoaDon(maHD);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
