from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        print(nums)
        i, j, s, max_sum = 0, 0, 0, -(10 ** 6)
        while i <= j and j < len(nums):
            s += nums[j]
            max_sum = max(max_sum, s)
            if s < 0:
                i += 1
                s = 0
            j += 1
        return max_sum


solution = Solution()
print(solution.maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))
print(solution.maxSubArray([1]))
print(solution.maxSubArray([5, 4, -1, 7, 8]))
print(solution.maxSubArray([-1]))
print(solution.maxSubArray([-2, -1]))
