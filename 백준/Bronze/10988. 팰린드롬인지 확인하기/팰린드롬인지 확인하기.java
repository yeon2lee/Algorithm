import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		boolean isPalindrome = true;
		int size = str.length;
		for (int i = 0; i < size / 2; i++) {
			if (str[i] != str[size - i - 1]) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}

}
