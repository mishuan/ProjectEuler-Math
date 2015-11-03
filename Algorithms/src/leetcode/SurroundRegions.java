package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundRegions {
  public void solve(char[][] board) {
    if (board.length == 0) return;
    int r = board.length - 1;
    int c = board[0].length - 1;
    for (int i = 0; i <= c; i++) {
      if (board[0][i] == 'O') bfs(board, 0, i);
      if (board[r][i] == 'O') bfs(board, r, i);
    }
    for (int i = 1; i < r; i++) {
      if (board[i][0] == 'O') bfs(board, i, 0);
      if (board[i][c] == 'O') bfs(board, i, c);
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] == 'T') board[i][j] = 'O';
        else board[i][j] = 'X';
    }
  }

  public void recurse(char[][] board, int r, int c) {
    board[r][c] = 'T';
    if (r + 1 < board.length && board[r + 1][c] == 'O') bfs(board, r + 1, c);
    if (r - 1 >= 0 && board[r - 1][c] == 'O') recurse(board, r - 1, c);
    if (c + 1 < board[0].length && board[r][c + 1] == 'O') bfs(board, r, c + 1);
    if (c - 1 >= 0 && board[r][c - 1] == 'O') bfs(board, r, c - 1);
  }

  public void bfs(char[][] board, int i, int j) {
    Queue<Integer> queue = new LinkedList<>();
    int nc = board[0].length;
    board[i][j] = 'T';
    queue.offer(i * nc + j);
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      int r = curr / nc;
      int c = curr % nc;
      int idx = r + 1;
      if (idx < board.length && board[idx][c] == 'O') {
        board[idx][c] = 'T';
        queue.offer(nc * idx + c);
      }
      idx = r - 1;
      if (idx >= 0 && board[idx][c] == 'O') {
        board[idx][c] = 'T';
        queue.offer(nc * idx + c);
      }
      idx = c + 1;
      if (idx < board[0].length && board[r][idx] == 'O') {
        board[r][idx] = 'T';
        queue.offer(nc * r + idx);
      }
      idx = c - 1;
      if (idx >= 0 && board[r][idx] == 'O') {
        board[r][idx] = 'T';
        queue.offer(nc * r + idx);
      }
    }
  }
}
