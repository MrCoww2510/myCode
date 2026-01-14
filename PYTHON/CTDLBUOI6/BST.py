# ==============================
# BÀI 3: CÂY TÌM KIẾM NHỊ PHÂN (BST)
# ==============================

class BSTNode:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None


class BSTree:
	def __init__(self):
		self.root = None

	def insert(self, root, data):
		if root is None:
			return BSTNode(data)
		if data < root.data:
			root.left = self.insert(root.left, data)
		elif data > root.data:
			root.right = self.insert(root.right, data)
		return root

	def print_tree(self, root, level=0, prefix="Gốc: "):
		if root:
			self.print_tree(root.right, level + 1, "R---- ")
			print(" " * level * 3 + prefix + str(root.data))
			self.print_tree(root.left, level + 1, "L---- ")

	def search(self, root, key):
		if root is None or root.data == key:
			return root
		if key < root.data:
			return self.search(root.left, key)
		return self.search(root.right, key)

	def findMin(self, root):
		while root.left:
			root = root.left
		return root

	def delete(self, root, key):
		if root is None:
			return root
		if key < root.data:
			root.left = self.delete(root.left, key)
		elif key > root.data:
			root.right = self.delete(root.right, key)
		else:
			if root.left is None:
				return root.right
			elif root.right is None:
				return root.left
			temp = self.findMin(root.right)
			root.data = temp.data
			root.right = self.delete(root.right, temp.data)
		return root

	# Duyệt tiền tự
	def preorder(self, root):
		if root:
			print(root.data, end=" ")
			self.preorder(root.left)
			self.preorder(root.right)

	# Duyệt trung tự
	def inorder(self, root):
		if root:
			self.inorder(root.left)
			print(root.data, end=" ")
			self.inorder(root.right)

	# Duyệt hậu tự
	def postorder(self, root):
		if root:
			self.postorder(root.left)
			self.postorder(root.right)
			print(root.data, end=" ")


# ==============================
# KIỂM TRA CHẠY CHƯƠNG TRÌNH
# ==============================
bst = BSTree()
bst.root = bst.insert(bst.root, 50)
bst.insert(bst.root, 30)
bst.insert(bst.root, 70)
bst.insert(bst.root, 20)
bst.insert(bst.root, 40)
bst.insert(bst.root, 60)
bst.insert(bst.root, 80)

print("Cây BST ban đầu:")
bst.print_tree(bst.root)

print("\nDuyệt trung tự (Inorder):")
bst.inorder(bst.root)

print("\n\nXóa 70:")
bst.root = bst.delete(bst.root, 70)
bst.print_tree(bst.root)

print("\nTìm kiếm nút 60:", "Tìm thấy" if bst.search(bst.root, 60) else "Không thấy")