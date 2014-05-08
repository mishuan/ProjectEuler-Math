package problems;

public class P026 {
   public static void main(String[] args) {
      int largestCycle = 0;
      int largestNumber = 1;
      for (int i = 1000; i > 0; i--) {
         if (largestCycle > i)
            break;
         boolean[] remainder = new boolean[i + 1];
         int value = 1;
         int currentCycle = 0;
         remainder[0] = true;
         while (!remainder[value]) {
            remainder[value] = true;
            value = (value * 10) % i;
            currentCycle++;
         }
         if (currentCycle > largestCycle) {
            largestNumber = i;
            largestCycle = currentCycle;
         }
      }
      System.out.println(largestNumber + " has cycle: " + largestCycle);
   }
}
