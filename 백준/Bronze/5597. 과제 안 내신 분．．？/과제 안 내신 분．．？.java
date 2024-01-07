import java.io.*;

public class Main {
	static int MAX = 30;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] A = new boolean[MAX + 1];
		for (int i = 0; i < MAX - 2; i++) {
			int N = Integer.parseInt(br.readLine());
			A[N] = true;
		}
		
		for (int i = 1; i <= MAX; i++) {
			if (!A[i]) {
				System.out.println(i);
			}
		}
	}

}
