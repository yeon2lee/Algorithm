import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N]; // 정렬할 배열
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(A, 0, N - 1); // 병합 정렬 수행
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	public static void mergeSort(int[] A, int p, int r) {
		int q;
		if (p < r) {
			q = (p + r) / 2;
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
			if (A[i] < A[j]) {
				tmp[index++] = A[i++];
			} else {
				tmp[index++] = A[j++];
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
