import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//수열의 길이 N, 구하고자 하는 합 S, 수열 A 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//연속된 수들의 부분합이 S이상이 되는 것 중 가장 짧은 것의 길이 구하기
		int i = 0; 
		int j = 0;
		int sum = A[i];
		int length = 1;
		int min = Integer.MAX_VALUE;
		boolean flag = false;
		while (j != N) {
			if (sum >= S) {
				flag = true;
				if (length < min) {
					min = length;
				}
				
				sum -= A[i];
				i++;
				length--;
			} else { //sum < S
				j++;
				if (j == N) {
					break;
				}
				sum += A[j];
				length++;
			}
		}
		
		if (flag) {
			System.out.println(min);
		} else {
			System.out.println("0");
		}
	}

}
