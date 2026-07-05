package lab2;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private double soKm;

	ChuyenXeNoiThanh() {
	}

	ChuyenXeNoiThanh(String maSo, String taiXe, double doanhThu, double soKm) {
		super(maSo, taiXe, doanhThu);
		this.soKm = soKm;
	}

	public double getSoKm() {
		return soKm;
	}

	public void setSoKm(double soKm) {
		this.soKm = soKm;
	}

	@Override
	public double tinhLoiNhuan() {
		return doanhThu - (soKm * 5000);
	}

}
