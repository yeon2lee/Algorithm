import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		P--;
		char[] str = br.readLine().toCharArray();
		//{‘A’, ‘C’, ‘G’, ‘T’}의 등장횟수 입력
		int[] minCount = new int[4];
		int check = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			minCount[i] = Integer.parseInt(st.nextToken());
			if (minCount[i] == 0) {
				check++;
			}
		}
		
		//문자가 등장하는 횟수 구하기
		int[] count = new int[4];
		int result = 0;
		for (int i = 0; i <= P; i++) {
			if (str[i] == 'A') {
				count[0]++;
				if (count[0] == minCount[0]) {
					check++;
				}
			} else if (str[i] == 'C') {
				count[1]++;
				if (count[1] == minCount[1]) {
					check++;
				}
			} else if (str[i] == 'G') {
				count[2]++;
				if (count[2] == minCount[2]) {
					check++;
				}
			} else if (str[i] == 'T') {
				count[3]++;
				if (count[3] == minCount[3]) {
					check++;
				}
			}
		}
		if (check >= 4) {
			result++;
		}
		
		for (int i = 1; P + i < S; i++) {
			
				if (str[i - 1] == 'A') {
					if (count[0] == minCount[0]) {
						check--;
					}
					count[0]--;
				} else if (str[i - 1] == 'C') {
					if (count[1] == minCount[1]) {
						check--;
					}
					count[1]--;
					
				} else if (str[i - 1] == 'G') {
					if (count[2] == minCount[2]) {
						check--;
					}
					count[2]--;
				} else if (str[i - 1] == 'T') {
					if (count[3] == minCount[3]) {
						check--;
					}
					count[3]--;
				}
			
			
			if (str[P + i] == 'A') {
				count[0]++;
				if (count[0] == minCount[0]) {
					check++;
				}
			} else if (str[P + i] == 'C') {
				count[1]++;
				if (count[1] == minCount[1]) {
					check++;
				}
			} else if (str[P + i] == 'G') {
				count[2]++;
				if (count[2] == minCount[2]) {
					check++;
				}
			} else if (str[P + i] == 'T') {
				count[3]++;
				if (count[3] == minCount[3]) {
					check++;
				}
			}
			
			if (check >= 4) {
				result++;
			}
		}
	
		System.out.println(result);
	}

}
