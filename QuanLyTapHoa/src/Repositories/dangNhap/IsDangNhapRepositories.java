/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.dangNhap;

import DomainModels.DangNhap.dangNhapModel;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public interface IsDangNhapRepositories {

    public boolean getAllDangNhap(String userName, String pass);

    public boolean SuaMK(String MK, String MaND);
    
    public boolean doiMK(String mkcu, String mkmoi,  String nhapLai);
}
