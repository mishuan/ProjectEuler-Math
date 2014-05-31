package eulerproblems;

import java.math.BigInteger;

public class P048 {
   public static void main(String[] args) {
      BigInteger sum = BigInteger.ZERO;
      for (int i = 1; i <= 1000; i++) {
         BigInteger tenDigits = new BigInteger(String.valueOf(i));
         tenDigits = tenDigits.pow(i);
         sum = sum.add(tenDigits.mod(BigInteger.valueOf(10000000000l)));
      }
      System.out.println(sum.toString());
   }
}
