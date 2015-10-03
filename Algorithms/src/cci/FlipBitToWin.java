package cci;

/**
 * You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the longest sequence of 1s you could create
 */
public class FlipBitToWin {
  public static void main(String[] args) {
    System.out.println(flipBit("11111011101111"));
  }

  public static int flipBit(String n) {
    char[] bits = n.toCharArray();
    int left = 0;
    int right = 0;
    int prevIdx = 0;
    int maxIdx = 0;
    int len = 0;
    for (int i = 0; i < bits.length; i++) {
      if (bits[i] == '1') {
        left++;
        continue;
      }
      prevIdx = i;
      break;
    }
    for (int i = prevIdx + 1; i < bits.length; i++) {
      if (bits[i] == '1')
        right++;
      else {
        int prev = left + right + 1;
        System.out.println(left + " " + right);
        if (prev > len) {
          len = prev;
          maxIdx = prevIdx;
        }
        left = right;
        right = 0;
      }
    }
    if (bits[bits.length - 1] == '1') {
      System.out.println(left + " " + right);
      int prev = left + right + 1;
      if (prev > len)
        maxIdx = prevIdx;
    }
    return maxIdx;
  }
}
