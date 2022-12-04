package ServiceImpl;

import DomainModels.HoaDon;
import Repositories.HoaDonRepository;
import Services.IManageHoaDon;
import ViewModels.ManageHoaDon;
import java.util.ArrayList;
import java.util.List;

public class ManageHoaDonService implements IManageHoaDon {

    private HoaDonRepository hdRepo;
    private List<ManageHoaDon> list;

    public ManageHoaDonService() {
        this.hdRepo = new HoaDonRepository();
    }

    @Override
    public void insert(ViewModels.ManageHoaDon sp) {
        HoaDon s = new HoaDon(sp.getMaHD(), sp.getMaND(), sp.getMaKH(), sp.getNgayTao(), sp.getTongTien(), sp.getTrangThai());
        this.hdRepo.insert(s);
    }

    @Override
    public List<ManageHoaDon> All() {
        list = new ArrayList<>();
        List<HoaDon> List_CH = this.hdRepo.All();
        for (HoaDon o : List_CH) {
            list.add(new ManageHoaDon(o.getMaHD(), o.getMaND(), o.getMaKH(), o.getNgayTao(), o.getTongTien(), o.getTrangThai()));
        }
        return list;
    }

    @Override
    public List<ManageHoaDon> AllCho() {
        list = new ArrayList<>();
        List<HoaDon> List_CH = this.hdRepo.AllCho();
        for (HoaDon o : List_CH) {
            list.add(new ManageHoaDon(o.getMaHD()));
        }
        return list;
    }

    @Override
    public List<ManageHoaDon> search(String maHD) {
        list = new ArrayList<>();
        List<HoaDon> list_HD = hdRepo.search(maHD);
        for (HoaDon hd : list_HD) {
            list.add(new ManageHoaDon(hd.getMaHD(), hd.getMaND(), hd.getMaKH()));
        }
        return list;
    }

}
