from typing import List

import collections


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        counter = collections.Counter(nums)
        for k, v in counter.items():
            if v == 1:
                return k

solution = Solution()
print(solution.singleNumber([4, 1, 2, 1, 2]))
