package eulerproblems;

import static utility.CommonMethods.primeGenerator;

public class P027 {

   public static void main(String[] args) throws Exception {
      long startTime = System.nanoTime();
      boolean[] isPrime = primeGenerator(2000000);
      int largestChain = 0;
      int largestProduct = 0;
      for (int b = 1000; b >= -1000; b--) {
         for (int a = 999; a >= -999; a -= 2) {
            int n = 0;
            int y = 0;
            do {
               y = n * n + a * n + b;
               n++;
            } while (isPrime[Math.abs(y)]);
            if (n > largestChain) {
               largestChain = n;
               largestProduct = a * b;
            }
         }
      }
      System.out.println(largestProduct);
      long endTime = System.nanoTime();
      System.out.println("Took " + (endTime - startTime) + " ns");
   }
}
