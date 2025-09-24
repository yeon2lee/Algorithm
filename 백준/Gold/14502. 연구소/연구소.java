import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] A;
    static List<int[]> empty;
    static List<int[]> virus;
    static int zeroCount = 0;
    static int max = 0;
    
    public static void main(String[] args) throws IOException {

        // 필요한 값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 빈 칸과 바이러스 인덱스 저장
        empty = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    empty.add(new int[] {i, j});
                    zeroCount++;
                } else if (A[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        chooseWall(0, 0);
        System.out.println(max);
    }

    private static void chooseWall(int start, int picked) {
        if (picked == 3) {
            max = Math.max(max, bfs());
            return;
        }
        
        for (int i = start; i < empty.size(); i++) {
            int r = empty.get(i)[0];
            int c = empty.get(i)[1];
            A[r][c] = 1;
            chooseWall(i + 1, picked + 1);
            A[r][c] = 0;
        }
    }
    
    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int[] v : virus) {
            queue.add(new int[]{v[0], v[1]});
            visited[v[0]][v[1]] = true;
        }

        int count = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!visited[nr][nc] && A[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        count++;
                        queue.add(new int[]{nr, nc});

                        if (zeroCount - 3 - count <= max) {
                            return 0;
                        }
                    }
                }
            }
        }

        return zeroCount - 3 - count;
    }
}
