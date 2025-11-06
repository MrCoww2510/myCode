class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkList:
    def __init__(self):
        self.head = None
    
    def addHead(self,data):
        newnode = Node(data)
        if self.head == None:
            self.head = newnode
        else:
            newnode.next = self.head
            self.head = newnode
    
    def addTail(self,data):
        newnode = Node(data)
        if self.head == None:
            self.head = newnode
        else:
            tam = self.head
            while tam.next != None:
                tam = tam.next
            tam.next = newnode
    
    def count(self):
        dem = 0
        tam = self.head
        while (tam != None):
            tam = tam.next
            dem +=1
        return dem
    
    def insert(self,data,vitrichensau):
        newnode = Node(data)
        tam = self.head
        if self.head == None:
            self.head = newnode
            return
        else:
            while (tam != None and tam.data != vitrichensau):
                tam = tam.next
            if tam == None:
                print('khog tim thay vi tri chen')
                return
            newnode.next = tam.next
            tam.next = newnode
            return
    
    def delHead(self):
        if self.head == None:
            print('rỗng')
            return
        elif self.head.next == None:
            self.head = None
            return
        self.head = self.head.next

    def delTail(self):
        if self.head == None:
            print('rỗng')
            return
        elif self.head.next == None:
            self.head = None
            return
        tam = self.head
        while tam.next.next != None:
            tam = tam.next
        tam.next = None
        
    def delPos(self,data):
        tam = self.head
        if tam == None:
                print('rỗng')
                return
            
        if tam.data == data:
            self.head = tam.next
            return
        
        while tam.next != None and tam.next.data != data:
            tam = tam.next
            
        if tam.next == None:
            print('ko tim thay node can xoa')
            return
        
        tam.next = tam.next.next

    def printList(self):
        tam = self.head
        if tam == None:
            print('rỗng') 
            return
        while tam != None:
            print("["+str(tam.data)+"]-->",end="")
            tam = tam.next
        print('None')
        
"""------------------------------------------"""

ds = LinkList()
ds.addTail(5)
ds.addTail(6)
ds.addTail(12)
ds.addTail(54)
ds.addTail(6)
ds.addTail(9)
ds.addTail(12)
ds.addTail(59)
ds.addTail(0)
ds.addTail(8)
ds.printList()
ds.insert(10,9)
ds.printList()