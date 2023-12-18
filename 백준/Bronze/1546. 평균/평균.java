import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] scores = new int[n];
		int sum = 0;
		int max = -1;
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			sum += scores[i];
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		
		System.out.println(sum * 100.0 / max / n);
	}

}
