package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
  public int largestRectangleArea(int[] height) {
    if (height.length == 0) return 0;
    if (height.length == 1) return height[0];
    Stack<Integer> idx = new Stack();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < height.length; i++) {
      while (!idx.empty() && height[idx.peek()] > height[i]) {
        int curr = idx.pop();
        max = Math.max(max, height[curr] * (i - idx.peek() - 1));
      }
      idx.add(i);
    }
    while (!idx.empty() && height[idx.peek()] > height[height.length - 1]) {
      int curr = idx.pop();
      max = Math.max(max, height[curr] * (height.length - idx.peek() - 1));
    }
    return max;
  }
}
