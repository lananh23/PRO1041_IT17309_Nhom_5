/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.dangNhapModel;
import Repositories.dangNhap.dangNhapRepositories;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsDangNhapService {

    public boolean KT_getAllDangNhap(String userName, String pass);

    public boolean KT_Check(String mkcu, String mkmoi, String nhaplai);

    public boolean KT_SuaMK(String MK, String MaND);
    
    public boolean KT_CheckDangNhap(String username, String password);
    
    

}
