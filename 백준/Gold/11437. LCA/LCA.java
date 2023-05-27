import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] parent;
	static int[] depth;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		parent = new int[N + 1];
		depth = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		
		// 부모 노드와 깊이 업데이트
		BFS(1);
		
		// LCA 출력
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());	
			printLCA(s, e);
		}
		
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
					parent[i] = now;
					depth[i] = depth[now] + 1;
					queue.add(i);
				}
			}
		}
	}
	
	public static void printLCA(int s, int e) {
		if (depth[s] < depth[e]) {
			int temp = s;
			s = e;
			e = temp;
		}
		
		// 두 노드의 depth 맞추기
		while (depth[s] != depth[e]) {
			s = parent[s];
		}
		
		// 같은 조상이 나올 때까지 한 칸씩 올리기
		while (s != e) {
			s = parent[s];
			e = parent[e];
		}
		
		System.out.println(s);
	}
	
}
