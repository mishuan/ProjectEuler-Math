package cci;

/**
 * Input string of mathematical operations, output the result
 */
public class Calculator {
  public static double calcFormula(String s) {
    s = '+' + s;
    int prev = 1;
    double total = 0;
    int i = 0;
    while (i < s.length()) {
      char curr = s.charAt(i);
      if (curr == '+') {
        i++;
        while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') i++;
        total += calcExpr(s.substring(prev, i));
        prev = i + 1;
      } else if (curr == '-') {
        i++;
        while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-') i++;
        total -= calcExpr(s.substring(prev, i));
        prev = i + 1;
      }
    }
    return total;
  }

  public static double calcExpr(String s) {
    int i = 0;
    while (i < s.length() && s.charAt(i) != '/' && s.charAt(i) != '*') i++;
    double total = Double.parseDouble(s.substring(0, i));
    int prev = i + 1;
    while (i < s.length()) {
      char curr = s.charAt(i);
      if (curr == '*') {
        i++;
        while (i < s.length() && s.charAt(i) != '*' && s.charAt(i) != '/') i++;
        total *= Double.parseDouble(s.substring(prev, i));
        prev = i + 1;
      } else if (curr == '/') {
        i++;
        while (i < s.length() && s.charAt(i) != '*' && s.charAt(i) != '/') i++;
        total /= Double.parseDouble(s.substring(prev, i));
        prev = i + 1;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(calcFormula("2*3+5/6*3+15"));
  }
}
