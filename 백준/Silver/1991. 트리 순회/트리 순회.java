import java.util.Scanner;

public class Main {

	static int n;
	static int[][] child;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		child = new int[n + 1][2];
		
		// l은 v의 왼쪽 노드, r은 v의 오른쪽 노드 
		for (int i = 0; i < n; i++) {
			char v = scan.next().charAt(0);
			char l = scan.next().charAt(0);
			char r = scan.next().charAt(0);
			
			/*
			 * child[v 노드값][0]은 v 노드의 왼쪽 노드 값 저장 
			 * child[v 노드값][1]은 v 노드의 오른쪽 노드 값 저장
			 */
			if (l != '.') {
				child[v - 'A' + 1][0] = l - 'A' + 1;
			}
			if (r != '.') {
				child[v - 'A' + 1][1] = r - 'A' + 1;
			}
		}
		
		/*
		 * 항상 A가 루트 노드 -> preorder(1) 호출
		 */
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
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
