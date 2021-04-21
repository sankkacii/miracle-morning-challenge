# N-Queen
N = int(input())


def solution(N):
    answer = []

    def promising(row, col, queens):
        for i in range(1, row + 1):
            if (
                ((row - i, col) in queens)
                or ((row - i, col - i) in queens)
                or ((row - i, col + i) in queens)
            ):
                return False
        return True

    def n_queen(row, queens):
        if row == N:
            answer.append(queens)
        for col in range(N):
            if promising(row, col, queens):
                n_queen(row + 1, queens | set([(row, col)]))

    for col in range(N):
        n_queen(1, set([(0, col)]))
    return len(answer)


print(solution(N))
