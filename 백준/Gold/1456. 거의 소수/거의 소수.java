import java.util.Scanner;

public class Main {
	static int MAX = 10000000;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long A = scan.nextLong();
		long B = scan.nextLong();
		
		boolean[] checked = new boolean[MAX + 1]; // 소수면 false, 소수가 아니면 true
		checked[0] = true; checked[1] = true;
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (checked[i]) {
				continue;
			}
			for (int j = i + i; j <= MAX; j += i) {
				checked[j] = true;
			}
		}
		
		int count = 0;
		for (int i = 2; i <= MAX; i++) {
			if (checked[i] == false) {
				long temp = i;
				while ((double) i <= (double) B / (double) temp) {
					if ((double) i >= (double) A / (double) temp) {
						count++;
					}
					temp *= i;
				}
			}
		}
		System.out.println(count);
		
		scan.close();
	}

}
