import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//수의 개수 N, 수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//정렬 후, 좋은 수 찾기
		Arrays.sort(A);
		int count = 0;
		for (int k = 0; k < N; k++) {
			int i = 0;
			int j = N - 1;
			while (i < j) {
				//두 수의 합이 find가 되는지 찾음
				long find = A[k];
				long sum = A[i] + A[j];
				if (sum == find) {
					if (i != k && j != k) {
						count++;
						break;
					} else if (i == k) {
						i++;
					} else { //endIndex == k
						j--;
					}
				} else if (sum < find) {
					i++;
				} else { // sum > find
					j--;
				}
			}
		}
		
		System.out.println(count);
	}

}
