package randomproblems;

import java.util.HashMap;
import java.util.Map;


public class NSumTo0 {

   public static void main(String[] args) {
      int[] array = {-3, -1, 1, 3, 5, -2};
      nSumTo0(array, 3);
   }

   public static void nSumTo0(int[] arr, int n) {
      int len = arr.length;
      Map<Integer, String> sums = new HashMap<Integer, String>();
      for (int i = 0; i < len; i++)
         sums.put(arr[i], String.valueOf(i));
      for (int k = 2; k < n; k++) {
         HashMap<Integer, String> temp = new HashMap<Integer, String>();
         for (int i = 0; i < len; i++) {
            for (Map.Entry<Integer, String> entry : sums.entrySet())
               if (!entry.getValue().contains(String.valueOf(i)))
                  temp.put(arr[i] + entry.getKey(), entry.getValue() + String.valueOf(" " + i));
         }
         sums = temp;
      }
      for (int i = 0; i < len; i++) {
         int complement = arr[i] * (-1);
         if (sums.containsKey(complement) && !sums.get(complement).contains(String.valueOf(i)))
            System.out.println(sums.get(complement) + " " + i);
      }
   }
}
