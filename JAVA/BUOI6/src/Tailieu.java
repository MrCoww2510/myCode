public abstract class Tailieu {
	private String maTaiLieu;
	private String tenTaiLieu;
	private String tenNhaXuatBan;
	private int soBanPhatHanh;

	Tailieu() {
	}

	Tailieu(String maTaiLieu, String tenTaiLieu, String tenNhaXuatBan, int soBanPhatHanh) {
		this.maTaiLieu = maTaiLieu;
		this.tenTaiLieu = tenTaiLieu;
		this.tenNhaXuatBan = tenNhaXuatBan;
		this.soBanPhatHanh = soBanPhatHanh;
	}

	public String getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}

	public String getTenNhaXuatBan() {
		return tenNhaXuatBan;
	}

	public void setTenNhaXuatBan(String tenNhaXuatBan) {
		this.tenNhaXuatBan = tenNhaXuatBan;
	}

	public String getTenTaiLieu() {
		return tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}

	public abstract void hienThiThongTin();
}
