package ServiceImpl;

import DomainModels.SanPhamLoi;
import Repositories.SanPhamLoiRepository;
import Services.IManageSanPhamLoiService;
import ViewModels.ManageSanPhamLoi;
import java.util.ArrayList;
import java.util.List;


public class ManageSanPhamLoiService implements IManageSanPhamLoiService{

     private SanPhamLoiRepository SanPhamRepo;
    private List<ManageSanPhamLoi> list;

    public ManageSanPhamLoiService() {
        this.SanPhamRepo = new SanPhamLoiRepository();
    }
    
    
    @Override
    public List<ManageSanPhamLoi> ALL() {
        list = new ArrayList<>();
        List<SanPhamLoi> List_CH = this.SanPhamRepo.All();
        for (SanPhamLoi o : List_CH) {
            list.add(new ManageSanPhamLoi(o.getMaSPL(), o.getMaSP(), o.getLyDoLoi()));
        }
        return list;
    }

    @Override
    public void insert(ManageSanPhamLoi sp) {
        SanPhamLoi s = new SanPhamLoi(sp.getMaSPL(), sp.getMaSP(), sp.getLyDoLoi());
        this.SanPhamRepo.insert(s);
    }

    @Override
    public void update(String ma, ManageSanPhamLoi sp) {
        SanPhamLoi s = new SanPhamLoi(sp.getMaSPL(), sp.getMaSP(), sp.getLyDoLoi());
        this.SanPhamRepo.update(ma, s);
    }

    @Override
    public void delete(String ma) {
        this.delete(ma);
    }
    
}
