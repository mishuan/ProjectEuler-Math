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
    PriorityQueue<Long> q = new PriorityQueue<>();
    q.add(1l);
    for(int i = 1; i < n; i++) {
      Long curr = q.poll();
      while(!q.isEmpty() && q.peek() == curr) q.poll();
      q.add(curr*2);
      q.add(curr*3);
      q.add(curr*5);
    }
    return Integer.parseInt(q.poll());
  }
}
