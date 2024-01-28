import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] A = new int[9][9];
		int max = -1;
		int maxRow = 0;
		int maxCol = 0;
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] > max) {
					max = A[i][j];
					maxRow = i;
					maxCol = j;
				}
			}
		}
		System.out.println(max);
		System.out.println((maxRow + 1) + " " + (maxCol + 1));
	}

}
