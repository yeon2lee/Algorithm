import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		radixSort(A, 5);
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}

	// 기수 정렬 함수 구현하기
	public static void radixSort(int[] A, int maxSize) {
		int[] output = new int[A.length];
		int digit = 1;
		int count = 0;
		while (count != maxSize) { // 최대 자리수 만큼 반복
			int[] bucket = new int[10];
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / digit) % 10]++; // 일의 자리 부터 시작
			}
			for (int i = 1; i < 10; i++) { // 합배열을 이용하여 index 계산
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) { // 현재 자리수 기준으로 정렬하기
				output[bucket[(A[i] / digit % 10)] - 1] = A[i];
				bucket[(A[i] / digit) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {
				A[i] = output[i]; // 다음 자리 수 이동을 위해 현재 자리수 기준 정렬 데이터 저장
			}
			digit = digit * 10; // 자리수 증가
			count++;
		}
	}
}
