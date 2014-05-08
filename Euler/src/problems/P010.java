package problems;

import static utility.CommonMethods.primeGenerator;

public class P010 {
   public static void main(String[] args) throws Exception {
      long startTime = System.nanoTime();
      boolean[] isPrime = primeGenerator(2000000);
      long sum = 0;
      for (int i = 0; i <= 2000000; i++) {
         if (isPrime[i]) {
            sum = sum + i;
         }
      }
      System.out.println(sum);
      long endTime = System.nanoTime();
      System.out.println("Took " + (endTime - startTime) + " ns");
   }
}
