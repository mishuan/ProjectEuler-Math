package eulerproblems;

import java.math.BigInteger;

public class P057 {
   public static void main(String[] args) {
      BigInteger n1 = BigInteger.valueOf(7);
      BigInteger n2 = BigInteger.valueOf(3);
      BigInteger d1 = BigInteger.valueOf(5);
      BigInteger d2 = BigInteger.valueOf(2);
      BigInteger n3 = BigInteger.ZERO;
      BigInteger d3 = BigInteger.ZERO;
      BigInteger two = BigInteger.valueOf(2);
      int total = 0;
      for (int i = 0; i < 998; i++) {
         n3 = n1.multiply(two).add(n2);
         d3 = d1.multiply(two).add(d2);
         n2 = n1;
         n1 = n3;
         d2 = d1;
         d1 = d3;
         if (n3.toString().toCharArray().length > d3.toString().toCharArray().length)
            total++;
      }
      System.out.println(total);
   }
}
