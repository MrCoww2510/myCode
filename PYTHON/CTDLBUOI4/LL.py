class Node:
    def __init__(self,data):
        self.data=data
        self.next=None
        self.prev=None

class LinkList:
    def __init__(self):
        self.head=None
        self.tail=None #tương tự đơn mà thêm đuôi
    
    def addAtHead(self,data):
        newNode = Node(data)
        temp = self.head
        if (self.head == None):
            self.head=newNode
            self.tail=newNode
        else:
            newNode.next = self.head
            self.head.prev = newNode
            self.head = newNode

    def addAtTail(self,data):   #thay vì duyệt từ đầu đến đuôi thì xuất phát từ đuôi rồi làm tương tự đàu mà ngược lại
        newNode = Node(data)
        temp = self.head
        if (self.tail == None):
            self.head=newNode
            self.tail=newNode
        else:
            newNode.prev = self.tail
            self.tail.next = newNode
            self.tail = newNode
    
    def insert(self,data,vitridatachensau): #như lk đơn mà thêm phần nối prev thôi
        newNode = Node(data)
        temp = self.head
        if (self.tail == None):
            self.head=newNode
            self.tail=newNode
        else:
            while (temp != None)and(temp.data != vitridatachensau):
                temp = temp.next
            newNode.prev = temp
            newNode.next = temp.next
            temp.next = newNode
            temp.next.prev = newNode

    def delAtHead(self):    #như lk đơn mà thêm đk xem có phải chỉ có duy nhất 1 pt hay không
        temp =self.head
        if (self.head == None):
            print('danh sách rỗng không thể xóa')
        elif (self.head == self.tail):
            self.head = None
            self.tail = None
        else:
            self.head = temp.next
    
    def delAtTail(self):    #như xóa đầu mà làm ngược
        temp =self.tail
        if (self.tail == None):
            print('danh sách rỗng không thể xóa')
        elif (self.head == self.tail):
            self.head = None
            self.tail = None
        else:
            self.tail = temp.prev
    
    def printLL(self):  #bê từ lk đơn qua
        temp = self.head
        if self.head != None:
            while (temp != None):
                print('['+str(temp.data)+']-->',end="")
                temp = temp.next
            print()
        else:
            print("ds Rỗng")
    
    def count(self,data):
        temp = self.head
        dem=0
        luuvitri = []
        if self.head != None:
            while (temp != None):
                if temp.data == data:
                    luuvitri.append(dem)
                dem+=1
                temp = temp.next
            return luuvitri
    
    
    def delEveryWhere(self,data1,vitri):
        temp =self.head
        if (self.head == None):
            print('danh sách rỗng không thể xóa')
        elif (self.head == self.tail):
            self.head = None
            self.tail = None
        else:
            dem = 0
            while (temp != None):
                if (temp.data == data1) and (dem in self.count(data1)):
                    temp.next = temp.next.next
                    return
                dem +=1
                temp = temp.next
            
        
'''----------------------MAIN----------------------'''
ds = LinkList()
ds.printLL()
ds.addAtHead(77)        
ds.addAtHead(778)        
ds.addAtHead(778)        
ds.addAtHead(778)        
ds.addAtTail(778)        
ds.addAtTail(779)        
ds.addAtTail(7700)
ds.insert(2510,77) 
ds.insert(2510,779) 
ds.insert(2510,778) 
ds.printLL()
ds.delAtHead()
ds.printLL()
ds.delAtTail()      
ds.printLL()
print()
ds.count(778)

ds.delEveryWhere(2510,3)
ds.printLL()