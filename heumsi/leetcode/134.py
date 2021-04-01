class Solution:
    # 완전 탐색 O(n^2)
    
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:    
        size = len(gas)
        for i in range(size):
            start, j = i, 0
            available_gas = 0
            while j < size:
                available_gas += gas[(start + j) % size]
                available_gas -= cost[(start + j) % size]
                if available_gas < 0:
                    break
                j += 1
            if j == size:
                return i
        return -1
