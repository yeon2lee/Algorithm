import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 재료의 개수
		int M = Integer.parseInt(br.readLine()); // 갑옷이 완성되는 번호의 합
		int[] A = new int[N];
		// 재료들 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(A);
		
		// 갑옷을 만들 수 있는 개수 찾기
		int i = 0;
		int j = N - 1;
		int count = 0;
		while (i < j) {
			int sum = A[i] + A[j];
			if (sum == M) { // 번호의 합이 M과 같을 떄
				count++;
				i++;
			} else if (sum > M) { // 번호의 합이 M보다 클 때
				j--;
			} else { // sum < M, 번호의 합이 M보다 작을 때
				i++;
			}
		}
		System.out.println(count);
	}

}
