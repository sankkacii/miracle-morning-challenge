from collections import defaultdict

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counter = defaultdict(int)
        for num in nums:
            counter[num] += 1
        return max(counter.items(), key=lambda x: x[1])[0]
