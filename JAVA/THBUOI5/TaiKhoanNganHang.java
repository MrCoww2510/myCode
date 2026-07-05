"editor.tokenColorCustomizations":{"comments":{"foreground":"#c8ff00","fontStyle":"italic",},},@startuml
skinparam monochrome true

class NguoiDung{
 -id
 -tenDangNhap
 -matKhau
 -vaiTro
}

class KhachHang{
 -id
 -ten
 -soDienThoai
 -email
}

class NhaCungCap{
 -id
 -ten
 -soDienThoai
}

class SanPham {
	-id-ten-moTa-thuongHieu-giaBan-trongLuong-chuViCan-mauSac-soLuongTon+themSanPham()
	+capNhatSanPham()
}

class DonNhap{
 -id
 -ngayNhap
 -tongTien
}

class ChiTietDonNhap{
 -soLuong
 -giaNhap
}

class DonBan{
 -id
 -ngayBan
 -tongTien
 -phuongThucThanhToan
}

	class ChiTietDonBan {
		-soLuong-giaBan
}

SanPham"1"--"n"

BienTheSanPham

DonNhap"1"--"n"
ChiTietDonNhap ChiTietDonNhap-->
BienTheSanPham DonNhap-->
NhaCungCap

DonBan"1"--"n"
ChiTietDonBan ChiTietDonBan-->
BienTheSanPham DonBan-->KhachHang

@
enduml