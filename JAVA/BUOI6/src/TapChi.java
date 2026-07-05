public class TapChi extends Tailieu {
	private int soPhatHanh;
	private int thangPhatHanh;
	private String chuDe;
	private String ngonNgu;

	TapChi() {
	}
	// heheehe
	TapChi(String maTaiLieu, String tenTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh,
			int thangPhatHanh, String chuDe, String ngonNgu) {
		super(maTaiLieu, tenTaiLieu, tenNhaXuatBan, soBanPhatHanh);
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
		this.chuDe = chuDe;
		this.ngonNgu = ngonNgu;
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
	}

	public int getThangPhatHanh() {
		return thangPhatHanh;
	}

	public void setThangPhatHanh(int thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	public String getChuDe() {
		return chuDe;
	}

	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	@Override
	public void hienThiThongTin() {
		System.out.println("hehe");
	}
}
