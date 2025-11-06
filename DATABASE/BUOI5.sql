use QLBH
select *
from CTHD
select *
from HoaDon
select *
from NhanVien
select *
from KhachHang
select *
from SanPham
-- câu 1
select masp,tensp
from SanPham
where nuocsx like N'Trung Quốc'
-- câu 2
select masp, tensp
from SanPham
where dvt = N'Cây' or dvt = N'Quyển'
-- câu 3
select masp, tensp
from SanPham
where masp like 'B%01'
-- câu 4
select masp,tensp
from SanPham
where (nuocsx like N'Trung Quốc') and (gia >= 30000 and gia <= 40000)
-- câu 5
select masp,tensp
from SanPham
where (nuocsx like N'Trung Quốc' or nuocsx like N'Thái Lan') and (gia >= 30000 and gia <= 40000)
-- câu 6
select sohd,trigia
from HoaDon
where nghd like '2007-01-01' or nghd like '2007-01-02'
-- câu 7
select sohd, trigia
from HoaDon
where nghd like '2007-01%'
order by nghd asc, trigia desc
-- câu 8
select h.makh, k.hoten
from HoaDon h
join KhachHang k on h.makh = k.makh
where nghd like '2007-01-%'
-- câu 9
select h.sohd,h.trigia
from HoaDon h
join NhanVien n on n.manv = h.manv
where n.hoten like N'Nguyễn Văn Bền'
-- câu 10
select ct.masp, sp.tensp
from HoaDon hd 
join KhachHang kh on hd.makh = kh.makh
join CTHD ct on hd.sohd = ct.sohd
join SanPham sp on sp.masp = ct.masp
where kh.hoten like N'Nguyễn Văn An'
-- câu 11
select sohd
from CTHD
where masp like 'BB01' or masp like 'BB02'
-- câu 12
select sohd
from CTHD
where (masp like 'BB01' or masp like 'BB02') and (sl >=10 and sl <= 20)
-- câu 13
select *
from CTHD
where (masp in ('BB01','BB02')) and (sl between 10 and 20)
-- câu 14
select sp.masp, sp.tensp
from CTHD ct
join HoaDon hd on ct.sohd = hd.sohd
join SanPham sp on sp.masp = ct.masp
where hd.nghd like '2007-01-01' or sp.nuocsx like N'Trung Quốc'
-- câu 15
select sp.masp, sp.tensp
from CTHD ct
right join SanPham sp on sp.masp = ct.masp
where ct.sohd is null
-- câu 16
SELECT MasP, TenSP
FROM SanPham
WHERE MasP NOT IN (
    SELECT c.Masp
    FROM CTHD c
    JOIN HoaDon h ON c.SoHD = h.SoHD
    WHERE YEAR(h.NghD) = 2006)
-- câu 17
SELECT MasP, TenSP
FROM SanPham
WHERE nuocsx = N'Trung Quốc' and MasP NOT IN (
    SELECT c.Masp
    FROM CTHD c
    JOIN HoaDon h ON c.SoHD = h.SoHD
    WHERE YEAR(h.NghD) = 2006)
-- câu 18
select sohd
from CTHD
where masp in (
    select s.masp
    from SanPham s
    where s.nuocsx = N'Singapore')
GROUP BY SoHD
HAVING COUNT(DISTINCT MasP) = (
    SELECT COUNT(*) FROM SanPham WHERE NuocSX = N'Singapore'
);
-- câu 19
SELECT h.SoHD
FROM HoaDon h
JOIN CTHD c ON h.SoHD = c.SoHD
WHERE YEAR(h.NghD) = 2006
  AND c.MasP IN (SELECT MasP FROM SanPham WHERE NuocSX = N'Singapore')
GROUP BY h.SoHD
HAVING COUNT(DISTINCT c.MasP) = (
    SELECT COUNT(*) FROM SanPham WHERE NuocSX = N'Singapore'
);
-- câu 20
SELECT COUNT(*) AS SoHoaDonKhongThanhVien
FROM HoaDon
WHERE Makh IS NULL OR Makh = '' OR Makh = N'Null';
-- câu 21
SELECT COUNT(DISTINCT c.MasP) AS SoSanPhamDaBan
FROM CTHD c
JOIN HoaDon h ON c.SoHD = h.SoHD
WHERE YEAR(h.NghD) = 2006;
-- câu 22
select max(trigia) as gialonnhat,
       min(trigia) as giathapnhat
from HoaDon
-- câu 23
select avg(trigia) as trb2006
from HoaDon
where year(nghd) = 2006
-- câu 24
select sum(trigia) as doanhthu
from HoaDon
where year(nghd) = 2006
--câu 25
select sohd
from HoaDon
where year(nghd) = 2006 and trigia in (
    select max(trigia)
    from HoaDon
    where year(nghd) = 2006
)
-- câu 26
select kh.hoten
from HoaDon hd
join KhachHang kh on kh.makh = hd.makh
where year(hd.nghd) =2006 and trigia in (
    select max(trigia)
    from HoaDon
    where year(nghd) = 2006
)
-- câu 27
select Top 3 makh, hoten, doanhso
from KhachHang
order by doanhso desc
-- câu 28
select masp, tensp
from SanPham
where gia in (
    select top 3 gia
    from SanPham
)
-- câu 29
select *
from SanPham
where nuocsx = N'Thái Lan' and gia in (
    select top 3 gia
    from SanPham
)
-- câu 30
select masp,tensp
from SanPham
where nuocsx = N'Trung Quốc' and gia in (
    select top 3 gia
    from SanPham
    where nuocsx = N'Trung Quốc'
)
-- câu 31 
select * 
from KhachHang
where doanhso in (
    select top 3 doanhso
    from KhachHang
    order by doanhso desc
)
-- câu 32
select count(*) as slspTQ
from SanPham
where nuocsx = N'Trung Quốc'
-- câu 33
SELECT NuocSX, COUNT(*) AS SoLuong
FROM SanPham
GROUP BY NuocSX;
-- câu 34
select nuocsx,
    max(gia) as caonhat,
    min(gia) as nhonhat,
    avg(gia) as trungbinh
from SanPham
group by nuocsx
-- câu 35
select nghd, sum(trigia)
from HoaDon
group by nghd
-- câu 36
SELECT c.Masp, s.TenSP, SUM(c.SL) AS TongSoLuong
FROM CTHD c
JOIN HoaDon h ON c.SoHD = h.SoHD
JOIN SanPham s ON c.Masp = s.Masp
WHERE YEAR(h.NghD) = 2006 AND MONTH(h.NghD) = 10
GROUP BY c.Masp, s.TenSP
ORDER BY TongSoLuong DESC;
-- câu 37
select month(nghd) as thang, sum(trigia) as DoanhThu
from HoaDon
where year(nghd) = 2006
group by month(nghd)
order by thang;
-- câu 38
SELECT SoHD
FROM CTHD
GROUP BY SoHD
HAVING COUNT(DISTINCT MasP) >= 4;
-- câu 39
SELECT SoHD
FROM CTHD
where sohd in (
    select ct.sohd
    from SanPham sp
    join CTHD ct on ct.masp = sp.masp
    join HoaDon hd on hd.sohd = ct.sohd
    where nuocsx = N'Việt Nam'
)
GROUP BY SoHD
HAVING COUNT(DISTINCT MasP) >= 3;