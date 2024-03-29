import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		int start = 1, end = 1;
		int sum = 1;
		int count = 1; 
		while (end != N) {
			if (sum < N) {
				end++;
				sum += end;
			} else if (sum > N) {
				sum -= start;
				start++;
			} else {
				count++;
				end++;
				sum += end;
			}
		}
		
		System.out.println(count);
	}

}
