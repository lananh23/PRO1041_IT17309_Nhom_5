package Repositories;

import DomainModels.SanPham;
import java.util.List;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

public class SanPhamRepository implements ISanPhamRepository {

    @Override
    public List<SanPham> All() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "select MaSP, IdLSP, IdNPP, TenSP, SoLuong, GiaNhap, GiaBan, HanSuDung, MoTa from SanPham ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String maSP = rs.getString("MaSP");
                String idLSP = rs.getString("IdLSP");
                String idNPP = rs.getString("IdNPP");
                String tenSP = rs.getString("TenSP");
                int soLuong = rs.getInt("SoLuong");
                float giaNhap = rs.getFloat("GiaNhap");
                float giaBan = rs.getFloat("GiaBan");
                Date hanSuDung = rs.getDate("HanSuDung");
                String moTa = rs.getString("MoTa");

                SanPham sp = new SanPham(maSP, idLSP, idNPP, tenSP, soLuong, giaNhap, giaBan, hanSuDung, moTa);

                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void insert(SanPham sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO SanPham (MaSP, IdLSP, IdNPP, TenSP, SoLuong, GiaNhap, GiaBan, HanSuDung, MoTa) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getIdLSP());
            ps.setString(3, sp.getIdNPP());
            ps.setString(4, sp.getTenSP());
            ps.setInt(5, sp.getSoLuong());
            ps.setFloat(6, sp.getGiaNhap());
            ps.setFloat(7, sp.getGiaBan());
            ps.setDate(8, (Date) sp.getHanSuDung());
            ps.setString(9, sp.getMoTa());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String maSP, SanPham sp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE SanPham SET MaSP=?, IdLSP=?, IdNPP=?, TenSP=?, SoLuong=?, GiaNhap=?, GiaBan=?, HanSuDung=?, MoTa=?  WHERE maSP=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getIdLSP());
            ps.setString(3, sp.getIdNPP());
            ps.setString(4, sp.getTenSP());
            ps.setInt(5, sp.getSoLuong());
            ps.setFloat(6, sp.getGiaNhap());
            ps.setFloat(7, sp.getGiaBan());
            ps.setDate(8, (Date) sp.getHanSuDung());
            ps.setString(9, sp.getMoTa());
            ps.setString(10, maSP);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String maSP) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM SanPham  WHERE maSP=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, maSP);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
