import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
			}
		}
		
		// 정사각형 크기 구하기
		int max = 0;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max * max);
	}

}
