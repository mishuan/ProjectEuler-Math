package randomproblems;

import java.util.Scanner;

public class QuoraUpvotes {
   static int N;
   static int K;
   static int[] upvotes;

   public static void run(Scanner in) {
      N = in.nextInt();
      K = in.nextInt();
      upvotes = new int[N];
      for (int i = 0; i < N; i++)
         upvotes[i] = in.nextInt();
      compute();
   }

   public static void compute() {
      if (!TEST) {
         for (int i = K; i <= N; i++) {
            System.out.println(computeK(i));
         }
      } else {
         for (int i = K; i <= N; i++) {
            System.out.print(computeK(i) + " ");
         }
      }
      System.out.println();

   }

   public static int computeK(int currK) {
      int startIdx = currK - K;
      int prev = upvotes[startIdx];
      int repCount = 1;
      int chain = 1;
      int total = 0;
      boolean inc = true;
      for (int i = startIdx + 1; i < currK; i++) {
         if (prev == upvotes[i]) {
            chain++;
            repCount++;
         } else {
            if (upvotes[i] > prev && inc) {
               chain++;
            } else if (upvotes[i] < prev && !inc) {
               chain++;
            } else {
               if (inc) total = total + countSubArrays(chain) - countSubArrays(repCount);
               else total = total - countSubArrays(chain) + countSubArrays(repCount);
               inc = !inc;
               chain = repCount + 1;
            }
            if (repCount > 1) {
               total = inc ? total - countSubArrays(repCount) : total + countSubArrays(repCount);
               repCount = 1;
            }
            prev = upvotes[i];
         }
      }
      total = inc ? total + countSubArrays(chain) : total - countSubArrays(chain);
      total = inc ? total - countSubArrays(repCount) : total + countSubArrays(repCount);
      return total;
   }

   public static int countSubArrays(int n) {
      if (n == 1)
         return 0;
      return (n + 1) * n / 2 - n;
   }

   public static final boolean TEST = true;

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         run(new Scanner("5 3\n1 2 3 1 1\n"));
         run(new Scanner("3 3\n3 1 1\n"));
         run(new Scanner("3 3\n3 1 3\n"));
         run(new Scanner("4 3\n3 1 1 3\n"));
         run(new Scanner("4 4\n3 1 1 3\n"));
         run(new Scanner("4 4\n1 1 0 0\n"));
         run(new Scanner("4 4\n0 0 1 1\n"));
         run(new Scanner("5 4\n 5 3 1 1 3\n"));
         run(new Scanner("5 5\n 5 3 1 1 3\n"));
         run(new Scanner("5 5\n 1 1 1 1 1\n"));
         run(new Scanner("5 5\n 1 1 3 1 1\n"));
         run(new Scanner("5 5\n 1 2 1 2 1\n"));
         run(new Scanner("7 7\n 5 3 1 1 0 0 3\n"));
         run(new Scanner("9 5\n 1 2 1 2 1 2 1 2 1\n"));
      }
   }
}
