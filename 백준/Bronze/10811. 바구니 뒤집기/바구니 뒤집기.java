import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] basket;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); 
		basket = new int[N + 1];
		for (int k = 1; k <= N; k++) {
			basket[k] = k;
		}
		
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());	
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			reverse(i, j);
		}
		
		for (int k = 1; k <= N; k++) {
			System.out.print(basket[k] + " ");
		}
	}
	
	public static void reverse(int i, int j) {
		for (int k = 0; k < (j - i) / 2 + 1; k++) {
			int tmp = basket[i + k];
			basket[i + k] = basket[j - k];
			basket[j - k] = tmp;
		}
	}

}
