import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int l = str.length();
		int q = Integer.parseInt(br.readLine());
		
		// 누적 합 배열 구하기
		int[][] S = new int[l + 1][26];
		for (int i = 0; i < l; i++) {
			char ch = str.charAt(i);
			for (int j = 1; j < l + 1; j++) {
				if (str.charAt(j - 1) == ch) {
					S[j][ch - 'a'] = S[j - 1][ch - 'a'] + 1;
				} else {
					S[j][ch - 'a'] = S[j - 1][ch - 'a'];
				}
			}
		}
		
		for (int i = 0; i < q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char alphabet = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken()) + 1;
			int end = Integer.parseInt(st.nextToken()) + 1;
			
			bw.append(S[end][alphabet - 'a'] - S[start - 1][alphabet - 'a'] + "\n");
		}
		bw.flush();
		bw.close();
	}
}