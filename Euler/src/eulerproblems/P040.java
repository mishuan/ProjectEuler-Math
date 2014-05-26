package eulerproblems;

public class P040 {

   public static void main(String[] args) {
      int product = 1;
      for (int i = 1; i <= 1000000; i *= 10) {
         int n = i;
         int num = 1;
         while (n > String.valueOf(num).length()) {
            n -= String.valueOf(num).length();
            num++;
         }
         product *= (int) (String.valueOf(num).charAt(n - 1) - '0');
      }
      System.out.println(product);
   }
}
