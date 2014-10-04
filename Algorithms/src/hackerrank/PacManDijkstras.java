package hackerrank;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PacManDijkstras {

   static class ListComparator implements Comparator<LinkedList<Integer[]>> {
      @Override
      public int compare(LinkedList<Integer[]> x, LinkedList<Integer[]> y) {
         if (x.size() < y.size()) {
            return -1;
         }
         if (x.size() > y.size()) {
            return 1;
         }
         return 0;
      }
   }

   static void dfs(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String[] grid) {
      // setup
      char cGrid[][] = new char[r][c];
      for (int i = 0; i < r; i++) {
         cGrid[i] = grid[i].toCharArray();
      }
      PriorityQueue<LinkedList<Integer[]>> queue = new PriorityQueue<LinkedList<Integer[]>>(10, new ListComparator());
      Integer init[] = {pacman_r, pacman_c};
      LinkedList<Integer[]> list = new LinkedList<Integer[]>();
      list.add(init);
      queue.add(list);
      boolean visited[][] = new boolean[r][c];
      // search
      LinkedList<Integer[]> returnList = null;
      while (!queue.isEmpty()) {
         LinkedList<Integer[]> currList = queue.poll();
         Integer currNode[] = currList.getLast();
         if (visited[currNode[0]][currNode[1]])
            continue;
         
         if (currNode[0] == food_r && currNode[1] == food_c) {
            returnList = currList;
            break;
         }
         visited[currNode[0]][currNode[1]] = true;

         int tempR = currNode[0] + 1;
         int tempC = currNode[1];
         if (tempR < r && !visited[tempR][tempC] && cGrid[tempR][tempC] != '%') {
            Integer node[] = {tempR, tempC};
            LinkedList<Integer[]> newList = new LinkedList<Integer[]>();
            newList.addAll(currList);
            newList.add(node);
            queue.add(newList);
         }

         tempR = currNode[0];
         tempC = currNode[1] - 1;
         if (tempC >= 0 && !visited[tempR][tempC] && cGrid[tempR][tempC] != '%') {
            Integer node[] = {tempR, tempC};
            LinkedList<Integer[]> newList = new LinkedList<Integer[]>();
            newList.addAll(currList);
            newList.add(node);
            queue.add(newList);
         }

         tempR = currNode[0];
         tempC = currNode[1] + 1;
         if (tempC < c && !visited[tempR][tempC] && cGrid[tempR][tempC] != '%') {
            Integer node[] = {tempR, tempC};
            LinkedList<Integer[]> newList = new LinkedList<Integer[]>();
            newList.addAll(currList);
            newList.add(node);
            queue.add(newList);
         }

         tempR = currNode[0] - 1;
         tempC = currNode[1];
         if (tempR >= 0 && !visited[tempR][tempC] && cGrid[tempR][tempC] != '%') {
            Integer node[] = {tempR, tempC};
            LinkedList<Integer[]> newList = new LinkedList<Integer[]>();
            newList.addAll(currList);
            newList.add(node);
            queue.add(newList);
         }
      }

      // print
      System.out.println(returnList.size());
   }

   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);


      int pacman_r = in.nextInt();
      int pacman_c = in.nextInt();

      int food_r = in.nextInt();
      int food_c = in.nextInt();

      int r = in.nextInt();
      int c = in.nextInt();

      String grid[] = new String[r];

      for (int i = 0; i < r; i++) {
         grid[i] = in.next();
      }

      dfs(r, c, pacman_r, pacman_c, food_r, food_c, grid);
   }
}
