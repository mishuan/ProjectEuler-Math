package eulerproblems;

public class P076 {

   public static void main(String[] args) {
      long[] combinations = new long[101];
      combinations[0] = 1;
      for (int i = 1; i < 100; i++) {
         for (int j = i; j < 101; j++) {
            combinations[j] += combinations[j - i];
         }
      }
      System.out.println(combinations[100]);
   }
}
