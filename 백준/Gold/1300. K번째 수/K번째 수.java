import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		long start = 1;
		long end = K;
		long answer = 0;
		// 이진 탐색 수행
		while (start <= end) {
			long middle = (start + end) / 2;
			long count = 0;
			// 중앙값보다 작은 수는 몇 개인지 계산
			for (int i = 1; i <= N; i++) {
				count += Math.min(middle / i, N); 
			}
			
			if (count < K) {
				start = middle + 1;
			} else {
				answer = middle; // 현재 단계의 중앙값을 정답 변수에 저장
				end = middle - 1;
			}
		}
		System.out.println(answer);
	}

}
