def hammingDistance(x: int, y: int) -> int:
    # count = 0
    # if x < y:
    #     x, y = y, x
    # x = bin(x)[2:]
    # y = bin(y)[2:]
    # while len(x) != len(y):
    #     y = "0" + y
    # print(x, y)
    # for b1, b2 in zip(x, y):
    #     if b1 != b2:
    #         count += 1
    # return count

    return bin(x^y).count('1')


print(hammingDistance(4, 1))
