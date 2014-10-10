package randomproblems;

import java.util.ArrayList;
import java.util.HashMap;

public class ExcelMath {
   public static ArrayList<Integer> sum(String s) {
      String[] operations = s.split("\n");
      ArrayList<Integer> returnSums = new ArrayList<Integer>();
      for (String tempS : operations) {
         String[] current = tempS.split("\\+");
         int sum = 0;
         for (String c : current) {
            char first = c.charAt(0);
            if (first >= 'A') {
               sum += returnSums.get((int) (first - 'A'));
            } else {
               sum += Integer.valueOf(c);
            }
         }
         returnSums.add(sum);
      }
      return returnSums;
   }

   static HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
   static String[] cells;

   static void sumUp(int cellNum) {
      String[] operands = cells[cellNum].split("\\+");
      int sum = 0;
      for (String o : operands) {
         char c = o.charAt(0);
         if (c >= 'A') {
            int cInt = c - 65;
            if (!sums.containsKey(cInt))
               sumUp(cInt);

            sum += sums.get(cInt);
         } else {
            sum += Integer.valueOf(o);
         }
      }
      if (!sums.containsKey((char) (cellNum + 65)))
         sums.put(cellNum, sum);
   }

   public static void createCells(String s) {
      cells = s.split("\n");
      for (int i = 0; i < cells.length; i++) {
         sumUp(i);
      }
   }

   public static void main(String[] args) {
      String test = "1+1 \n C+1 \n A+1 \n 1+B \n B+C";
      // 2, 4, 3, 5, 7
      // System.out.println(sum(test));
      // sumRecursion(test);
      createCells(test);
      System.out.println(sums);
   }
}
