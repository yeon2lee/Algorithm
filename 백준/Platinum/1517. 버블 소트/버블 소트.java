import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] A, tmp;
	static long count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		count = 0;
		mergeSort(0, N - 1);
		System.out.println(count);
	}
	private static void mergeSort(int s, int e) {
		if (e - s <= 0) {
			return;
		}
		int m = s + (e - s) / 2;
		mergeSort(s, m);
		mergeSort(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m + 1;
		while (index1 <= m && index2 <= e) {
			if (tmp[index1] <= tmp[index2]) {
				A[k++] = tmp[index1++];
			} else {
				count += index2 - k; //뒤쪽 데이터 값이 작은 경우 count 업데이트
				A[k++] = tmp[index2++];
			}
		}
		
		while (index1 <= m) {
			A[k++] = tmp[index1++];
		}
		while (index2 <= e) {
			A[k++] = tmp[index2++];
		}
	}

}
