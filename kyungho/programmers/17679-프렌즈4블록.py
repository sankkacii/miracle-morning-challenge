def is_four_block(board, i, j):
    return board[i][j] != 'X' and (board[i][j] == board[i][j+1] == board[i+1][j] == board[i+1][j+1])

def block_down(board, m):
    new_board = []
    for col in list(zip(*board)):
        new_col = []
        idx = len(col) - 1
        while 0 <= idx:
            if col[idx] != 0:
                new_col.append(col[idx])
            idx -= 1
        while len(new_col) < m:
            new_col.append('X')
        new_board.append(new_col[::-1])
    print(new_board)
    return [list(row) for row in zip(*new_board)]

def solution(m, n, board):
    board = [list(row) for row in board]
    print(*board, sep='\n')
    answer = 0
    while True:
        to_be_removed = set()
        for i in range(m-1):
            for j in range(n-1):
                if is_four_block(board, i, j):
                    to_be_removed.add((i, j))
                    to_be_removed.add((i, j+1))
                    to_be_removed.add((i+1, j))
                    to_be_removed.add((i+1, j+1))
        print(to_be_removed)
        if not to_be_removed:
            break
        answer += len(to_be_removed)
        while to_be_removed:
            i, j = to_be_removed.pop()
            board[i][j] = 0
        print(*board, sep='\n')
        board = block_down(board, m)
        print(*board, sep='\n')
    return answer

print(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]))
print(solution(6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]))


