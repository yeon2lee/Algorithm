import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 삽입 정렬 구현
		for (int i = 0; i < N; i++) {
			int index = i;
			for (int j = i - 1; j >= 0; j--) {
				if (A[i] < A[j]) {
					index = j;
				} else {
					break;
				}
			}
			// shift
			int tmp = A[i];
			for (int j = i; j > index; j--) {
				A[j] = A[j - 1];
			}
			A[index] = tmp;
		}

		// 각 사람이 인출하는 데 필요한 시간의 합
		// 합 배열 만들기
		int[] S = new int[N];
		S[0] = A[0];
		for (int i = 1; i < N; i++) {
			S[i] = S[i - 1] + A[i];
		}
		
		// 합 배열 총합 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += S[i];
		}
		System.out.println(sum);
	}

}
