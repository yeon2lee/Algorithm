import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int V;
	static ArrayList<Integer> A[];
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		// 노드 번호가 작은 것을 먼저 방문 -> 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(A[i]);
		}
        
        // DFS
		visited = new boolean[N + 1];
		DFS(V);
		System.out.println();
		
        // BFS
		visited = new boolean[N + 1];
		BFS(V);
		System.out.println();
	}
	
	public static void DFS(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for (int i : A[v]) {
			if (!visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);
		visited[v] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int i : A[now]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
				
			}
		}
	}

}
