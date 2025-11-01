danh_sach = ["apple banana cherry date"]
def find_longest_word(words):
    wordsl = words[0].split()  # Split the single string into a list of words
    longest_word = wordsl[0]
    for word in wordsl:
        if len(word) > len(longest_word):
            longest_word = word
    return longest_word
print(find_longest_word(danh_sach))  # Output: "banana"