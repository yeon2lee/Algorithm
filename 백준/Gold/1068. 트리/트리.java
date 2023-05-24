import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] tree; // 트리를 저장할 인접 리스트
	static boolean[] visited; // 방문 여부 배열
	static int count = 0; // 리프 노드 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rootNode = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (input == -1) { // 루트 노드 찾기 
				rootNode = i;
			} else { // 인접 리스트에 트리 데이터 저장
				tree[i].add(input);
				tree[input].add(i);
			}
		}
		
		// 삭제할 노드 입력
		int deleteNode = Integer.parseInt(br.readLine());
		
		// 삭제할 노드가 리프 노드라면 항상 리프 노드의 개수는 0
		if (deleteNode == rootNode) {
			System.out.println(0);
		} else { // 노드 제거 후, 리프 노드 개수 찾기
			DFS(rootNode, deleteNode);
			System.out.println(count);
		}
	}
	
	public static void DFS(int node, int delete) {
		visited[node] = true;
		int degree = 0;
		for (int next : tree[node]) {
			if (!visited[next] && next != delete) {
				DFS(next, delete);
				degree++;
			}
		}
		
		if (degree == 0) { // 자식 노드의 개수가 0 -> 리프 노드
			count++;
		}
	}

}
