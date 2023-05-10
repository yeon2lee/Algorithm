import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int checkArr[]; // 비밀번호 체크 배열
	static int myArr[]; // 현재 상태 배열
	static int checkSecret; // 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] A = new char[S];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;
		
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			
			if (checkArr[i] == 0) {
				checkSecret++;
			}
		}
		
		for (int i = 0; i < P; i++) {
			Add(A[i]);
		}
		
		int count = 0;
		if (checkSecret == 4) {
			count++;
		}
		
		// 슬라이딩 윈도우
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void Add(char c) {
		switch(c) {
			case 'A':
				myArr[0]++;
				if (myArr[0] == checkArr[0]) {
					checkSecret++;
				}
				break;
			case 'C':
				myArr[1]++;
				if (myArr[1] == checkArr[1]) {
					checkSecret++;
				}
				break;
			case 'G':
				myArr[2]++;
				if (myArr[2] == checkArr[2]) {
					checkSecret++;
				}
				break;
			case 'T':
				myArr[3]++;
				if (myArr[3] == checkArr[3]) {
					checkSecret++;
				}
				break;
		}
	}
	
	public static void Remove(char c) {
		switch(c) {
		case 'A':
			if (myArr[0] == checkArr[0]) {
				checkSecret--;
			}
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) {
				checkSecret--;
			}
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) {
				checkSecret--;
			}
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) {
				checkSecret--;
			}
			myArr[3]--;
			break;
	    }
	}

}
