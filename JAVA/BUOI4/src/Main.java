import java.util.*;

//==============================================
// Chương trình quản lý nhân sự đóng thuế
//==============================================

public class Main
{
	static Scanner scanner = new Scanner(System.in);

	static ArrayList<IDongThue> DanhSach = new ArrayList<>(); 
	// Danh sách quản lý tất cả cá nhân có nghĩa vụ thuế

	public static void main(String[] args)
	{
		chayChuongTrinh();
	}

	//==============================================
	// Điều khiển chương trình
	//==============================================

	static void chayChuongTrinh()
	{
		int LuaChon;

		do
		{
			menu();

			LuaChon = scanner.nextInt();

			switch(LuaChon)
			{
				case 1:
					nhapThongTin();
					break;

				case 2:
					xuatDanhSach();
					break;

				case 3:
					sapXep();
					break;

				case 4:
					timKiem();
					break;

				case 5:
					thongKe();
					break;
			}

		} while(LuaChon != 0);
	}

	//==============================================

	static void menu()
	{
		System.out.println("\n========= MENU =========");
		System.out.println("1. Nhập thông tin");
		System.out.println("2. Xuất danh sách quyết toán");
		System.out.println("3. Sắp xếp theo thuế giảm dần");
		System.out.println("4. Tìm người thuế > 1,000,000");
		System.out.println("5. Thống kê");
		System.out.println("0. Thoát");
		System.out.print("Chọn: ");
	}

	//==============================================

	static void nhapThongTin()
	{
		System.out.println("1. NV Kinh Doanh");
		System.out.println("2. NV Kỹ Thuật");
		System.out.println("3. Cộng tác viên");

		int Loai = scanner.nextInt();
		scanner.nextLine();

		if(Loai == 1)
		{
			System.out.print("Mã NV: ");
			String ma = scanner.nextLine();

			System.out.print("Họ tên: ");
			String ten = scanner.nextLine();

			System.out.print("Doanh số: ");
			double ds = scanner.nextDouble();

			NhanVienKinhDoanh nv = new NhanVienKinhDoanh(ma, ten, ds, 0.1);

			DanhSach.add(nv);
		}

		else if(Loai == 2)
		{
			System.out.print("Mã NV: ");
			String ma = scanner.nextLine();

			System.out.print("Họ tên: ");
			String ten = scanner.nextLine();

			System.out.print("Lương cứng: ");
			double lc = scanner.nextDouble();

			System.out.print("Số giờ tăng ca: ");
			int gio = scanner.nextInt();

			NhanVienKyThuat nv = new NhanVienKyThuat(ma, ten, lc, gio);

			DanhSach.add(nv);
		}

		else if(Loai == 3)
		{
			System.out.print("Họ tên: ");
			String ten = scanner.nextLine();

			System.out.print("Thu nhập dự án: ");
			double tn = scanner.nextDouble();

			CongTacVien ctv = new CongTacVien(ten, tn);

			DanhSach.add(ctv);
		}
	}

	//==============================================

	static void xuatDanhSach()
	{
		System.out.println("\n===== DANH SÁCH QUYẾT TOÁN =====");

		for(IDongThue x : DanhSach)
		{
			System.out.println("Thuế phải nộp: " + String.format("%,.0f", x.tinhThue()));
		}
	}

	//==============================================

	static void sapXep()
	{
		DanhSach.sort((a, b) -> Double.compare(b.tinhThue(), a.tinhThue()));
	}

	//==============================================

	static void timKiem()
	{
		for(IDongThue x : DanhSach)
		{
			if(x.tinhThue() > 1000000)
			{
				System.out.println("Thuế: " + x.tinhThue());
			}
		}
	}

	//==============================================

	static void thongKe()
	{
		double TongThue = 0;

		for(IDongThue x : DanhSach)
		{
			TongThue += x.tinhThue();
		}

		System.out.println("Tổng thuế thu hộ: " + String.format("%,.0f", TongThue));
	}
}