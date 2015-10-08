package cci;

/**
 * A child is running up a staircase with n steps and can hop either 1, 2, or 3 steps.
 * Write an algorithm to count how many possible ways the child can run up the stairs.
 */
public class TripleStep {
  public static long[] cache;
  public static int N = 1000;

  public static void main(String args[]) {
    System.out.println(tripleStep(N));
  }

  public static long tripleStep(int n) {
    cache = new long[n + 1];
    cache[0] = 1;
    return recurse(n);
  }

  private static long recurse(int n) {
    if (cache[n] != 0)
      return cache[n];

    for (int i = 1; i <= 3; i++) {
      int next = n - i;
      if (next >= 0) {
        if (cache[next] == 0)
          cache[n] += recurse(next);
        else
          cache[n] += cache[next];
      }
    }
    return cache[n];
  }
}
