/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.dangNhap;

import DomainModels.DangNhap.dangNhapModel;
import Services.ThongBao.thongBao;
import Utilities.DBConnection;
import Views.FrmTrangChu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;

public class dangNhapRepositories implements IsDangNhapRepositories {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    List<dangNhapModel> listDangNhaps;
    public static String TenUser = "", MatKhau = "", ChucVu = "";

    @Override
    public boolean SuaMK(String MK, String MaND) {

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.NguoiDung SET Pass = ''" + MatKhau + " WHERE MaND = ''" + TenUser + "";
            int kq = DBConnection.ExecuteTruyVan(sql);
            ps.setString(1, MatKhau);
            ps.setString(2, TenUser);
            if (kq > 0) {
                thongBao.thongbao.thongbao("Update Pass Thành Công", "Thông Báo");
            } else {
                thongBao.thongbao.thongbao("Update Pass Thất Bại", "Thông Báo");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return true;
    }

    @Override
    public boolean getAllDangNhap(String userName, String pass) {

        if (userName.trim().equals("") || pass.trim().equals("")) {
            thongBao.thongbao.thongbao("Không được bỏ trống", "Thông Báo");
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
                if (rs.getString("MaND").matches(userName)) {
                    if (rs.getString("Pass").matches(pass)) {
                        thongBao.thongbao.thongbao("Đăng nhập thành công", "");
                        TenUser = rs.getString("MaND");
                        MatKhau = rs.getString("Pass");
                        ChucVu = rs.getString("ChucVu");
                        return true;
                    }
                    thongBao.thongbao.thongbao("Login Failed !!", "Thông Báo");
                    return false;

                }
                thongBao.thongbao.thongbao("Login Failed !!", "Thông Báo");
                return false;

            }
            thongBao.thongbao.thongbao("Login Failed !!", "Thông Báo");
            return false;

        } catch (Exception e) {
            System.out.println(e);
        }
        thongBao.thongbao.thongbao("Login Failed !!", "Thông Báo");
        return true;
    }

    @Override
    public boolean doiMK(String mkcu, String mkmoi, String nhapLai) {
        if (mkcu.trim().equals("") || mkmoi.trim().equals("")
                || nhapLai.trim().equals("")) {
            thongBao.thongbao.thongbao("Không được bỏ trống", "");
            return false;
        }

        if (!mkcu.equals(MatKhau)) {
            thongBao.thongbao.thongbao("Mật khẩu cũ sai", "");
            return false;
        }
        if (mkmoi.length() < 5) {
            thongBao.thongbao.thongbao("mật khẩu dài hơn 5 ký tự", "");
            return false;
        }
        if (!mkmoi.equals(nhapLai)) {
            thongBao.thongbao.thongbao("Mật Khẩu Không Trùng Khớp", "");
            return false;
        }

        return true;
    }

}
