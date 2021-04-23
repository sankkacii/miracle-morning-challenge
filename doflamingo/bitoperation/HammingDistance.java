package org.example.leetcode;

public class HammingDistance {
  public static void main(String[] args) {
    System.out.println(hammingDistance(1,3));
    System.out.println(hammingDistance(1,4));
  }

  public static int hammingDistance(int x, int y) {
    int answer = x^y;
    String binaryString = Integer.toBinaryString(answer);
    String s = binaryString.replaceAll("0", "");
    return s.length();
  }
}
