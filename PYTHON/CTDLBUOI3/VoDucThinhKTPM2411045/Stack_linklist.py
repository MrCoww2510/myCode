# Tạo nút chứa dữ liệu
class StackNode:
    def __init__(self, data):
        self.data = data  # Giá trị của nút
        self.next = None  # Con trỏ tới nút tiếp theo

# Tạo ngăn xếp
class Stack:
    def __init__(self):
        self.root = None  # Nút gốc đại diện cho phần tử trên cùng

    def isEmpty(self):
        return self.root is None  # True nếu ngăn xếp rỗng

    def push(self, data):
        newNode = StackNode(data)  # Tạo nút mới
        newNode.next = self.root   # Nối nút mới tới nút gốc hiện tại
        self.root = newNode        # Cập nhật nút gốc là nút mới
        print(f"{data} pushed to stack")

    def pop(self):
        if self.isEmpty():
            return None
        temp = self.root
        self.root = self.root.next
        return temp.data

    def top(self):
        if self.isEmpty():
            return None
        return self.root.data

# Kiểm tra
stack = Stack()
stack.push(10)
stack.push(20)
stack.push(30)
print(f"{stack.pop()} popped from stack")
print(f"Top element is {stack.top()}")