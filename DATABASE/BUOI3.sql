USE CSDLHangkhong
-- câu 1
SELECT cb.*
FROM ChuyenBay cb
JOIN ChungNhan cn ON cb.MaMB = cn.MaMB
JOIN NhanVien nv ON nv.MaNV = cn.MaNV
WHERE nv.Ten = N'Tôn Văn Quý';
-- câu 2
select loai
from MAYBAY
where TamBay >= 10000
-- câu 3
select GioDi,GioDen
from CHUYENBAY
where (GaDi=N'HAN')and(GaDen=N'DAD')
-- câu 4
select cb.*
FROM ChuyenBay cb
JOIN ChungNhan cn ON cb.MaMB = cn.MaMB
JOIN NhanVien nv ON nv.MaNV = cn.MaNV
where GaDi = N'DAD' and GioDi < '12:00:00.0000000'		
-- câu 5
select nv.Ten
FROM  CHUNGNHAN cn
join NHANVIEN nv on nv.MANV = cn.MANV
join MAYBAY mb on mb.MaMB = cn.MaMB
where mb.Loai = N'Airbus A319'
-- câu 6
select cb.MaCB,cb.ChiPhi,mb.loai
from CHUYENBAY cb
join MAYBAY mb on cb.MaMB = mb.MaMB
where cb.GaDi like N'SG%'
-- câu 7
select * 
from MAYBAY
where loai like N'B%'
-- câu 8
select *
from CHUYENBAY
where MaCB like N'VN2%' or MaCB like N'VN3%'
-- câu 9
SELECT mb.Loai, cb.ChiPhi
FROM ChuyenBay cb
JOIN MayBay mb ON cb.MaMB = mb.MaMB
ORDER BY cb.ChiPhi ASC;
-- câu 10
SELECT nv.Ten, COUNT(DISTINCT cn.MaMB) AS SoLoaiMayBay
FROM NhanVien nv
JOIN ChungNhan cn ON nv.MaNV = cn.MaNV
GROUP BY nv.Ten;