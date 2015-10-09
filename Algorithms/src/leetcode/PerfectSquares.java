package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
  public static int numSquares(int n) {
    int[] min = new int[n + 1];
    for (int i = 0; i <= n; i++) min[i] = Integer.MAX_VALUE;
    int sqrt = (int) Math.sqrt((double) n);
    int[] squares = new int[sqrt + 1];
    for (int i = 0; i <= sqrt; i++) {
      squares[i] = i * i;
      min[squares[i]] = 1;
    }
    System.out.println(Arrays.toString(min));
    System.out.println(Arrays.toString(squares));
    for (int i = 2; i <= n; i++)
      for (int j = 1; j <= sqrt; j++)
        if(squares[j] < i && min[i-squares[j]]+1 < min[i]) min[i] = min[i-squares[j]]+1;
    System.out.println(Arrays.toString(min));
    return min[n];
  }

  public static void main(String[] args) {
    System.out.println(numSquares(12));

    int[] temp = {4, 5};
    removeElement(temp, 4);
  }

  public static int removeElement(int[] nums, int val) {
    int count = 0;
    for(int i : nums)
      if(val == i)
        count++;
    int[] newNums = new int[nums.length-count];
    count = 0;
    for(int i = 0; i < nums.length; i++){
      if(nums[i] != val){
        newNums[count] = nums[i];
        count++;
      }
    }
    nums = newNums;
    System.out.println(Arrays.toString(nums));
    return count;
  }
}
