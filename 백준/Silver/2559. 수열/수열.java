import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		// 누적 합 배열 만들기
		st = new StringTokenizer(br.readLine());
		long[] S = new long[N + 1];
		for (int i = 1; i < N + 1; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		// 연속적인 K일의 온도의 합이 최대가 되는 값 찾기
		long max = S[K];
		for (int i = K; i < N + 1; i++) {
			long tmp = S[i] - S[i - K]; // 연속적인 K일 동안의 온도의 합
			if (tmp > max) {
				max = tmp;
			}
		}
		
		System.out.println(max);
	}

}
