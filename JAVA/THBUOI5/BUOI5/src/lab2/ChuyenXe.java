package lab2;

public class ChuyenXe {
	protected String maSo;
	protected String taiXe;
	protected double doanhThu;

	ChuyenXe() {
	}

	ChuyenXe(String maSo, String taiXe, double doanhThu) {
		this.maSo = maSo;
		this.taiXe = taiXe;
		this.doanhThu = doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setTaiXe(String taiXe) {
		this.taiXe = taiXe;
	}

	public String getTaiXe() {
		return taiXe;
	}

	public double tinhLoiNhuan() {
		return 0.0;
	}
}
