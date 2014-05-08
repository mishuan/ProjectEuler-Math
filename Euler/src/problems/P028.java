package problems;

public class P028 {
   public static void main(String[] args) throws Exception {
      long startTime = System.nanoTime();
      int sum = 1;
      for (int i = 3; i <= 1001; i += 2) {
         int j = i - 1; // even counterpart
         sum += (i * i) + (i * i - j) + (j * j + 1) + (j * j - i + 2);
      }
      System.out.println(sum);
      long endTime = System.nanoTime();
      System.out.println("Took " + (endTime - startTime) + " ns");
   }
}
