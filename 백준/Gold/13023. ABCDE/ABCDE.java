import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static int N;
	static int M;
	static ArrayList<Integer> A[];
	static boolean[] visited;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}

		for (int i = 0; i < N; i++) {
			DFS(i, 1);
			if (arrive) {
				break;
			}
		}
		
		if (arrive) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
		
	}

	public static void DFS(int v, int depth) {
		if (depth == 5 || arrive) {
			arrive = true;
			return;
		}
		
		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i, depth + 1);
			}
		}
		visited[v] = false;
	}
}
