'''Câu hỏi 2: Cho danh sách sinh viên sau: 
a) Tạo danh sách liên kết LStudent với các khóa là MSSV. 
b) Thêm khóa “2100460” vào vị trí đầu tiên, khóa “2100761” vào vị trí thứ 3 và khóa “2101057” vào vị trí cuối cùng trong danh sách. 
In các phần tử có trong danh sách sau khi thêm phần tử. 
c) Xóa nút có khóa “2101259” và “01004023” ra khỏi danh sách và cho biết kết quả. 
d) Sử dụng vòng lặp và đệ quy để tìm độ dài của danh sách liên kết. 
e) Sử dụng vòng lặp và đệ quy để tìm khóa “2100320” trong danh sách liên kết.'''

'''cau 2'''
class Node:
    def __init__(self, data):
        self.data = data   # giá trị của nút
        self.next = None   # con trỏ trỏ đến nút tiếp theo

# Lớp LinkedList điều khiển toàn bộ danh sách
class LinkedList:
    def __init__(self):
        self.head = None   # ban đầu danh sách trống

    # Thêm phần tử vào cuối danh sách
    def append(self, new_data):
        new_node = Node(new_data)
        if self.head is None:      # nếu danh sách rỗng
            self.head = new_node
            return
        last = self.head
        while last.next:           # duyệt tới nút cuối cùng
            last = last.next
        last.next = new_node       # gắn nút mới vào cuối

    # In danh sách liên kết
    def printList(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

list_student = ["2100320", "2101259", "01004023", "2101111", "2100544"]
LS_student = LinkedList()
LS_student.__init__()
for student in list_student:
    LS_student.append(student)
LS_student.printList()