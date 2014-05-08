package problems;

import java.math.BigInteger;

public class P020 {

   public static void main(String[] args) {

      BigInteger factorial = new BigInteger("1");
      BigInteger TEN = new BigInteger("10");
      int digit_sum = 0;
      for (int i = 1; i <= 100; i++) {
         factorial = factorial.multiply(BigInteger.valueOf(i));
         while (factorial.mod(TEN).intValue() == 0) {
            factorial = factorial.divide(TEN);
         }
      }
      System.out.println(factorial);
      while (factorial.compareTo(BigInteger.valueOf(0)) == 1) {
         digit_sum += factorial.mod(TEN).intValue();
         factorial = factorial.divide(TEN);
      }
      System.out.println(digit_sum);
   }
}
