package eulerproblems;

import java.util.ArrayList;

import utility.CommonMethods;

public class P049 {

   public static void main(String[] args) throws Exception {
      boolean[] isPrime = CommonMethods.primeGenerator(10000);

      for (int i = 1000; i < 3340; i++) {
         boolean found = false;
         if (isPrime[i] && isPrime[i + 3330] && isPrime[i + 6660]) {
            found = true;
            int[] num = {i, i + 3330, i + 6660};
            ArrayList<Integer> digits = new ArrayList<Integer>();
            while (num[0] > 0) {
               digits.add(num[0] % 10);
               num[0] /= 10;
            }
            while (num[1] > 0) {
               if (!digits.contains(num[1] % 10)) {
                  found = false;
                  break;
               }
               num[1] /= 10;
            }
            if (found == true) {
               while (num[2] > 0) {
                  if (!digits.contains(num[2] % 10)) {
                     found = false;
                     break;
                  }
                  num[2] /= 10;
               }
            }
         }
         if (found == true) {
            System.out.println(i);
         }
      }
   }
}
