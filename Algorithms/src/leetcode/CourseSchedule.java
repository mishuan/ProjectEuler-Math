package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] e = new List[numCourses];
    for (int i = 0; i < numCourses; i++) e[i] = new ArrayList<Integer>();
    int[] in = new int[numCourses];
    for (int[] edge : prerequisites) {
      in[edge[0]]++;
      e[edge[1]].add(edge[0]);
    }
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++)
      if (in[i] == 0) q.offer(i);
    int count = 0;
    while (!q.isEmpty()) {
      int curr = q.poll();
      count++;
      for (int i : e[curr]) {
        in[i]--;
        if(in[i] == 0) q.offer(i);
      }
    }
    return count == numCourses;
  }
}
