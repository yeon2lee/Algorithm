import java.util.*;

class Solution {
    static int[][] A;
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        A = new int[n + 1][n + 1];
        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            A[start][end] = 1;
            A[end][start] = 1;
        }    
        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            A[start][end] = 0;
            A[end][start] = 0;
            
            answer = Math.min(answer, bfs(n, start));
            A[start][end] = 1;
            A[end][start] = 1;
        }
        
        return answer;
    }
    
    public static int bfs(int n, int node) {
        boolean[] visited = new boolean[n + 1];
        int depth = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (A[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    depth++;
                }
            }
        }
        
        return (int) Math.abs(depth - (n - depth));
    }
}