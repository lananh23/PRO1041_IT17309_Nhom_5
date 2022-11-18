package Services;

import ViewModels.QLSanPham;
import java.util.List;

public interface IManageSanPhamService {

    public List<QLSanPham> ALL();

    public void insert(QLSanPham sp);

    public void update(String maSP, QLSanPham sp);

    public void delete(String maSP);
}
