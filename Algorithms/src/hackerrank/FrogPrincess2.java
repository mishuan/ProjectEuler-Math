package hackerrank;

import java.util.Scanner;

public class FrogPrincess2 {
   static void nextMove(int n, int r, int c, String[] grid) {
      for (int i = 0; i < n; i++) {
         int pos = grid[i].indexOf('p');
         if (pos >= 0) {
            int x = c - pos;
            int y = r - i;
            String output = "";
            if (Math.abs(x) > Math.abs(y)) {
               if (x < 0)
                  output = "RIGHT";
               else
                  output = "LEFT";
            } else {
               if (y < 0)
                  output = "DOWN";
               else
                  output = "UP";
            }
            System.out.println(output);
            break;
         }
      }
   }

   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner in = new Scanner(System.in);
      int n, r, c;
      n = in.nextInt();
      r = in.nextInt();
      c = in.nextInt();
      in.useDelimiter("\n");
      String grid[] = new String[n];

      for (int i = 0; i < n; i++) {
         grid[i] = in.next();
      }

      nextMove(n, r, c, grid);

   }
}
