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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class dangNhapRepositories implements IsDangNhapRepositories {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    List<dangNhapModel> listDangNhaps;
    public static String TenUser = "", MatKhau = "", ChucVu = "";
    thongBao thongBao = new thongBao();
    dangNhapModel dn = new dangNhapModel();

    @Override
    public boolean SuaMK(String MK, String MaND) {

        int kq = 0;

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.NguoiDung SET Pass = ? WHERE MaND = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, MK);
            ps.setString(2, MaND);
            ps.executeUpdate();
            if (kq > 0) {
                thongBao.thongbao("Update Pass Thành Công", "Thông Báo");
                return false;
            } else {
                thongBao.thongbao("Update Pass Thất Bại", "Thông Báo");
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
                        thongBao.thongbao("Đăng nhập thành công", "");
                        TenUser = rs.getString("MaND");
                        MatKhau = rs.getString("Pass");
                        ChucVu = rs.getString("ChucVu");
                        return true;

                    }
                    thongBao.thongbao("Login Failed !!", "Thông Báo");
                    return false;

                }
                thongBao.thongbao("Login Failed !!", "Thông Báo");
                return false;

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
    public boolean doiMK(String mkcu, String mkmoi,
            String nhapLai
    ) {
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

}
