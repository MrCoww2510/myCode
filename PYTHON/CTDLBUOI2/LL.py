class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

class LinkList:
    def __init__(self):
        self.head=None
    
    def add(self,data):
        newNode = Node(data)
        temp = self.head
        if (self.head == None):
            self.head=newNode
        else:
            while temp.next:
                temp = temp.next
            temp.next = newNode

ds = LinkList()
ds.add(77)        
ds.add(778)        
ds.add(779)        
ds.add(7700)        
temp = ds.head
while temp:
    print('['+str(temp.data)+']-->',end="")
    temp = temp.next