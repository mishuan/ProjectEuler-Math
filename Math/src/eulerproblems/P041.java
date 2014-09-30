package eulerproblems;

import utility.CommonMethods;

public class P041 {

   public static void main(String[] args) throws Exception {
      boolean[] primes = CommonMethods.primeGenerator(7654321);
      for (int i = 7654321; i > 0; i -= 2) {
         if (primes[i] && CommonMethods.isPandigital(i)) {
            System.out.println(i);
            break;
         }
      }
   }
}
