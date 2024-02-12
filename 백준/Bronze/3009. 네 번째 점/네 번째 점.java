import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] X = new int[3];
		int[] Y = new int[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}
		
		if (X[0] == X[1]) {
			System.out.print(X[2] + " ");
		} else if (X[0] == X[2]) {
			System.out.print(X[1] + " ");
		} else {
			System.out.print(X[0] + " ");
		}
		
		if (Y[0] == Y[1]) {
			System.out.println(Y[2]);
		} else if (Y[0] == Y[2]) {
			System.out.println(Y[1]);
		} else {
			System.out.println(Y[0]);
		}
	}

}
