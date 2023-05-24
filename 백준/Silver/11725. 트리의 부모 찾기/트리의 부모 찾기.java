import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] A; // 트리를 저장하는 인접 리스트
	static boolean[] visited; // 방문 여부 확인 배열
	static int[] answer; // 부모 노드 저장 배열
	public static void main(String[] args) throws IOException {
		// 입력 및 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		answer = new int[N + 1];
		A = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 트리 입력
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e);
			A[e].add(s);
		}
		
		// 부모 노드 찾기
		DFS(1);
		
		// 부모 노드 출력
		for (int i = 2; i < N + 1; i++) {
			System.out.println(answer[i]);
		}
		
	}

	public static void DFS(int v) {
		visited[v] = true;
		for (int next : A[v]) {
			if (!visited[next]) {
				visited[next] = true;
				answer[next] = v;
				DFS(next);
			}
		}
	}
}
