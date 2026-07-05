package HDTTHBUOI1;

import java.util.Scanner;

public class Lab5Lab4 {

    static SinhVien[] ds = new SinhVien[100]; // danh sách tối đa 100 SV
    static int soLuong = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("===== QUAN LY SINH VIEN =====");
            System.out.println("1. Nhap danh sach");
            System.out.println("2. Xuat danh sach");
            System.out.println("3. Sap xep theo diem");
            System.out.println("4. Tim kiem theo ten");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Thoat");
            System.out.print(">> Chon: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    Nhap(sc);
                    break;
                case 2:
                    Xuat();
                    break;
                case 3:
                    SapXep();
                    break;
                case 4:
                    TimKiem(sc);
                    break;
                case 5:
                    Xoa(sc);
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Chon sai, nhap lai.");
            }
        } while (chon != 6);
    }

    // ================= NHAP =================
    static void Nhap(Scanner sc) {
        System.out.print("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            SinhVien sv = new SinhVien();

            System.out.print("Nhap ho ten: ");
            sv.setHoVaTen(sc.nextLine());

            System.out.print("Nhap diem: ");
            sv.setDiem(sc.nextFloat());
            sc.nextLine();

            ds[soLuong++] = sv;
        }
    }

    // ================= XUAT =================
    static void Xuat() {
        if (soLuong == 0) {
            System.out.println("Danh sach rong.");
            return;
        }

        System.out.println("| Ho va ten           | Diem | Hoc luc |");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("| %-20s | %4.1f | %-7s |\n",
                    ds[i].getHoVaTen(),
                    ds[i].getDiem(),
                    XepLoai(ds[i].getDiem()));
        }
    }

    // ================= SAP XEP =================
    static void SapXep() {
        for (int i = 0; i < soLuong - 1; i++) {
            for (int j = i + 1; j < soLuong; j++) {
                if (ds[i].getDiem() > ds[j].getDiem()) {
                    SinhVien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep theo diem.");
    }

    // ================= TIM KIEM =================
    static void TimKiem(Scanner sc) {
        System.out.print("Nhap tu khoa can tim: ");
        String key = sc.nextLine().toLowerCase();
        boolean timThay = false;

        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getHoVaTen().toLowerCase().contains(key)) {
                System.out.printf("%s - %.1f - %s\n",
                        ds[i].getHoVaTen(),
                        ds[i].getDiem(),
                        XepLoai(ds[i].getDiem()));
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sinh vien phu hop.");
        }
    }

    // ================= XOA =================
    static void Xoa(Scanner sc) {
        System.out.print("Nhap ten sinh vien can xoa: ");
        String ten = sc.nextLine().toLowerCase();
        boolean daXoa = false;

        for (int i = 0; i < soLuong; i++) {
            if (ds[i].getHoVaTen().toLowerCase().contains(ten)) {
                for (int j = i; j < soLuong - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                soLuong--;
                i--;
                daXoa = true;
            }
        }

        if (daXoa) {
            System.out.println("Da xoa sinh vien.");
        } else {
            System.out.println("Khong tim thay sinh vien can xoa.");
        }
    }

    // ================= XEP LOAI =================
    static String XepLoai(float d) {
        if (d < 5)
            return "Yeu";
        if (d < 7)
            return "Trung binh";
        if (d < 8)
            return "Kha";
        return "Gioi";
    }
}

// ================= LOP SINH VIEN =================
class SinhVien {
    private String hoVaTen;
    private float diem;

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}