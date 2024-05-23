import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 30;
	static int[][] D;
	public static void main(String[] args) throws IOException {
		D = new int[MAX + 1][MAX + 1];
		for (int i = 0; i <= MAX; i++) {
			D[i][0] = 1;
			D[i][i] = 1;
		}
		
		for (int i = 2; i <= MAX; i++) {
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
			}
		}
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			System.out.println(D[M][N]);
		}
	}
}
