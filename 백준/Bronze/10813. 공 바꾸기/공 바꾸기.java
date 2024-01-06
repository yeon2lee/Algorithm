import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N + 1];
		for (int x = 1; x <= N; x++) {
			A[x] = x;
		}
		
		for (int x = 0 ; x < M; x++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
		}
				
		for (int i = 1; i <= N; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
