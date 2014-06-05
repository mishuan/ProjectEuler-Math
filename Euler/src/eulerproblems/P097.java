package eulerproblems;

import java.math.BigInteger;

public class P097 {

   public static void main(String[] args) {
      BigInteger a = BigInteger.valueOf(28433);
      BigInteger b = BigInteger.valueOf(2).pow(7830457);
      b = a.multiply(b).add(BigInteger.ONE);
      System.out.println(b.mod(BigInteger.valueOf(10000000000l)));
   }
}
