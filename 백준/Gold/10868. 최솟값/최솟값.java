import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int treeSize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 트리 초기화
		int length = N;
		int treeHeight = 0;
		while (length != 0) {
			length /= 2;
			treeHeight++;
		}
		treeSize = (int) Math.pow(2, treeHeight + 1);
		tree = new int[treeSize];
		int LeftNodeStartIndex = treeSize / 2 - 1;
		for (int i = 0; i < treeSize; i++) {
			tree[i] = Integer.MAX_VALUE;
		}
		
		for (int i = LeftNodeStartIndex + 1; i <= LeftNodeStartIndex + N; i++) {
			tree[i] = Integer.parseInt(br.readLine());
		}
		setTree(treeSize - 1);
	
		// 최솟값 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			s += LeftNodeStartIndex;
			e += LeftNodeStartIndex;
			System.out.println(getMin(s, e));
		}
		
	}
	
    // 트리 초기화 함수
	public static void setTree(int index) {
		while (index != 1) {
			tree[index / 2] = Math.min(tree[index], tree[index - 1]);
			index -= 2;
		}
	}
	
    // 최솟값 구하기 함수
	public static int getMin(int s, int e) {
		int min = Integer.MAX_VALUE;
		while (s <= e) {
			if (s % 2 == 1) {
				min = Math.min(min, tree[s]);
				s++;
			} 
			
			if (e % 2 == 0) {
				min = Math.min(min, tree[e]);
				e--;
			}
			
			s /= 2;
			e /= 2;
		}
		return min;
	}

}
