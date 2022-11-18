package DomainModels;


public class SanPhamLoi {
    private String id;
    private String idSP;
    private String maSPL;
    private String tenSPL;
    private String lyDoLoi;

    public SanPhamLoi() {
    }

    public SanPhamLoi(String id, String idSP, String maSPL, String tenSPL, String lyDoLoi) {
        this.id = id;
        this.idSP = idSP;
        this.maSPL = maSPL;
        this.tenSPL = tenSPL;
        this.lyDoLoi = lyDoLoi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getMaSPL() {
        return maSPL;
    }

    public void setMaSPL(String maSPL) {
        this.maSPL = maSPL;
    }

    public String getTenSPL() {
        return tenSPL;
    }

    public void setTenSPL(String tenSPL) {
        this.tenSPL = tenSPL;
    }

    public String getLyDoLoi() {
        return lyDoLoi;
    }

    public void setLyDoLoi(String lyDoLoi) {
        this.lyDoLoi = lyDoLoi;
    }
    
    
}
