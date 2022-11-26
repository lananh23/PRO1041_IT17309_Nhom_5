/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.dangNhap;

import DomainModels.dangNhapModel;
import Services.ThongBao.thongBao;
import Utilities.DBConnection;
import Views.FrmQLSanPham;
import Views.FrmTrangChu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class dangNhapRepositories implements IsDangNhapRepositories {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    List<dangNhapModel> listDangNhaps = new ArrayList<>();
    public static String TenUser = "", MatKhau = "", ChucVu = "";

    @Override
    public boolean SuaMK(String MK, String MaND) {

        try {

            connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.NguoiDung SET Pass = ? WHERE MaND = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, MK);
            ps.setString(2, MaND);
            ps.executeUpdate();
            if (MK.isEmpty() || MK == null) {
                thongBao.thongbao("Update Pass Thất Bại", "Thông Báo");
                return false;
            } else {
                thongBao.thongbao("Update Pass Thành Công", "Thông Báo");
                return false;

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return true;
    }

    @Override
    public boolean getAllDangNhap(String userName, String pass) {

        if (userName.trim().equals("") || pass.trim().equals("")) {
            thongBao.thongbao("Không được bỏ trống", "Thông Báo");
            return false;
        } else {

        }
        try {
            connection = DBConnection.getConnection();
            String sql = " SELECT * FROM dbo.NguoiDung WHERE MaND = ? AND Pass = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                TenUser = rs.getString("MaND");
                MatKhau = rs.getString("Pass");
                ChucVu = rs.getString("ChucVu");
                thongBao.thongbao("Đăng nhập thành công", "");
                new FrmTrangChu().setVisible(true);
                return true;
            }
            thongBao.thongbao("Login Failed !!", "Thông Báo");
            return false;

        } catch (Exception e) {
            System.out.println(e);
        }
        thongBao.thongbao("Login Failed !!", "Thông Báo");
        return true;

    }

    @Override
    public boolean doiMK(String mkcu, String mkmoi, String nhapLai) {

        if (mkcu.trim().equals("") || mkmoi.trim().equals("")
                || nhapLai.trim().equals("")) {
            thongBao.thongbao("Không được bỏ trống", "");
            return false;
        }
        if (!mkcu.equals(MatKhau)) {
            thongBao.thongbao("Mật khẩu cũ sai", "");
            return false;
        }
        if (mkmoi.length() < 5) {
            thongBao.thongbao("mật khẩu dài hơn 5 ký tự", "");
            return false;
        }
        if (!mkmoi.equals(nhapLai)) {
            thongBao.thongbao("Mật Khẩu Không Trùng Khớp", "");
            return false;
        }
        return true;
    }

    @Override
    public boolean KiemTra(String username, String password) {

        try {
            connection = DBConnection.getConnection();
            String sql = "SELECT * FROM dbo.NguoiDung WHERE MaND = ? AND Pass = ?";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TenUser = rs.getString("MaND");
                MatKhau = rs.getString("Pass");
                ChucVu = rs.getString("ChucVu");
                return true;
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
