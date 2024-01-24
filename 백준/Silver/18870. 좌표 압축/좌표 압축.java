import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Coordinate[] C = new Coordinate[N];

		/*좌표 압축*/
		for (int i = 0; i < N; i++) {
			C[i] = new Coordinate(i, Integer.parseInt(st.nextToken()));
		}
		//뒤의 숫자로 정렬
		Arrays.sort(C, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if (c1.n2 == c2.n2) {
					return c1.n1 - c2.n1;
				}
				return c1.n2 - c2.n2;
			}
		});
		//좌표 지정 
		int index = 0;
		int before = C[0].n2;
		C[0].n2 = index++;
		for (int i = 1; i < N; i++) {
			if (C[i].n2 == before) {
				index--;
			}
			before = C[i].n2;
			C[i].n2 = index++;
		}
		//앞의 숫자로 정렬
		Arrays.sort(C, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				return c1.n1 - c2.n1;
			}
		});
		//뒤의 숫자 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(C[i].n2).append(" ");
		}
		System.out.println(sb.toString());
	}

	static class Coordinate {
		int n1;
		int n2;
		
		public Coordinate(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
		}
	}
}
