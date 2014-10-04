package eulerproblems;

import java.math.BigInteger;

import utility.CommonMethods;

public class P065 {

   public static void main(String[] args) {
      BigInteger n1 = BigInteger.valueOf(1);
      BigInteger n2 = BigInteger.valueOf(2);
      BigInteger n3 = BigInteger.ZERO;
      for (int i = 2; i <= 100; i++) {
         BigInteger temp = n2;
         int k = i % 3 == 0 ? (i / 3) * 2 : 1;
         n3 = n2.multiply(BigInteger.valueOf(k)).add(n1);
         n2 = n3;
         n1 = temp;
      }
      System.out.println(CommonMethods.digitSum(n3));
   }
}
