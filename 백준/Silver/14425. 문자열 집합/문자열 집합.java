import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		tNode root = new tNode();
		
		// 트라이 자료구조 구축
		for (int i = 0; i < N; i++) {
			String text = br.readLine();
			tNode now = root;
			for (int j = 0; j < text.length(); j++) {
				char ch = text.charAt(j);
				// 26개 알파벳의 위치를 배열 index로 나타내기 위해 -'a' 수행
				if (now.next[ch - 'a'] == null) {
					now.next[ch - 'a'] = new tNode();
				}
				now = now.next[ch - 'a'];
				if (j == text.length() - 1) {
					now.isEnd = true;
				}
			}
		}
		
		// 트라이 자료구조 검색
		int count = 0;
		for (int i = 0; i < M; i++) {
			String text = br.readLine();
			tNode now = root;
			for (int j = 0; j < text.length(); j++) {
				char ch = text.charAt(j);
				if (now.next[ch - 'a'] == null) { // 공백 노드라면 이 문자열을 포함하지 않음
					break;
				}
				now = now.next[ch - 'a'];
				if (j == text.length() - 1 && now.isEnd) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	// 트라이 자료구조를 위한 클래스 
	static class tNode {
		tNode[] next = new tNode[26]; // size: 알파벳 개수
		boolean isEnd; // 문자열의 마지막 유무 표시
	}
}
