import java.io.*;

public class Main {
	static int MAX = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 소수 구하기
		boolean[] isNotPrime = new boolean[MAX + 1];
		isNotPrime[0] = true; isNotPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(MAX); i++) {
			if (isNotPrime[i] == false) {
				for (int j = i + i; j <= MAX; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		for (int i = N; i <= MAX; i++) {
			if (isNotPrime[i] == false) { // 소수인 경우에만 팰린드롬 판별
				if (isPalindrome(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	// 팰린드롬 판별
	public static boolean isPalindrome(int target) {
		char[] temp = Integer.toString(target).toCharArray();
		for (int i = 0; i < temp.length / 2; i++) {
			if (temp[i] != temp[temp.length - i - 1]) {
				return false;
			}
		}
		return true;
	}

}
