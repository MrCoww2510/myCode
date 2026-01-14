# ==============================
# BÀI 1: CÂY TỔNG QUÁT (TREE)
# ==============================

# Lớp Node - biểu diễn 1 nút trong cây
class Node:
	def __init__(self, data):
		self.data = data                # Dữ liệu của nút
		self.list_child = []            # Danh sách con của nút

	def addChild(self, child_node):
		self.list_child.append(child_node)

	def getData(self):
		return self.data


# Lớp Tree - biểu diễn cây tổng quát
class Tree:
	def __init__(self, root):
		self.root = root

	# Duyệt cây bằng đệ quy
	def printTree(self, node=None, level=0):
		if node is None:
			node = self.root
		print(" " * level * 4 + str(node.getData()))
		for i in node.list_child:
			self.printTree(i, level + 1)

	# Duyệt cây bằng ngăn xếp
	def printTreeUsingStack(self, node=None):
		if node is None:
			node = self.root
		stack = [[node, 0]]
		while len(stack) > 0:
			data = stack.pop()
			node = data[0]
			level = data[1]
			print(" " * level * 4 + str(node.getData()))
			for i in reversed(node.list_child):
				stack.append([i, level + 1])

	# Tính độ sâu của một nút (đệ quy)
	def depthOfNode(self, rnode, node):
		if rnode is None:
			return -1
		if rnode.data == node.data:
			return 0
		for child in rnode.list_child:
			depth = self.depthOfNode(child, node)
			if depth != -1:
				return depth + 1
		return -1

	# Tính độ sâu bằng stack
	def depthOfNodeUsingStack(self, rnode, node):
		if rnode is None:
			return -1
		stack_node = [[rnode, 0]]
		while stack_node:
			temp_node = stack_node.pop()
			if temp_node[0].data == node.data:
				return temp_node[1]
			for child in temp_node[0].list_child:
				stack_node.append([child, temp_node[1] + 1])
		return -1

	# Tính chiều cao của cây (đệ quy)
	def height(self, node=None):
		if node is None:
			node = self.root
		if not node.list_child:
			return 0
		return 1 + max(self.height(child) for child in node.list_child)

	# Tính chiều cao của cây (dùng hàng đợi)
	def heightUsingQueue(self):
		if not self.root:
			return 0
		queue = [(self.root, 0)]
		max_depth = 0
		while queue:
			node, depth = queue.pop(0)
			max_depth = max(max_depth, depth)
			for child in node.list_child:
				queue.append((child, depth + 1))
		return max_depth

	# Tìm kiếm nút (đệ quy)
	def findNode(self, node, key):
		if node.data == key:
			return node
		for child in node.list_child:
			result = self.findNode(child, key)
			if result:
				return result
		return None

	# Tìm kiếm nút (dùng stack)
	def findNodeUsingStack(self, key):
		stack = [self.root]
		while stack:
			node = stack.pop()
			if node.data == key:
				return node
			for child in node.list_child:
				stack.append(child)
		return None


# ==============================
# KIỂM TRA CHẠY CHƯƠNG TRÌNH
# ==============================
thpc = Node("This PC")
docs = Node("Documents")
ebo = Node("Ebooks")
sys = Node("System")
win = Node("Windows")
pro = Node("Program Files")

tree_file = Tree(thpc)
thpc.addChild(sys)
thpc.addChild(docs)
sys.addChild(pro)
sys.addChild(win)
docs.addChild(ebo)

print("Cấu trúc cây tổng quát:")
tree_file.printTree()
print("\nChiều cao của cây:", tree_file.height())
print("Độ sâu của 'Ebooks':", tree_file.depthOfNode(thpc, ebo))
print("Tìm 'Windows':", tree_file.findNode(thpc, "Windows").getData())