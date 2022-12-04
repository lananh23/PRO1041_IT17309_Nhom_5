package Repositories;

import DomainModels.HoaDonChiTiet;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDonCTRepository {
        Connection connection;
    PreparedStatement ps;
    ResultSet rs;
        List<HoaDonChiTiet> listHoaDonChiTiets;

    public void insert(HoaDonChiTiet sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO HoaDonChiTiet (MaHDCT,MaHD, MaSP, SoLuong, DonGia, ThanhTien, Ma_HDCT_Cu) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaHDCT());
            ps.setString(2, sp.getMaHD());
            ps.setString(3, sp.getMaSP());
            ps.setFloat(4, sp.getSoLuong());
            ps.setFloat(5, sp.getGiaBan());
            ps.setFloat(6, sp.getThanhTien());
            ps.setString(7, sp.getMaCu());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    public List<HoaDonChiTiet> AllSP(String ma) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT MaSP, SoLuong, DonGia, ThanhTien FROM HoaDonChiTiet WHERE MaHD = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maSP = rs.getString("MaSP");
                int soLuong = rs.getInt("SoLuong");
                float donGia = rs.getFloat("DonGia");
                float thanhTien = rs.getFloat("ThanhTien");
                HoaDonChiTiet sp = new HoaDonChiTiet(maSP, soLuong, donGia, thanhTien);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDonChiTiet> getAll() {

        listHoaDonChiTiets = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT MaSP, MaHD, MaHDCT, SoLuong, DonGia, ThanhTien  FROM  HoaDonChiTiet";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                String maSP = rs.getString("MaSP");
                String maHD = rs.getString("MaHD");
                String maHDCT = rs.getString("MaHDCT");
                int soLuong = rs.getInt("SoLuong");
                float donGia = rs.getFloat("DonGia");
                float thanhTien = rs.getFloat("ThanhTien");

                listHoaDonChiTiets.add(new HoaDonChiTiet(maHDCT, maHD, maSP, soLuong, donGia, thanhTien));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return listHoaDonChiTiets;
    }

    public List<HoaDonChiTiet> shearchMaSP(String maSP) {

        listHoaDonChiTiets = new ArrayList<>();
        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT MaSP, MaHD, MaHDCT, SoLuong, DonGia, ThanhTien"
                    + " FROM  HoaDonChiTiet WHERE MaSP = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, maSP);
            rs = ps.executeQuery();
            while (rs.next()) {

                String maSPP = rs.getString("MaSP");
                String maHD = rs.getString("MaHD");
                String maHDCT = rs.getString("MaHDCT");
                int soLuong = rs.getInt("SoLuong");
                float donGia = rs.getFloat("DonGia");
                float thanhTien = rs.getFloat("ThanhTien");

                listHoaDonChiTiets.add(new HoaDonChiTiet(maHDCT, maHD, maSPP, soLuong, donGia, thanhTien));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return listHoaDonChiTiets;

    }
}
