package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P036 {

   public static void main(String[] args) {
      int sum = 0;
      for (int i = 0; i < 1000000; i++) {
         BigInteger number = BigInteger.valueOf(i);
         if (CommonMethods.isPalindrome(number.toString()) && CommonMethods.isPalindrome(number.toString(2)))
            sum += i;
      }
      System.out.println(sum);
   }
}
