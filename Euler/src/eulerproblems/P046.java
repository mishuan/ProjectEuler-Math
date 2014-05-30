package eulerproblems;

import java.util.ArrayList;

import utility.CommonMethods;

public class P046 {

   public static void main(String[] args) throws Exception {
      boolean[] isPrimes = CommonMethods.primeGenerator(10000);
      ArrayList<Integer> primes = CommonMethods.getPrimeList(isPrimes);
      int index = 33;
      boolean found = false;
      while (!found) {
         index += 2;
         if (!isPrimes[index]) {
            for (int i = 0; i < primes.size(); i++) {
               double n = Math.sqrt((index - primes.get(i)) / 2);
               if (n == (int) n) {
                  break;
               } else if (primes.get(i) > index) {
                  found = true;
                  break;
               }
            }
         }
      }
      System.out.println(index);
   }
}
