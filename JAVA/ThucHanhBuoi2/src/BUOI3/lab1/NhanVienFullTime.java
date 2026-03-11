package BUOI3.lab1;

public class NhanVienFullTime extends NhanVien {
    public double luongCoBan;
    public int soNgayLamThem;
    public NhanVienFullTime(){}
    public NhanVienFullTime(String maNV, String hoTen, double luongCoBan, int soNgayLamThem){
        super(maNV,hoTen);
        this.luongCoBan = luongCoBan;
        this.soNgayLamThem = soNgayLamThem;
    }
    public double getLuongCoBan() {
        return luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    public int getSoNgayLamThem() {
        return soNgayLamThem;
    }
    public void setSoNgayLamThem(int soNgayLamThem) {
        this.soNgayLamThem = soNgayLamThem;
    }
    @Override
    public double tinhluong(){
        double  luong = luongCoBan + (soNgayLamThem * 300.000);
        return luong;
    }
    @Override
    public String toString() {
        return super.toString()
        +", Luong co ban: "+luongCoBan
        +",So ngay lam them: "+soNgayLamThem
        +", Tong luong: "+tinhluong();
    }
}
