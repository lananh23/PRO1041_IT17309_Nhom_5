package Services;

import ViewModels.ManagePhieuTraHangCT;
import java.util.List;


public interface IManagePhieuTraHangCTService {
    public List<ManagePhieuTraHangCT> ALL();
    public void insert(ManagePhieuTraHangCT p);
    public void update(String ma, ManagePhieuTraHangCT p);
    public void delete(String ma);
}
