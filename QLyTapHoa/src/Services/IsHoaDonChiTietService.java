/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.hoaDonChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsHoaDonChiTietService {
    
    public List<hoaDonChiTiet> getAllHoaDonChiTiet();
    
    public List<hoaDonChiTiet> fillShearchMaSP(String maSP);
    
}
