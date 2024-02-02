import java.io.*;

public class Main {
	static final int QUARTER = 25;
	static final int DIME = 10;
	static final int NICKEL = 5;
	static final int PENNY = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int C = Integer.parseInt(br.readLine());
			System.out.print(C / QUARTER + " ");
			C %= QUARTER;
			System.out.print(C / DIME + " ");
			C %= DIME;
			System.out.print(C / NICKEL + " ");
			C %= NICKEL;
			System.out.println(C / PENNY);
		}
	}

}
