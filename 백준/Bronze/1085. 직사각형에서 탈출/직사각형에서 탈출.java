import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
 
		int x_min = Math.min(X, W - X);	// x축 최소거리
		int y_min = Math.min(Y, H - Y);	// y축 최소거리
   
		// x와 y축 최소거리 중 가장 작은 값
		System.out.println(Math.min(x_min, y_min));
	}

}
