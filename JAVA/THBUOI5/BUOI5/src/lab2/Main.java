package lab2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<ChuyenXe> ds = new ArrayList<ChuyenXe>();
		ChuyenXeNoiThanh cNoiThanh = new ChuyenXeNoiThanh("01", "a", 1000000, 200);
		ds.add(cNoiThanh);
		ChuyenXeNgoaiThanh cNgoaiThanh = new ChuyenXeNgoaiThanh("01", "a", 10000000, 20);
		ds.add(cNgoaiThanh);
		double TDT = 0.0;
		double TLN = 0.0;
		for (ChuyenXe chuyenXe : ds) {
			TDT = TDT + chuyenXe.getDoanhThu();
			TLN = TLN + chuyenXe.tinhLoiNhuan();
		}
		System.out.println(TDT + " " + TLN);
	}

}
