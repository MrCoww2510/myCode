'''
Câu hỏi 1: Viết chương trình Python để xây dựng danh sách liên kết đơn (Singly Linked List) gồm các phần tử 1, 3, 6, 2, 10.
'''
'''cau 1'''
# Lớp Node đại diện cho 1 phần tử trong danh sách
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

# --- Chương trình chính ---
L = LinkedList()
for x in [1, 3, 6, 2, 10]:
    L.append(x)

print("Danh sách liên kết gồm các phần tử:")
L.printList()

