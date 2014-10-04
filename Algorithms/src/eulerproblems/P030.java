package eulerproblems;

public class P030 {
   public static void main(String[] args) {
      int sum = 0;
      for (int i = 2; i < 420000; i++) {
         int number = i;
         int digitSum = 0;
         int digit;
         while (number > 0) {
            digit = number % 10;
            number /= 10;
            digitSum += digit * digit * digit * digit * digit;
         }
         if (digitSum == i) {
            sum += i;
         }
      }
      System.out.println(sum);
   }
}
