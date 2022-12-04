package ServiceImpl;

import DomainModels.HoaDonChiTiet;
import Repositories.HoaDonCTRepository;
import Services.IManageHoaDonChiTiet;
import ViewModels.ManageHoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;


public class ManageHoaDonChiTietService implements IManageHoaDonChiTiet{

    private HoaDonCTRepository hdRepo;
        private List<ManageHoaDonChiTiet> list;

    public ManageHoaDonChiTietService() {
        this.hdRepo = new HoaDonCTRepository();
    }
    @Override
    public void insert(ManageHoaDonChiTiet sp) {
        HoaDonChiTiet s = new HoaDonChiTiet(sp.getMaHDCT(),sp.getMaHD(), sp.getMaSP(), sp.getSoLuong(), sp.getGiaBan(), sp.getThanhTien(), sp.getMaCu());
        this.hdRepo.insert(s);
    }

    @Override
    public List<ManageHoaDonChiTiet> All(String ma) {
        list = new ArrayList<>();
        List<HoaDonChiTiet> List_CH = this.hdRepo.AllSP(ma);
        for (HoaDonChiTiet o : List_CH) {
            list.add(new ManageHoaDonChiTiet(o.getMaSP(), o.getSoLuong(), o.getGiaBan(), o.getThanhTien()));
        }
        return list;
    }

    @Override
    public List<ManageHoaDonChiTiet> getAll_2() {
        List<HoaDonChiTiet> ds = hdRepo.getAll();
        List<ManageHoaDonChiTiet> listView = new ArrayList<>();
        for(HoaDonChiTiet hdct : ds){
            ManageHoaDonChiTiet hdctView = new ManageHoaDonChiTiet(
                    hdct.getMaSP(),
                    hdct.getSoLuong(),
                    hdct.getGiaBan(), 
                    hdct.getThanhTien());
            listView.add(hdctView);
        }
        return listView;
    }
    
}
