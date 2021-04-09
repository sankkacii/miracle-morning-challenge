package org.example.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cache {
  public static void main(String[] args) {
    System.out.println(solution(3,new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    System.out.println(solution(3,new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
    System.out.println(solution(2,new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
    System.out.println(solution(2,new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
    System.out.println(solution(2,new String[] {"Jeju", "Pangyo", "NewYork", "newyork"}));
    System.out.println(solution(2,new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
  }

  public static int solution(int cacheSize, String[] cities) {
    List<String> cachingMemory = new ArrayList<>();
    int answer = 0;

    if(cacheSize == 0){
      return cities.length * 5;
    }

    for (String city : cities) {
      String lowerCase = city.toLowerCase(Locale.ROOT);
      if(cachingMemory.contains(lowerCase)) { //캐싱 가능
        cachingMemory.remove(lowerCase);
        cachingMemory.add(lowerCase);
        answer ++;
        continue;
      }
      if (cachingMemory.size() == cacheSize) { //메모리 꽉찼을 때
        cachingMemory.remove(0);
      }
      cachingMemory.add(lowerCase);
      answer+=5;

    }
    return answer;
  }
}
