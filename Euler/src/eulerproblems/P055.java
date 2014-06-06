package eulerproblems;

import java.math.BigInteger;
import java.util.LinkedList;

import utility.CommonMethods;

public class P055 {

   public static void main(String[] args) {
      int[] lychrel = new int[10001];
      for (int i = 0; i < 196; i++)
         lychrel[i] = -1;
      lychrel[196] = 1;
      for (int i = 196; i <= 10000; i++) {
         if (lychrel[i] == 0) {
            LinkedList<BigInteger> list = new LinkedList<BigInteger>();
            // reverse digits
            BigInteger temp = BigInteger.valueOf(i);
            list.add(temp);
            for (int j = 0; j < 50; j++) {
               BigInteger tempReverse = CommonMethods.reverseNumber(temp);
               list.add(tempReverse);
               temp = temp.add(tempReverse);
               list.add(temp);
               if (CommonMethods.isPalindrome(temp.toString())) {
                  lychrel[i] = -1;
                  break;
               }
            }
            int value = 0;
            if (lychrel[i] == -1) {
               value = -1;
            } else {
               value = 1;
            }
            for (int j = 0; j < list.size(); j++) {
               BigInteger popped = list.pop();
               if (popped.compareTo(BigInteger.valueOf(10000)) < 0) {
                  lychrel[popped.intValue()] = value;
               }
            }
         }
      }
      int total = 0;
      for (int i = 0; i <= 10000; i++) {
         if (lychrel[i] == 1)
            total++;
      }
      System.out.println(total);
   }
}
