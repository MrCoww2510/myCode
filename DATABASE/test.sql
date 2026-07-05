-- ==========================================
-- DẠNG 1: CÂU LỆNH TRUY VẤN CÓ ĐIỀU KIỆN
-- ==========================================

-- Bài số 1: Câu lệnh SQL không kết nối
-- 1. DSSV trong trường
SELECT MaSV, HoTen, MaLop, NgaySinh, GioiTinh FROM SINHVIEN;

-- 2. DSSV Nữ (Năm sinh)
SELECT MaSV, HoTen, MaLop, YEAR(NgaySinh) AS NamSinh, GioiTinh FROM SINHVIEN WHERE GioiTinh = N'Nữ';

-- 3. SV Nam ở Tuy Phước hay Tây Sơn
SELECT MaSV, HoTen, MaLop, NgaySinh, GioiTinh FROM SINHVIEN WHERE GioiTinh = N'Nam' AND (NoiSinh = N'Tuy Phước' OR NoiSinh = N'Tây Sơn');

-- 4. SV Nam học lớp CT13 (dd/mm/yyyy)
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh FROM SINHVIEN WHERE GioiTinh = N'Nam' AND MaLop = 'CT13';

-- 5. SV Nam học lớp CT11 (Hiển thị Nam/Nữ)
SELECT MaSV, HoTen, MaLop, YEAR(NgaySinh) AS NamSinh, CASE WHEN GioiTinh = 1 THEN N'Nam' ELSE N'Nữ' END AS GioiTinh FROM SINHVIEN WHERE GioiTinh = N'Nam' AND MaLop = 'CT11';

-- 6. SV có ký tự thứ 2 của Hoten là 'g'
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh, GioiTinh FROM SINHVIEN WHERE HoTen LIKE '_g%';

-- 7. SV có họ lót là “Văn”
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh, GioiTinh FROM SINHVIEN WHERE HoTen LIKE N'% Văn %';

-- 8. SV có họ không bắt đầu bằng N,L,T
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh, GioiTinh FROM SINHVIEN WHERE HoTen NOT LIKE '[NLT]%';

-- 9. SV học lớp CT11, CT12, CT13
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh, GioiTinh FROM SINHVIEN WHERE MaLop IN ('CT11', 'CT12', 'CT13');

-- 10. SV có tuổi từ 20-29
SELECT MaSV, HoTen, MaLop, CONVERT(VARCHAR, NgaySinh, 103) AS NgaySinh, GioiTinh, (YEAR(GETDATE()) - YEAR(NgaySinh)) AS Tuoi FROM SINHVIEN WHERE (YEAR(GETDATE()) - YEAR(NgaySinh)) BETWEEN 20 AND 29;


-- Bài số 2: Câu lệnh SQL có kết nối
-- 1. Điểm HP >= 5, sắp xếp theo Mã lớp, Họ tên tăng dần
SELECT SV.MaSV, SV.HoTen, SV.MaLop, D.MaHP, D.DiemHP FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.DiemHP >= 5 ORDER BY SV.MaLop, SV.HoTen;

-- 2. Điểm HP từ 7 đến 9 ở học kỳ I
SELECT SV.MaSV, SV.HoTen, SV.MaLop, D.DiemHP, D.MaHP FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.HocKy = 1 AND D.DiemHP BETWEEN 7 AND 9;

-- 3. SV thuộc Khoa CNTT hoặc KT
SELECT SV.MaSV, SV.HoTen, SV.MaLop, L.TenLop, K.TenKhoa FROM SINHVIEN SV JOIN LOP L ON SV.MaLop = L.MaLop JOIN KHOA K ON L.MaKhoa = K.MaKhoa WHERE K.MaKhoa IN ('CNTT', 'KT');


-- ==========================================
-- DẠNG 2: CÂU LỆNH TRUY VẤN CÓ PHÂN NHÓM
-- ==========================================

-- Bài số 1: GROUP BY không điều kiện
-- 1. Tổng số SV của mỗi lớp
SELECT L.MaLop, L.TenLop, COUNT(SV.MaSV) AS TongSV FROM LOP L LEFT JOIN SINHVIEN SV ON L.MaLop = SV.MaLop GROUP BY L.MaLop, L.TenLop;

-- 2. ĐTB chung của mỗi SV ở mỗi học kỳ
SELECT MaSV, HocKy, AVG(DiemHP) AS DiemTBC FROM DIEM GROUP BY MaSV, HocKy;

-- 3. Số lượng nam nữ theo từng lớp
SELECT MaLop, GioiTinh, COUNT(MaSV) AS SoLuong FROM SINHVIEN GROUP BY MaLop, GioiTinh;


-- Bài số 2: GROUP BY với điều kiện lọc (WHERE)
-- 1. Số các học phần thiếu điểm (<5) của mỗi SV
SELECT SV.MaSV, SV.HoTen, COUNT(D.MaHP) AS SoHocPhanNo FROM SINHVIEN SV LEFT JOIN DIEM D ON SV.MaSV = D.MaSV AND D.DiemHP < 5 GROUP BY SV.MaSV, SV.HoTen;

-- 2. Đếm số SV có điểm HP > 5 của mỗi học phần
SELECT MaHP, COUNT(MaSV) AS SoSV_Dat FROM DIEM WHERE DiemHP > 5 GROUP BY MaHP;

-- 3. Tổng số DVHT có điểm HP >= 5 của mỗi SV
SELECT SV.MaSV, SUM(HP.SoDVHT) AS TongDVHT FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV JOIN HOCPHAN HP ON D.MaHP = HP.MaHP WHERE D.DiemHP >= 5 GROUP BY SV.MaSV;


-- Bài số 3: GROUP BY với điều kiện nhóm (HAVING)
-- 1. Lớp có tổng số SV >= 10
SELECT L.MaLop, L.TenLop FROM LOP L JOIN SINHVIEN SV ON L.MaLop = SV.MaLop GROUP BY L.MaLop, L.TenLop HAVING COUNT(SV.MaSV) >= 10;

-- 2. HoTen SV có điểm TBC các học phần < 3
SELECT SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV GROUP BY SV.MaSV, SV.HoTen HAVING AVG(D.DiemHP) < 3;

-- 3. SV có ít nhất 2 học phần có điểm <= 5
SELECT SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.DiemHP <= 5 GROUP BY SV.MaSV, SV.HoTen HAVING COUNT(D.MaHP) >= 2;

-- 4. SV học TẤT CẢ các học phần ở ngành 140902
SELECT SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.MaHP IN (SELECT MaHP FROM HOCPHAN WHERE MaNganh = '140902') GROUP BY SV.MaSV, SV.HoTen HAVING COUNT(DISTINCT D.MaHP) = (SELECT COUNT(*) FROM HOCPHAN WHERE MaNganh = '140902');

-- 5. SV học ít nhất 3 học phần mã ‘001’, ‘002’, ‘003’
SELECT SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.MaHP IN ('001', '002', '003') GROUP BY SV.MaSV, SV.HoTen HAVING COUNT(DISTINCT D.MaHP) >= 3;


-- Bài số 4: Câu lệnh SQL có từ khoá TOP
-- 1. SV có điểm TBC cao nhất ở học kỳ 1
SELECT TOP 1 WITH TIES SV.MaSV, SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.HocKy = 1 GROUP BY SV.MaSV, SV.HoTen ORDER BY AVG(D.DiemHP) DESC;

-- 2. SV có số học phần điểm HP < 5 nhiều nhất
SELECT TOP 1 WITH TIES SV.MaSV, SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.DiemHP < 5 GROUP BY SV.MaSV, SV.HoTen ORDER BY COUNT(D.MaHP) DESC;

-- 3. Học phần có số SV điểm HP < 5 nhiều nhất
SELECT TOP 1 WITH TIES HP.MaHP, HP.TenHP FROM HOCPHAN HP JOIN DIEM D ON HP.MaHP = D.MaHP WHERE D.DiemHP < 5 GROUP BY HP.MaHP, HP.TenHP ORDER BY COUNT(D.MaSV) DESC;


-- ==========================================
-- DẠNG 3: CÂU LỆNH TRUY VẤN VỚI CẤU TRÚC LỒNG NHAU
-- ==========================================

-- Bài số 1: Cấu trúc lồng nhau phủ định
-- 1. SV KHÔNG học học phần nào
SELECT HoTen FROM SINHVIEN WHERE MaSV NOT IN (SELECT MaSV FROM DIEM);

-- 2. SV CHƯA học học phần có mã ‘002’
SELECT HoTen FROM SINHVIEN WHERE MaSV NOT IN (SELECT MaSV FROM DIEM WHERE MaHP = '002');

-- 3. Tên học phần KHÔNG có SV điểm HP <= 5
SELECT TenHP FROM HOCPHAN WHERE MaHP NOT IN (SELECT MaHP FROM DIEM WHERE DiemHP <= 5);

-- 4. SV KHÔNG có học phần điểm HP < 5
SELECT HoTen FROM SINHVIEN WHERE MaSV NOT IN (SELECT MaSV FROM DIEM WHERE DiemHP < 5) AND MaSV IN (SELECT MaSV FROM DIEM);


-- Bài số 2: Cấu trúc lồng nhau không kết nối
-- 1. Tên lớp có SV nữ tên Hoa
SELECT TenLop FROM LOP WHERE MaLop IN (SELECT MaLop FROM SINHVIEN WHERE GioiTinh = N'Nữ' AND HoTen LIKE N'% Hoa');

-- 2. SV có điểm học phần ‘001’ là > 5
SELECT HoTen FROM SINHVIEN WHERE MaSV IN (SELECT MaSV FROM DIEM WHERE MaHP = '001' AND DiemHP > 5);

-- 3. HP có số DVHT >= số DVHT của học phần mã 001
SELECT MaHP, TenHP FROM HOCPHAN WHERE SoDVHT >= (SELECT SoDVHT FROM HOCPHAN WHERE MaHP = '001');


-- ==========================================
-- DẠNG 4: CÂU LỆNH TRUY VẤN VỚI LƯỢNG TỪ ALL, ANY, EXISTS
-- ==========================================

-- Bài số 1: Lượng từ ALL
-- 1. SV có DiemHP cao nhất
SELECT SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.DiemHP >= ALL (SELECT DiemHP FROM DIEM);

-- 2. SV có tuổi cao nhất
SELECT HoTen FROM SINHVIEN WHERE NgaySinh <= ALL (SELECT NgaySinh FROM SINHVIEN);

-- 3. SV có điểm HP mã ‘001’ cao nhất
SELECT SV.MaSV, SV.HoTen FROM SINHVIEN SV JOIN DIEM D ON SV.MaSV = D.MaSV WHERE D.MaHP = '001' AND D.DiemHP >= ALL (SELECT DiemHP FROM DIEM WHERE MaHP = '001');


-- Bài số 2: Lượng từ ANY
-- 1. Điểm HP lớn hơn bất kỳ điểm HP nào của SV mã ‘001’
SELECT MaSV, MaHP FROM DIEM WHERE DiemHP > ANY (SELECT DiemHP FROM DIEM WHERE MaSV = '001');

-- 2. SV có điểm HP lớn hơn gấp rưỡi ĐTB chung của chính mình
SELECT D1.MaSV FROM DIEM D1 WHERE D1.DiemHP > 1.5 * (SELECT AVG(D2.DiemHP) FROM DIEM D2 WHERE D2.MaSV = D1.MaSV);


-- Bài số 3: Lượng từ EXISTS
-- 1. SV đã ít nhất một lần học học phần nào đó
SELECT SV.MaSV, SV.HoTen FROM SINHVIEN SV WHERE EXISTS (SELECT 1 FROM DIEM D WHERE D.MaSV = SV.MaSV);

-- 2. SV đã không học học phần nào
SELECT SV.MaSV, SV.HoTen FROM SINHVIEN SV WHERE NOT EXISTS (SELECT 1 FROM DIEM D WHERE D.MaSV = SV.MaSV);

-- 3. Lớp đã không có SV nào học
SELECT L.MaLop, L.TenLop FROM LOP L WHERE NOT EXISTS (SELECT 1 FROM SINHVIEN SV WHERE SV.MaLop = L.MaLop);