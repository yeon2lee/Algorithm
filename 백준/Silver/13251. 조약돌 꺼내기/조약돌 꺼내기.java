import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 50 * 50;
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
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int size = 0;// 조약돌의 전체 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			size += A[i];
		}
		int K = Integer.parseInt(br.readLine());
		
		double answer = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] >= K) {
				double probability = 1;
				for (int k = 0; k < K; k++) {
					probability *= (double) (A[i] - k) / (size - k);
				}
				answer += probability;
			}
		}
		System.out.println(answer);
	}

}
