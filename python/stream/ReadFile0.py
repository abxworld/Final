import os


def list_file():
    path0 = 'D://'
    files = os.listdir(path0)
    for file in files:
        if not os.path.isdir(file) and str(file) == 'hello.txt':
            with open(path0 + file) as f:
                stringArr = []
                m = f.readline()
                while m != '':
                    stringArr.append(m)

                    m = f.readline()

    print(stringArr)


def test0():
    i = 100
    while i is not None:
        print(i)
        i = None


hello = 100


def test1():
    global hello
    hello = 10
    print(hello)


def test2():
    a = [i * i for i in range(1, 10)]
    print(a)


if __name__ == '__main__':
    test2()
