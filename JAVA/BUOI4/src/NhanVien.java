public abstract class NhanVien implements IDongThue
{
	protected String maNV;   
	protected String hoTen;  

	public NhanVien(String maNV, String hoTen)
	{
		this.maNV = maNV;
		this.hoTen = hoTen;
	}

	public abstract double tinhLuong();

	@Override
	public double tinhThue()
	{
		double Luong = tinhLuong(); 

		if(Luong > 11000000)
		{
			return (Luong - 11000000) * 0.1;
		}

		return 0;
	}

	public String getHoTen()
	{
		return hoTen;
	}
}