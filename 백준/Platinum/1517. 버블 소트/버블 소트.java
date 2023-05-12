import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;
		mergeSort(A, 0, N - 1);
		System.out.println(result);
		for (int i = 0; i < N; i++) {
		//	System.out.println(A[i]);
		}
	}

	public static void mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int index = 0;
		int[] tmp = new int[r - p + 1];
		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[index++] = A[i++];
			} else {
				tmp[index++] = A[j++];
				result += (j - p - index);
			}
		}

		while (i <= q) {
			tmp[index++] = A[i++];
		}

		while (j <= r) {
			tmp[index++] = A[j++];
		}

		index = 0;
		for (i = p; i <= r; i++) {
			A[i] = tmp[index++];
		}
	}
}
