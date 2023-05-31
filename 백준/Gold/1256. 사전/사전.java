import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] D;
	static int MAX = 1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[202][202];
		// 조합 테이블 초기화
		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					D[i][j] = 1;
				} else {
					D[i][j] = D[i - 1][j - 1] + D[i - 1][j];
					if (D[i][j] > MAX) {
						D[i][j] = MAX + 1; // K 범위가 넘어가면 범위의 최댓값 저장하기
					}
				}
			}
		}
		
		if (D[N + M][M] < K) { // 주어진 자릿수로 만들 수 없는 K번째 수이면
			System.out.println("-1");
		} else {
			while (!(N == 0 && M == 0)) {
				// a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K보다 크면
				if (D[N - 1 + M][M] >= K) {
					System.out.print("a");
					N--;
				} else { // 모든 경우의 수가 K보다 작으면
					System.out.print("z");
					K -= D[N - 1 + M][M]; // K값 업데이트
					M--;
				}
			}
		}
		
	}

}
