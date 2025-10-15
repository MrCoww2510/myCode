USE qlydean
-- Câu 1
SELECT masv , hoten 
FROM sinhvien 
WHERE LOP = 'CNTT0019' 
-- Câu 2
select distinct  hesoluong
from bangluong 
order by hesoluong desc
-- câu 3
select hoten,ngaysinh,hocvi
from giangvien
where makhoa = 'CNTT'
-- câu 4
select * 
from sinhvien
where (quequan = N'Cần Thơ') 
and ((makhoa = 'CNTT') or  (makhoa = 'CNTP')) 
-- câu 5 
SELECT 
    hoten,
    ngaysinh,
    YEAR(GETDATE()) - YEAR(ngaysinh) AS tuoi
FROM giangvien
WHERE ngaysinh = (SELECT MIN(ngaysinh) FROM giangvien);
-- câu 6
select hoten,makhoa
from giangvien
where (gioitinh = 0) 
and not ((makhoa = 'QLCN') or  (makhoa = 'CNTP')) 
-- câu 7
select tenkhoa , namthanhlap
from khoa 
where trgkhoa is null
-- câu 8
select hoten 
from giangvien 
where hoten like N'%Nguyễn%' 
-- câu 9
select 
count(*) as SoLuongThacSi
from giangvien
where hocvi = N'Thạc Sĩ'
--câu 10 
SELECT 
SUM((b.hesoluong * b.luongcoban) + ((b.hesoluong * b.luongcoban) * b.phucap)) AS TongLuongKhoaCoKhi
FROM bangluong b
JOIN giangvien g ON b.magv = g.magv
WHERE g.makhoa = N'CK';