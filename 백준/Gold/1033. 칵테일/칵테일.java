import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static int N; // 재료 개수
	static ArrayList<Node>[] A; // 인접 리스트
	static boolean visited[]; // DFS를 탐색할 때 탐색 여부 저장 배열
	static long lcm; // 최소 공배수
	static long D[]; // 각 노드값 저장 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new ArrayList[N];
		visited = new boolean[N];
		D = new long[N];
		lcm = 1;
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			// 인접 리스트에 edge 정보 저장
			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p));
			
			// 최소 공배수 업데이트
			lcm *= (p * q / gcd(p, q));
		}
		
		D[0] = lcm; // 0번 노드에 최소 공배수 지정
		DFS(0);
		// 최대 공약수 계산
		long mgcd = D[0];
		for (int i = 1; i < N ; i++) {
			mgcd = gcd(mgcd, D[i]);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}
	}
	
	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public static void DFS(int v) {
		if (visited[v]) {
			return;
		}
		
		visited[v] = true;
		for (Node i : A[v]) {
			int next = i.b;
			if (!visited[next]) {
				int p = i.p;
				int q = i.q;
				D[next] = D[v] * q / p; // 주어진 비율로 다음 노드값 갱신
				DFS(next);
			}
		}
	}
	
	static class Node {
		int b;
		int p;
		int q;
		
		public Node(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}
	}
}
