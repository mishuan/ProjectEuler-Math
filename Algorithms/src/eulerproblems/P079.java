package eulerproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P079 {

   public static void main(String[] args) {
      int[] temp =
            {319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368, 710, 720, 710, 629, 168, 160, 689, 716, 731, 736, 729,
                  316, 729, 729, 710, 769, 290, 719, 680, 318, 389, 162, 289, 162, 718, 729, 319, 790, 680, 890, 362, 319,
                  760, 316, 729, 380, 319, 728, 716};
      HashSet<Integer> set = new HashSet<Integer>();
      for (int i = 0; i < temp.length; i++) {
         set.add(temp[i]);
      }
      String[] input = new String[set.size()];
      int index = 0;
      for (Integer i : set)
         input[index++] = i.toString();
      Arrays.sort(input);
      ArrayList<ArrayList<Integer>> after = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < 10; i++) {
         ArrayList<Integer> tempList = new ArrayList<Integer>();
         after.add(tempList);
      }
      for (int i = 0; i < input.length; i++) {
         char[] c = input[i].toCharArray();
         int a100 = c[0] - '0';
         int a10 = c[1] - '0';
         int a = c[2] - '0';
         if (!after.get(a100).contains(a10))
            after.get(a100).add(a10);
         if (!after.get(a100).contains(a))
            after.get(a100).add(a);
         if (!after.get(a10).contains(a))
            after.get(a10).add(a);
      }
      ArrayList<Integer> solution = new ArrayList<Integer>();
      index = 7;
      int listPos = 9;
      int counter = 1;
      while (counter < 8) {
         if (counter == after.get(listPos).size()) {
            for (Integer i : after.get(listPos)) {
               if (!solution.contains(i)) {
                  solution.add(i);
                  counter++;
               }
            }
         }
         listPos = (listPos + 1) % 9;
      }
      solution.add(7);
      System.out.println(solution.toString());
   }
}
