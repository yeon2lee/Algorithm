import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int MOD = 1000000007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 트리 초기화
		int length = N;
		int treeHeight = 0;
		while (length != 0) {
			length /= 2;
			treeHeight++;
		}
		int treeSize = (int) Math.pow(2, treeHeight + 1);
		int leftNodeStartIndex = treeSize / 2 - 1;
		tree = new long[treeSize];
		for (int i = 0; i < treeSize; i++) { // 곱셈이므로 초깃값을 1로 설정
			tree[i] = 1;
		}
		for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		setTree(treeSize - 1); // tree 만들기
		
		// 구간 곱 구하기
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (a == 1) { // 값 변경
				changeVal(leftNodeStartIndex + s, e);
			} else { // a == 2 (구간의 곱)
				s += leftNodeStartIndex;
				e += leftNodeStartIndex;
				System.out.println(getMul(s, e));
			}
		}
		
	}
	
    // 트리 초기화 함수
	public static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] = tree[i / 2] * tree[i] % MOD;
			i--;
		}
	}
	
    // 노드값 변경 함수
	public static void changeVal(int index, int value) {
		tree[index] = value;
		while (index != 1) {
			index /= 2;
			tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
		}
	}
	
    // 구간 곱 구하기 함수
	public static long getMul(int s, int e) {
		long partMul = 1;
		while (s <= e) {
			if (s % 2 == 1) {
				partMul = partMul * tree[s] % MOD;
				s++;
			}
			if (e % 2 == 0) {
				partMul = partMul * tree[e] % MOD;
				e--;
			}
			s /= 2;
			e /= 2;
		}
		
		return partMul;
	}

}
