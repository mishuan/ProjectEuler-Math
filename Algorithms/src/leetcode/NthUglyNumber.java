package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {
  public static void main(String[] args) {

    System.out.println(findNthUglyNumber(10));
  }

  public static int findNthUglyNumber(int n) {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    q.add(1);
    for(int i = 1; i < n; i++) {
      int curr = q.poll();
      while(!q.isEmpty() && q.peek() == curr) q.poll();
      q.add(curr*2);
      q.add(curr*3);
      q.add(curr*5);
    }
    return q.poll();
  }
}
