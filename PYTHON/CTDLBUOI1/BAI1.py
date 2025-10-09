'''2.1 Cho một mảng gồm 20 phần tử sau
[90, 88, 54, 14, 91, 97, 12, 34, 91, 98, 71, 35, 18, 12, 71, 21, 14, 12, 61, 93]
a) Tạo một mảng và lưu trữ các phần tử trên
b) In ra màn hình số lượng các số có trong mảng. Ví dụ: Số 90 có 1 số
c) Thay đổi tất cả phần tử 91 trong mảng thành 8
d) Cho biết vị trí các phần tử 14 có trong mảng, in ra màn hình
e) Cho biết phần tử 12 có tồn tại trong mảng hay không, nếu có hãy in ra màn
hình vị trí của các phần tử 12 và xóa phần tử này khỏi mảng
f) Thêm lại đúng số lượng phần tử 12 đã xóa vào mảng bắt đầu tại vị trí thứ 2
của mảng và in ra màn hình sau khi đã cập nhật
g) Cập nhật lại mảng sao cho mỗi phần tử là duy nhất trong mảng '''
import array 
arr = array.array('i',[90, 88, 54, 14, 91, 97, 12, 34, 91, 98, 71, 35, 18, 12, 71, 21, 14, 12, 61, 93])
print("Mảng ban đầu: ", arr)
#b
for i in arr:
    print("Số", i, "có", arr.count(i), "số")
#c
for i in range(len(arr)):
    if arr[i] == 91:
        arr[i] = 8
print("Mảng sau khi thay 91 thành 8: ", arr)
#d
print("vị trí các phần tử 14 có trong mảng là : ",end="")
for i in range(len(arr)):
    if arr[i] == 14:
        print(i, end=" ")
print()
#e
count = arr.count(12)
if count > 0:
    print("Phần tử 12 có tồn tại trong mảng"
          "\nVị trí các phần tử 12 là: ", end="")
    for i in range(len(arr)):
        if arr[i]==12:
            print (i, end=" ")
    print()
    for _ in range(count):
        arr.remove(12)
    print("Mảng sau khi xóa phần tử 12: ", arr)
else:
    print("Phần tử 12 không tồn tại trong mảng")
#f
for _ in range(count):
    arr.insert(2, 12)
print("Mảng sau khi thêm lại phần tử 12: ", arr)
#g
arr2 = array.array('i',[])
for i in arr:
    if i not in arr2:
        arr2.append(i)
print("Mảng sau khi cập nhật lại sao cho mỗi phần tử là duy nhất: ", arr2)
#Cách 2
arr = array.array('i',[90, 88, 54, 14, 91, 97, 12, 34, 91, 98, 71, 35, 18, 12, 71, 21, 14, 12, 61, 93])
arr = array.array('i',list(set(arr)))
print("Mảng sau khi cập nhật lại sao cho mỗi phần tử là duy nhất: ", arr)