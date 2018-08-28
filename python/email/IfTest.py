# L = [x * x for x in range(1, 10)]
# print(L)
# L.append(30)
# a = sorted(L)
# print(a)

# G  = (x * x for x in range(1,10))
# print("G", "=", G.__next__)

# a = []
# for x in range(1, 10):
#     a.append(x)
#
# print(a)


# def lazy_sum(*args):
#     def sum():
#         an = 0
#         for i in args:
#             an = an + i
#         return an;
#     return sum
#
#
# if __name__ == '__main__':
#     L1 = [x for x in range(1, 10)]
#     L2 = [x for x in range(1, 10)]
#     f1 = lazy_sum(L1)
#     f2 = lazy_sum(L2)
#     print(f1)
#     print(f2)
#
#     f1()

# def lazy_sum(*args):
#     def sum():
#         ax = 0
#         for n in args:
#             ax = ax + n
#         return ax
#     return sum


# def lazy_sum(*args):
#     def sum():
#         an = 0
#         for i in args:
#             an = an + i
#         return an;
#     return sum
#
# f = lazy_sum(1, 3, 5, 7, 9)
# print(f)
# print(f())


def count(*args):
    fs = []
    for i in args:
        def f(j):
            def g():
                return j * j
            return g
        fs.append(f(i))
    return fs

if __name__ == '__main__':
    fs = count(1, 2,3,4)
    print(fs[0]())