package ServiceImpl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonCTRepository;
import Services.IManageHoaDonChiTiet;
import ViewModels.ManageHoaDonChiTiet;


public class ManageHoaDonChiTietService implements IManageHoaDonChiTiet{

    private HoaDonCTRepository hdRepo;

    public ManageHoaDonChiTietService() {
        this.hdRepo = new HoaDonCTRepository();
    }
    @Override
    public void insert(ManageHoaDonChiTiet sp) {
        HoaDonChiTiet s = new HoaDonChiTiet(sp.getMaHDCT(),sp.getMaHD(), sp.getMaSP(), sp.getSoLuong(), sp.getGiaBan(), sp.getThanhTien(), sp.getMaCu());
        this.hdRepo.insert(s);
    }
    
}
