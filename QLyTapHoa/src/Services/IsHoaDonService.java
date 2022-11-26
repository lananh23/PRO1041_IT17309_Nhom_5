/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.hoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsHoaDonService {
    
    public List<hoaDon> getAllHoaDon();
    
    public List<hoaDon> findShearchHoaDon(String maHD);
}
