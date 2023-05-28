import java.io.*;

public class Main {
	static int[][] dp;
	static int MAX = 14;
	public static void main(String[] args) throws IOException {
		dp = new int[MAX + 1][MAX + 1];
		for (int i = 1; i <= MAX; i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}
		
		for (int i = 1; i <= MAX; i++) {
			for (int j = 2; j <= MAX; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[K][N]);
		}	
	}
}
