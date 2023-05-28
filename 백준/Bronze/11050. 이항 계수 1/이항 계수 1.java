import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		D = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			D[i][1] = i;
			D[i][0] = 1;
			D[i][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i - 1][j] + D[i - 1][j - 1]; // 조합 기본 점화식
			}
		}
		System.out.println(D[N][K]);
	}
	
}
