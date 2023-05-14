import java.io.*;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		while (pq.size() != 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			sum += min1 + min2;
			pq.add(min1 + min2);
		}
		System.out.println(sum);
	}

}
