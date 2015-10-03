package cci;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  static List<String> list;

  public static void main(String args[]) {
    list = new ArrayList<>();
    permuteString("abc");
    System.out.println(list.toString());
  }
  public static void permuteString(String s){
    permute(s, 1);
  }

  public static void permute(String s, int n) {
    System.out.println("P(" + s + ", " + n + ")");
    int len = s.length();
    if (n == len)
      list.add(s);
    else {
      String firstHalf = s.substring(0, n + 1);
      String secondHalf = s.substring(n + 1, len);
      permute(s, n + 1);
      for (int i = n; i > 0; i--) {
        firstHalf = swap(firstHalf, i, i - 1);
        permute(firstHalf + secondHalf, n + 1);
      }
    }
  }

  public static String swap(String s, int pos0, int pos1) {
    char[] chars = s.toCharArray();
    char temp = chars[pos0];
    chars[pos0] = chars[pos1];
    chars[pos1] = temp;
    return new String(chars);
  }
}
