import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[][] parent;
	static int[] depth;
	static boolean[] visited;
	static int kMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = N;
		kMax = 0;
		while (temp != 1) {
			temp /= 2;
			kMax++;
		}
		parent = new int[kMax + 1][N + 1];
		depth = new int[N + 1];
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		depth = new int[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		// 트리 높이 구하기
		BFS(1);
		for (int k = 1; k <= kMax; k++) {
			for (int n = 1; n <= N; n++) {
				parent[k][n] = parent[k - 1][parent[k - 1][n]];
			}
		}
		
		// LCA 출력
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());	
			int LCA = executeLCA(a, b);
			System.out.println(LCA);
		}
	}
	
	public static int executeLCA(int a, int b) {
		// 더 깊은 depth가 b가 되도록 변경
		if (depth[a] > depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		// depth 맞추기
		for (int k = kMax; k >= 0; k--) {
			if (Math.pow(2, k) <= depth[b] - depth[a]) {
				if (depth[a] <= depth[parent[k][b]]) {
					b = parent[k][b];
				}
			}
		}
		
		// 조상 찾기
		for (int k = kMax; k >= 0; k--) {
			if (parent[k][a] != parent[k][b]) {
				if (parent[k][a] != parent[k][b]) {
					a = parent[k][a];
					b = parent[k][b];
				}
			}
		}
		
		int LCA = a;
		if (a != b) {
			LCA = parent[0][LCA];
		}
		return LCA;	
	}
	
	public static void BFS(int v) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		visited[v] = true;
		queue.add(v);
		while (!queue.isEmpty()) {
			int now = queue.remove();
			for (int i : tree[now]) {
				if (!visited[i]) {
					visited[i] = true;
					parent[0][i] = now;
					depth[i] = depth[now] + 1;
					queue.add(i);
				}
			}
		}
	}

}
