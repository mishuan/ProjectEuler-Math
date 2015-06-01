package randomproblems;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This problem can be solved using a standard dfs while caching all the subtree scores for quick
 * look up since every subtree will be computed multiple times
 */
public class QuoraRelatedQuestions {
   static int[] nodeScore;
   static float[] totalScore;
   static float[][] subTreeScore;
   static int nodes;

   public static void run(Scanner in) {
      initialize(in);
      constructTrees();
      System.out.println(Arrays.deepToString(subTreeScore));
      findAndPrintMax();
   }

   // find minimum value in the array and print index
   public static void findAndPrintMax() {
      float min = Float.MAX_VALUE;
      int idx = 0;
      for (int i = 0; i < nodes; i++) {
         if (totalScore[i] < min) {
            min = totalScore[i];
            idx = i;
         }
      }
      System.out.println(idx + 1);
   }

   // compute the total score for every node if they were the root node of the graph
   public static void constructTrees() {
      for (int i = 0; i < nodes; i++)
         totalScore[i] = traverse(i, -1);
   }

   // recursive dfs to calculate subtree scores
   public static float traverse(int node, int parent) {
      float total = 0;
      int counter = 0;
      for (int i = 0; i < nodes; i++) {
         // pass if i if there is no connection between the two nodes or i is the parents
         if (subTreeScore[node][i] == -1 || i == parent) continue;
         // if the subtree score is 0, it means this subtree has never been visited before.
         // traverse down the= subtree to calculate its value
         if (subTreeScore[node][i] == 0) subTreeScore[node][i] = traverse(i, node);
         // total score is the score of all the subtress combined
         total += subTreeScore[node][i];
         // increment counter signifying total number of connections
         // TODO:this counter could be encoded in the same subtree matrix
         counter++;
      }
      // return the average score of this node's children values plus the score of the node itself
      return nodeScore[node] + (counter == 0 ? 0 : total / counter);
   }

   // initialize the data structures used
   public static void initialize(Scanner in) {
      nodes = in.nextInt();
      nodeScore = new int[nodes];
      totalScore = new float[nodes];
      // adjacencies and subtree scores can be encoded in the same array
      subTreeScore = new float[nodes][];
      for (int i = 0; i < nodes; i++) {
         subTreeScore[i] = new float[nodes];
         nodeScore[i] = in.nextInt();
      }
      // by default set subtree score to -1, signifying the two nodes are not connected
      for (int i = 0; i < nodes; i++) {
         for (int j = 0; j < nodes; j++) {
            subTreeScore[j][i] = -1;
            subTreeScore[i][j] = -1;
         }
      }
      // for every adjacency, change the subtree score to 0, signifying a connection
      while (in.hasNext()) {
         int node1 = in.nextInt() - 1;
         int node2 = in.nextInt() - 1;
         subTreeScore[node1][node2] = 0;
         subTreeScore[node2][node1] = 0;
      }
   }

   public static void printArray(float[] arr) {
      for (float i : arr)
         System.out.print(String.format("%.2f", i) + " ");
      System.out.println();
   }

   public static void printArray(int[] arr) {
      for (int i : arr)
         System.out.print(i + " ");
      System.out.println();
   }

   public static final boolean TEST = true;

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         run(new Scanner("5\n2 2 1 2 2\n1 2\n2 3\n3 4\n4 5"));
         run(new Scanner("1\n1"));
         run(new Scanner("3\n3 2 1\n2 3\n2 1"));
      }
   }
}
