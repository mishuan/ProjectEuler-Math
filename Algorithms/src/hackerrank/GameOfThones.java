package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfThones {
  public static String compute(String s) {
    char[] chars = s.toCharArray();
    if (s.length() == 1)
      return "YES";
    if (s.length() == 2 && chars[0] != chars[1])
      return "NO";
    Arrays.sort(chars);
    int count = 0;
    for (int i = 0; i < chars.length; i += 2) {
      if (chars[i] == chars[i + 1])
        continue;
      count++;
    }
    if (count > 1)
      return "NO";
    return "YES";
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    String s = in.next();
    System.out.println('A' - 65);
    System.out.println(compute2(s));
  }

  public static String compute2(String s){
    char[] chars = s.toUpperCase().toCharArray();
    int[] alphabet = new int[26];
    for(char c:chars)
      alphabet[c - 65]++;
    int count = 0;
    for(int i : alphabet){
      if(i%2 != 0)
        count++;
    }
    return count > 1 ? "NO" : "YES";
  }
}
