import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
	static int[] degree;
	static ArrayList<Integer>[] A;
	static int[] time;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		degree = new int[N + 1];
		A = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		time = new int[N + 1];
		result = new int[N + 1];
		
		// 각 건물을 짓는 데 걸리는 시간과 그 건물을 짓기 위해 먼저 지어야 하는 건물들의 번호 입력
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			int tmp = Integer.parseInt(st.nextToken());
			while (tmp != -1) {
				A[tmp].add(i);
				degree[i]++;
				tmp = Integer.parseInt(st.nextToken());
			}
		}
		
		// 위상 정렬 이용
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : A[now]) {
				degree[next]--; // 진입차수 -1
				// 시간 업데이트
				result[next] = Math.max(result[next], result[now] + time[now]);
				if (degree[next]  == 0) {
					queue.add(next);
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.println(result[i] + time[i]);
		}
	}

}
