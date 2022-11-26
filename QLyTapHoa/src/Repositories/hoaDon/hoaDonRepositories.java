/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.hoaDon;

import DomainModels.hoaDon;
import Services.ThongBao.thongBao;
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
public class hoaDonRepositories implements IsHoaDonRepositories {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    List<hoaDon> listHoaDons;

    @Override
    public List<hoaDon> getAll() {

        listHoaDons = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String sql = " SELECT * FROM  HoaDon";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                String maND = rs.getString(1);
                String maKH = rs.getString(2);
                String maHD = rs.getString(3);
                String ngayTao = rs.getString(4);
                BigDecimal tongTien = rs.getBigDecimal(5);
                int trangThai = rs.getInt(6);

                listHoaDons.add(new hoaDon(maND, maKH, maHD, ngayTao, tongTien, trangThai));

               
            }
            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return listHoaDons;
    }

    @Override
    public List<hoaDon> shearchMaHD(String maHD) {

        listHoaDons = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String sql = " SELECT * FROM  HoaDon WHERE MaHD = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, maHD);
            rs = ps.executeQuery();
            while (rs.next()) {

                String maND = rs.getString(1);
                String maKH = rs.getString(2);
                String maHDD = rs.getString(3);
                String ngayTao = rs.getString(4);
                BigDecimal tongTien = rs.getBigDecimal(5);
                int trangThai = rs.getInt(6);

                listHoaDons.add(new hoaDon(maND, maKH, maHDD, ngayTao, tongTien, trangThai));

            }

            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return listHoaDons;

    }

}
