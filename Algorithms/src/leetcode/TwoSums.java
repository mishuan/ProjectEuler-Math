package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSums {
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) map.put(nums[i], i);

    for (int i = 0; i < nums.length; i++) {
      int curr = target - nums[i];
      if (map.containsKey(curr) && map.get(curr) != i) {
        if (map.get(curr) > i) {
          result[0] = i + 1;
          result[1] = map.get(curr) + 1;
        } else {
          result[0] = map.get(curr) + 1;
          result[1] = i + 1;
        }
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {3, 2, 4};
    System.out.println(Arrays.toString(twoSum(arr, 6)));
  }
}
