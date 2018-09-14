def cal():
    list_arr = [1, 8, 3, 4, 7, 9, 2, 0, 6, 5]
    i = 0
    for j in list_arr:
        if j > i:
            i = j
    print(i)
if __name__ == '__main__':
    cal()
