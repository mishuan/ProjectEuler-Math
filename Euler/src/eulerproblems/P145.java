package eulerproblems;

import utility.CommonMethods;

public class P145 {

   public static void main(String[] args) {
      int counter = 0;
      boolean[] checked = new boolean[1000000000];
      for (int i = 1; i < 1000000000; i += 2) {
         if (checked[i])
            continue;
         int reverse = CommonMethods.reverseNumber(i);
         checked[i] = true;
         checked[reverse] = true;
         int sum = reverse + i;
         boolean isReversible = true;
         while (sum > 0) {
            if ((sum % 10) % 2 == 0) {
               isReversible = false;
               break;
            }
            sum /= 10;
         }
         if (isReversible) {
            if (CommonMethods.isPalindrome(String.valueOf(i)))
               counter += 2;
            else
               counter++;
         }
      }
      System.out.println(counter);
   }
}
