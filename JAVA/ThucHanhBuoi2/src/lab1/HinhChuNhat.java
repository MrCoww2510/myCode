package lab1;
public class HinhChuNhat {
    private double chieudai;
    private double chieurong;
    public HinhChuNhat(){}
    public HinhChuNhat(double chieudai, double chieurong){
        this.chieudai = chieudai; this.chieurong = chieurong;
    }
    public void setChieudai(double chieudai) {
        if (chieudai > 0) {
            this.chieudai = chieudai; 
        } else {System.out.println("Kích thước phải dương");}
        
    }
    public void setChieurong(double chieurong) {
        if (chieurong > 0) {
            this.chieurong = chieurong; 
        } else {System.out.println("Kích thước phải dương");}
    }
    public double getChieudai() {
        return chieudai;
    }
    public double getChieurong() {
        return chieurong;
    }

    public double getchuvi(){
        return (this.chieudai+this.chieurong)*2 ;
    }

    public double getdientich(){
        return this.chieudai*this.chieurong;
    }
    @Override
    public String toString(){
        return String.format("HCN [Dai: %.2f | Rong: %.2f | Chu vi: %.2f | DienTich: %.2f]",getChieudai(),getChieurong(),getchuvi(),getdientich());
    }

}
