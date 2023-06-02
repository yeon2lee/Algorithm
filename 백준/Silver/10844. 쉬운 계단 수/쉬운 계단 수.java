import java.io.*;

public class Main {
	static int mod = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] D = new int[N + 1][10];
		for (int i = 1; i <= 9; i++) {
			D[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					D[i][j] = D[i - 1][j + 1] % mod;
				} else if (j == 9) {
					D[i][j] = D[i - 1][j - 1] % mod;
				} else {
					D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + D[N][i]) % mod;
		}
		System.out.println(result);
	}

}
