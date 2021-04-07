class TwoSum167 {
  public int[] twoSum(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length-1;
    int sum = numbers[start] + numbers[end];
    while(sum != target && start != end) {
      if(sum < target) {
        start++;
      }else {
        end--;
      }
      sum = numbers[start] + numbers[end];
    }

    return new int[] {start+1, end+1};
  }
}