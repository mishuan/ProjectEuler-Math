package eulerproblems;

import java.util.ArrayList;

import utility.CommonMethods;

public class P047 {

   public static void main(String[] args) throws Exception {
      ArrayList<Integer> primes = CommonMethods.getPrimeList(CommonMethods.primeGenerator(1000000));
      int count = 1;
      int num = 2 * 3 * 5 * 7;
      while (count != 4) {
         num++;
         int factors = 0;
         if (!primes.contains(num)) {
            int temp = num;
            int index = 0;
            int p = primes.get(index);
            while (temp > 1) {
               boolean isFactor = false;
               while (temp % p == 0) {
                  temp /= p;
                  isFactor = true;
               }
               if (isFactor)
                  factors++;
               index++;
               p = primes.get(index);
            }
         }
         if (factors == 4) {
            count++;
         } else {
            count = 0;
         }
      }
      System.out.println(num - 3);
   }
}
