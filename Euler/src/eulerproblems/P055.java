package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P055 {

   public static void main(String[] args) {
      int total = 195;
      for (int i = 197; i <= 10000; i++) {
         BigInteger temp = BigInteger.valueOf(i);
         for (int j = 0; j < 50; j++) {
            temp = temp.add(CommonMethods.reverseNumber(temp));
            if (CommonMethods.isPalindrome(temp.toString())) {
               total++;
               break;
            }
         }
      }
      System.out.println(10000 - total);
   }
}
