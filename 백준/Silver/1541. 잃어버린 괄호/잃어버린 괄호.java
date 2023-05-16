import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");
		int answer = 0;
		for (int i = 0; i < str.length; i++) {
			int temp = mySum(str[i]);
			if (i == 0) {
				answer += temp; // 가장 앞에 있는 값만 더함
			} else {
				answer -= temp; // 뒷부분은 더한 값들을 뺌
			}
		}
		System.out.println(answer);
	}

	public static int mySum(String a) { // 나뉜 그룹의 더하기 연산 수행 함수
		int sum = 0;
		String temp[] = a.split("\\+");
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}
