from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        answer = []
        for hi, ki in people:
            answer.insert(ki, (hi, ki))
        return answer


solution = Solution()
print(solution.reconstructQueue(
    [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]))
