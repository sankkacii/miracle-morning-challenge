package org.example.leetcode;

import java.util.Arrays;

public class MaximumArray53 {
  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    System.out.println(maxSubArray(new int[]{1}));
    System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
  }
  public static int maxSubArray(int[] nums) {

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for(int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i-1],0)+nums[i];
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
