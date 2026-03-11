package HDTTHBUOI1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chose;
        do {
            System.out.println("\n=========== MENU ===========");
			System.out.println("1. Giải phương trình bậc nhất");
			System.out.println("2. Giải phương trình bậc hai");
			System.out.println("3. Tính tiền điện");
			System.out.println("4. Thoát");
			System.out.print("Bạn chọn gì: ");chose = sc.nextInt();
            switch (chose) {
                case 1:
                    GiaiPTBac1();
                    break;
                case 2:
                    GiaiPTBac2();
                    break;
                case 3:
                    tinhTienDien();
                    break;
                case 4:
                    System.out.println(" Thoat chuong trinh");
                    break;
                default:
                    System.out.println("nhap sai roi");
                    break;
            }
            
        } while (chose != 4);
        sc.close();
    }

    static void GiaiPTBac1(){
        float x;
        Scanner sc1 = new Scanner(System.in);
        System.out.println("nhap a:");
      
        float a = sc1.nextInt();
        System.out.println("nhap b:");
        float b = sc1.nextInt();
        x = (-b)/a;
        System.out.println("x = "+ x );
    }
    
    static void GiaiPTBac2()
    {
        Scanner sc2 = new Scanner(System.in);

        System.out.println("nhap a:");
        float a = sc2.nextFloat();

        System.out.println("nhap b:");
        float b = sc2.nextFloat();

        System.out.println("nhap c:");
        float c = sc2.nextFloat();

        if (a == 0)
        {
            if (b == 0)
            {
                if (c == 0)
                    System.out.println("phuong trinh vo so nghiem");
                else
                    System.out.println("phuong trinh vo nghiem");
            }
            else
            {
                float x = -c / b;
                System.out.println("x = " + x);
            }
        }
        else
        {
            float delta = b * b - 4 * a * c;

            if (delta < 0)
            {
                System.out.println("phuong trinh vo nghiem");
            }
            else if (delta == 0)
            {
                float x = -b / (2 * a);
                System.out.println("phuong trinh co nghiem kep x = " + x);
            }
            else
            {
                float x1 = (float)((-b + Math.sqrt(delta)) / (2 * a));
                float x2 = (float)((-b - Math.sqrt(delta)) / (2 * a));
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
	    }
    }

    static void tinhTienDien(){
        Scanner sc3 = new Scanner(System.in);
        System.out.println("nhap so dien cu");
        int socu = sc3.nextInt();
        System.out.println("nhap so dien moi");
        int somoi = sc3.nextInt();
        int socantinh = somoi - socu;
        int thanhtien;
        if (socantinh >=0 && socantinh < 51) {
            thanhtien = socantinh*1678;
           
        } else if (socantinh < 101) { 
            thanhtien = (socantinh-50)*1734 + 50*1678;
            
            
        } else { 
            thanhtien = (socantinh -100)*2014 + 50*1734 + 50*1678; 
        }

        System.out.println("tien dien thang nay la "+thanhtien);
    }

}