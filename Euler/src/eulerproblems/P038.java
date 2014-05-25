package eulerproblems;

import utility.CommonMethods;

public class P038 {

   public static void main(String[] args) {
      for (int i = 9999; i > 5000; i--) {
         if (CommonMethods.isPandigital(CommonMethods.concat(i, i * 2))) {
            System.out.println(i + "" + i * 2);
            break;
         }
      }
   }
}
