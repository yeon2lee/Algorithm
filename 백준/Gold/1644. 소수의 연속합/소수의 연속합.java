import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//소수 구하기
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				A.add(i);
			}
		}
		
		//연속된 소수의 합 개수 구하기
		int size = A.size();
		int i = 0; 
		int j = 0;
		int sum = 0;
		if (size != 0) {
			sum = A.get(i);
		}
		int count = 0;
		while (j != size) {
			if (sum < N) {
				j++;
				if (j < size) {
					sum += A.get(j);
				}
			} else if (sum > N) {
				sum -= A.get(i);
				i++;
			} else { //sum == N
				count++;
				j++;
				if (j < size) {
					sum += A.get(j);
				}
			}
		}
		
		System.out.println(count);
	}

}
