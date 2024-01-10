import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N + 1];
		Deque<Integer> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			q.add(i);
		}
		
		ArrayList<Integer> answer = new ArrayList<>();
		int K = A[1];
		int index = A[1] > 0 ? 1 : -1;
		answer.add(q.removeFirst());
		while (!q.isEmpty()) {
			if (K > 0) {
				if (index == K) {
					int removed = q.removeFirst();
					K = A[removed];
					answer.add(removed);
					index = K > 0 ? 1 : -1;
				} else {
					q.addLast(q.removeFirst());
					index++;
				}
			} else { //K가 음수일 때 
				if (index == K) {
					int removed = q.removeLast();
					K = A[removed];
					answer.add(removed);
					index = K > 0 ? 1 : -1;
				} else {
					q.addFirst(q.removeLast());
					index--;
				}
			}
		}
		
		for (int value : answer) {
			System.out.print(value + " ");
		}
	}

}
