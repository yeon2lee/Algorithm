import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		set = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			set[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int select = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (select == 0) {
				union(a, b);
			} else { // select == 1
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			set[b] = a;
		}
	}
	
	public static int find(int a) {
		if (set[a] == a) {
			return a;
		} else {
			return set[a] = find(set[a]);
		}
	}

}
