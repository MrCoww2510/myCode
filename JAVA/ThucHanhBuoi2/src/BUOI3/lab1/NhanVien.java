package BUOI3.lab1;
public class NhanVien {
    protected String maNV;
    protected String hoTen;
    public NhanVien(){}
    public NhanVien(String maNV, String hoTen){this.maNV = maNV; this.hoTen = hoTen;}
    public double tinhluong(){return 0.0;};
    public String getmaNV(){return this.maNV;}
    public void setmaNV(String maNV){this.maNV = maNV;}
    public String gethoTen(){return this.hoTen;}
    public void sethoTen(String hoTen){this.hoTen = hoTen;}
    @Override
    public String toString(){return "Ma NV: " + maNV + ", Ho Ten: " + hoTen;}
}
