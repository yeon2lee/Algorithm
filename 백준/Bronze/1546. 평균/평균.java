import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[N];
		int M = -1;
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			M = Math.max(M, scores[i]); // 최댓값 구하기
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) scores[i] / M * 100;
		}
		
		System.out.println(sum / N);
	}

}
