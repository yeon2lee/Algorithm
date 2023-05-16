import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i][0] = Integer.parseInt(st.nextToken());
			A[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) { // 종료 시간이 같을 때
					return S[0] - E[0]; // 시작 시간이 빠른 순 (오름차순)
				} 
				return S[1] - E[1]; // 종료 시간이 빠른 순 (오름차순) 
			}
		});
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if (A[i][0] >= end) { // 겹치지 않는 다음 회의가 나온 경우
				end = A[i][1]; // 종료 시간 업데이트하기
				count++;
			}
		}
		System.out.println(count);
	}
}