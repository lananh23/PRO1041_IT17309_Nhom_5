/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Repositories.IsDangNhapRepositories;
import DomainModels.dangNhapModel;
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
import org.apache.log4j.chainsaw.Main;

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
            String sql = "UPDATE dbo.NguoiDung SET Pass = ? WHERE MaND = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, MK);
            ps.setString(2, MaND);
            ps.executeUpdate();
            if (MK == null || MK.isEmpty()) {
                thongBao.thongbao("Update Pass Thất Bại  ^.^", "Thông Báo");
                return false;
            } else {
                thongBao.thongbao("Update Pass Thành Công  ^.^", "Thông Báo");
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
                ChucVu = rs.getNString("ChucVu");
                if (ChucVu.equals("Quản lý")) {
                    TenUser = rs.getString("MaND");
                    MatKhau = rs.getString("Pass");
                    ChucVu = rs.getString("ChucVu");
                    thongBao.thongbao("Đăng nhập thành công admin", "Thông Báo");
                    new FrmTrangChu().setVisible(true);
                    //  new Main().setVisible(true);
                    return true;
                } else if (ChucVu.equals("Nhân viên")) {
                    TenUser = rs.getString("MaND");
                    MatKhau = rs.getString("Pass");
                    ChucVu = rs.getString("ChucVu");
                    thongBao.thongbao("Đăng nhập thành công user", "Thông Báo");
                    new FrmTrangChu().setVisible(true);
                    // new Main().setVisible(true);
                    return true;

                }

            }
            if (userName.length() >= 20) {
                thongBao.thongbao("Username không được lớn hơn 20 ký tự", "");
                return false;
            } else if (pass.length() >= 20) {
                thongBao.thongbao("Password không được lớn hơn 20 ký tự", "");
                return false;
            } else {
                thongBao.thongbao("Sai tên tài khoản hoặc mật khẩu", "");
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public boolean doiMatKhau(String mkcu, String mkmoi, String nhapLai) {
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
