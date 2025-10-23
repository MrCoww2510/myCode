import array

class QueueArray:
    def __init__(self, n_size):
        self.data = array.array('i', [0]*n_size)
        self.size = n_size
        self.front = 0
        self.rear = -1
        self.count = 0  # Số lượng phần tử hiện tại

    def isFull(self):
        return self.count == self.size

    def isEmpty(self):
        return self.count == 0

    def EnQueue(self, item):
        if self.isFull():
            print("Hàng đợi đầy")
            return
        self.rear = (self.rear + 1) % self.size
        self.data[self.rear] = item
        self.count += 1
        print(f"{item} được thêm vào hàng đợi")

    def DeQueue(self):
        if self.isEmpty():
            print("Hàng đợi rỗng")
            return None
        item = self.data[self.front]
        self.front = (self.front + 1) % self.size
        self.count -= 1
        print(f"{item} được lấy ra khỏi hàng đợi")
        return item

    def PrintRear(self):
        if self.isEmpty():
            print("Hàng đợi rỗng")
        else:
            print(f"Phần tử cuối cùng trong hàng đợi: {self.data[self.rear]}")

# Kiểm tra
queue = QueueArray(10)
queue.EnQueue(10)
queue.PrintRear()
queue.EnQueue(20)
queue.PrintRear()
queue.DeQueue()
queue.PrintRear()
queue.EnQueue(30)
queue.PrintRear()
queue.EnQueue(40)
queue.PrintRear()

class SoThuTuPhongKham:
    def __init__(self):
        self.queue = QueueArray(1000)
        self.last_number = 0

    def LaySo(self):
        if self.last_number >= 1000:
            print("Hết số thứ tự")
            return
        self.last_number += 1
        self.queue.EnQueue(self.last_number)
        print(f"Số thứ tự của bệnh nhân: {self.last_number}")

    def DocSo(self):
        number = self.queue.DeQueue()
        if number is not None:
            print(f"Gọi bệnh nhân số: {number}")

phongKham = SoThuTuPhongKham()
phongKham.LaySo()
phongKham.LaySo()
phongKham.LaySo()
phongKham.DocSo()
phongKham.DocSo()