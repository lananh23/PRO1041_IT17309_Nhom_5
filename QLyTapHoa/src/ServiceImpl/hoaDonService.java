/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImpl;

import DomainModels.hoaDon;
import Repositories.hoaDon.hoaDonRepositories;
import Services.IsHoaDonService;
import java.util.List;

/**
 *
 * @author Admin
 */
public class hoaDonService implements IsHoaDonService {

    private hoaDonRepositories hdRepositories;

    public hoaDonService() {
        this.hdRepositories = new hoaDonRepositories();
    }

    @Override
    public List<hoaDon> getAllHoaDon() {

        try {
            return hdRepositories.getAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public List<hoaDon> findShearchHoaDon(String maHD) {
         try {
            return hdRepositories.shearchMaHD(maHD);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
