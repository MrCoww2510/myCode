# ----------------------------
# BÀI 2.5 – DANH SÁCH LIÊN KẾT ĐƠN
# ----------------------------

# Lớp Node
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


# Lớp LinkedList
class LinkedList:
    def __init__(self):
        self.head = None

    # a) Đếm số phần tử trong danh sách
    def dem_so_phan_tu(self):
        count = 0
        current = self.head
        while current:
            count += 1
            current = current.next
        return count

    # b) Thêm phần tử vào cuối danh sách
    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    # In toàn bộ danh sách
    def in_ds(self):
        current = self.head
        while current:
            print(current.data, end=" -> ")
            current = current.next
        print("None")

    # c) Thêm giá trị x vào sau giá trị y
    def chen_sau(self, y, x):
        current = self.head
        while current:
            if current.data == y:
                new_node = Node(x)
                new_node.next = current.next
                current.next = new_node
                return
            current = current.next
        print(f"Không tìm thấy giá trị {y} trong danh sách.")

    # d) Thay đổi giá trị a thành b
    def thay_doi(self, a, b):
        current = self.head
        while current:
            if current.data == a:
                current.data = b
            current = current.next

    # e) In 3 giá trị cuối và tính tổng + 2
    def in_3_cuoi_va_tong(self):
        arr = []
        current = self.head
        while current:
            arr.append(current.data)
            current = current.next
        print("3 giá trị cuối:", arr[-3:])
        tong = sum(arr) + 2
        print("Tổng các giá trị + 2 =", tong)


# ----------------------------
# PHẦN 1: DỮ LIỆU SỐ
# ----------------------------
print("=== DANH SÁCH SỐ ===")
ds = LinkedList()

# b) Thêm các phần tử
for x in [5, 6, 12, 54, 6, 9, 12, 59, 0, 8]:
    ds.append(x)

print("Danh sách ban đầu:")
ds.in_ds()

# c) Thêm 10 vào sau 9
ds.chen_sau(9, 10)
print("Sau khi thêm 10 vào sau 9:")
ds.in_ds()

# d) Thay giá trị 0 bằng 20
ds.thay_doi(0, 20)
print("Sau khi thay 0 bằng 20:")
ds.in_ds()

# e) In 3 giá trị cuối và tổng + 2
ds.in_3_cuoi_va_tong()

print("Số phần tử trong danh sách:", ds.dem_so_phan_tu())


# ----------------------------
# PHẦN 2: DANH SÁCH SINH VIÊN
# ----------------------------

class SinhVien:
    def __init__(self, msv, hodem, ten, gioitinh, ngaysinh, lophoc):
        self.msv = msv
        self.hodem = hodem
        self.ten = ten
        self.gioitinh = gioitinh
        self.ngaysinh = ngaysinh
        self.lophoc = lophoc

    def __str__(self):
        return f"{self.msv} | {self.hodem} {self.ten} | {self.gioitinh} | {self.ngaysinh} | {self.lophoc}"


class NodeSV:
    def __init__(self, sv):
        self.data = sv
        self.next = None


class LinkedListSV:
    def __init__(self):
        self.head = None

    def append(self, sv):
        new_node = NodeSV(sv)
        if not self.head:
            self.head = new_node
            return
        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    def in_danh_sach(self):
        current = self.head
        while current:
            print(current.data)
            current = current.next

    def tim_theo_ten(self, ten_can_tim):
        print(f"\nKết quả tìm kiếm theo tên '{ten_can_tim}':")
        current = self.head
        found = False
        while current:
            if current.data.ten.lower() == ten_can_tim.lower():
                print(current.data)
                found = True
            current = current.next
        if not found:
            print("Không có sinh viên nào trùng tên.")

    def tim_theo_ngaysinh(self, ngay_can_tim):
        print(f"\nKết quả tìm kiếm theo ngày sinh '{ngay_can_tim}':")
        current = self.head
        found = False
        while current:
            if current.data.ngaysinh == ngay_can_tim:
                print(current.data)
                found = True
            current = current.next
        if not found:
            print("Không có sinh viên nào trùng ngày sinh.")


# Dữ liệu mẫu
print("\n=== DANH SÁCH SINH VIÊN ===")
sv_list = LinkedListSV()
sv_list.append(SinhVien("2101259", "Nguyễn Thị Ái", "Trân", "Nữ", "04/06/2003", "KTPM0121"))
sv_list.append(SinhVien("2101538", "Phan Nguyễn Hoàng", "Trân", "Nam", "23/06/2003", "KTPM0121"))
sv_list.append(SinhVien("2100574", "Trương Chí", "Trung", "Nam", "20/07/2003", "KTPM0121"))
sv_list.append(SinhVien("2100320", "Nguyễn Hải", "Tường", "Nam", "15/03/2003", "KTPM0121"))
sv_list.append(SinhVien("2101236", "Võ Quang", "Vinh", "Nam", "24/02/2003", "KTPM0121"))

sv_list.in_danh_sach()

# Tìm kiếm theo tên
sv_list.tim_theo_ten("Trân")

# Tìm kiếm theo ngày sinh
sv_list.tim_theo_ngaysinh("24/02/2003")