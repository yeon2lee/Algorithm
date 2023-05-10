import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N];
		long[] C = new long[M];
		long answer = 0;
		
		// 수열 합 배열 만들기
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		// 합 배열의 모든 값에 % 연산 수행
		for (int i = 0; i < N; i++) { 
			int remainder = (int) (S[i] % M);
			// 0~i까지의 구간 합 자체가 0일 때 정답에 더하기
			if (remainder == 0) {
				answer++;
			}
			// 나머지가 같은 인덱스의 개수 카운팅
			C[remainder]++;
		}
		
		// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
		for (int i = 0; i < M; i++) {
			if (C[i] > 1) {
				answer += (C[i] * (C[i] - 1) / 2);
			}
		}
		
		System.out.println(answer);
	}

}
