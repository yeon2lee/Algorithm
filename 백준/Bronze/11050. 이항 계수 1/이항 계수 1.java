import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(f(N, K));
	}
	
	public static int f(int n, int k) {
		if (n == k || k == 0) {
			return 1;
		}
		return f(n - 1, k - 1) + f(n - 1, k);
	}

}
