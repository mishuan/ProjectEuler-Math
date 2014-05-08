package problems;

import java.math.BigInteger;

public class P016 {

   public static void main(String[] args) {
      int sum = 0;
      BigInteger power2 = new BigInteger("2");
      BigInteger TEN = new BigInteger("10");
      power2 = power2.pow(1000);
      for (int i = 0; i < 302; i++) {
         sum += power2.mod(TEN).intValue();
         power2 = power2.divide(TEN);
      }
      System.out.println(sum);
   }
}
