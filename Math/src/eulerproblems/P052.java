package eulerproblems;

import utility.CommonMethods;

public class P052 {

   public static void main(String[] args) {
      boolean found = false;
      int index = 10;
      while (!found) {
         for (int i = index; i < index * 10 / 6; i++) {
            found = true;
            for (int j = 2; j <= 6; j++) {
               if (!CommonMethods.isPermutation(i, i * j)) {
                  found = false;
                  break;
               }
            }
            if (found) {
               System.out.println(i);
               break;
            }
         }
         index *= 10;
      }
   }
}
