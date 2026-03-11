package BUOI3.lab1;

import java.util.ArrayList;
import java.util.Scanner;
public class QuanLyNhanSu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        NhanVienFullTime nvA = new NhanVienFullTime("001", "A", 10000, 17);
        NhanVienFullTime nvB = new NhanVienFullTime("002", "B", 100000, 67);
        NhanVienPartTime nvC = new NhanVienPartTime("003", "C", 8000, 72);
        NhanVienPartTime nvD = new NhanVienPartTime("004", "D", 10000, 27);
        dsnv.add(nvA);
        dsnv.add(nvB);
        dsnv.add(nvC);
        dsnv.add(nvD);
        int chon;
        do {      
                System.out.println("======== MENU ========");
                System.out.println("1. Nhập nhân viên");
                System.out.println("2. Xuất danh sách");
                System.out.println("3. Tính tổng lương");
                System.out.println("0. Thoát");
                System.out.print("Nhập lựa chọn: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1: LuaChonBanLaNhanVienNao(sc,dsnv); break;
                case 2: XuatDanhSach(dsnv); break;
                case 3: TinhTongLuong(dsnv); break;
                case 0: System.out.println("Thoát chương trình."); break;
            
                default:
                    System.out.println("Chọn sai vui lòng chọn lại");break;
            }
            
        } while (chon != 0);

    }

    // 
    public static void LuaChonBanLaNhanVienNao(Scanner sc,ArrayList<NhanVien> dsnv){
        int chon;
        do {      
                System.out.println("======== MENU ========");
                System.out.println("Bạn là.?");
                System.out.println("1. Nhân viên full time");
                System.out.println("2. Nhân viên part time");
                System.out.println("0. Thoát");
                System.out.print("Nhập lựa chọn: ");
            chon = Integer.parseInt(sc.nextLine());
             switch (chon) {
                case 1: fulltime(sc,dsnv); break;
                case 2: parttime(sc,dsnv); break;
                case 0: System.out.println("Thoát chương trình."); break;
                default:
                    System.out.println("Chọn sai vui lòng chọn lại");break;
            }
        } while (chon != 0);
    }
    public static void fulltime(Scanner sc,ArrayList<NhanVien> dsnv){
        System.out.println("Nhập mã nhân viên: ");      String maNV = sc.nextLine();
        System.out.println("Nhập họ và tên: ");         String hoTen = sc.nextLine();
        System.out.println("Nhập Lương cơ bản: ");      double luongCoBan = sc.nextDouble();
        System.out.println("Nhập số ngày làm thêm: ");  int soNgayLamThem = sc.nextInt();
        sc.nextLine();
        NhanVienFullTime nv = new NhanVienFullTime(maNV, hoTen, luongCoBan, soNgayLamThem);
        dsnv.add(nv);
    }
    public static void parttime(Scanner sc,ArrayList<NhanVien> dsnv){
        System.out.println("Nhập mã nhân viên: ");      String maNV = sc.nextLine();
        System.out.println("Nhập họ và tên: ");         String hoTen = sc.nextLine();
        System.out.println("Nhập Lương theo giờ: ");    double luongTheoGio = sc.nextDouble();
        System.out.println("Nhập số giờ làm: ");        int soGioLam = sc.nextInt();
        sc.nextLine();
        NhanVienPartTime nv = new NhanVienPartTime(maNV, hoTen, luongTheoGio, soGioLam);
        dsnv.add(nv);
    }
    //
    public static void XuatDanhSach(ArrayList<NhanVien> dsnv){
         for (NhanVien nhanVien : dsnv) {
           if (nhanVien instanceof NhanVienPartTime nvpt) {
             System.out.print(nhanVien+" "); nvpt.ThongBaoCaLam();
           } else {System.out.println(nhanVien);}
        }
    }
    public static void TinhTongLuong(ArrayList<NhanVien> dsnv){
        double Tongluong = 0.0;
        for (NhanVien nv : dsnv) {
            Tongluong = Tongluong + nv.tinhluong();
        }
        System.out.println("Tổng tiền cần phát cho nhân viên là: "+Tongluong+"VND");
    }
}