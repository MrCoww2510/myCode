class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Queue:
    def __init__(self):
        self.front = None
        self.rear = None

    def isEmpty(self):
        return self.front is None

    def EnQueue(self, item):
        temp = Node(item)
        if self.isEmpty():
            self.front = self.rear = temp
        else:
            self.rear.next = temp
            self.rear = temp
        print(f"Giá trị {item} được thêm vào hàng đợi")

    def DeQueue(self):
        if self.isEmpty():
            print("Hàng đợi rỗng")
            return None
        temp = self.front
        self.front = self.front.next
        if self.front is None:
            self.rear = None
        print(f"Giá trị {temp.data} được lấy ra khỏi hàng đợi")
        return temp.data

# Kiểm tra
q = Queue()
q.EnQueue(10)
q.EnQueue(20)
q.DeQueue()
q.DeQueue()
q.EnQueue(30)
q.EnQueue(40)
q.EnQueue(50)
q.DeQueue()
print("Queue Front " + str(q.front.data))
print("Queue Rear " + str(q.rear.data))