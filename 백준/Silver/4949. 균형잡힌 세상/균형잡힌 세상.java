import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/*
		모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
		모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
		모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
		모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
		짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
		 */
		String str;
		while(true) {
			str = br.readLine();
			char[] line = str.toCharArray();
			Stack<Character> stack = new Stack<>();
			if (str.equals(".")) {
				break;
			}
            
			for (int j = 0; j < line.length; j++) {
				char top = ' ';
				if (!stack.isEmpty()) {
					top = stack.peek();
				}
				
				if (top == '(') {
					if (line[j] == ')') {
						stack.pop();
					} else if (line[j] == '(' || line[j] == '[' || line[j] == ']'){
						stack.add(line[j]);
					}
				} else if (top == '[') {
					if (line[j] == ']') {
						stack.pop();
					} else if (line[j] == '(' || line[j] == ')' || line[j] == '[') {
						stack.add(line[j]);
					}
				} else {
					if (line[j] == '(' || line[j] == ')' || line[j] == '[' || line[j] == ']') {
						stack.add(line[j]);
					}
				}
			}
			
			if (stack.isEmpty()) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		bw.flush();
	}
	

}
