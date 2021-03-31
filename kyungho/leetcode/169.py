from typing import List
import collections


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # solution 1
        # counter = collections.Counter(nums)
        # n = len(nums)
        # for k, v in counter.items():
        #     if v > n // 2:
        #         return k

        # solution 2
        n = len(nums)
        counter = collections.Counter()
        for v in nums:
            counter[v] += 1
            if counter[v] > n // 2:
                return v

        # solution 3


solution = Solution()
print(solution.majorityElement([3, 2, 3]))
print(solution.majorityElement([2, 2, 1, 1, 1, 2, 2]))
