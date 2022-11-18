package Repositories;

import DomainModels.SanPhamLoi;
import java.util.List;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;


public class SanPhamLoiRepository implements ISanPhamLoiRepository{

    @Override
    public List<SanPhamLoi> All() {
        ArrayList<SanPhamLoi> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM SanPhamLoi";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String id = rs.getString("Id");
                String idSP = rs.getString("IdSP");
                String ma = rs.getString("MaSPL");
                String ten = rs.getString("TenSP");
                String loi = rs.getString("LyDoLoi");
                SanPhamLoi sp = new SanPhamLoi(id, idSP, ma, ten, loi);
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(SanPhamLoi sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO SanPhamLoi (IdSP, MaSPL, TenSP, LyDoLoi) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getIdSP());
            ps.setString(2, sp.getMaSPL());
            ps.setString(3, sp.getTenSPL());
            ps.setString(4, sp.getLyDoLoi());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, SanPhamLoi sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE SanPhamLoi SET IdSP =?, MaSPL=?, TenSP=?, LyDoLoi=?  WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getIdSP());
            ps.setString(2, sp.getMaSPL());
            ps.setString(3, sp.getTenSPL());
            ps.setString(4, sp.getLyDoLoi());
            ps.setString(5, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM SanPhamLoi  WHERE Id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
