package org.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class FriendsBlock {

  public static void main(String[] args) {
    System.out.println(solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    System.out.println(solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
  }
  public static int solution(int m, int n, String[] board) {
    char[][] boardCharArray = new char[m][n];
    for(int i = 0; i < m; i++) {
      boardCharArray[i] = board[i].toCharArray();
    }
    int answer = 0;
    while (true) {
      boolean isFinished = false;
      for(int i = 0; i< m-1; i++) {
        for(int j = 0; j< n-1; j++) {
          if(isSquare(m,n,boardCharArray,i,j))
            isFinished = true;
        }
      }
      if(!isFinished)
        break;
      removeBlock(m, n, boardCharArray);
      blockDown(m, n, boardCharArray);

    }
    for(int i =0; i< m; i++) {
      for(int j = 0; j < n; j++){
        if(boardCharArray[i][j] == '0')
          answer++;
      }
    }

    return answer;
  }

  public static void removeBlock(int m, int n, char[][] board) {
    boolean[][] checkBlock = new boolean[m][n];
    for(int i = 0; i< m; i++) {
      for(int j = 0; j< n; j++) {
        if(board[i][j] != '0' && isSquare(m,n,board,i,j)){  // 제거시 0으로 표기
          checkBlock[i][j] = true;
          checkBlock[i][j+1] = true;
          checkBlock[i+1][j] = true;
          checkBlock[i+1][j+1] = true;
        }
      }
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(checkBlock[i][j])
          board[i][j] = '0';
      }
    }
  }

  public static boolean isSquare(int m , int n, char[][] board, int i, int j) {   //사각형이 형성되었는지 판단.
    if(i < m-1 && j < n-1) {
      return (board[i][j] != '0') &&( board[i][j] == board[i][j+1]) && (board[i][j] == board[i+1][j]) && (board[i][j] == board[i+1][j+1]);
    }
    return false;
  }

  public static void blockDown(int m, int n, char[][] board) {
    for(int i = 0; i< n; i++) {
      List<Character> row = new ArrayList<>();
      for(int j = 0; j < m; j++) {
        if(board[j][i] != '0')
          row.add(board[j][i]);
      }
      while(row.size() != m) {
        row.add(0,'0');
      }

      for(int j = 0; j< m; j++) {
        board[j][i] = row.get(j);
      }
    }
  }
}
