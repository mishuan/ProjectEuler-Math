package eulerproblems;

public class P031 {

   public static void main(String[] args) {
      int[] dominations = {1, 2, 5, 10, 20, 50, 100, 200};
      int[] combinations = new int[201];
      combinations[0] = 1;
      for (int i = 0; i < dominations.length; i++) {
         for (int j = dominations[i]; j <= 200; j++) {
            combinations[j] += combinations[j - dominations[i]];
         }
      }
      System.out.println(combinations[200]);
   }
}
