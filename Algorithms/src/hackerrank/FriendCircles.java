package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FriendCircles {
   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      int n;
      n = in.nextInt();
      in.useDelimiter("\n");
      String grid[] = new String[n];

      for (int i = 0; i < n; i++) {
         grid[i] = in.next();
      }

      int trees = 0;
      boolean used[] = new boolean[n];
      for (int i = 0; i < n; i++) {
         if (!used[i]) {
            trees++;
            Queue<Integer> nodeList = new LinkedList<Integer>();
            nodeList.add(i);
            while (!nodeList.isEmpty()) {
               int curr = nodeList.poll();
               if (used[curr])
                  continue;
               used[curr] = true;
               char connections[] = grid[curr].toCharArray();
               for (int j = 0; j < n; j++) {
                  if (connections[j] == 'x' && !used[j])
                     nodeList.add(j);
               }
            }
         }
      }
      System.out.println(trees);
   }
}
