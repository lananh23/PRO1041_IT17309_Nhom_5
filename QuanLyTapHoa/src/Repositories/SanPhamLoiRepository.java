package Repositories;

import DomainModels.SanPhamLoi;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class SanPhamLoiRepository {
    public List<SanPhamLoi> All() {
        ArrayList<SanPhamLoi> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM SanPhamLoi";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maSPL = rs.getString("MaSPL");
                String maSP = rs.getString("MaSP");
                String loi = rs.getString("LyDoLoi");
                SanPhamLoi sp = new SanPhamLoi(maSPL, maSP, loi);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(SanPhamLoi sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO SanPhamLoi (MaSPL, MaSP, LyDoLoi) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaSPL());
            ps.setString(2, sp.getMaSP());
            ps.setString(3, sp.getLyDoLoi());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String ma, SanPhamLoi sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE SanPhamLoi SET MaSP =?, LyDoLoi=?  WHERE MaSPL=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getLyDoLoi());
            ps.setString(3, ma);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String ma) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM SanPhamLoi  WHERE MaSPL=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, ma);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
