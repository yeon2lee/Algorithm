import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        
        boolean[] checked = new boolean[n + 1];
        checked[0] = checked[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!checked[i]) { 
                for(int j = i * i; j <= n; j += i) {
                    checked[j] = true; 
                }
            }
        }
        
        for (int i = m; i <= n; i++) {
            if (!checked[i]) { 
                System.out.println(i);
            }
        }
        
        scan.close();
    }
}