import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		/*
		1 X: 정수 X를 덱의 앞에 넣는다. (1 ≤ X ≤ 100,000)
		2 X: 정수 X를 덱의 뒤에 넣는다. (1 ≤ X ≤ 100,000)
		3: 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		4: 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
		5: 덱에 들어있는 정수의 개수를 출력한다.
		6: 덱이 비어있으면 1, 아니면 0을 출력한다.
		7: 덱에 정수가 있다면 맨 앞의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		8: 덱에 정수가 있다면 맨 뒤의 정수를 출력한다. 없다면 -1을 대신 출력한다.
		 */
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int X;
			switch(command) {
			case 1: 
				X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
				break;
			case 2:
				X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
				break;
			case 3: 
				if (!deque.isEmpty()) {
					sb.append(deque.removeFirst() + "\n"); 
				} else {
					sb.append("-1\n");
				}
				break;
			case 4:
				if (!deque.isEmpty()) {
					sb.append(deque.removeLast() + "\n"); 
				} else {
					sb.append("-1\n");
				}
				break;
			case 5: 
				sb.append(deque.size() + "\n");
				break;
			case 6:
				if (deque.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case 7:
				if (!deque.isEmpty()) {
					sb.append(deque.getFirst() + "\n"); 
				} else {
					sb.append("-1\n");
				}
				break;
			case 8:
				if (!deque.isEmpty()) {
					sb.append(deque.getLast() + "\n"); 
				} else {
					sb.append("-1\n");
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}
