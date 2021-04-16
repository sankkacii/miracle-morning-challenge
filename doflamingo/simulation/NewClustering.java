package org.example.programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewClustering {
  public static void main(String[] args) {
    System.out.println(solution("FRANCE", "french"));
    System.out.println(solution("handshake", "shake hands"));
    System.out.println(solution("aa1+aa2", "AAAA12"));
    System.out.println(solution("E=M*C^2", "e=m*c^2"));
  }
  public static int solution(String str1, String str2) {
    int answer = 0;

    Map<String, Integer> hashMap1 = new HashMap<>();
    Map<String, Integer> hashMap2 = new HashMap<>();
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    List<String> s1List = new ArrayList<>();
    List<String> s2List = new ArrayList<>();
    Set<String> union = new HashSet<>();
    Set<String> intersection = new HashSet<>();

    getTwoWordsString(hashMap1, str1, s1List);
    getTwoWordsString(hashMap2, str2, s2List);

    union.addAll(s1List);
    union.addAll(s2List);

    int unionCount = 0;
    int intersectionCount = 0;
    for (String u : union) {
      unionCount += Math.max(hashMap1.getOrDefault(u,0), hashMap2.getOrDefault(u,0));
    }

    intersection.addAll(s1List);
    intersection.retainAll(s2List);
    for (String i : intersection) {
      intersectionCount += Math.min(hashMap1.get(i), hashMap2.get(i));
    }
    if(unionCount == 0)
      return 65536;
    return intersectionCount*65536/unionCount;
  }

  private static void getTwoWordsString(Map<String, Integer> hashMap, String s, List<String> stringList) {
    for(int i = 0; i< s.length()-1; i++) {
      if(!Character.isAlphabetic(s.charAt(i)) || !Character.isAlphabetic(s.charAt(i+1)) )
        continue;
      String substring = s.substring(i, i + 2);
      hashMap.put(substring, hashMap.getOrDefault(substring,0)+1);
      stringList.add(substring);
    }
  }

}
