package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QueueReconstruction {

  public static void main(String[] args) {
    Arrays.stream(reconstructQueue(new int[][]{ {7,0},{4,4},{7,1},{5,0},{6,1},{5,2}})).forEach(i -> System.out.println(i[0]+" "+i[1]));
    System.out.println("--------------------------------");
    Arrays.stream(reconstructQueue(new int[][]{ {6,0},{5,0},{4,0},{3,2},{2,2},{1,4}})).forEach(i -> System.out.println(i[0]+" "+i[1]));
  }

  public static int[][] reconstructQueue(int[][] people) {
    List<int[]> answer = new ArrayList<>();
    Arrays.stream(people)
      .sorted((o1, o2) -> o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0])
      .forEach(person -> {
        answer.add(person[1], person);
      });
    return answer.toArray(people);
  }
}
