a = [12,2,8,5,1]
for i in range(1,len(a)+1):
    if a[i] > a[i+1]:
        temp = a[i]
        a[i] = a[i+1]
        a[i+1] = temp
print(a)