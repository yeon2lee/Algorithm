import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int order = 1;
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}
			
			A[i] = Integer.parseInt(st.nextToken());
			if (A[i] != order) {	
				stack.add(A[i]);
			} else {
				order++;
			}
		}
		
		boolean success = true;
		while (!stack.isEmpty()) {
			if (stack.pop() == order) {
				order++;
			} else {
				success = false;
				break;
			}
		}
		if (success) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
	}

}
