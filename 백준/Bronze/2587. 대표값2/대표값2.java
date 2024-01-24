import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[5];
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			A[i] = Integer.parseInt(br.readLine());
			sum += A[i];
		}
	
		Arrays.sort(A);
		System.out.println(sum / 5);
		System.out.println(A[2]);
	}

}
