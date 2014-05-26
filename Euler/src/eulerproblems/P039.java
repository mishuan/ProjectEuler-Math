package eulerproblems;

public class P039 {

   public static void main(String[] args) {
      int maxTriplets = 0;
      int perimeter = 0;
      for (int i = 2; i < 1000; i += 2) {
         int solutions = 0;
         for (int j = 2; j < i / 3; j++) {
            if ((i * (2 * j - i)) % (2 * (j - i)) == 0)
               solutions++;
         }
         if (solutions > maxTriplets) {
            maxTriplets = solutions;
            perimeter = i;
         }
      }
      System.out.println(perimeter);
   }
}
