package randomproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;

// Round two
public class QuoraNearby2 {
   // Topic data structure
   static public class Topic {
      double x;
      double y;
      int[] questions;
      int pointer = 0;

      public Topic(double x, double y, int nQ) {
         this.x = x;
         this.y = y;
         questions = new int[nQ];
      }

      public void append(int i) {
         questions[pointer] = i;
         pointer++;
      }
   }

   // data structure to hold topic vs distance
   static public class TopicDistancePair {
      public final int topic;
      public final double distance;

      public TopicDistancePair(int topic, double distance) {
         this.topic = topic;
         this.distance = distance;
      }
   }

   // comparator for topic/distance pair
   static class DistanceComparator implements Comparator<TopicDistancePair> {
      public int compare(TopicDistancePair p1, TopicDistancePair p2) {
         double d1 = p1.distance;
         double d2 = p2.distance;
         if (d1 == d2)
            return p1.topic > p2.topic ? 1 : -1;
         else if (d1 < d2)
            return -1;
         else
            return 1;
      }
   }

   // compute distance between query position and topic
   static double computeDistance(int topicNum, double x, double y) {
      double tX = topics[topicNum].x;
      double tY = topics[topicNum].y;
      double xDiff = tX - x;
      double yDiff = tY - y;
      return Math.sqrt(yDiff * yDiff + xDiff * xDiff);
   }

   // print results given query type
   static String findResults(String queryType, int numResults, TopicDistancePair[] distances) {
      String returnString = "";
      char type = queryType.charAt(0);
      Arrays.sort(distances, new DistanceComparator());
      if (type == 't') {
         for (int i = 0; i < numResults; i++)
            returnString += distances[i].topic + " ";
      } else if (type == 'q') {
         LinkedHashSet<Integer> questionSet = new LinkedHashSet<Integer>();
         int setSize = distances.length;
         loop: for (int i = 0; i < setSize; i++) {
            int topicId = distances[i].topic;
            int[] questions = topics[topicId].questions;
            for (int j = topics[topicId].pointer - 1; j >= 0; j--) {
               questionSet.add(questions[j]);
               if (questionSet.size() == numResults)
                  break loop;
            }
         }
         for (int i : questionSet)
            returnString += i + " ";
      }
      return returnString;
   }

   static Topic[] topics;

   public static void main(String[] args) {
      long init = System.currentTimeMillis();
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      int nT = in.nextInt();
      int nQ = in.nextInt();
      int nR = in.nextInt();

      // Construct topics
      topics = new Topic[nT];
      for (int i = 0; i < nT; i++) {
         in.nextInt();
         topics[i] = new Topic(in.nextDouble(), in.nextDouble(), nQ);
      }
      // Add questions to topics
      for (int i = 0; i < nQ; i++) {
         in.nextInt();
         int numCategories = in.nextInt();
         for (int j = 0; j < numCategories; j++) {
            topics[in.nextInt()].append(i);
         }
      }
      // Run queries
      in.nextLine();
      for (int i = 0; i < nR; i++) {
         String query = in.nextLine();
         String[] params = query.split(" ");
         int numResults = Integer.valueOf(params[1]);
         double x = Double.valueOf(params[2]);
         double y = Double.valueOf(params[3]);
         TopicDistancePair[] distances = new TopicDistancePair[nT];
         for (int j = 0; j < nT; j++) {
            TopicDistancePair pair = new TopicDistancePair(j, computeDistance(j, x, y));
            distances[j] = pair;
         }
         System.out.println(findResults(params[0], numResults, distances));
      }
      System.out.println(System.currentTimeMillis() - init);
   }
}
