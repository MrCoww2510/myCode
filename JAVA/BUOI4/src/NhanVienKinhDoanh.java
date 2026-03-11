public class NhanVienKinhDoanh extends NhanVien
{
	private double doanhSo;      
	private double tiLeHoaHong;  

	public NhanVienKinhDoanh(String maNV, String hoTen, double doanhSo, double tiLeHoaHong)
	{
		super(maNV, hoTen);

		this.doanhSo = doanhSo;
		this.tiLeHoaHong = tiLeHoaHong;
	}

	@Override
	public double tinhLuong()
	{
		double Luong = doanhSo * tiLeHoaHong;

		if(doanhSo > 100000000)
		{
			Luong += Luong * 0.1; 
		}

		return Luong;
	}
}