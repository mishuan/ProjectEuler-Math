package leetcode;

/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {
  public static boolean isUgly(int num) {
    if (num == 1) return true;
    if (num == 0) return false;

    double dnum = (double) num;
    while (dnum != 1) {
      if (dnum / 2d == (double) (num / 2)) {
        dnum /= 2;
        num /= 2;
      } else if (dnum / 3d == (double) (num / 3)) {
        dnum /= 3;
        num /= 3;
      } else if (dnum / 5d == (double) (num / 5)) {
        dnum /= 5;
        num /= 5;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]) {
    System.out.println(isUgly(14));
  }
}
