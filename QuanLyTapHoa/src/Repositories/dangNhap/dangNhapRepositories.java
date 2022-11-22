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
    public static String TenUser = "", MatKhau = "";
    public static int chucVu;

    @Override
    public void SuaMK(String MK, String MaND) {

        try {
            connection = DBConnection.getConnection();
            String sql = "UPDATE dbo.NguoiDung SET Pass = ?" + MK + "WHERE MaND = ?" + MaND + " ";
            int kq = DBConnection.ExecuteTruyVan(sql);
            if (kq > 0) {
                thongBao.thongbao.thongbao("Update Pass Thành Công", "");
            } else {
                thongBao.thongbao.thongbao("Update Pass Thất Bại", "");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
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
                        chucVu = rs.getInt("ChucVu");
                        return true;
                    }
                    thongBao.thongbao.thongbao("Username or Password Failed !!", "Thông Báo");
                    return false;

                }
                thongBao.thongbao.thongbao("Username or Password Failed !!", "Thông Báo");
                return false;

            }
            thongBao.thongbao.thongbao("Username or Password Failed !!", "Thông Báo");
            return false;

        } catch (Exception e) {
            System.out.println(e);
        }
        thongBao.thongbao.thongbao("Username or Password Failed !!", "Thông Báo");
        return true;
    }

}
