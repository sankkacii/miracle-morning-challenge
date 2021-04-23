package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int num : nums) {
      count.put(num, count.getOrDefault(num,0)+1);
    }
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      if(entry.getValue() == 1)
        return entry.getKey();
    }

    return -1;
  }

  public int bestSolution(int[] nums) {
    int answer = 0;

    for (int num : nums) {
      answer ^= num;
    }
    return answer;
  }
}
