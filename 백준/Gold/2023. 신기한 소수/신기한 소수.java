import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//신기한 소수 찾기
		for (int i = 2; i < 9; i++) {
			if (isPrime(i)) {
				DFS(i, 1);
			}
		}
	}
	
	private static void DFS(int search, int depth) {
		if (depth == N) {
			System.out.println(search);
			return;
		}
		
		for (int i = 1; i <= 9; i += 2) {
			if (isPrime(search * 10 + i)) {
				DFS(search * 10 + i, depth + 1);
			}
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
