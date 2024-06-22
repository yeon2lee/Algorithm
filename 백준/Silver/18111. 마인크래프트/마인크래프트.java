import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] ground = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(ground[i][j], min);
                max = Math.max(ground[i][j], max);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int k = min; k <= max; k++) {
            int block = B;
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] < k) {
                        count += k - ground[i][j];
                        block -= k - ground[i][j];
                    } else if (ground[i][j] > k) {
                        count += 2 * (ground[i][j] - k);
                        block += ground[i][j] - k;
                    }
                }
            }
            if (block < 0) {
                break;
            }
            
            time = Math.min(time, count);
            if (time == count) {
                height = k;
            }
        }

        System.out.println(time + " " + height);
    }
}