package connectfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter board dimensions in the form MxN: ");
      String[] dim = br.readLine().split("x");
      System.out.println("Enter player one's name: ");
      String p1 = br.readLine();
      System.out.println("Enter player two's name: ");
      String p2 = br.readLine();

      BoardManager bm = new BoardManager(Integer.valueOf(dim[0]), Integer.valueOf(dim[1]), p1, p2);

      int id = 0;
      String currPlayer;
      while (!bm.isFinished()) {
         if (id == 0)
            currPlayer = p1;
         else
            currPlayer = p2;
         System.out.println(currPlayer + ", enter placement: ");
         String result = bm.makeMove(currPlayer, br.readLine());
         if (result.equals("Successfully placed"))
            id = (id + 1) % 2;

         char[][] currBoard = bm.getBoard();
         StringBuffer sb = new StringBuffer();
         for (char[] cArray : currBoard) {
            for (char c : cArray)
               sb.append(c).append(' ');
            sb.append('\n');
         }
         System.out.println(sb.toString());
         System.out.println(result);
      }
   }
}
