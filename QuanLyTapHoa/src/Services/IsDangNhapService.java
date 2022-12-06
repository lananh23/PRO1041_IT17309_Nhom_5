/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.dangNhapModel;
import Repositories.dangNhapRepositories;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsDangNhapService {

     public boolean find_getAllDangNhap(String userName, String pass);

    public boolean find_DoiMK(String mkcu, String mkmoi, String nhaplai);
    
    public boolean find_UpdateMK(String MK, String MaND);

}
