import re


def solution(dartResult):
    groups = re.finditer(r"\d+\w\W?", dartResult)
    rounds = [0] * 3
    for index, round in enumerate(groups):
        score, bonus, option = re.findall(r"(\d+)(\w)([\*\#]*)", round.group())[0]
        score = int(score)
        bonus = 1 if bonus == "S" else 2 if bonus == "D" else 3
        rounds[index] = score ** bonus
        if option == "*" and index == 0:
            rounds[0] *= 2
            continue
        if option == "*" and index != 0:
            rounds[index] *= 2
            rounds[index - 1] *= 2
        if option == "#":
            rounds[index] = -rounds[index]

    return sum(rounds)


print(solution("1S2D*3T"))
print(solution("1D2S#10S"))
# print(solution("1D2S0T"))
# print(solution("1S*2T*3S"))
# print(solution("1D#2S*3S"))
# print(solution("1T2D3D#"))
# print(solution("1D2S3T*"))
