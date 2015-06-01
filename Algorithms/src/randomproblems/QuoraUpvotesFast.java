package randomproblems;

import java.util.Scanner;

public class QuoraUpvotesFast {
   static int N;
   static int K;
   static int[] upvotes;
   static int[][] inc;
   static int[][] dec;

   public static void run(Scanner in) {
      N = in.nextInt();
      K = in.nextInt();
      inc = new int[2][];
      dec = new int[2][];
      upvotes = new int[N];
      for (int i = 0; i < N; i++)
         upvotes[i] = in.nextInt();
      constructAddTable();
      constructDelTable();
      calculateSubranges();
   }

   public static void calculateSubranges() {
      int incSub = 0;
      int decSub = 0;
      for (int i = 0; i < K; i++) {
         incSub += inc[0][i];
         decSub += dec[0][i];
      }
      for (int i = K; i < N; i++) {
         System.out.println(incSub - decSub);
         incSub += inc[0][i] - inc[1][i - K];
         decSub += dec[0][i] - dec[1][i - K];
      }
      System.out.println(incSub - decSub);
   }

   public static String arrayToString(int[] arr) {
      StringBuffer s = new StringBuffer("");
      for (int i : arr)
         s.append(i + " ");
      return s.toString();
   }

   // construct table used for adding sub arrays
   public static void constructAddTable() {
      inc[0] = new int[N];
      dec[0] = new int[N];
      for (int i = 1; i < N; i++) {
         int before = i - 1;
         inc[0][i] = upvotes[i] >= upvotes[before] ? inc[0][before] + 1 : 0;
         dec[0][i] = upvotes[i] <= upvotes[before] ? dec[0][before] + 1 : 0;
         inc[0][i] = Math.min(inc[0][i], K - 1);
         dec[0][i] = Math.min(dec[0][i], K - 1);
      }
   }

   // construct table used for deleting sub arrays
   public static void constructDelTable() {
      inc[1] = new int[N];
      dec[1] = new int[N];
      for (int i = N - 2; i >= 0; i--) {
         int after = i + 1;
         inc[1][i] = upvotes[i] <= upvotes[after] ? inc[1][after] + 1 : 0;
         dec[1][i] = upvotes[i] >= upvotes[after] ? dec[1][after] + 1 : 0;
         inc[1][i] = Math.min(inc[1][i], K - 1);
         dec[1][i] = Math.min(dec[1][i], K - 1);
      }
   }

   public static final boolean TEST = true;

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         run(new Scanner("5 3\n1 2 3 1 1\n"));
         run(new Scanner("2 2\n3 1\n"));
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
