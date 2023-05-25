import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] child; // 트리의 자식 노드 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 노드 개수
		child = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char node = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			/*
			 * child[node][0] == 0인 경우를 자식 노드가 없다는 의미로 쓰기 위해서, 노드 번호를 0번부터가 아니라 1번부터 시작한다.
			 * 그래서 (node - 'A')가 아니라 (node - 'A' + 1). (left - 'A')가 아니라 (left - 'A' + 1)을 해줌.
			 */
			if (left != '.') {
				child[node - 'A' + 1][0] = left - 'A' + 1;
			}
			if (right != '.') {
				child[node - 'A' + 1][1] = right - 'A' + 1;
			}
		}
		
		preorder(1); // 1번 노드부터 순회 시작
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
	}

	public static void preorder(int node) {
		if (node == 0) {
			return;
		}
		
		System.out.print((char) (node + 'A' - 1));
		preorder(child[node][0]);
		preorder(child[node][1]);
	}

	public static void inorder(int node) {
		if (node == 0) {
			return;
		}
		
		inorder(child[node][0]);
		System.out.print((char) (node + 'A' - 1));
		inorder(child[node][1]);
	}

	public static void postorder(int node) {
		if (node == 0) {
			return;
		}
		
		postorder(child[node][0]);
		postorder(child[node][1]);
		System.out.print((char) (node + 'A' - 1));
	}

}
