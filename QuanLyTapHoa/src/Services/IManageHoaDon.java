package Services;

import ViewModels.ManageHoaDon;
import java.util.List;


public interface IManageHoaDon {
    public void insert(ManageHoaDon sp);
    public List<ManageHoaDon> All() ;
    public List<ManageHoaDon> AllCho() ;
}