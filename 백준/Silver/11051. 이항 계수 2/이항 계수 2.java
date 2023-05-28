import java.util.Scanner;

public class Main {
	static long[][] dp;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		dp = new long[n + 1][k + 1];
		System.out.println(f(n, k));
	}
	
	public static long f(int n, int k) {
		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		
		if(n == k || k == 0) {
			return dp[n][k] = 1;
		}
 
		return dp[n][k] = (f(n - 1, k - 1) + f(n - 1, k)) % 10007; 
	}

}
