import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		//수열의 크기 N, 수열에 포함되는 수, 수열의 합 X 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int X = Integer.parseInt(br.readLine());
		Arrays.sort(A); //투 포인터를 활용하기 위해 수열 정렬
		
		//A[i] + A[j] = X를 만족하는 쌍의 수 구하기 
		int i = 0;
		int j = N - 1; 
		int count = 0;
		while (i < j) {
			if (A[i] + A[j] < X) {
				i++;
			} else if (A[i] + A[j] > X) {
				j--;
			} else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
	}

}
