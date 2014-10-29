package hackerrank;

import java.util.Scanner;

public class LonelyInteger {
   public static int[] stringToInt(String[] s) {
      int[] array = new int[s.length];
      for (int i = 0; i < s.length; i++)
         array[i] = Integer.parseInt(s[i]);
      return array;
   }
   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      in.nextLine();
      String[] list = in.nextLine().split(" ");
      int[] intArr = stringToInt(list);
      int result = 0;
      for(int i : intArr)
         result ^= i;
      System.out.println(result);
   }
}
