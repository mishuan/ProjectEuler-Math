package connectfour;

import java.util.Arrays;

public class BoardManager {
   private char[][] board;
   private int[] pieceCount;
   private int m;
   private int n;
   private String p1;
   private String p2;
   private int whosTurn = 0;
   private boolean finished = false;

   public BoardManager(int m, int n, String p1, String p2) {
      board = new char[m][n];
      pieceCount = new int[n];
      this.m = m;
      this.n = n;
      this.p1 = p1;
      this.p2 = p2;
      for (char[] c : board)
         Arrays.fill(c, '_');
   }

   public boolean isFinished() {
      return finished;
   }

   public char[][] getBoard() {
      return board;
   }

   private boolean checkWinState(int M, int N, char piece) {
      finished = true;
      // horizontals
      int winCounter = 0;
      int init = Math.max(N - 3, 0);
      for (int i = 0; i < 7; i++) {
         int currN = init + i;
         if (currN == n)
            break;
         if (board[M][currN] == piece) {
            if (winCounter == 3)
               return true;
            winCounter++;
         } else
            winCounter = 0;
      }

      // verticals
      winCounter = 0;
      init = Math.max(pieceCount[N] - 3, 0);
      for (int i = 0; i < 7; i++) {
         int currM = init + i;
         if (currM == m)
            break;
         if (board[currM][N] == piece) {
            if (winCounter == 3)
               return true;
            winCounter++;
         } else
            winCounter = 0;
      }

      // diagonals are annoying, im lazy, no that many operations anyways, so lets brute force
      for (int i = 0; i < m - 3; i++) {
         for (int j = 0; j < n; j++) {
            if (board[i][j] != piece)
               continue;

            // left to right
            if (j < n - 3) {
               if (board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                  return true;
            }
            // right to left
            if (j > 2) {
               if (board[i + 1][j - 1] == piece && board[i + 2][j - 2] == piece && board[i + 3][j - 3] == piece)
                  return true;
            }
         }
      }

      finished = false;
      return false;
   }

   private boolean checkTie() {
      for (int i : pieceCount) {
         if (i != m)
            return false;
      }
      finished = true;
      return true;
   }

   public String makeMove(String player, String cmd) {
      if (cmd.equals("forfeit")) {
         finished = true;
         return player + " has forfeited.";
      } else
         return placePiece(player, Integer.valueOf(cmd));
   }

   private String placePiece(String player, int n) {
      if (this.n - 1 < n || n < 0)
         return "Invalid column number";
      char piece;
      if (player.equals(p1)) {
         if (whosTurn == 0)
            piece = 'o';
         else
            return "Wrong player's turn";
      } else if (player.equals(p2)) {
         if (whosTurn == 1)
            piece = 'x';
         else
            return "Wrong player's turn";
      } else
         return "Invalid player ID";
      int count = pieceCount[n];
      if (count == m)
         return "This column selected is full";

      int M = m - 1 - count;
      board[M][n] = piece;
      pieceCount[n]++;

      if (checkWinState(M, n, piece))
         return player + " has won";

      if (checkTie())
         return "Tied game";

      whosTurn = (whosTurn + 1) % 2;

      return "Successfully placed";
   }
}
