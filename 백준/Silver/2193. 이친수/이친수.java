import java.io.*;

public class Main {
	static int MAX = 90;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] D = new long[MAX + 1][2];
		D[1][1] = 1; // 1자리 이친수는 1 한 가지 
		D[1][0] = 0;
		for (int i = 2; i <= MAX; i++) {
			D[i][0] = D[i - 1][1] + D[i - 1][0];
			D[i][1] = D[i - 1][0];
		}
		System.out.println(D[N][0] + D[N][1]);
	}

}
