import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		/*
		1: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
		2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		3: 스택에 들어있는 정수의 개수를 출력한다.
		4: 스택이 비어있으면 1, 아니면 0을 출력한다.
		5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		 */
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			switch (command) {
			case 1:
				int X = Integer.parseInt(st.nextToken());
				stack.add(X);
				break;
			case 2: 
				if (!stack.isEmpty()) {
					bw.write(stack.pop() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case 3: 
				bw.write(stack.size() + "\n");
				break;
			case 4:
				if (stack.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
			case 5:
				if (!stack.isEmpty()) {
					bw.write(stack.peek() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.flush();
	}

}
