import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		int length = (int) (M - N + 1);
		boolean[] checked = new boolean[length];
		for (long i = 2; i * i <= M; i++) {
			long pow = i * i;
			long start_index = N / pow;
			if (N % pow != 0) {
				start_index++; // 나머지가 있으면 1을 더해야 N보다 큰 제곱수에서 시작됨
			}
			for (long j = start_index; pow * j <= M; j++) {
				checked[(int) ((j * pow) - N)] = true;
			}
		}
		int count = 0;
		for (int i = 0; i <= M - N; i++) {
			if (!checked[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

}
