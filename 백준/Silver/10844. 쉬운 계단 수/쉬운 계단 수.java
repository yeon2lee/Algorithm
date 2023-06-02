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
			D[i][0] = D[i - 1][1];
			D[i][9] = D[i - 1][8];
			
			for (int j = 1; j <= 8; j++) {
				D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
			}
		}
		
		long result = 0;
		for (int i = 0; i <= 9; i++) {
			result = (result + D[N][i]) % mod;
		}
		System.out.println(result);
	}

}
