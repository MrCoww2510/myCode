class node:
    def __init__(self,data):
        self.data=data
        self.next=None
class linkedlist():
    def __init__(self):
        self.head=None
    def append(self,data): #thêm vào cuối danh sách
        new_node = node(data)
        if self.head is None:
            self.head = new_node
            return
        last_node = self.head
        while last_node.next:
            last_node = last_node.next
        last_node.next = new_node
    
    def prepend(self,data): #thêm vào đầu danh sách
        new_node=node(data)
        new_node.next=self.head
        self.head = new_node

    def insert_after(self, prev_data, new_data):
        current_node = self.head
        while current_node is not None and current_node.data != prev_data:
            current_node = current_node.next
        if current_node is None:
            print("không tìm được giá trị này trong ds")
            return 
        new_node = node(new_data)
        new_node.next = current_node.next
        current_node.next = new_node
    def find_linkedlist(self,find_data):
            current_node = self.head
            while current_node is not none and current_node.data != prev_data:
                current_node = current_node.next
            return current_node
    def dalete_linkedlist(self,delete_data):
        current_node = self.head
        if current_node and current_node.data == delete_data:
            self.head = current_node.next
            current_node = None
            return
        while current_node and current_node.data != delete_data:
            prev_node = current_node
            current_node=current_node.next
        if current_node is none:
            return
        prev_node.next = current_node.next
        current_node = None