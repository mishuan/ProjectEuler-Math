package hackerrank;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CountLuck {

   public static class Grid {
      public char[][] grid;
      public int waves;
      public int x;
      public int y;
      public int destX;
      public int destY;

      public Grid(char[][] grid, int waves) {
         this.grid = grid;
         this.waves = waves;
         getHermionePos();
      }

      public void getHermionePos() {
         for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == 'M') {
                  y = j;
                  x = i;
               }
               if (grid[i][j] == '*') {
                  destY = j;
                  destX = i;
               }
            }
         }
      }
   }

   static class IntComparator implements Comparator<int[]> {
      @Override
      public int compare(int[] x, int[] y) {
         if (x[4] < y[4]) {
            return -1;
         }
         if (x[4] > y[4]) {
            return 1;
         }
         return 0;
      }
   }

   public static String aStarSearch(Grid grid) {
      int waveCount = 0;
      char[][] map = grid.grid;
      int m = map.length;
      int n = map[0].length;
      boolean pathFound = false;
      boolean[][] visited = new boolean[m][n];
      PriorityQueue<int[]> queue = new PriorityQueue<int[]>(10, new IntComparator());
      int[] initPos = {grid.x, grid.y, 0, 0, 0};
      queue.add(initPos);

      while (!queue.isEmpty()) {
         int[] curr = queue.poll();
         if (visited[curr[0]][curr[1]])
            continue;
         if (map[curr[0]][curr[1]] == '*') {
            pathFound = true;
            waveCount = curr[3];
            break;
         }
         visited[curr[0]][curr[1]] = true;

         // magic
         int edges = 0;
         LinkedList<int[]> nextNode = new LinkedList<int[]>();
         int distance = curr[2] + 1;

         int temp = curr[1] + 1;
         if ( curr[1] < n - 1 && !visited[curr[0]][temp] &&map[curr[0]][temp] != 'X') {
            int[] node =
                  {curr[0], temp, distance, 0, distance + Math.abs(temp - grid.destY) + Math.abs(curr[0] - grid.destX)};
            nextNode.add(node);
            edges++;
         }

         temp = curr[1] - 1;
         if (curr[1] > 0 && !visited[curr[0]][temp] && map[curr[0]][temp] != 'X') {
            int[] node =
                  {curr[0], temp, distance, 0, distance + Math.abs(temp - grid.destY) + Math.abs(curr[0] - grid.destX)};
            nextNode.add(node);
            edges++;
         }

         temp = curr[0] + 1;
         if (curr[0] < m - 1 && !visited[temp][curr[1]] && map[curr[0] + 1][curr[1]] != 'X') {
            int[] node =
                  {temp, curr[1], distance, 0, distance + Math.abs(temp - grid.destY) + Math.abs(curr[0] - grid.destX)};
            nextNode.add(node);
            edges++;
         }

         temp = curr[0] - 1;
         if (curr[0] > 0 &&!visited[temp][curr[1]] &&  map[curr[0] - 1][curr[1]] != 'X') {
            int[] node =
                  {temp, curr[1], distance, 0, distance + Math.abs(temp - grid.destY) + Math.abs(curr[0] - grid.destX)};
            nextNode.add(node);
            edges++;
         }
         int numWaves = curr[3];
         if (edges > 1)
            numWaves++;
         for (int[] array : nextNode) {
            array[3] = numWaves;
            queue.add(array);
         }
      }

      if (pathFound && waveCount == grid.waves)
         return "Impressed";
      return "Oops!";
   }

   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      int problems = in.nextInt();
      Grid[] problemGrids = new Grid[problems];
      for (int i = 0; i < problems; i++) {
         String params = in.next();
         in.next();
         int rows = Integer.valueOf(params);
         char[][] grid = new char[rows][];
         for (int j = 0; j < rows; j++) {
            grid[j] = in.next().toCharArray();
         }
         int waves = in.nextInt();
         problemGrids[i] = new Grid(grid, waves);
      }
      for (Grid g : problemGrids)
         System.out.println(aStarSearch(g));
   }
}
