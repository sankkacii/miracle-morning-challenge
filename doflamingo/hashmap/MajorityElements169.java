package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElements169 {
  public static void main(String[] args) {
    System.out.println(majorityElement(new int[]{3,2,3}));
    System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
  }

  public static int majorityElement(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for(int i = 0; i< nums.length; i++){
      counts.put(nums[i], counts.getOrDefault(nums[i],0)+1);
    }
    Map.Entry<Integer, Integer> majority = null;

    for (Map.Entry<Integer, Integer>  unit : counts.entrySet()) {
      if(majority == null || unit.getValue() > majority.getValue())
        majority = unit;
    }

    return majority.getKey();
    
  }
}
