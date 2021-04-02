package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class AssignCookies455 {

  public static void main(String[] args) {
    System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
  }

  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int cookieIndex = s.length-1;
    int childCount = g.length-1;

    while(cookieIndex >= 0 && childCount >= 0) {
      if(s[cookieIndex] >= g[childCount]) {
        cookieIndex--;
      }
      childCount--;
    }

    return s.length- cookieIndex -1;
  }
}
