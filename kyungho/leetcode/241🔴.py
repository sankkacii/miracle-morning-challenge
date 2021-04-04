from typing import List
import re


class Solution:
    def diffWaysToCompute(self, expression: str) -> List[int]:
        
        def calc(x, op, y):
            if op == '+':
                return x + y
            if op == '-':
                return x - y
            if op == '*':
                return x * y
        
        def seperate(string):
            nums = list(map(int, re.findall(r'\d+', string)))
            ops = re.findall(r'\D+', string)
            print(444, nums, ops)
            new_exp = []
            for pair in zip(nums, ops):
                new_exp.extend(pair)
            new_exp.append(nums[-1])
            return tuple(new_exp)
            
        
        ops = {'+', '-', '*'}

        def dfs(exp):
            print("exp", exp, "answer", answer, "visited", visited)
            visited.add(exp)
            for i in range(0, len(exp)-1, 2):
                print(111, exp, exp[i:i+3])
                x, op, y = exp[i:i+3]
                left, right  = exp[:i], exp[i+3:]
                center = calc(int(x), op, int(y))
                print(222, left, center, right)
                next_expression = (*left, center, *right)
                print("next_expression", next_expression)
                if not any([x in ops for x in next_expression]):
                    answer.extend(next_expression)
                    print(333, answer)
                    continue

                if next_expression in visited:
                    print('zzz', exp) 
                if next_expression not in visited:
                    dfs(next_expression)

        visited = set()
        answer = []
        dfs(seperate(expression))
        if not answer:
            return [int(expression)]
        return answer

solution = Solution()
# print(solution.diffWaysToCompute("2-1-1"))
# print(solution.diffWaysToCompute("2242*123-554*65"))
# print(solution.diffWaysToCompute("2*3-4*5"))
# print(solution.diffWaysToCompute("0"))
print(solution.diffWaysToCompute("15*1*4"))
