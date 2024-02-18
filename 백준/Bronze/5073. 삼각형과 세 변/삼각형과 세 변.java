import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length1 = Integer.parseInt(st.nextToken());
		int length2 = Integer.parseInt(st.nextToken());
		int length3 = Integer.parseInt(st.nextToken());
		while (!(length1 == 0 && length2 == 0 && length3 == 0)) {
			int sum = length1 + length2 + length3;
			int max = Math.max(length1, Math.max(length2, length3));
			if ((sum - max) <= max) {
				System.out.println("Invalid");
			} else {
				if (length1 == length2) {
					if (length2 == length3) {
						System.out.println("Equilateral");
					} else {
						System.out.println("Isosceles");
					}
				} else {
					if (length2 == length3) {
						System.out.println("Isosceles");
					} else {
						if (length1 == length3) {
							System.out.println("Isosceles");
						} else {
							System.out.println("Scalene");
						}
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			length1 = Integer.parseInt(st.nextToken());
			length2 = Integer.parseInt(st.nextToken());
			length3 = Integer.parseInt(st.nextToken());
		}
	}
}
