import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] A = new String[N];
		for (int i = 0; i < N; i++) {
			A[i] = br.readLine();
		}
		
		Arrays.sort(A, new Comparator<String>() {		
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length() - s2.length();
			}
		});
		
		StringBuilder sb = new StringBuilder();
		sb.append(A[0]).append('\n');
		for (int i = 1; i < N; i++) {
			if (!A[i].equals(A[i - 1])) {
				sb.append(A[i]).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

}
