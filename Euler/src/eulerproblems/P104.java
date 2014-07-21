package eulerproblems;

import utility.CommonMethods;

public class P104 {

   public static void main(String[] args) {
      long f0 = 1;
      long f1 = 1;
      long f2;
      int count = 2;
      while (true) {
         f2 = (f0 + f1) % 1000000000;
         count++;
         f0 = f1;
         f1 = f2;
         if (count < 2750)
            continue;
         if (CommonMethods.isPandigital(Long.valueOf(f2))) {
            // if we want to find the first 9 digits of a number, we find the log of the large
            // number then split it up into 10^8*10^f where f is some floating point containing
            // information about the decimal point. for example log(12345) = 4.091491094...
            // 10^0.91491094... = 1.2345
            double log = (count * 0.20898764024997873) - 0.3494850021680094;
            if (CommonMethods.isPandigital((long) Math.pow(10, log - (long) log + 8)))
               break;
         }
      }
      System.out.println(count);
   }
}
