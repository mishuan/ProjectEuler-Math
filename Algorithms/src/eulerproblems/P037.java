package eulerproblems;

import java.util.ArrayList;
import java.util.List;

import utility.CommonMethods;

public class P037 {

   public static void main(String[] args) throws Exception {
      long sum = 0;
      int counter = 0;
      boolean[] primes = CommonMethods.primeGenerator(1000000);
      for (int i = 20; i < 1000000; i++) {
         if (primes[i]) {
            List<Integer> digits = new ArrayList<Integer>();
            int n = i;
            while (n > 0) {
               digits.add(n % 10);
               n /= 10;
               if (!primes[n])
                  break;
            }
            if (n == 0) {
               int multiplier = 1;
               int m = 0;
               while (!digits.isEmpty()) {
                  m += digits.remove(0) * multiplier;
                  if (!primes[m])
                     break;
                  multiplier *= 10;
               }
            }
            if (digits.isEmpty()) {
               sum += i;
               counter++;
            }
         }
      }
      System.out.println(sum + "   " + counter);
   }
}
