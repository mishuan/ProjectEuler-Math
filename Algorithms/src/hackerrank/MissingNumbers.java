package hackerrank;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

//This causes run time error?!
public class MissingNumbers {
   public static String findMissingNumbers(int[] s1, int[] s2) {
      LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
      int p1 = 0;
      for (int p2 = 0; p2 < s2.length; p2++) {
         if (s1[p1] != s2[p2])
            set.add(s2[p2]);
         else
            p1++;
      }
      String missingNums = "";
      for (Integer i : set)
         missingNums += i + " ";
      return missingNums;
   }

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
      String l1 = in.nextLine();
      in.nextLine();
      String l2 = in.nextLine();
      String[] list1 = l1.split(" ");
      String[] list2 = l2.split(" ");
      int[] intList1 = stringToInt(list1);
      int[] intList2 = stringToInt(list2);

      Arrays.sort(intList1);
      Arrays.sort(intList2);

      String result =
            list1.length > list2.length ? findMissingNumbers(intList2, intList1) : findMissingNumbers(intList1, intList2);
      System.out.println(result);
   }
}
