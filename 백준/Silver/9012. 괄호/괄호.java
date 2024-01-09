import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			char[] str = br.readLine().toCharArray();
			stack.add(str[0]);
			for (int j = 1; j < str.length; j++) {
				if (!stack.isEmpty()) {
					char top = stack.peek();
					if (top == '(' && str[j] == ')') {
						stack.pop();
					} else {
						stack.add(str[j]);
					}
				} else {
					stack.add(str[j]);
				}
			}
			
			if (stack.isEmpty()) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
		}
		bw.flush();
	}

}
