package leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
  public static int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) return 0;
    int sum = 0;
    int r = 0;
    int l = 0;
    int min = Integer.MAX_VALUE;
    while (r < nums.length) {
      while (sum < s && r < nums.length) sum += nums[r++];
      if (sum >= s) {
        while (sum >= s && l < r) sum -= nums[l++];
        min = Math.min(min, r - l + 1);
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 2, 4, 3};
    System.out.println(minSubArrayLen(7, arr));
  }
}
