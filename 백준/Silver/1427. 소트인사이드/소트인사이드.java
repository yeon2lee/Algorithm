import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		int N = tmp.length;
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = tmp[i] - '0';
		}
		
		// 선택 정렬
		for (int i = 0; i < N; i++) {
			// 최댓값 찾기
			int maxIndex = i;
			for (int j = i + 1; j < N; j++) {
				if (A[j] > A[maxIndex]) {
					maxIndex = j;
				}
			}
			// swap
			int temp = A[i];
			A[i] = A[maxIndex];
			A[maxIndex] = temp;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(A[i]);
		}
		System.out.println();
	}

}
