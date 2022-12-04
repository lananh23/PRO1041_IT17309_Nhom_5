/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ViewModels.ManageHoaDonChiTiet;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UltiClass {

    public static float getTongTienHoaDon(List<ManageHoaDonChiTiet> chiTiets) {
        float s = 0;
        for (ManageHoaDonChiTiet chiTiet : chiTiets) {
            s += chiTiet.getGiaBan()*chiTiet.getSoLuong();
        }
        return s;
    }
}
