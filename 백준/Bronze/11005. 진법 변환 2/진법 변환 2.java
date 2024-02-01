import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int base = Integer.parseInt(st.nextToken());
		
		int tmp = N;
		StringBuilder sb = new StringBuilder();
		while (tmp != 0) {
			int result = tmp % base;
			if (result >= 10) {
				char ch = (char) ('A' + (result - 10));
				sb.append(ch);
			} else {
				sb.append(result);
			}
			tmp /= base;
		}
		
		String numbers = sb.toString();
		sb = new StringBuilder();
		for (int i = numbers.length() - 1; i >= 0; i--) {
			sb.append(numbers.charAt(i));
		}
		System.out.println(sb.toString());
	}

}
