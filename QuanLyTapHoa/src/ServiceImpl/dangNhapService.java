/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import Services.IsDangNhapService;
import DomainModels.dangNhapModel;
import Repositories.dangNhapRepositories;
import static Repositories.dangNhapRepositories.MatKhau;
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
    public boolean find_getAllDangNhap(String userName, String pass) {
        boolean isDangNhap = dangNhapRepositories.getAllDangNhap(userName, pass);
        return isDangNhap;
    }

    @Override
    public boolean find_DoiMK(String mkcu, String mkmoi, String nhaplai) {
        boolean isKT_DoiPass = dangNhapRepositories.doiMatKhau(mkcu, mkmoi, nhaplai);
        return isKT_DoiPass;
    }

    @Override
    public boolean find_UpdateMK(String MK, String MaND) {
        boolean isKT_SuaMK = dangNhapRepositories.SuaMK(MK, MaND);
        return isKT_SuaMK;
    }


}
