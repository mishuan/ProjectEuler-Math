package hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 */
public class FunnyString {
  public static final boolean TEST = false;
  public static int T;

  public static void run(Scanner in) {
    T = Integer.parseInt(in.nextLine());
    for (int i = 0; i < T; i++)
      System.out.println(isFunny(in.nextLine()) ? "Funny" : "Not Funny");
  }

  public static boolean isFunny(String s) {
    int front = 0;
    int back = s.length() - 1;
    while (front < back) {
      int frontVal = Math.abs(s.charAt(front + 1) - s.charAt(front));
      int backVal = Math.abs(s.charAt(back) - s.charAt(back - 1));
      if (frontVal != backVal) {
        return false;
      }
      front++;
      back--;
    }
    return true;
  }

  public static void main(String[] args) {
    if (!TEST) {
      Scanner in = new Scanner(System.in);
      run(in);
      in.close();
    } else {

    }
  }
}
