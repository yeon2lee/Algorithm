import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int i = 0;
        while (i < N - 1) {
            int j = i;
            int sum = distance[j];
            while (j < N - 1 && cost[j] <= cost[j + 1]) {
                j++;
                sum += distance[j];
            }
            result += cost[i] * sum;
            i = j + 1;
        }

        System.out.println(result);
    }
}