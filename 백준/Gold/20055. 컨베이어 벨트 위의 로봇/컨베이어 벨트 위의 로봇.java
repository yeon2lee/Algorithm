import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] robot = new boolean[N * 2];

        int step = 0;
        int count = 0;
        int up = 0;
        int down = N - 1;
        while (count < K) {
            //컨베이어 벨트 회전
            up--;
            down--;
            if (up == -1) {
                up = N * 2 - 1;
            }
            if (down == -1) {
                down = N * 2 - 1;
            }

            //로봇 이동
            robot[down] = false; //로봇 내리기
            int now = down;
            int before = down - 1;
            if (before == -1) {
                before = N * 2 - 1;
            }
            while (now != up) {
                if (robot[before] && !robot[now] && A[now] != 0) {
                    robot[before] = false;
                    robot[now] = true;
                    if (now == down) { //로봇이 내리는 위치에 도달했을 때
                        robot[now] = false;
                    }
                    A[now]--;
                    if (A[now] == 0) {
                        count++;
                    }
                }
                now--;
                before--;
                if (now == -1) {
                    now = N * 2 - 1;
                }
                if (before == -1) {
                    before = N * 2 - 1;
                }
            }

            //로봇 올리기
            if (!robot[up] && A[up] != 0) {
                robot[up] = true;
                A[up]--;
                if (A[up] == 0) {
                    count++;
                }
            }

            step++;
        }

        System.out.println(step);
    }

}