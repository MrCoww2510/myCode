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
-- file buổi 2 (tt)
-- câu 11
select tendt,ngaybd
from detai
where ngaykt > ngaydkkt
-- câu 12
select 
    count(*) as soluongsinhvien,makhoa
from sinhvien
group by makhoa
order by soluongsinhvien asc 
-- câu 13
select  tendt
from detai
where kinhphi >= all(select kinhphi from detai)
-- câu 14
select hoten,quequan
from sinhvien
where ngaysinh < all(select ngaysinh as tuoi
                            from sinhvien
                            where lop = 'CNTT0018')
-- câu 15
select *
from sinhvien sv 
where sv.masv not in ( select distinct ct.masv from ctdt ct)
-- câu 16
select gv.hoten, gv.hocvi, bl.ngayvaolam
from giangvien gv join bangluong bl on gv.magv = bl.magv
where (chucvu = N'Trưởng Khoa')and(makhoa = N'CNTT')
-- câu 17
select dt.tendt, count(ct.masv) as soluong
from detai dt 
left join ctdt ct on dt.madt = ct.madt
group by dt.tendt
-- câu 18
select dt.tendt, dt.ngaybd, dt.ngaykt, dt.tongdiem
from  detai dt
join ctdt ct on dt.madt = ct.madt
group by dt.tendt, dt.ngaybd, dt.ngaykt, dt.tongdiem
having count(distinct ct.masv) > 1;
-- câu 19
select *
from sinhvien sv 
where sv.masv not in ( select distinct ph.masv from phuhuynh ph)
-- câu 20
update detai
set tongdiem = 80
where mahd = 'GV002'
select * from detai





-- file rieng 1 toi 17
-- câu 1
select hoten,lop
from sinhvien
where (quequan = N'Cần Thơ') 
and ((makhoa = 'CNTT') or  (makhoa = 'QLCN')) 
order by hoten asc,lop desc
-- câu 2
select hoten,ngaysinh
from giangvien
where makhoa = 'CNTT'
-- câu 3
select mahd,ketqua
from detai
where tendt = N'Xây dựng website đoàn khoa'
--câu 4
select hoten,hocvi
from giangvien
where (gioitinh = 1 ) and ((makhoa = 'CNTT') or  (makhoa = 'CNTP')) 
--câu 5
select hoten
from giangvien
where (gioitinh = 0) and makhoa not in ('CNTT','CNTP','QLCN')
--câu 6
select *
from giangvien
where chucvu in (N'Trợ lý',N'Phó khoa')
--câu 7
select hoten,ngaysinh,lop
from sinhvien
where  year(getdate())-year(ngaysinh) between 24 and 27
--câu 8
select *
from detai
where (year(ngaybd)>=2011 and year(ngaykt)<=2013) and ketqua = N'Xuất Sắc'
--câu 9
select *
from giangvien
where (gioitinh = 0) and (hoten like N'%Thị%')
--câu 10
select hoten,ngaysinh,hocvi
from giangvien
where chucvu = '' and makhoa = 'CNTP'
--câu 11
select tenkhoa , namthanhlap
from khoa 
where trgkhoa is not null
--câu 12
select 
max((hesoluong * luongcoban) + ((hesoluong * luongcoban) * phucap)) as luongcaonhat,
avg((hesoluong * luongcoban) + ((hesoluong * luongcoban) * phucap)) as luongtrungbinh,
min((hesoluong * luongcoban) + ((hesoluong * luongcoban) * phucap)) as luongnhonhat
from bangluong
--câu 13
select sum(kinhphi) as TongKinhPhi
from detai
where mahd = 'GV008'
--câu 14
select count(gioitinh) as SoLuongGiangVienNu
from giangvien
where gioitinh = 0 and hocvi = N'Thạc Sĩ'
--câu 15 
select count(magv) as tonggv,
       avg((hesoluong * luongcoban) + ((hesoluong * luongcoban) * phucap)) as luongtrungbinh
from bangluong
where ngayvaolam = '2019-11-20'
--câu 16
select distinct hesoluong 
from bangluong
--câu 17
select count( distinct hesoluong) as tongsoloai 
from bangluong