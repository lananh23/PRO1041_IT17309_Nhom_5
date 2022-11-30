package Services;

import ViewModels.ManageHoaDon;
import java.util.List;


public interface IManageHoaDon {
    public void insert(ManageHoaDon sp);
    public List<ManageHoaDon> All() ;
    public List<ManageHoaDon> AllHD() ;
    public List<ManageHoaDon> AllCho() ;
    public void deleteMa(String ma);
    public void delete();
}
