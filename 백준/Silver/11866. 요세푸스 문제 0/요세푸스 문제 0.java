import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		int order = 1;
		while (!queue.isEmpty()) {
			if (order == K) {
				answer.add(queue.poll());
				order = 0;
			} else {
				queue.add(queue.poll());
			}
			
			order++;
		}
		
		System.out.print("<" + answer.get(0));
		for (int i = 1; i < N; i++) {
			System.out.print(", " + answer.get(i));
		}
		System.out.print(">");
	}

}
