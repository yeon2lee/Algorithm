import java.util.*;

class Solution {

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] str = {"d", "l", "r", "u"};

    static String answer = "impossible";
    static boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";
        
        dfs(n, m, x, y, r, c, k, 0, "");
        return answer;
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, int depth, String path) {
        if (found) {
            return;
        }

        int dist = Math.abs(x - r) + Math.abs(y - c);
        int remain = k - depth;
        if (dist > remain || (remain - dist) % 2 != 0) return;
        
        if (depth == k) {
            if (x == r && y == c) {
                answer = path;
                found = true;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m) {
                dfs(n, m, nx, ny, r, c, k, depth + 1, path + str[d]);
                if (found) {
                    return; 
                }
            }
        }
    }
}
