package lab2;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
	private double soNgayDi;

	ChuyenXeNgoaiThanh() {
	}

	ChuyenXeNgoaiThanh(String maSo, String taiXe, double doanhThu, double soNgayDi) {
		super(maSo, taiXe, doanhThu);
		this.soNgayDi = soNgayDi;
	}

	public double getsoNgayDi() {
		return soNgayDi;
	}

	public void setsoNgayDi(double soNgayDi) {
		this.soNgayDi = soNgayDi;
	}

	@Override
	public double tinhLoiNhuan() {
		return doanhThu - (soNgayDi * 500.000);
	}

}
