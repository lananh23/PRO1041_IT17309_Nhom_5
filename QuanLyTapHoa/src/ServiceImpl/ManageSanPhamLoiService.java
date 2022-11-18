package ServiceImpl;

import DomainModels.SanPhamLoi;
import Repositories.ISanPhamLoiRepository;
import Repositories.SanPhamLoiRepository;
import Services.IManageSanPhamLoiService;
import ViewModels.QLSanPhamLoi;
import java.util.ArrayList;
import java.util.List;

public class ManageSanPhamLoiService implements IManageSanPhamLoiService {

    private ISanPhamLoiRepository SanPhamRepo;
    private List<QLSanPhamLoi> list;

    public ManageSanPhamLoiService() {
        this.SanPhamRepo = new SanPhamLoiRepository();
    }
    @Override
    public List<QLSanPhamLoi> ALL() {
        list = new ArrayList<>();
        List<SanPhamLoi> List_CH = this.SanPhamRepo.All();
        for (SanPhamLoi o : List_CH) {
            list.add(new QLSanPhamLoi(o.getId(), o.getIdSP(), o.getMaSPL(), o.getTenSPL(), o.getLyDoLoi()));
        }
        return list;
    }

    @Override
    public void insert(QLSanPhamLoi sp) {
        SanPhamLoi s = new SanPhamLoi(sp.getId(), sp.getIdSP(), sp.getMaSPL(), sp.getTenSPL(), sp.getLyDoLoi());
        this.SanPhamRepo.insert(s);
    }

    @Override
    public void update(String id, QLSanPhamLoi sp) {
        SanPhamLoi s = new SanPhamLoi(sp.getId(), sp.getIdSP(), sp.getMaSPL(), "", sp.getLyDoLoi());
        this.SanPhamRepo.update(id, s);
    }

    @Override
    public void delete(String id) {
        this.SanPhamRepo.delete(id);
    }

}
