import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point[] A = new Point[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			A[i] = new Point(X, Y);
		}
		
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			System.out.println(A[i].x + " " + A[i].y);
		}
	}
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point p) {
			if (this.y == p.y) {
				return this.x - p.x;
			}
			return this.y - p.y;
		}
	}

}
