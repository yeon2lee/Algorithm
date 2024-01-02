import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int V = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (A[i] == V) {
				count++;
			}
		}
		System.out.println(count);
	}

}
