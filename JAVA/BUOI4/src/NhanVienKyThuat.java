public class NhanVienKyThuat extends NhanVien
{
	private double luongCung;   
	private int soGioTangCa;    

	public NhanVienKyThuat(String maNV, String hoTen, double luongCung, int soGioTangCa)
	{
		super(maNV, hoTen);

		this.luongCung = luongCung;
		this.soGioTangCa = soGioTangCa;
	}

	@Override
	public double tinhLuong()
	{
		return luongCung + (soGioTangCa * 200000);
	}
}