package problems;

import java.math.BigInteger;
import java.util.TreeSet;

public class P029 {
   public static void main(String[] args) throws Exception {
      long startTime = System.nanoTime();
      TreeSet<BigInteger> set = new TreeSet<BigInteger>();
      for (int a = 2; a <= 100; a++) {
         for (int b = 2; b <= 100; b++) {
            BigInteger temp = BigInteger.valueOf(a);
            temp = temp.pow(b);
            set.add(temp);
         }
      }
      System.out.println(set.size());
      long endTime = System.nanoTime();
      System.out.println("Took " + (endTime - startTime) + " ns");
   }
}
