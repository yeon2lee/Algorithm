import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//queuestack을 구성하는 자료구조의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		//길이 N의 수열 A 입력 (자료구조가 큐라면 0, 스택이라면 1)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] isStack = new int[N];
		for (int i = 0; i < N; i++) {
			isStack[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new LinkedList<>();
		//길이 N의 수열 B 입력 (자료구조에 들어있는 원소 입력)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int element = Integer.parseInt(st.nextToken());
			if (isStack[i] == 0) { //자료구조가 큐인 경우에만 Deque에 삽입
				deque.addLast(element);
			}
		}
		
		//삽입할 수열의 길이 M 입력
		int M = Integer.parseInt(br.readLine());
		//수열 C 삽입
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			deque.addFirst(Integer.parseInt(st.nextToken()));
			sb.append(deque.pollLast() + " ");
		}
		
		System.out.println(sb.toString());
	}

}
