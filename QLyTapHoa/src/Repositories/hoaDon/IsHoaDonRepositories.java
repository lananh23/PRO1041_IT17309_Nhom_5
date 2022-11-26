/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.hoaDon;

import DomainModels.hoaDon;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsHoaDonRepositories {
    
    public List<hoaDon> getAll();
    
    public List<hoaDon> shearchMaHD(String maHD);
    
}
