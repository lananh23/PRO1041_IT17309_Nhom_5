/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import DomainModels.NhaPhanPhoi;
import Utilities.DBConnection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caoxu
 */
public class NhaPhanPhoiRP {

    public List<NhaPhanPhoi> select() throws SQLException {
        ArrayList<NhaPhanPhoi> n1 = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "select * from NhaPhanPhoi";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String Ma = rs.getString("MaNPP");
            String Ten = rs.getString("TenNPP");
            String DiaChi = rs.getString("DiaChi");
            String Sdt = rs.getString("SDT");
            NhaPhanPhoi n = new NhaPhanPhoi();
            n.setMaNPP(Ma);
            n.setTenNPP(Ten);
            n.setDiaChi(DiaChi);
            n.setSdt(Sdt);
            n1.add(n);
        }
        return n1;
    }

    public List<NhaPhanPhoi> select1(String ma) throws SQLException {
        ArrayList<NhaPhanPhoi> n1 = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "select * from NhaPhanPhoi where MaNPP =?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, ma);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            String Ma = rs.getString("MaNPP");
            String Ten = rs.getString("TenNPP");
            String DiaChi = rs.getString("DiaChi");
            String Sdt = rs.getString("SDT");
            NhaPhanPhoi n = new NhaPhanPhoi();
            n.setMaNPP(Ma);
            n.setTenNPP(Ten);
            n.setDiaChi(DiaChi);
            n.setSdt(Sdt);
            n1.add(n);
        }
        return n1;
    }

    public List<NhaPhanPhoi> insert(String Ma, String Ten, String DiaChi, String SDT) throws SQLException {
        ArrayList<NhaPhanPhoi> n1 = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "insert NhaPhanPhoi (MaNPP,TenNPP,DiaChi,SDT) values (?,?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, Ma);
        st.setString(2, Ten);
        st.setString(3, DiaChi);
        st.setString(4, SDT);
        st.executeUpdate();
        NhaPhanPhoi n = new NhaPhanPhoi();
        n.setMaNPP(Ma);
        n.setTenNPP(Ten);
        n.setDiaChi(DiaChi);
        n.setSdt(SDT);
        n1.add(n);
        return n1;
    }

    public List<NhaPhanPhoi> update(String Ma, String Ten, String DiaChi, String SDT) throws SQLException {
        ArrayList<NhaPhanPhoi> n1 = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "update NhaPhanPhoi set TenNPP=?,DiaChi=?, SDT=? where MaNPP=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(4, Ma);
        st.setString(1, Ten);
        st.setString(2, DiaChi);
        st.setString(3, SDT);
        st.executeUpdate();
        NhaPhanPhoi n = new NhaPhanPhoi();
        n.setMaNPP(Ma);
        n.setTenNPP(Ten);
        n.setDiaChi(DiaChi);
        n.setSdt(SDT);
        n1.add(n);
        return n1;
    }

    public List<NhaPhanPhoi> delete(String Ma) throws SQLException {
        ArrayList<NhaPhanPhoi> n1 = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "delete from NhaPhanPhoi where MaNPP=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, Ma);
        st.executeUpdate();
        NhaPhanPhoi n = new NhaPhanPhoi();
        n.setMaNPP(Ma);
        n1.add(n);
        return n1;
    }
}
