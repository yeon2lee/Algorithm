import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 정렬
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			// 이진 탐색
			int target = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = N - 1;
			boolean find = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (A[mid] == target) {
					find = true;
					break;
				} else if (A[mid] > target) {
					end = mid - 1;
				} else { // A[mid] < target
					start = mid + 1;
				}
			}
			
			if (find) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

	}

}
