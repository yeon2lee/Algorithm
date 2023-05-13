import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] > start) { 
				start = A[i]; // 레슨 최댓값을 시작 인덱스로 지정
			}
			end += A[i]; // 모든 레슨의 총합을 종료 인덱스로 저장
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) { // mid값으로 모든 레슨을 저장할 수 있는지 확인
				if (sum + A[i] > mid) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			
			if (sum != 0) {
				count++;
			}
			
			if (count > M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(start);
	}

}
