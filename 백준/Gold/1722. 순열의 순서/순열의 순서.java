import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 20;

	public static void main(String[] args) throws IOException {
		long[] F = new long[MAX + 1]; // 각 자리별로 만들 수 있는 경우의 수 저장
		int[] S = new int[MAX + 1]; // 순열을 담는 배열
		boolean visited[] = new boolean[MAX + 1]; // 숫자 사용 유무 저장 배열

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 순열의 길이
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken()); // 문제의 종류

		// 팩토리얼 초기화 -> 각 자릿수에서 만들 수 있는 경우의 수
		F[0] = 1;
		for (int i = 1; i <= N; i++) {
			F[i] = F[i - 1] * i;
		}

		if (Q == 1) { // K번째 순열 출력
			long K = Long.parseLong(st.nextToken()); // 몇 번째 순열을 출력할지 입력받음
			for (int i = 1; i <= N; i++) {
				int count = 1; // 해당 자리에서 몇 번째 숫자를 사용해야 할지를 정하는 변수
				for (int j = 1; j <= N; j++) {
					if (!visited[j]) { // 이미 사용한 숫자는 사용할 수 없음
						// 주어진 K에 따라 각 자리에 들어갈 수 있는 수 찾기
						if (K <= count * F[N - i]) {
							K -= ((count - 1) * F[N - i]);
							S[i] = j;
							visited[j] = true;
							break;
						}
						count++;
					}
				}
			}
			for (int i = 1; i <= N; i++) {
				System.out.print(S[i] + " ");
			}
		} else { // Q == 2 (입력된 순열의 순서 구하기)
			long K = 1;
			for (int i = 1; i <= N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
				long count = 0;
				for (int j = 1; j < S[i]; j++) {
					if (visited[j] == false) {
						count++; // 미사용 숫자 개수만큼 카운트
					}
				}
				K += count * F[N - i]; // 자릿수에 따라 순서 더하기
				visited[S[i]] = true;
			}
			System.out.println(K);
		}

	}

}
