from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)
        nums[2] += nums[0]
        for i in range(3, len(nums)):
            # print(nums[i], nums[i - 2], nums[i - 3])
            nums[i] += max(nums[i - 2], nums[i - 3])
        print(nums)
        return max(nums)


solution = Solution()
# print(solution.rob([1, 2, 3, 1]))
print(solution.rob([1, 7, 9, 2]))
# print(solution.rob([2, 7, 9, 3, 1]))
