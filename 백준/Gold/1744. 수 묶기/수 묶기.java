import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		int oneCount = 0;
		int zeroCount = 0;
		for (int i = 0; i < N; i++) {
			int data = Integer.parseInt(br.readLine());
			if (data > 1) {
				plusPq.add(data);
			} else if (data == 1) {
				oneCount++;
			} else  if (data == 0) {
				zeroCount++;
			} else { // data < 0
				minusPq.add(data);
			}
		}
		
		int sum = 0;
		// 양수 처리
		while (plusPq.size() > 1) {
			int data1 = plusPq.remove();
			int data2 = plusPq.remove();
			sum += (data1 * data2);
		}
		if (!plusPq.isEmpty()) {
			sum += plusPq.remove();
		}
		
		// 음수 처리
		while (minusPq.size() > 1) {
			int data1 = minusPq.remove();
			int data2 = minusPq.remove();
			sum += (data1 * data2);
		}
		if (!minusPq.isEmpty()) {
			if (zeroCount == 0) { // 0 처리 
				sum += minusPq.remove();
			}
		}
		
		// 1 처리
		sum += oneCount;
		
		System.out.println(sum);
	}

}
