package eulerproblems;

import java.util.LinkedList;

public class P092 {

   public static void main(String[] args) {
      long init = System.nanoTime();
      int[] numbers = new int[10000001];
      numbers[1] = 1;
      numbers[89] = 89;
      for (int i = 1; i <= 10000000; i++) {
         if (numbers[i] == 0) {
            LinkedList<Integer> numbersSquare = new LinkedList<Integer>();
            int curr = i;
            int convergence = 0;
            while (true) {
               int digitSum = 0;
               while (curr > 0) {
                  int digit = curr % 10;
                  digitSum += digit * digit;
                  curr /= 10;
               }
               if (numbers[digitSum] != 0) {
                  convergence = numbers[digitSum];
                  break;
               } else {
                  numbersSquare.add(digitSum);
                  curr = digitSum;
               }
            }
            for (int j = 0; j < numbersSquare.size(); j++) {
               numbers[numbersSquare.pop()] = convergence;
            }
            numbers[i] = convergence;
         }
      }
      // could have did something inside the big for loop to count, too lazy to change
      int total = 0;
      for (int i = 0; i <= 10000000; i++) {
         if (numbers[i] == 89)
            total++;
      }
      System.out.println(total);
      System.out.println((System.nanoTime() - init) / 1000000 + "ms");
   }
}
