import java.io.*;
import java.util.StringTokenizer; 

public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	long n1 = Integer.parseInt(st.nextToken());
    	long n2 = Integer.parseInt(st.nextToken());
    	
        long gcd = getGCD(Math.max(n1, n2), Math.min(n1, n2));
        System.out.println((n1 * n2) / gcd);
    }
    
    public static long getGCD(long a, long b) {
        while(b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
