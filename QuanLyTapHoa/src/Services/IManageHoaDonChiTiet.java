
package Services;

import ViewModels.ManageHoaDonChiTiet;
import java.util.List;


public interface IManageHoaDonChiTiet {
    public void insert(ManageHoaDonChiTiet sp);
    public List<ManageHoaDonChiTiet> All(String ma);
    public List<ManageHoaDonChiTiet> getAll_2();
}
