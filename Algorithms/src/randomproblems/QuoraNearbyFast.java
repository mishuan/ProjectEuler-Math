package randomproblems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class QuoraNearbyFast {
   // Topic data structure
   private static class Topic {
      double x;
      double y;
      int[] questions;
      int count = 0;

      public Topic(double x, double y, int nQ) {
         this.x = x;
         this.y = y;
         questions = new int[nQ];
      }

      public void append(int i) {
         questions[count] = i;
         count++;
      }
   }

   // data structure to hold topic/question vs distance
   private static class DistancePair {
      public final int id;
      public double distance;

      public DistancePair(int id, double distance) {
         this.id = id;
         this.distance = distance;
      }
   }

   // comparator for topic/distance pair
   private static class DistanceComparator implements Comparator<DistancePair> {
      public int compare(DistancePair p1, DistancePair p2) {
         double d1 = p1.distance;
         double d2 = p2.distance;
         if (p1.id == p2.id) {
            return 0;
         } else if (Math.abs(d1 - d2) < 0.001d)
            return p1.id < p2.id ? 1 : -1;
         else if (d1 < d2)
            return -1;
         else
            return 1;
      }
   }

   // compute distance between query position and topic
   private static double computeDistance(int topicNum, double x, double y) {
      double tX = topics.get(topicNum).x;
      double tY = topics.get(topicNum).y;
      double xDiff = tX - x;
      double yDiff = tY - y;
      return yDiff * yDiff + xDiff * xDiff;
   }

   private static String findTResults(int numResults, double x, double y) {
      TreeSet<DistancePair> topicTree = new TreeSet<DistancePair>(new DistanceComparator());
      StringBuffer returnString = new StringBuffer();
      Set<Integer> keys = topics.keySet();

      for (Integer j : keys) {
         double distance = computeDistance(j, x, y);
         if (topicTree.size() < numResults) {
            DistancePair pair = new DistancePair(j, distance);
            topicTree.add(pair);
         } else if (distance - topicTree.last().distance < 0.001d) {
            DistancePair pair = new DistancePair(j, distance);
            topicTree.pollLast();
            topicTree.add(pair);
         }
      }

      int n = Math.min(numResults, topicTree.size());
      for (int i = 0; i < n; i++)
         returnString.append(topicTree.pollFirst().id).append(' ');

      return returnString.toString().trim();
   }

   private static String findQResults(int numResults, double x, double y) {
      StringBuffer returnString = new StringBuffer();
      TreeSet<DistancePair> questionTree = new TreeSet<DistancePair>(new DistanceComparator());
      HashMap<Integer, DistancePair> questionHash = new HashMap<Integer, DistancePair>(numResults);
      Set<Integer> keys = topics.keySet();

      for (Integer j : keys) {
         double distance = computeDistance(j, x, y);
         int[] questions = topics.get(j).questions;
         int count = topics.get(j).count;

         if (questionTree.size() < numResults) {
            for (int i = 0; i < count; i++) {
               int currQuestion = questions[i];
               DistancePair qdPair = new DistancePair(currQuestion, distance);
               questionTree.add(qdPair);
               questionHash.put(currQuestion, qdPair);
            }
         } else {
            for (int i = 0; i < count; i++) {
               if (distance - questionTree.last().distance < 0.001d) {
                  int currQuestion = questions[i];
                  if (questionHash.containsKey(currQuestion)) {
                     DistancePair duplicate = questionHash.get(currQuestion);
                     if (duplicate.distance > distance) {
                        questionTree.remove(duplicate);
                        duplicate.distance = distance;
                        questionTree.add(duplicate);
                     }
                  } else {
                     DistancePair qdPair = new DistancePair(currQuestion, distance);
                     questionTree.pollLast();
                     questionTree.add(qdPair);
                  }
               }
            }
         }
      }

      int n = Math.min(numResults, questionTree.size());
      for (int i = 0; i < n; i++)
         returnString.append(questionTree.pollFirst().id).append(' ');

      return returnString.toString().trim();
   }

   private static HashMap<Integer, Topic> topics;
   private static int nT;
   private static int nQ;
   private static int nR;

   public static void run(Scanner in) {
      nT = in.nextInt();
      nQ = in.nextInt();
      nR = in.nextInt();
      topics = new HashMap<Integer, Topic>(nT, 1.0f);

      // Construct topics
      long init = System.nanoTime();
      for (int i = 0; i < nT; i++) {
         int topicNum = in.nextInt();
         Topic tempTopic = new Topic(in.nextDouble(), in.nextDouble(), nQ);
         topics.put(topicNum, tempTopic);
      }
      if (BENCHMARK)
         System.out.println("Contruct topics: " + (System.nanoTime() - init));

      init = System.nanoTime();
      // Add questions to topics
      for (int i = 0; i < nQ; i++) {
         int questionNum = in.nextInt();
         int numCategories = in.nextInt();
         for (int j = 0; j < numCategories; j++) {
            topics.get(in.nextInt()).append(questionNum);
         }
      }
      if (BENCHMARK)
         System.out.println("Add questions: " + (System.nanoTime() - init));

      // Run queries
      init = System.nanoTime();
      in.nextLine();
      for (int i = 0; i < nR; i++) {
         char queryType = in.next().charAt(0);
         int numResults = in.nextInt();
         double x = in.nextDouble();
         double y = in.nextDouble();

         // result searching
         if (queryType == 't') {
            if (!BENCHMARK)
               System.out.println(findTResults(numResults, x, y));
            else
               findTResults(numResults, x, y);
         } else {
            if (!BENCHMARK)
               System.out.println(findQResults(numResults, x, y));
            else
               findQResults(numResults, x, y);
         }
      }
      if (BENCHMARK)
         System.out.println("Search: " + (System.nanoTime() - init));
   }

   public static final boolean TEST = !false;
   public static final boolean BENCHMARK = !false;

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         if (!BENCHMARK) {
            run(new Scanner("0 0 0\n"));

            run(new Scanner("0 0 1\nq 100 0.0 0.0\n"));
            run(new Scanner("0 0 1\nt 100 0.0 0.0\n"));

            run(new Scanner("0 1 0\n0 0\n"));
            run(new Scanner("1 0 0\n0 0.0 0.0\n"));
            run(new Scanner("1 1 0\n0 0.0 0.0\n 0 1 0\n"));

            run(new Scanner("0 1 1\n0 0\nq 10 0.0 0.0\n"));
            run(new Scanner("1 0 1\n0 0.0 0.0\nq 10 0.0 0.0\n"));
            run(new Scanner("1 1 1\n0 0.0 0.0\n0 1 0\nq 10 0.0 0.0\n"));

            run(new Scanner("2 2 1\n0 0.0 0.0\n1 0.0 0.0\n1 1 1\n0 1 0\nq 10 0.0 0.0\n")); // 1 0
         }
         Random rand = new Random(0x32423);
         StringBuilder sb = new StringBuilder();
         sb.append("10000 1000 100\n");
         for (int i = 0; i < 10000; i++) {
            sb.append(i).append(' ').append(1000 * rand.nextDouble()).append(' ').append(1000 * rand.nextDouble())
                  .append('\n');
         }
         for (int i = 0; i < 1000; i++) {
            sb.append(i).append(" 1 ").append(rand.nextInt(1000)).append('\n');
         }
         for (int i = 0; i < 50; i++) {
            sb.append("t 10 ").append(1000 * rand.nextDouble()).append(' ').append(1000 * rand.nextDouble()).append('\n');
            sb.append("t 10 ").append(1000 * rand.nextDouble()).append(' ').append(1000 * rand.nextDouble()).append('\n');
         }
         long t0 = System.currentTimeMillis();
         run(new Scanner(sb.toString()));
         System.out.println("Total time: " + (System.currentTimeMillis() - t0));

         run(new Scanner(
               "3 6 2\n0 0.0 0.0\n1 1.0 1.0\n2 2.0 2.0\n0 1 0\n1 2 0 1\n2 3 0 1 2\n3 0\n4 0\n5 2 1 2\nt 2 0.0 0.0\nq 5 100.0 100.0\n"));
         // 0 1
         // 5 2 1 0
      }
   }
}
