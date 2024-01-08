import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// 수열의 개수 N, 수열 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		// 스택으로 오름차순 수열 만들기
		Stack<Integer> stack = new Stack<>();
		boolean success = true; // 오름차순 수열 만들기 성공여부
		int insert = 1; // 수열에 삽입해야 할 수
		int index = 0; // 확인할 수열의 인덱스
		StringBuffer bf = new StringBuffer();
		while (index < N) {
			if (insert <= A[index]) {
				stack.push(insert++);
				bf.append("+\n");
			} else { // insert > A[i]
				int now = stack.peek(); //스택 가장 위에 있는 수
				if (now == A[index]) {
					stack.pop();
					bf.append("-\n");
					index++;
				} else {
					success = false;
					break;
				}
			}
		}

		if (success) {
			System.out.println(bf.toString());
		} else {
			System.out.println("NO");
		}
	}

}
