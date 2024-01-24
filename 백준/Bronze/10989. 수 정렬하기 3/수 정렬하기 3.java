import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
	
		//기수정렬
		radixSort(A, 5);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(A[i] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void radixSort(int[] A, int maxSize) {
		int[] output = new int[A.length];
		int digit = 1; //자릿수
		int count = 0;
		while (count != maxSize) { //최대 자릿수만큼 반복하기
			int[] bucket = new int[10]; //현재 자릿수들의 분포를 합 배열의 형태로 알려주는 배열
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / digit) % 10]++; //일의 자리부터 시작하기
			}
			for (int i = 1; i < 10; i++) { //합 배열을 이용해 index 계산하기
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length - 1; i >= 0; i--) { //현재 자릿수를 기준으로 정렬하기
				output[bucket[(A[i] / digit) % 10] - 1] = A[i];
				bucket[(A[i] / digit) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {
				//다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장하기
				A[i] = output[i];
			}
			digit *= 10; //자릿수 증가시키기
			count++;
		}
	}

}
