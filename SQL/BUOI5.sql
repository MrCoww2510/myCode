select * from DIEMHP
select * from DMHOCPHAN
select * from DMKHOA
select * from DMLOP
select * from DMNGANH
select * from SINHVIEN
--Phần 1: Truy xuất cơ bản trên 1 bảng
--1. Tạo View hiển thị danh sách tất cả các khoa (gồm MaKhoa, TenKhoa) từ bảng
--DMKHOA.
create view DSKHOA
as 
	select MAKHOA,TENKHOA from DMKHOA
--2. Tạo View hiển thị thông tin cơ bản của sinh viên (gồm MaSV, HoTen, NgaySinh) từ
--bảng SINHVIEN.
create view TTCBSV
as 
	select MASV, HOTEN, NGAYSINH from SINHVIEN
--3. Tạo View danh sách các sinh viên có GioiTinh là 'Nữ' từ bảng SINHVIEN.
create view SVGTNU
as 
	select * 
	from SINHVIEN
	where GIOITINH = 1
--4. Tạo View danh sách các học phần có số đơn vị học trình (SoDVHT) lớn hơn hoặc
--bằng 3 từ bảng DMHOCPHAN.

create view SDVHT3
as
	select *
	from DMHOCPHAN
	where SODVHT >= 3
--5. Tạo View danh sách các lớp thuộc hệ đào tạo đại học (điều kiện cột HEDT bằng
--'Đại học') từ bảng DMLOP.
create view HEDTDH
as 
	select * 
	from DMLOP
	where HEDT like 'Đại Học'
--6. Tạo View hiển thị MaSV, HoTen và Tuoi của sinh viên từ bảng SINHVIEN (Gợi ý:
--Tuoi = Năm hiện tại trừ đi năm của NgaySinh).
create view hienthisinhvien
as
	select MASV,HOTEN, year(getdate()) - year(NGAYSINH) as TUOI
	from SINHVIEN
--Phần 2: Kết nối 2 bảng
--7. Tạo View hiển thị MaNganh, TenNganh (từ bảng DMNGANH) và TenKhoa quản lý
--ngành đó (từ bảng DMKHOA).
create view HIENTHI
as
	select n.MANGANH, n.TENNGANH, k.TENKHOA from DMKHOA k 
	join DMNGANH n on k.MAKHOA = n.MAKHOA
--8. Tạo View hiển thị danh sách sinh viên (MaSV, HoTen từ bảng SINHVIEN) kèm theo
--TenLop mà họ đang học (từ bảng DMLOP).
create view HIENTHI2
as 
	select s.MASV, s.HOTEN, l.tenlop from SINHVIEN s
	join DMLOP l on l.MALOP = s.MALOP
--9. Tạo View hiển thị MaLop, TenLop (từ bảng DMLOP) và TenNganh học của lớp đó
--(từ bảng DMNGANH).
create view HIENTHI3
as
	select l.MALOP, l.TENLOP, n.TENNGANH
	from DMLOP l
	join DMNGANH n on n.MANGANH = l.MANGANH
--10. Tạo View hiển thị TenHP (từ bảng DMHOCPHAN) và TenNganh mà học phần đó
--trực thuộc (từ bảng DMNGANH).
create view HIENTHI4
as
	select h.TENHP, n.TENNGANH
	from DMHOCPHAN h
	join DMNGANH n on n.MANGANH = h.MANGANH
--11. Tạo View danh sách điểm của sinh viên gồm: MaSV (từ bảng DIEMHP), TenHP (từ
--bảng DMHOCPHAN) và Diem (từ bảng DIEMHP).
create view DS
as 
	select d.MASV, h.TENHP, d.DIEMHP
	from DMHOCPHAN h
	join DIEMHP d on d.MAHP = h.MAHP
--Phần 3: Kết nối từ 3 bảng trở lên
--12. Tạo View hiển thị Bảng điểm chi tiết gồm: HoTen sinh viên (bảng SINHVIEN),
--TenLop (bảng DMLOP), TenHP (bảng DMHOCPHAN) và Diem (bảng DIEMHP).
create view ht12
as
	select s.HOTEN, l.TENLOP, h.TENHP,d.DIEMHP 
	from SINHVIEN s
	join DMLOP l on l.MALOP = s.MALOP
	join DIEMHP d on d.MASV = s.MASV
	join DMHOCPHAN h on h.MAHP = d.MAHP
	
--13. Tạo View hiển thị danh sách sinh viên bị rớt môn (điều kiện Diem < 5) gồm: HoTen
--(bảng SINHVIEN), TenHP (bảng DMHOCPHAN) và Diem (bảng DIEMHP).
create view ht13
as
	select s.HOTEN, h.TENHP,d.DIEMHP 
	from SINHVIEN s
	join DIEMHP d on d.MASV = s.MASV
	join DMHOCPHAN h on h.MAHP = d.MAHP
	where d.DIEMHP <= 5
--14. Tạo View hiển thị thông tin phân cấp học: TenLop (bảng DMLOP), TenNganh (bảng
--DMNGANH) và TenKhoa (bảng DMKHOA) tương ứng.
create view ht14
as
	select l.TENLOP, n.TENNGANH, k.TENKHOA
	from DMLOP l
	join DMNGANH n on l.MANGANH = n.MANGANH
	join DMKHOA k on n.MAKHOA = k.MAKHOA
--15. Tạo View hiển thị bảng điểm các môn học thuộc Học kỳ 1 (điều kiện HOCKY = 1) của
--tất cả sinh viên (liên kết các bảng DIEMHP, SINHVIEN, DMHOCPHAN).
create view ht15
as
	select s.HOTEN, d.DIEMHP
	from SINHVIEN s
	join DIEMHP d on d.MASV = s.MASV
	join DMHOCPHAN h on h.MAHP = d.MAHP
	where h.HOCKY = 1
--Phần 4: Thống kê dữ liệu
--16. Tạo View thống kê số lượng sinh viên thực tế của mỗi lớp (đếm MaSV trong bảng
--SINHVIEN, nhóm theo MaLop).
create view ht16
as
	select l.MALOP, l.TENLOP, count(s.MASV) as SoLuongSV
	from DMLOP l
	join SINHVIEN s on s.MALOP = l.MALOP
	group by l.MALOP, l.TENLOP
--17. Tạo View thống kê mỗi Khoa đang quản lý bao nhiêu Ngành học (đếm MaNganh
--trong bảng DMNGANH, nhóm theo TenKhoa trong bảng DMKHOA).
create view ht17
as
	select k.TENKHOA, count(n.MANGANH) as SoLuongNganh
	from DMKHOA k
	join DMNGANH n on n.MAKHOA = k.MAKHOA
	group by k.TENKHOA
--18. Tạo View tính Điểm trung bình (tính AVG(Diem) trong bảng DIEMHP) của từng sinh
--viên (nhóm theo MaSV).
create view ht18
as
	select s.MASV, s.HOTEN, avg(d.DIEMHP) as DiemTrungBinh
	from SINHVIEN s
	join DIEMHP d on d.MASV = s.MASV
	group by s.MASV, s.HOTEN
--19. Tạo View đếm tổng số lượng học phần (đếm MaHP trong bảng DMHOCPHAN) thuộc
--về mỗi ngành học (nhóm theo TenNganh trong bảng DMNGANH).
create view ht19
as
	select n.TENNGANH, count(h.MAHP) as TongHocPhan
	from DMNGANH n
	join DMHOCPHAN h on h.MANGANH = n.MANGANH
	group by n.TENNGANH
--20. Tạo View danh sách các lớp có số lượng sinh viên thực tế trên 40 sinh viên(nhóm
--theo TenLop trong bảng DMLOP, có điều kiện đếm MaSV > 40 trong bảng
--SINHVIEN).
create view ht20
as
	select l.TENLOP, count(s.MASV) as SoLuongSV
	from DMLOP l
	join SINHVIEN s on s.MALOP = l.MALOP
	group by l.TENLOP
	having count(s.MASV) > 40