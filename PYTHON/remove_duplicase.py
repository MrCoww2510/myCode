list = [3,1,5,2,4,3,2,1,4,2,4,5,2,1,3,5,4,2,1,3,4,5]
def remove_duplicase(list):
    new_list = []
    for i in list:
        if i not in new_list:
            new_list.append(i)
    return new_list
print(remove_duplicase(list))