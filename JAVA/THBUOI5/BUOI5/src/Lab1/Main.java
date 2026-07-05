package Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TaiKhoanNganHang dt = new TaiKhoanNganHang("a", 5000000);

        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nạp tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Xem lịch sử giao dịch");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    dt.naptien(sc);
                    break;

                case 2:
                    dt.ruttien(sc);
                    break;

                case 3:
                    dt.hienThiLSGD(); // đúng chuẩn
                    break;

                case 0:
                    System.out.println("Bye...");
                    break;

                default:
                    System.out.println("Nhập sai, chọn lại!");
                    break;
            }

        } while (chon != 0);

        sc.close();
    }
}