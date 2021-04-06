class Solution:
    def climbStairs(self, n: int) -> int:
        d = [1, 1] + [0] * 100
        for i in range(2, 100):
            d[i] = d[i - 1] + d[i - 2]
        return d[n]


solution = Solution()
print(solution.climbStairs(2))
