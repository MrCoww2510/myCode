public class CongTacVien implements IDongThue
{
	private String hoTen;        
	private double thuNhapDuAn;  

	public CongTacVien(String hoTen, double thuNhapDuAn)
	{
		this.hoTen = hoTen;
		this.thuNhapDuAn = thuNhapDuAn;
	}

	public double getThuNhap()
	{
		return thuNhapDuAn;
	}

	public String getHoTen()
	{
		return hoTen;
	}

	@Override
	public double tinhThue()
	{
		return thuNhapDuAn * 0.1;
	}
}