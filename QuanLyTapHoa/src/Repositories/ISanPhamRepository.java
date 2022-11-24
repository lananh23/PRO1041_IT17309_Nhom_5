package Repositories;

import DomainModels.SanPham;
import java.util.List;

public interface ISanPhamRepository {

    public List<SanPham> All();

    public void insert(SanPham sp);

    public void update(String maSP, SanPham sp);

    public void delete(String maSP);
    
    public List<SanPham> findByCode(String maSP);
}
