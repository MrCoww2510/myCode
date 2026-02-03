package HuongDoiTuong;

public class ConMeo {
    ConMeo(){}
    ConMeo(String maulong, int tuoi){
        this.maulong = maulong;
        this.tuoi = tuoi;
    }
    private String maulong;
    private int tuoi;
    public void setmaulong(String maulong) {this.maulong = maulong;}
    public void settuoi(int tuoi) {this.tuoi = tuoi;}
    public String getmaulong(){return this.maulong;}
    public int gettuoi(){return this.tuoi;}

    public void Keu(){System.out.println("gâu gâu");}
    public void batchuot(){System.out.println("đã bắt chuột");}
    public void Keu(String a){System.out.println(a);}
}
