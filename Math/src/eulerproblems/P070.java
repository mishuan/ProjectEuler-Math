package eulerproblems;

import utility.CommonMethods;

public class P070 {

   public static void main(String[] args) {
      int[] primes = CommonMethods.getPrimeArray(CommonMethods.primeGenerator(10000));
      int min = 0;
      double minRatio = 10000000;
      for (int i = 0; i < primes.length; i++) {
         for (int j = i + 1; j < primes.length; j++) {
            int n = primes[i] * primes[j];
            if (n > 10000000)
               break;
            int phi = (primes[i] - 1) * (primes[j] - 1);
            if (CommonMethods.isPermutation(n, phi)) {
               double ratio = (double) n / (double) phi;
               if (ratio < minRatio) {
                  min = n;
                  minRatio = ratio;
               }
            }
         }
      }
      System.out.println(min);
   }
}
