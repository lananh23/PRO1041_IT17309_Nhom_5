/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.dangNhap;

import DomainModels.DangNhap.dangNhapModel;
import Repositories.dangNhap.dangNhapRepositories;
import static Repositories.dangNhap.dangNhapRepositories.MatKhau;
import Services.ThongBao.thongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class dangNhapService implements IsDangNhapService {

    private dangNhapRepositories dangNhapRepositories;

    public dangNhapService() {
        dangNhapRepositories = new dangNhapRepositories();
    }

    @Override
    public boolean getAllDangNhap(String userName, String pass) {
        boolean isDangNhap = dangNhapRepositories.getAllDangNhap(userName, pass);
        return isDangNhap;
    }

    @Override
    public boolean KT_DoiMK(String mkcu, String mkmoi, String nhaplai) {
        if (!mkcu.equals(MatKhau)) {
            thongBao.thongbao.thongbao("Mật khẩu cũ sai", "");
            return false;
        }
        if (mkmoi.length() < 5) {
            thongBao.thongbao.thongbao("mật khẩu dài hơn 5 ký tự", "");
            return false;
        }
        if (!mkmoi.equals(nhaplai)) {
            thongBao.thongbao.thongbao("Mật Khẩu Không Trùng Khớp", "");
            return false;
        }
        return true;
    }

}
