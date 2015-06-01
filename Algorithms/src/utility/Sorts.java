package utility;


public class Sorts {
   public static final boolean TEST = true;

   public static int[] insertion(int[] arr) {
      int[] sorted = new int[arr.length];
      int top = arr.length - 1;
      for (int i = 0; i < arr.length; i++) {
         sorted[top] = arr[i];
         for (int j = top; j < arr.length - 1; j++) {
            if (sorted[j] < sorted[j + 1])
               break;
            int temp = sorted[j];
            sorted[j] = sorted[j + 1];
            sorted[j + 1] = temp;
         }
         top--;
      }
      return sorted;
   }

   public static void quickSort(int[] arr) {
      quick(arr, 0, arr.length - 1);
   }

   public static void quick(int[] arr, int left, int right) {
      int leftIdx = left;
      int rightIdx = right;
      int pivot = arr[left + (right - left) / 2];
      while (leftIdx <= rightIdx) {
         while (arr[rightIdx] > pivot)
            rightIdx--;
         while (arr[leftIdx] < pivot)
            leftIdx++;
         if (leftIdx > rightIdx)
            continue;
         int temp = arr[rightIdx];
         arr[rightIdx] = arr[leftIdx];
         arr[leftIdx] = temp;
         rightIdx--;
         leftIdx++;
      }
      if (rightIdx > left)
         quick(arr, left, rightIdx);
      if (leftIdx < right)
         quick(arr, leftIdx, right);
   }

   public static void printArray(int[] arr) {
      for (int i : arr)
         System.out.print(i + " ");
   }

   public static void main(String[] args) {
      int[] arr = {4, 1, 6, 1, 5, 8, 3, 8, 4, 7, 9};
      quickSort(arr);
      printArray(arr);
   }
}
