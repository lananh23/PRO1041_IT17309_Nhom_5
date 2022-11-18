package Services;

import ViewModels.QLSanPhamLoi;
import java.util.List;

public interface IManageSanPhamLoiService {
    public List<QLSanPhamLoi> ALL();
    public void insert(QLSanPhamLoi sp);
    public void update(String id, QLSanPhamLoi sp);
    public void delete(String id);
}
