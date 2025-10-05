list1 = ["Hello", "World"] 
list2 = ["Python", "Programming", "is", "fun"] 
def merge_alternately(list1, list2):
    list3 = []
    i = 0
    while i < len(list1) or i < len(list2):
        if i < len(list1):
            list3.append(list1[i])
        if i < len(list2):
            list3.append(list2[i])
        i += 1
    return list3
print(merge_alternately(list1, list2))  # Output: ['Hello', 'Python', 'World', 'Programming', 'is', 'fun']