package BUOI3.lab1;

public class NhanVienPartTime extends NhanVien {
    private double luongTheoGio;
    private int soGioLam;
    public double getLuongTheoGio() {
        return luongTheoGio;
    }
    public void setLuongTheoGio(double luongTheoGio) {
        this.luongTheoGio = luongTheoGio;
    }
    public int getSoGioLam() {
        return soGioLam;
    }
    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }
    public NhanVienPartTime(){}
    public NhanVienPartTime(String maNV,String hoTen, double luongTheoGio, int soGioLam){
        super(maNV,hoTen);
        this.luongTheoGio = luongTheoGio;
        this.soGioLam = soGioLam;
    }

    public void ThongBaoCaLam(){
        System.out.println("Bạn là nhân viên part time, nhớ chấm công!!!");
    }

    @Override
    public double tinhluong(){
        double luong = luongTheoGio*soGioLam;
        return luong;
    }
    @Override
    public String toString() {
        return super.toString()
        +", Luong theo gio: "+luongTheoGio
        +",So gio lam: "+soGioLam
        +", Tong luong: "+tinhluong();
    }
}
