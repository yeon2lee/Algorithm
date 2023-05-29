import java.io.*;

public class Main {
	static int MAX = 1000000;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[MAX + 1];
		dp[1] = 0;
		for (int i = 2; i <= MAX; i++) {
			dp[i] = dp[i - 1] + 1; // -1 연산 표현
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 나누기 3 연산
			} 
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 나누기 2 연산
			} 
		}
		System.out.println(dp[N]);
	}

}
