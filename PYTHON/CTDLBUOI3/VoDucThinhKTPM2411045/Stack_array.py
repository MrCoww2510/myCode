import array

class StackArray:
    def __init__(self, nsize):
        self.data = array.array('i', [0]*nsize)  # Mảng chứa dữ liệu
        self.size = nsize                         # Kích thước tối đa
        self.topIndex = -1                        # Chỉ số phần tử trên cùng

    def isEmpty(self):
        return self.topIndex == -1

    def isFull(self):
        return self.topIndex == self.size - 1

    def push(self, item):
        if self.isFull():
            print("Ngăn xếp đầy")
            return
        self.topIndex += 1
        self.data[self.topIndex] = item
        print(f"{item} pushed to stack")

    def pop(self):
        if self.isEmpty():
            print("Ngăn xếp rỗng")
            return None
        item = self.data[self.topIndex]
        self.topIndex -= 1
        return item

    def top(self):
        if self.isEmpty():
            return None
        return self.data[self.topIndex]

# Kiểm tra
stack = StackArray(5)
stack.push(1)
stack.push(2)
stack.push(3)
stack.push(4)
stack.push(5)
stack.push(6)
print(stack.pop())
print(stack.top())

# a) Chuyển số thập phân N sang nhị phân
def DecimalToBinary(N):
    stack = StackArray(32)
    if N == 0:
        return "0"
    while N > 0:
        stack.push(N % 2)
        N //= 2
    binary = ""
    while not stack.isEmpty():
        binary += str(stack.pop())
    return binary

print(DecimalToBinary(13))  # Output: 1101

# b) Kiểm tra từ có phải palindrome hay không
def IsPalindrome(word):
    stack = StackArray(len(word))
    for ch in word:
        stack.push(ch)
    reversed_word = ""
    while not stack.isEmpty():
        reversed_word += stack.pop()
    return word == reversed_word

print(IsPalindrome("tốt"))  # True nếu palindrome, False nếu không