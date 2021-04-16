package org.example.programmers;

public class SecretMap {
  public static void main(String[] args) {
    solution(5, new int[] {9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
  }

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for(int i = 0; i < n; i++) {
      answer[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i])).replaceAll("0"," ").replaceAll("1","#");
      System.out.println(answer[i]);
    }
    return answer;
  }
}
