#1. Cấu trúc cơ bản
# Python không cần khai báo lớp, hàm bắt đầu bằng def
def ham_chinh():
    print("Xin chào")

if __name__ == "__main__":
    ham_chinh()


#def → khai báo hàm

#__name__ == "__main__" → điểm bắt đầu khi chạy file trực tiếp

#Không cần dấu ngoặc {}, dùng indentation (thụt lề)

#🧮 2. Biến & kiểu dữ liệu
SoLuong = 10          # int
DiemTrungBinh = 8.5   # float
HoTen = "Nguyen Van A" # str
LaSinhVien = True     # bool
DanhSach = [1,2,3]   # list
Tuples = (1,2,3)      # tuple
TapHop = {1,2,3}      # set
TuKhoa = {'ten':'Thinh', 'tuoi':18} # dict


#Biến Python không cần khai báo kiểu, tự động xác định

#None tương đương null trong Java

#⚙️ 3. Câu lệnh điều kiện
if SoLuong > 10:
    print("Nhiều")
elif SoLuong == 10:
    print("Đúng 10")
else:
    print("Ít")


#Không có switch-case chuẩn (Python 3.10+ có match-case):

x = 2
match x:
    case 1:
        print("Một")
    case 2:
        print("Hai")
    case _:
        print("Khác")

#🔁 4. Vòng lặp
#For
for i in range(5): # 0 1 2 3 4
    print(i)

for x in [1,2,3]:
    print(x)


#range(start, stop, step) → tạo dãy số

#While
i = 0
while i < 5:
    print(i)
    i += 1

#🧩 5. Hàm
def Tong(a, b):
    return a + b

print(Tong(2,3))


#*args → nhận nhiều tham số không giới hạn

#**kwargs → nhận nhiều tham số đặt tên

def demo(*args, **kwargs):
    print(args, kwargs)

#🧱 6. Lớp & đối tượng
class NhanVien:
    def __init__(self, HoTen, Tuoi):
        self.HoTen = HoTen
        self.Tuoi = Tuoi

    def xuat(self):
        print(self.HoTen, "-", self.Tuoi)

nv = NhanVien("Thinh", 18)
nv.xuat()


#__init__ → hàm khởi tạo

#self → tương đương this trong Java

#🧾 7. Nhập/xuất
HoTen = input("Nhập tên: ") # luon là str
So = int(input("Nhập số: ")) # ép kiểu int
print("Xin chào", HoTen)
print(f"Điểm trung bình: {8.5:.2f}") # f-string định dạng

#🚧 8. Xử lý ngoại lệ
try:
    a = 5 / 0
except ZeroDivisionError as e:
    print("Lỗi chia 0", e)
finally:
    print("Luôn chạy")


#Exception là lớp cha, bắt chung tất cả lỗi

#raise → ném lỗi thủ công

#📦 9. Thư viện thường dùng
#Cơ bản
import math        # toán học: sqrt, pow, sin, cos
import random      # số ngẫu nhiên: randint, choice, shuffle
import datetime    # thời gian: datetime.now()
import os          # thao tác file, thư mục
import sys         # tương tác hệ thống, tham số dòng lệnh

#Dữ liệu & cấu trúc
import collections  # deque, Counter, namedtuple
import itertools    # tổ hợp, hoán vị

#File & IO
with open("file.txt", "r") as f:
    data = f.read()

#Regex
import re
if re.match(r'\d+', "123abc"):
    print("Có số đầu chuỗi")

#Thư viện khoa học & dữ liệu
import numpy as np      # mảng, ma trận
import pandas as pd     # dataframe
import matplotlib.pyplot as plt  # vẽ biểu đồ

#Web & network
import requests        # HTTP request
import urllib.parse    # encode URL
import socket          # socket network

#Thư viện nâng cao
import threading       # đa luồng
import multiprocessing # đa tiến trình
import logging         # log
import json            # đọc/ghi JSON
import pickle          # lưu object