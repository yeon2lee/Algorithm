import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int sum = a + b + c;
		int max = Math.max(a, Math.max(b, c));
		if ((sum - max) > max) {
			System.out.println(sum);
		} else {
			int diff = max - (sum - max) + 1;
			System.out.println(sum - diff);
		}
	}
}
