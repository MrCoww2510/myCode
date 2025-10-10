def CONGDENN(n):
    if n == 1 :
        return 1
    else :
        return n + CONGDENN(n-1)
print('ketqua',CONGDENN(4))