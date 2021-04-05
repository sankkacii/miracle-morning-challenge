package org.example.leetcode;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println(fib(0));
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
  }

  public static int fib(int n) {
    if(n == 0 || n == 1)
      return n;

    return fib(n-1)+ fib(n-2);

  }
}
