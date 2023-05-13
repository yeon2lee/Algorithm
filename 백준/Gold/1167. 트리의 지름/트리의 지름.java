import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Edge>[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		A = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			A[i] = new ArrayList<Edge>();
		}
		
		// 트리 입력
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			while (e != -1) {
				int value = Integer.parseInt(st.nextToken());
				A[node].add(new Edge(e, value));
				
				e = Integer.parseInt(st.nextToken());
			}
		}
		
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		BFS(1);
		// distance 배열에서 가장 큰 값으로 다시 시작점 설정
		int maxIndex = 1;
		for (int i = 2; i <= V; i++) {
			if (distance[i] > distance[maxIndex]) {
				maxIndex = i;
			}
		}
		
		// 새로운 시작점으로 실행
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		BFS(maxIndex);
		int max = -1;
		for (int i = 1; i <= V; i++) {
			if (distance[i] > max) {
				max = distance[i];
			}
		}
		System.out.println(max);
	}
	
	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (Edge i : A[now]) {
				int e = i.e;
				int v = i.value;
				if (!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now] + v; 
				}
			}
		}
	}
	
	static class Edge {
		private int e;
		private int value;
		
		public Edge(int e, int value) {
			this.e = e;
			this.value = value;
		}
	}
}
