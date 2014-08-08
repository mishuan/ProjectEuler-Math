package eulerproblems;

public class P100 {
   public static void main(String[] args) {
      double n = 707106700000l;
      while (true) {
         double m = Math.sqrt(2 * n * n - 2 * n + 0.25d) + 0.5d;
         if (m == (long) m && m > 1000000000000d) {
            System.out.println((long) n);
            break;
         }
         n++;
      }
   }
}
