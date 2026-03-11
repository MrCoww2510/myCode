package HDTTHBUOI1;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: "); 
        int n = sc.nextInt();

        for (int i = 0; i < args.length; i++) {
            
        }
        String[] hovaten = new String[n];
        float[] diem = new float[n];

        for (int i = 0; i < diem.length; i++) {
            System.out.print("nhap ho va ten sv thu "+(i+1)+" : ");
            sc.nextLine();
            
            hovaten[i] = sc.nextLine();
            
            System.out.print("nhap diem sv thu "+(i+1)+" : ");

            diem[i] = sc.nextFloat(); 
            
        }

        for (int i = 0; i < diem.length-1; i++) {
            for (int j = i+1; j < diem.length; j++) {
                if (diem[i] > diem[j]) {
                    
                    float tempf = diem[i];
                    diem[i] = diem[j];
                    diem[j]=tempf;

                    String temps = hovaten[i];
                    hovaten[i] = hovaten[j];
                    hovaten[j]=temps;
                }
            }
        }
        String[] hocluc = new String[n];
        for (int i = 0; i < diem.length; i++) {
         if ( diem[i] >= 0 && diem[i] <= 5.0 ) { hocluc[i] = "yeu";
            
        } else if (diem[i] <= 6.9) {
            hocluc[i] = "trung binh";
            
        } else if (diem[i] <= 7.9) {
            hocluc[i] = "kha";
            
        } else { hocluc[i] = "gioi";}
        }
        System.out.println("|  Ho va ten |  Diem  |   Hoc Luc      ");
        for (int i = 0; i < diem.length; i++) {
            System.out.printf("| %20s | %5.2f | %s",hovaten[i],diem[i],hocluc[i]);
            System.out.println();
        }

    }
}