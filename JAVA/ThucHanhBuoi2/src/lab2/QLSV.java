package lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLSV {
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args)
        {
            ArrayList<SinhVien> DanhSach = new ArrayList<SinhVien>();

            HienThiMenu(DanhSach);
        }
        //
        public static void HienThiMenu(ArrayList<SinhVien> DanhSach)
        {
            int LuaChon;

            do
            {
                System.out.println("======== MENU ========");
                System.out.println("1. Nhập sinh viên");
                System.out.println("2. Xuất danh sách");
                System.out.println("3. tìm kiếm theo khoảng điểm");
                System.out.println("4. Cập nhật thông tin sinh viên");
                System.out.println("5. Sấp xếp danh sách ");
                System.out.println("6. Xóa sinh viên");
                System.out.println("0. Thoát");
                System.out.print("Nhập lựa chọn: ");

                LuaChon = Integer.parseInt(scanner.nextLine());

                switch (LuaChon)
                {
                    case 1: LuaChonNhap(DanhSach); break;
                    case 2: XuatDanhSach(DanhSach); break;
                    case 3: TimKiemTheoKhoang(DanhSach); break;
                    case 4: CapNhatThongTinSinhVien(DanhSach); break;
                    case 5: SapXepDanhSachSinhVien(DanhSach); break;
                    case 6: XoaSinhVien(DanhSach); break;
                    //case 7: TaoEmailTheoTen(DanhSach); break;
                    case 0: System.out.println("Thoát chương trình."); break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }

            }
            while (LuaChon != 0);
        }
        //
        public static void LuaChonNhap(ArrayList<SinhVien> DanhSach)
        {
            int Chon;

            System.out.println("1. Nhập 1 sinh viên");
            System.out.println("2. Nhập nhiều sinh viên");
            System.out.print("Nhập lựa chọn: ");

            Chon = Integer.parseInt(scanner.nextLine());

            switch (Chon)
            {
                case 1:
                    NhapSinhVien(DanhSach);
                    break;

                case 2:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n; i++)
                    {
                        System.out.println("---- Sinh viên thứ " + (i + 1) + " ----");
                        NhapSinhVien(DanhSach);
                    }
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
        //
        public static void NhapSinhVien(ArrayList<SinhVien> DanhSach)
        {
            SinhVien sv = new SinhVien();

            System.out.print("Nhập họ tên: ");
            sv.setHoTen(scanner.nextLine());

            System.out.print("Nhập điểm: ");
            sv.setDiemTB(Double.parseDouble(scanner.nextLine()));

            DanhSach.add(sv);

            System.out.println("Thêm sinh viên thành công.");
        }
        //
        public static void XuatDanhSach(ArrayList<SinhVien> DanhSach)
        {
            if (DanhSach.isEmpty())
            {
                System.out.println("Danh sách rỗng.");
                return;
            }

            for (SinhVien sv : DanhSach)
            {
                System.out.println("Họ tên: " + sv.getHoTen() +
                                " | Điểm: " + sv.getDiemTB());
            }
        }
        //
        public static void TimKiemTheoKhoang(ArrayList<SinhVien> DanhSach)
        {
            System.out.print("Nhập điểm min: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập điểm max: ");
            double max = Double.parseDouble(scanner.nextLine());

            for (SinhVien sv : DanhSach)
            {
                if (sv.getDiemTB() >= min && sv.getDiemTB() <= max)
                {
                    System.out.println("Họ tên: " + sv.getHoTen() +
                                    " | Điểm: " + sv.getDiemTB());
                }
            }
        }
        //
        public static void CapNhatThongTinSinhVien(ArrayList<SinhVien> DanhSach)
        {
            System.out.print("Nhập họ tên cần sửa: ");
            String Ten = scanner.nextLine();

            for (SinhVien sv : DanhSach)
            {
                if (sv.getHoTen().equalsIgnoreCase(Ten))
                {
                    System.out.print("Nhập tên mới: ");
                    sv.setHoTen(scanner.nextLine());

                    System.out.print("Nhập điểm mới: ");
                    sv.setDiemTB(Double.parseDouble(scanner.nextLine()));

                    System.out.println("Cập nhật thành công.");
                    return;
                }
            }

            System.out.println("Không tìm thấy sinh viên.");
        }
        //
        public static void SapXepDanhSachSinhVien(ArrayList<SinhVien> DanhSach)
        {
            Collections.sort(DanhSach, new Comparator<SinhVien>()
            {
                public int compare(SinhVien a, SinhVien b)
                {
                    return Double.compare(a.getDiemTB(), b.getDiemTB());
                }
            });

            System.out.println("Đã sắp xếp theo điểm tăng dần.");
        }
        //
        public static void XoaSinhVien(ArrayList<SinhVien> DanhSach)
        {
            System.out.print("Nhập họ tên cần xóa: ");
            String Ten = scanner.nextLine();

            for (SinhVien sv : DanhSach)
            {
                if (sv.getHoTen().equalsIgnoreCase(Ten))
                {
                    DanhSach.remove(sv);
                    System.out.println("Đã xóa.");
                    return;
                }
            }

            System.out.println("Không tìm thấy sinh viên.");
        }
}