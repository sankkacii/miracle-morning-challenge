package org.example.leetcode;

public class BestTimeToBuyAndSellStock122 {

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
  }

  public static int maxProfit(int[] prices) {
    boolean nowBuying = false;
    int maxPrice = 0;

    for(int i = 0; i < prices.length-1; i++) {
      if(prices[i] < prices[i+1] && !nowBuying) { //안샀으면 사라
        maxPrice -= prices[i];
        nowBuying = true;
      }
      if(prices[i] < prices[i+1] && nowBuying) {  //가지고 있으면 팔아라
        maxPrice += prices[i+1];
        nowBuying = false;
      }
    }

    return maxPrice;
  }
}
