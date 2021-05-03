import collections
import itertools


def solution(orders, course):
    answer = []
    counter = collections.Counter()
    for order in orders:
        for c in course:
            for combination in itertools.combinations(order, c):
                counter["".join(sorted(combination))] += 1
    print(counter)
    for c in course:
        arr = [(v, k) for k, v in counter.items() if len(k) == c and v >= 2]
        print(arr)
        if arr:
            M = max([v for v, k in arr])
            answer += [k for v, k in arr if v == M]
    return sorted(answer)


# print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4]))
print(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]))
