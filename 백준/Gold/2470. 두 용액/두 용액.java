import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//전체 용액의 수 N, 용액의 특성값을 나타내는 N개의 정수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값 구하기
		Arrays.sort(A);
		int i = 0;
		int j = N - 1;
		int min = Integer.MAX_VALUE;
		int value1 = A[i];
		int value2 = A[j];
		while (i < j) {
			//특성값이 0에 가장 가까운 용액 찾기
			int sum = Math.abs(A[i] + A[j]);
			if (sum < min) {
				min = sum;
				value1 = A[i];
				value2 = A[j];
			} 

			if (A[i] + A[j] < 0) {
				i++;
			} else if (A[i] + A[j] > 0){
				j--;
			} else { //A[i] + A[j] == 0
				break;
			}
		}
		
		System.out.println(value1 + " " + value2);
	}

}
