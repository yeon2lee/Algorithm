import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static int[] visitOrder;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		A = new ArrayList[N + 1];
		visitOrder = new int[N + 1];
		count = 1;
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
			A[E].add(S);
		}
		//내림차순 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(A[i], new Comparator<Integer>() {
				@Override
				public int compare(Integer n1, Integer n2) {
					return n2 - n1;
				}
			});
		}
		
		DFS(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(visitOrder[i]);
		}
	}

	private static void DFS(int node) {
		visitOrder[node] = count++;
		for (int i : A[node]) {
			if (visitOrder[i] == 0) {
				DFS(i);
			}
		}
	}

}
