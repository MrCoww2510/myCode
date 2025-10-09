''' Mã số sinh viên Họ đệm Tên Giới tính Ngày sinh MMT CTDL
1 CNTT2411103 Cao Hoàng An Nam 23/10/2007 8 7
2 CNTT2411026 Dương Hoàng Ân Nam 12/01/2007 9 6.5
3 KTPM2211019 Trần Công Anh Nam 19/06/2007 6.5 9
4 KTPM2211069 Nguyễn Minh Thái Bảo Nam 30/12/2007 6 8.75
5 CNTT2411052 Lê Thanh Bình Nam 01/01/2007 7.75 5.75
6 CNTT2411030 Châu Thúy Cẩm Nam 05/08/2007 10 8
7 CNTT2411056 Thái Lục Cân Nam 26/01/2007 9.25 7 

Sử dụng mảng (array) để làm các yêu cầu sau:
a) Tạo các mảng lưu trữ thông tin của bảng.
b) In ra màn hình các thông tin của sinh viên tương tự như bảng trên
c) Tính tổng điểm thi môn MMT và CTDL của toàn bộ sinh viên trong bảng,
thêm giá trị này vào vị trí cuối cùng của bảng trong câu (b)
d) Tìm thông tin sinh viên có điểm môn MMT lớn nhất và nhỏ nhất in thông
tin ra màn hình
e) Thống kê có bao nhiêu sinh viên có môn CTDL từ 7 điểm trở lên và bao
nhiêu sinh viên thấp hơn 7, in thông tin các sinh viên thuộc các trường hợp trên
tương ứng
f) Tìm các sinh viên có Ngày sinh trong tháng 10 và gửi lời chúc sinh nhật
đến họ ra màn hình 

'''
import array;
#a
mssv = ['CNTT2411103', 'CNTT2411026', 'KTPM2211019', 'KTPM2211069', 'CNTT2411052', 'CNTT2411030', 'CNTT2411056']
hotendem = ['Cao Hoàng', 'Dương Hoàng', 'Trần Công', 'Nguyễn Minh Thái', 'Lê Thanh', 'Châu Thúy', 'Thái Lục']
ten = ['An', 'Ân', 'Anh', 'Bảo', 'Bình', 'Cẩm', 'Cân']
gioitinh = ['Nam', 'Nam', 'Nam', 'Nam', 'Nam', 'Nam', 'Nam']
ngaysinh = ['23/10/2007', '12/01/2007', '19/06/2007', '30/12/2007', '01/01/2007', '05/08/2007', '26/01/2007']
mmt = array.array('f',[8, 9, 6.5, 6, 7.75, 10, 9.25])
ctdl = array.array('f',[7, 6.5, 9, 8.75, 5.75, 8, 7])

#b
for i in range(len(mssv)):
    print(mssv[i] +" " + hotendem[i] + " " + ten[i] + " " + gioitinh[i] + " " + ngaysinh[i] + " " + str(mmt[i]) + " " + str(ctdl[i]))

#c
tongmmt=sum(mmt)
tongctdl=sum(ctdl)
print("Tổng điểm thi môn MMT của toàn bộ sinh viên trong bảng là: ", tongmmt)
print("Tổng điểm thi môn CTDL của toàn bộ sinh viên trong bảng là: ", tongctdl)

#d
max_mmt = max(mmt)
min_mmt = min(mmt)
index_max_mmt = mmt.index(max_mmt)
index_min_mmt = mmt.index(min_mmt)
print("Sinh viên có điểm môn MMT lớn nhất là: ", mssv[index_max_mmt], hotendem[index_max_mmt], ten[index_max_mmt], "với điểm MMT là: ", max_mmt)
print("Sinh viên có điểm môn MMT nhỏ nhất là: ", mssv[index_min_mmt], hotendem[index_min_mmt], ten[index_min_mmt], "với điểm MMT là: ", min_mmt)

#e
count_ctdl_ge_7 = 0
count_ctdl_lt_7 = 0
print("Sinh viên có môn CTDL từ 7 điểm trở lên:")
for i in range(len(ctdl)):
    if ctdl[i] >= 7:
        count_ctdl_ge_7 += 1
        print(mssv[i] +" " + hotendem[i] + " " + ten[i] + " " + gioitinh[i] + " " + ngaysinh[i] + " " + str(mmt[i]) + " " + str(ctdl[i]))
print("Tổng số sinh viên có môn CTDL từ 7 điểm trở lên là: ", count_ctdl_ge_7)
print("Sinh viên có môn CTDL thấp hơn 7 điểm:")
for i in range(len(ctdl)):
    if ctdl[i] < 7:
        count_ctdl_lt_7 += 1
        print(mssv[i] +" " + hotendem[i] + " " + ten[i] + " " + gioitinh[i] + " " + ngaysinh[i] + " " + str(mmt[i]) + " " + str(ctdl[i]))
print("Tổng số sinh viên có môn CTDL thấp hơn 7 điểm là: ", count_ctdl_lt_7)

#f
print("Sinh viên có Ngày sinh trong tháng 10:")
for i in range(len(ngaysinh)):
    if ngaysinh[i][3:5] == '10':
        print("Chúc mừng sinh nhật sinh viên: ", mssv[i], hotendem[i], ten[i], "ngày sinh: ", ngaysinh[i])