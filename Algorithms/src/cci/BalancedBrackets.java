package cci;

/**
 * Find all balanced bracket combinations
 */
public class BalancedBrackets {
  public static void main(String args[]) {
    balancedBrackets(3);
  }

  public static void balancedBrackets(int n) {
    for (int i = 1; i <= n; i++)
      printBrackets("", 0, 0, i);
  }

  public static void printBrackets(String s, int open, int close, int n) {
    if (open == n && close == n)
      System.out.println(s);
    else {
      if (open > close)
        printBrackets(s + ')', open, close + 1, n);
      if (open < n)
        printBrackets(s + '(', open + 1, close, n);
    }
  }
}
