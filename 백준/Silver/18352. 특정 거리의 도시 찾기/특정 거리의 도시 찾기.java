import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 초기화
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		A = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}

		// 도로 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
		}
		
		// 최단 거리가 K인 모든 도시의 번호 구하기
		BFS(X);
		
		// 최단 거리가 K인 모든 도시들의 번호 출력 (없다면 -1 출력)
		boolean find = false;
		for (int i = 1; i < N + 1; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				find = true;
			}
		}
		
		if (!find) {
			System.out.println("-1");
		}
	}
	
	public static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(node);
		visited[node] = true;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i : A[now]) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
					distance[i] = distance[now] + 1;
				}
			}
		}
	}

}
