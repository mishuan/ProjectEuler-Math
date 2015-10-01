package hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
public class BreadthFirstSearchShortest {
  public static final boolean TEST = false;
  public static int T;
  public static int N;
  public static int A;

  public static void run(Scanner in) {
    T = in.nextInt();
    for (int t = 0; t < T; t++) {
      in.nextLine();
      N = in.nextInt();
      A = in.nextInt();
      boolean[][] matrix = new boolean[N][N];
      for (int i = 0; i < A; i++) {
        in.nextLine();
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        matrix[x][y] = true;
        matrix[y][x] = true;
      }
      in.nextLine();
      int node = in.nextInt() - 1;
      bfs(matrix, node);
    }
  }

  private static void bfs(boolean[][] matrix, int node) {
    Queue<Integer> q = new LinkedList<>();
    int len = matrix.length;
    int[] height = new int[len];
    q.add(node);

    while (!q.isEmpty()) {
      int curr = q.poll();
      for (int i = 0; i < len; i++) {
        if (matrix[curr][i] && height[i] == 0) {
          height[i] = height[curr] + 1;
          q.add(i);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      if (i == node) continue;
      else if (height[i] == 0) sb.append("-1 ");
      else sb.append(height[i] * 6).append(' ');
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args) {
    if (!TEST) {
      Scanner in = new Scanner(System.in);
      run(in);
      in.close();
    } else {
    }
  }
}
