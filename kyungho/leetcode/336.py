from typing import List


class Solution:
    def fib(self, n: int) -> int:
        # Soluntion 1: Recursive

        # if n <= 1:
        #     return n
        # return self.fib(n-1) + self.fib(n-2)

        # Solution 2: Iterative

        fib = [0, 1] + [0] * 30
        for i in range(2, 31):
            fib[i] = fib[i-1] + fib[i-2]
        return fib[n]


solution = Solution()
print(solution.fib(2))
print(solution.fib(2))
print(solution.fib(3))
print(solution.fib(4))
print(solution.fib(5))
print(solution.fib(6))
print(solution.fib(7))
print(solution.fib(8))
