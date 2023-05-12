import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	
	public static void DFS(int num, int digit) {
		if (digit == N) {
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i < 10; i += 2) {
			int tmp = num * 10 + i;
			if (isPrime(tmp)) {
				DFS(tmp, digit + 1);
			}
		}
	}
	
	public static boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
