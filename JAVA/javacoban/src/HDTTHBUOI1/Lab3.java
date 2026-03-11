package HDTTHBUOI1;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong sinh vien");
        int n = sc.nextInt();
        sc.nextLine();
        SinhVien[] sv = new SinhVien[n];
        Nhap(sv,n);
        XapXep(sv);
        Xuat(sv);
    }

    static void Nhap(SinhVien[] sv, int n){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            sv[i] = new SinhVien();
            System.out.println("nhap ho va ten sinh vien thu "+(i+1)+" : ");
            String temp = sc.nextLine();
            sv[i].sethovaten(temp);
            System.out.println("nhap diem sinh vien thu "+(i+1)+" : ");
            float tempf = sc.nextFloat(); 
            sc.nextLine();
            sv[i].setdiem(tempf);
        }
    }

    static String xeploai(float a){
        if ( a >= 0 && a <= 5.0 ) { return "yeu";
            
        } else if (a <= 6.9) {
            return "trung binh";
            
        } else if (a <= 7.9) {
            return "kha";
            
        } else { return "gioi";}
    }

    static void Xuat(SinhVien[] sv){
        System.out.println("|   ho va ten   |   diem    |   hoc luc    |");
        for (int i = 0; i < sv.length; i++) {
            System.out.printf("|%20s | %6.2f | %10s |\n",sv[i].gethovaten(),sv[i].getdiem(),xeploai(sv[i].getdiem()));
        }
    }

    static void XapXep(SinhVien[] sv){
        int n = sv.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (sv[i].getdiem() > sv[j].getdiem()) {

                    SinhVien temp = sv[i];
                    sv[i]= sv[j];
                    sv[j]= temp;
                    
                }
            }
        }
    }

}
class SinhVien{
        private String hovaten;
        private float diem;
        SinhVien(){}
        SinhVien(String hovaten, float diem){
            this.hovaten = hovaten;
            this.diem = diem;
        }
        public void sethovaten(String hovaten){
            this.hovaten = hovaten;
        }
        public void setdiem(float diem){
            this.diem = diem;
        }
        public String gethovaten() {
            return hovaten;
        }
        public float getdiem() {
            return diem;
        }
    }