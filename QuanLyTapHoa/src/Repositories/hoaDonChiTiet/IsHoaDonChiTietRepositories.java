/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories.hoaDonChiTiet;

import DomainModels.hoaDonChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IsHoaDonChiTietRepositories {

    public List<hoaDonChiTiet> getAll();

    public List<hoaDonChiTiet> shearchMaSP(String maSP);
}
