package hackerrank;

import java.util.Scanner;

public class FrogPrincess {
   static void displayPathtoPrincess(int n, String[] grid) {
      int botPos[] = null;
      int princessPos[] = null;
      for (int i = 0; i < n; i++) {
         int botY = grid[i].indexOf('m');
         int princessY = grid[i].indexOf('p');
         if (botY > -1) {
            botPos = new int[2];
            botPos[0] = i;
            botPos[1] = botY;
         }
         if (princessY > -1) {
            princessPos = new int[2];
            princessPos[0] = i;
            princessPos[1] = princessY;
         }
         if (botPos != null && princessPos != null)
            break;
      }
      String xDir;
      String yDir;
      int xDisp = botPos[1] - princessPos[1];
      int yDisp = botPos[0] - princessPos[0];

      if (xDisp > 0) {
         xDir = "LEFT";
      } else {
         xDir = "RIGHT";
      }

      if (yDisp > 0) {
         yDir = "UP";
      } else {
         yDir = "DOWN";
      }
      String output = "";
      for (int i = 0; i < Math.abs(xDisp); i++) {
         output += xDir + "\n";
      }
      for (int i = 0; i < Math.abs(yDisp); i++) {
         output += yDir + "\n";
      }
      System.out.println(output);
   }

   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      int m;
      m = in.nextInt();
      String grid[] = new String[m];
      for (int i = 0; i < m; i++) {
         grid[i] = in.next();
      }

      displayPathtoPrincess(m, grid);
   }
}
