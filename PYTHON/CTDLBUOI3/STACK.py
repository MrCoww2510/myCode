class StackNode:
    def __init__(self,data):
        self.data = data
        self.next = None
class Stack:
    def __init__(self):
        self.root = None
    
    def IsEmpty(self):
        if self.root is None:
            return True
        else:
            return False
    
    def push(self,data):
        NewNode = StackNode(data)
        NewNode.next = self.root
        self.root=NewNode
        print("% d pushed to stack"%(data))
    
    def pop(self):
        if self.IsEmpty():
            return None
        temp = self.root
        self.root = self.root.next
        popped = temp.data
        return popped
    
    def top(self):
        if self.IsEmpty():
            return None
        return self.root.data
    
'''--------------------------------------------'''
NganXep = Stack()
NganXep.push(10)
NganXep.push(20)
NganXep.push(30)
NganXep.push(40)
NganXep.push(50)

print("% d popped from stack" % (NganXep.pop())) 
print(" Top element is % d " % (NganXep.top()))