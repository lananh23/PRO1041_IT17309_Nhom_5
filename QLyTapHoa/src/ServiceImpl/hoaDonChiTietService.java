/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModels.hoaDonChiTiet;
import Repositories.hoaDonChiTiet.hoaDonChiTietRepositories;
import java.util.List;
import Services.IsHoaDonChiTietService;

/**
 *
 * @author Admin
 */
public class hoaDonChiTietService implements IsHoaDonChiTietService {

    private hoaDonChiTietRepositories hdctRepositories;

    public hoaDonChiTietService() {
        hdctRepositories = new hoaDonChiTietRepositories();
    }

    @Override
    public List<hoaDonChiTiet> getAllHoaDonChiTiet() {

        try {
            return hdctRepositories.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<hoaDonChiTiet> fillShearchMaSP(String maSP) {
           try {
            return hdctRepositories.shearchMaSP(maSP);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
