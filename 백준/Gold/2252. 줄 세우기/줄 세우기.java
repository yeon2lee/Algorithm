import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int[] degree; // 진입 차수 배열
	static ArrayList<Integer>[] A; // 인접 리스트
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 변수 초기화
		degree = new int[N + 1];
		A = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		// 엣지 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			A[s].add(e); // 인접 리스트에 노드 데이터 저장
			degree[e]++; // 진입 차수 배열값 업데이트
		}
		
		// 위상 정렬 실행
		topologicalSort();
	}

	public static void topologicalSort() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) { // 진입차수가 0인 노드를 큐에 저장
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			bw.write(now + " ");
			for (int i : A[now]) { 
				degree[i]--; // 진입 차수 1씩 감소
				if (degree[i] == 0) { // 진입 차수가 0이 되었다면, 큐에 추가
					queue.add(i);
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}
