package lab2;

public class SinhVien {
    private String maSV;
    private String hoTen; 
    private Double diemTB; 

    public SinhVien(){this.maSV="NoMaSV"; this.hoTen="NoHoTen"; this.diemTB=0.0;}
    public SinhVien(String maSV,String hoTen,Double diemTB){this.maSV=maSV; this.hoTen=hoTen; this.diemTB=diemTB;}

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiemTB(Double diemTB) {
        if ((diemTB >=0.0) && (diemTB <= 10.0)) {
            this.diemTB = diemTB;
        } else {
            this.diemTB = 0.0;
            System.out.println("lỗi!!!");
        }
        
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public Double getDiemTB() {
        return diemTB;
    }
    public String getHoTen() {
        return hoTen;
    }
    public String getMaSV() {
        return maSV;
    }

    public String getHocLuc(){
        if (diemTB < 5 ) {return "yếu";} 
        else if (diemTB < 6.5 ) {return "Trung Bình";} 
        else if (diemTB <8.0 ) {return "khá";}
        else {return "Giỏi";}
    }
    @Override
    public String toString(){
        return String.format("ID: %s TEN: %s DTB: %.2f XEPLOAI: %s ", getMaSV(), getHoTen(), getDiemTB(), getHocLuc());
    }
}
