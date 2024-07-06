import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int data[] = new int[i + 1];
            // 데이터를 입력받아 저장한다.
            for (int j = 1; j <= i; j++) {
                data[j] = Integer.parseInt(st.nextToken());
            }
            // 마지막 인덱스부터 비교하여 값을 저장한다.
            for (int j = i; j > 0; j--) {                
                dp[j] = Math.max(dp[j], dp[j - 1]) + data[j];                
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}