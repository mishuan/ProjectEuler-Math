package randomproblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class QuoraFeedOptimizer {
   static int eventsCount;
   static int timeRange;
   static int windowSize;

   static Queue<Story> storyQueue;

   public static class Story {
      int size;
      int score;
      int time;
      int id;

      public Story(int time, int score, int size, int id) {
         this.time = time;
         this.size = size;
         this.score = score;
         this.id = id;
      }
   }

   public static class Feed {
      ArrayList<Integer> items;
      int totalScore = 0;

      public Feed(ArrayList<Integer> list) {
         items = new ArrayList<Integer>(list.size() + 1);
         items.addAll(list);
      }
   }

   public static void checkQueue(int time) {
      while (!storyQueue.isEmpty() && time - storyQueue.peek().time > timeRange)
         storyQueue.poll();
   }

   public static boolean isChooseCurr(ArrayList<Integer> currList, ArrayList<Integer> newList) {
      int newListSize = newList.size();
      int newLen = newListSize + 1;
      if (newLen < currList.size())
         return false;
      else if (newLen == currList.size()) {
         for (int i = 0; i < newListSize; i++) {
            if (newList.get(i) < currList.get(i))
               return false;
         }
      }
      return true;
   }

   public static String generateFeed() {
      int numOfItems = storyQueue.size();
      Story[] items = storyQueue.toArray(new Story[storyQueue.size()]);
      Feed[][] dpGrid = new Feed[numOfItems + 1][windowSize + 1];
      ArrayList<Integer> emptyList = new ArrayList<Integer>();

      // initialize dp grid
      Feed emptyFeed = new Feed(emptyList);
      for (int i = 0; i <= windowSize; i++)
         dpGrid[0][i] = emptyFeed;

      // run knapsack dp
      for (int i = 0; i < numOfItems; i++) {
         for (int j = 0; j <= windowSize; j++) {
            Feed curr = dpGrid[i][j];
            int prevJ = j - items[i].size;
            int nextI = i + 1;
            int newTotalScore = prevJ < 0 ? 0 : dpGrid[i][prevJ].totalScore + items[i].score;;
            if (curr.totalScore > newTotalScore || newTotalScore == 0) {
               dpGrid[nextI][j] = curr;
            } else if (curr.totalScore == newTotalScore && isChooseCurr(curr.items, dpGrid[i][prevJ].items)) {
               dpGrid[nextI][j] = curr;
            } else {
               Feed feed = new Feed(dpGrid[i][prevJ].items);
               feed.items.add(items[i].id);
               feed.totalScore = newTotalScore;
               dpGrid[nextI][j] = feed;
            }
         }
      }
      return resultString(dpGrid[numOfItems][windowSize]);
   }
   
   public static String resultString(Feed feed){
      ArrayList<Integer> list = feed.items;
      StringBuffer sb = new StringBuffer();
      sb.append(feed.totalScore).append(' ').append(list.size());
      for (int i : list)
         sb.append(' ').append(i);
      return sb.toString().trim();
   }
   
   public static void run(Scanner in) {
      eventsCount = in.nextInt();
      timeRange = in.nextInt();
      windowSize = in.nextInt();
      storyQueue = new ArrayDeque<Story>(timeRange);
      int storyId = 1;
      for (int i = 0; i < eventsCount; i++) {
         char eventType = in.next().charAt(0);
         int timeStamp = in.nextInt();;

         if (eventType == 'S') {
            storyQueue.add(new Story(timeStamp, in.nextInt(), in.nextInt(), storyId));
            storyId++;
         } else {
            checkQueue(timeStamp);
            generateFeed();
         }
      }
   }

   public static final boolean TEST = true;

   public static void main(String[] args) {
      if (!TEST) {
         Scanner in = new Scanner(System.in);
         run(in);
         in.close();
      } else {
         run(new Scanner("1 1 1\nR 12\n"));
         run(new Scanner("1 1 1\nS 12 10 10\n"));
         run(new Scanner("3 10 10\nS 11 9 9\nS 12 9 9\nR 13\n"));
         run(new Scanner("4 10 10\nS 11 5 5\nS 12 5 5\nS 13 5 5\nR 14\n"));
         run(new Scanner("5 10 10\nS 11 2 3\nS 12 2 3\nS 13 2 3\nS 14 6 9\nR 15\n"));

         Random rand = new Random(0x32423);
         StringBuilder sb = new StringBuilder();
         sb.append("5000 1000 1000\n");
         for (int i = 0; i < 5000; i += 2) {
            sb.append('S').append(' ').append(i).append(' ').append(rand.nextInt(2000)).append(' ')
                  .append(rand.nextInt(2000)).append('\n');
            sb.append('R').append(' ').append(i + 1).append('\n');
         }
         long t0 = System.currentTimeMillis();
         run(new Scanner(sb.toString()));
         System.out.println(System.currentTimeMillis() - t0);
      }
   }
}
