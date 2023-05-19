import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 그래프 초기화
		A = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 그래프 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e); // A가 B를 신뢰 -> B를 해킹하면 A도 해킹할 수 있음
		}
		
		// 컴퓨터 신뢰도 구하기
		answer = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			BFS(i);
		}
		
        // 신뢰도 max값 구한 후, 오름차순으로 출력
		int max = 0;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(max, answer[i]);
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (answer[i] == max) {
				System.out.print(i + " ");
			}
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
					visited[i] = true;
					queue.add(i);
					answer[i]++;
				}
			}
		}
	}
}
