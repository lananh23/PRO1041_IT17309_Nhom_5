/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.hoaDonChiTiet;

import DomainModels.hoaDonChiTiet;
import Utilities.DBConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hoaDonChiTietRepositories implements IsHoaDonChiTietRepositories {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    List<hoaDonChiTiet> listHoaDonChiTiets;

    @Override
    public List<hoaDonChiTiet> getAll() {

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
                BigDecimal donGia = rs.getBigDecimal("DonGia");
                BigDecimal thanhTien = rs.getBigDecimal("ThanhTien");

                listHoaDonChiTiets.add(new hoaDonChiTiet(maSP, maHD, maHDCT, soLuong, donGia, thanhTien));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return listHoaDonChiTiets;
    }

    @Override
    public List<hoaDonChiTiet> shearchMaSP(String maSP) {

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
                BigDecimal donGia = rs.getBigDecimal("DonGia");
                BigDecimal thanhTien = rs.getBigDecimal("ThanhTien");

                listHoaDonChiTiets.add(new hoaDonChiTiet(maSPP, maHD, maHDCT, soLuong, donGia, thanhTien));
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
