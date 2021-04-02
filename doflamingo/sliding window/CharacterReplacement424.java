class CharacterReplacement424 {
  public int characterReplacement(String s, int k) {
    int[] alphabetCount = new int[26];
    int start = 0;
    int maxCount = 0; //윈도우안 알파벳 최대 개수
    int maxLength = 0;  // 최대 부분 문자열 길이
    for(int end = 0; end < s.length(); end++) {
      maxCount = Math.max(maxCount, ++alphabetCount[s.charAt(end)-'A']);

      if(end-start+1-maxCount > k) {    //윈도우내에 존재하는 최대 알파벳의 개수가 k개를 넘을 때 윈도우를 한칸 이동한다.
        alphabetCount[s.charAt(start)-'A']--;
        start++;
      }
      maxLength = Math.max(maxLength, end-start+1);
    }
    return maxLength;
  }
}