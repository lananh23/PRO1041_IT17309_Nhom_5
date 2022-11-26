package Repositories;

import DomainModels.HoaDonChiTiet;
import Utilities.DBConnection;
import java.sql.*;

public class HoaDonCTRepository {
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
}
