package leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
  public static int trap(int[] height) {
    if (height.length == 0) return 0;
    int maxIdx = findMax(height);
    int prevMax = 0;
    int totalWater = 0;
    for (int i = 1; i <= maxIdx; i++) {
      if (height[prevMax] > height[i])
        totalWater += height[prevMax] - height[i];
      else
        prevMax = i;
    }
    prevMax = height.length - 1;
    for (int i = height.length - 1; i >= maxIdx; i--) {
      if (height[prevMax] > height[i])
        totalWater += height[prevMax] - height[i];
      else
        prevMax = i;
    }
    return totalWater;
  }

  public static int findMax(int[] height) {
    int max = height[0];
    int maxIdx = 0;
    for (int i = 0; i < height.length; i++)
      if (max < height[i]) {
        maxIdx = i;
        max = height[i];
      }
    return maxIdx;
  }

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(arr));
  }

}
