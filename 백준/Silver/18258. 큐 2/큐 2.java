import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		/*
		push X: 정수 X를 큐에 넣는 연산이다.
		pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		size: 큐에 들어있는 정수의 개수를 출력한다.
		empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 */
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			switch(command) {
			case "push":
				int X = Integer.parseInt(st.nextToken());
				queue.add(X);
				break;
			case "pop":
				if (!queue.isEmpty()) {
					bw.write(queue.poll() + "\n");	
				} else {
					bw.write("-1\n");
				}
				break;
			case "size":
				bw.write(queue.size() + "\n");
				break;
			case "empty":
				if (queue.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
			case "front":
				if (!queue.isEmpty()) {
					bw.write(queue.peek() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			case "back":
				if (!queue.isEmpty()) {
					bw.write(queue.peekLast() + "\n");
				} else {
					bw.write("-1\n");
				}
				break;
			}
		}
		bw.flush();
	}

}
