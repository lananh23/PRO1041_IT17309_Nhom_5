package Repositories;

import DomainModels.SanPhamLoi;
import java.util.List;


public interface ISanPhamLoiRepository {
    public List<SanPhamLoi> All();
    public void insert(SanPhamLoi sp);
    public void update(String id, SanPhamLoi sp);
    public void delete(String id);
}
