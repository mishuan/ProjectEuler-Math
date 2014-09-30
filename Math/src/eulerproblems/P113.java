package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P113 {

   public static void main(String[] args) {
      // we take 109 digit number, 1 being print, 0 being increase. we see how many different ways
      // we can place 9 0s in the 109 digit number
      BigInteger increasing = CommonMethods.combinations(109, 9).subtract(BigInteger.ONE);
      // we do something similar for decreasing. except this time we have to first start at 9, hence
      // there are 110 digits (one digit being inserting the 9)
      BigInteger decreasing =
            CommonMethods.combinations(110, 10).subtract(BigInteger.valueOf(100)).subtract(BigInteger.valueOf(1));
      BigInteger sameDigits = BigInteger.valueOf(100 * 9);
      System.out.println(increasing.add(decreasing.subtract(sameDigits)).toString());
   }
}
