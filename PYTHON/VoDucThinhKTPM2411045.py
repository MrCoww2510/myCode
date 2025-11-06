#Note git, kiểm tra giữa kì CTDL ngày 06/11/2025
#
#
#Cho một khai báo về nút và danh sách liên kết đôi
#Hãy hoàn thiện các phương thức được khai báo bên duới đây
class Nut:
    def __init__(self, du_lieu):
        self.du_lieu = du_lieu
        self.nut_truoc = None
        self.nut_sau = None
class DanhSachLienKetDoi:
    def __init__(self):
        self.vi_tri_dau_ds = None
        self.vi_tri_cuoi_ds = None
#(2 điểm)
#Phương thức thêm dữ liệu vào bên trái vị trí được xác định
#Ví dụ: thêm 2 vào bên trái vị trí 3 (3 là tham số vi_tri
#trong phương thức) trong [1, 4, 3, 6]  [1, 4, 2, 3, 6]
    def them_dulieu_vao_ben_trai_vi_tri(self, vi_tri, du_lieu):
#Viết Code của bạn tại đây
        newNode = Nut(du_lieu)
        temp = self.vi_tri_dau_ds

        if temp is None:
            self.vi_tri_dau_ds = newNode
            self.vi_tri_cuoi_ds = newNode
            return

        while temp is not None and temp.du_lieu != vi_tri:
            temp = temp.nut_sau

        if temp is None:
            print("Không tìm thấy giá trị cần chèn bên trái.")
            return

        if temp == self.vi_tri_dau_ds:
            newNode.nut_sau = temp
            temp.nut_truoc = newNode
            self.vi_tri_dau_ds = newNode
        else:
            truoc = temp.nut_truoc
            newNode.nut_truoc = truoc
            newNode.nut_sau = temp
            truoc.nut_sau = newNode
            temp.nut_truoc = newNode



#(2 điểm)
#Phương thức thêm dữ liệu vào bên phải vị trí được xác định
#Ví dụ: thêm 2 vào bên phải vị trí 3 (3 là tham số vi_tri
#trong phương thức) trong [1, 4, 3, 6]  [1, 4, 3, 2, 6]
    def them_dulieu_vao_ben_phai_vi_tri(self, vi_tri, du_lieu):
#Viết Code của bạn tại đây
        newNode = Nut(du_lieu)
        temp = self.vi_tri_dau_ds

        if temp is None:
            self.vi_tri_dau_ds = newNode
            self.vi_tri_cuoi_ds = newNode
            return

        while temp is not None and temp.du_lieu != vi_tri:
            temp = temp.nut_sau

        if temp is None:
            print("Không tìm thấy giá trị cần chèn bên phải.")
            return

        if temp == self.vi_tri_cuoi_ds:
            temp.nut_sau = newNode
            newNode.nut_truoc = temp
            self.vi_tri_cuoi_ds = newNode
        else:
            sau = temp.nut_sau
            newNode.nut_sau = sau
            newNode.nut_truoc = temp
            temp.nut_sau = newNode
            sau.nut_truoc = newNode



#(2 điểm)
#Phương thức xóa dữ liệu ở bên trái vị trí được xác định
#Ví dụ: xóa phần tử bên phải vị trí 3 (3 là tham số vi_tri
#trong phương thức) trong [1, 4, 3, 6]  [1, 3, 6]
    def xoa_phan_tu_ben_trai_vi_tri(self ,vi_tri):
#Viết Code của bạn tại đây
        temp = self.vi_tri_dau_ds

        if temp is None:
            print("Danh sách rỗng.")
            return

        while temp is not None and temp.du_lieu != vi_tri:
            temp = temp.nut_sau

        if temp is None or temp.nut_truoc is None:
            print("Không có phần tử bên trái để xóa.")
            return

        node_xoa = temp.nut_truoc

        if node_xoa == self.vi_tri_dau_ds:
            self.vi_tri_dau_ds = temp
            temp.nut_truoc = None
        else:
            truoc = node_xoa.nut_truoc
            truoc.nut_sau = temp
            temp.nut_truoc = truoc



#(2 điểm)
#Phương thức xóa dữ liệu ở bên phải vị trí được xác định
#Ví dụ: xóa phần tử bên phải vị trí 3 (3 là tham số vi_tri
#trong phương thức) trong [1, 4, 3, 6]  [1, 4, 3]
    def xoa_phan_tu_ben_phai_vi_tri(self ,vi_tri):
#Viết Code của bạn tại đây
        temp = self.vi_tri_dau_ds

        if temp is None:
            print("Danh sách rỗng.")
            return

        while temp is not None and temp.du_lieu != vi_tri:
            temp = temp.nut_sau

        if temp is None or temp.nut_sau is None:
            print("Không có phần tử bên phải để xóa.")
            return

        node_xoa = temp.nut_sau

        if node_xoa == self.vi_tri_cuoi_ds:
            self.vi_tri_cuoi_ds = temp
            temp.nut_sau = None
        else:
            sau = node_xoa.nut_sau
            temp.nut_sau = sau
            sau.nut_truoc = temp



#(2 điểm)
#Phương thức in các phần tử của danh sách bắt đầu từ vị trí đầu
#tiên ra màn hình
    def in_danh_sach_tu_dau(self):
#Viết Code của bạn tại đây
        temp = self.vi_tri_dau_ds
        while temp is not None:
            print(  "["+str(temp.du_lieu)+"]-->", end="")
            temp = temp.nut_sau
        print('None')
        
'''==============================={chạy thử}==================================='''
ds = DanhSachLienKetDoi()
ds.them_dulieu_vao_ben_phai_vi_tri(0,25)
ds.them_dulieu_vao_ben_phai_vi_tri(25,2005)
ds.them_dulieu_vao_ben_trai_vi_tri(2005,10)
ds.in_danh_sach_tu_dau()