import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
	static boolean[] visited;
	static ArrayList<Node>[] A; // 인접 리스트
	static int[] D; // 최소 거리 배열
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 노드의 개수
		int E = Integer.parseInt(st.nextToken()); // 에지의 개수
		int K = Integer.parseInt(br.readLine()); // 출발 노드의 번호 K
		visited = new boolean[N + 1];
		A = new ArrayList[N + 1];
		D = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Node>();
			D[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken()); 
			int weight = Integer.parseInt(st.nextToken());
			
			A[s].add(new Node(e, weight));
		}
		
        // 다익스트라 알고리즘 실행
		dijkstra(K);
		for (int i = 1; i < N + 1; i++) {
			if (D[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(D[i]);
			}
		}
	}
	
	public static void dijkstra(int start) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
		visited[start] = true;
		D[start] = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (Node next : A[now]) {
				int v = next.vertex;
				int w = next.value;
				if (D[now] + w < D[v]) {
					D[v] = D[now] + w;
				}
			}
			
			// 거리 최솟값 노드 선택
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 1; i < N + 1; i++) {
				if (!visited[i]) {
					if (D[i] < min) {
						min = D[i];
						minIndex = i;
					}
				}
			}
			if (minIndex != -1) {
				queue.add(minIndex);
				visited[minIndex] = true;
			}
		}
	}

	static class Node {
		int vertex;
		int value;
		
		public Node(int vertex, int value) {
			this.vertex = vertex;
			this.value = value;
		}
	}
}
