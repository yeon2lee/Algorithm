import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] numbers = st.nextToken().toCharArray();
		int base = Integer.parseInt(st.nextToken());
		int[] N = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= 'A') {
				N[i] = numbers[i] - 'A' + 10;
			} else {
				N[i] = numbers[i] - '0';
			}
		}
		
		int result = 0;
		int digit = 1;
		for (int i = N.length - 1; i >= 0; i--) {
			result += N[i] * digit;
			digit *= base;
		}
		System.out.println(result);
	}

}
