package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSums {
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    ArrayList<List<Integer>> results = new ArrayList<>(nums.length);
    int i = 0;
    int len = nums.length;
    while (i < len - 2) {
      int top = i + 1;
      int bot = len - 1;
      int goal = nums[i] * (-1);
      while (bot > top) {
        int curr = nums[top] + nums[bot];
        if (goal == curr) {
          List<Integer> list = new ArrayList<>(3);
          list.add(nums[i]);
          list.add(nums[top]);
          list.add(nums[bot]);
          results.add(list);
          while (top < len - 1&& nums[top] == nums[top + 1]) top++;
          top++;
        } else if (goal < curr) {
          bot--;
          while (top < bot && nums[bot] == nums[bot + 1]) bot--;
        } else {
          top++;
          while (top < bot && nums[top] == nums[top - 1]) top++;
        }
      }
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
      i++;
    }
    return results;
  }

  public static void main(String[] args) {
    int[] arr = {0, 0, 0};
    for (List<Integer> list : threeSum(arr))
      System.out.println(list);
  }
}
