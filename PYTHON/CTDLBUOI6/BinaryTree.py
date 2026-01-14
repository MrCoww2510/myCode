# ==============================
# BÀI 2: CÂY NHỊ PHÂN
# ==============================

class Node:
	def __init__(self, data):
		self.data = data
		self.left_child = None
		self.right_child = None


class BinaryTree:
	def __init__(self):
		self.root = None

	def insert(self, root, data):
		new_node = Node(data)
		if root is None:
			self.root = new_node
			return self.root

		queue = [root]
		while queue:
			current = queue.pop(0)
			if current.left_child is None:
				current.left_child = new_node
				return self.root
			else:
				queue.append(current.left_child)

			if current.right_child is None:
				current.right_child = new_node
				return self.root
			else:
				queue.append(current.right_child)

	def print_tree(self, root, level=0, prefix="Gốc: "):
		if root is not None:
			self.print_tree(root.right_child, level + 1, "R---- ")
			print(" " * level * 2 + prefix + str(root.data))
			self.print_tree(root.left_child, level + 1, "L---- ")

	def _delete_deepest(self, root, d_node):
		queue = [root]
		while queue:
			temp = queue.pop(0)
			if temp is d_node:
				temp = None
				return
			if temp.left_child:
				if temp.left_child is d_node:
					temp.left_child = None
					return
				else:
					queue.append(temp.left_child)
			if temp.right_child:
				if temp.right_child is d_node:
					temp.right_child = None
					return
				else:
					queue.append(temp.right_child)

	def delete(self, root, key):
		if root is None:
			return None
		if root.left_child is None and root.right_child is None:
			if root.data == key:
				return None
			else:
				return root

		key_node = None
		queue = [root]
		while queue:
			temp = queue.pop(0)
			if temp.data == key:
				key_node = temp
			if temp.left_child:
				queue.append(temp.left_child)
			if temp.right_child:
				queue.append(temp.right_child)

		if key_node:
			deepest = temp
			key_node.data = deepest.data
			self._delete_deepest(root, deepest)
		return root

	def search(self, root, key):
		if root is None:
			return None
		queue = [root]
		while queue:
			node = queue.pop(0)
			if node.data == key:
				return node
			if node.left_child:
				queue.append(node.left_child)
			if node.right_child:
				queue.append(node.right_child)
		return None


# ==============================
# KIỂM TRA CHẠY CHƯƠNG TRÌNH
# ==============================
bt = BinaryTree()
bt.root = bt.insert(bt.root, "A")
bt.insert(bt.root, "B")
bt.insert(bt.root, "C")
bt.insert(bt.root, "D")
bt.insert(bt.root, "E")
bt.insert(bt.root, "F")
bt.insert(bt.root, "G")

print("Cây ban đầu:")
bt.print_tree(bt.root)

bt.delete(bt.root, "E")
print("\nCây sau khi xóa 'E':")
bt.print_tree(bt.root)

bt.delete(bt.root, "C")
print("\nCây sau khi xóa 'C':")
bt.print_tree(bt.root)

kq = bt.search(bt.root, "F")
print("\nTìm nút 'F':", "Tồn tại" if kq else "Không tìm thấy")