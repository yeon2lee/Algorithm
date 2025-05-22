import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N을 한 번만 써서 바로 만들 수 있으면 1 반환
        if (N == number) {
            return 1;
        }

        // dp[i]는 N을 i번 사용해서 만들 수 있는 모든 수를 저장하는 집합
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        // N을 1번 사용한 경우: N 자체
        dp.get(1).add(N);

        // N을 2번부터 8번까지 사용하는 경우
        for (int i = 2; i <= 8; i++) {

            // N, NN, NNN 등 숫자 이어붙이기 결과 추가 (예: N=5일 때 55, 555 등)
            StringBuilder sb = new StringBuilder().append(N);
            for (int j = 1; j < i; j++) {
                sb.append(N);
            }
            dp.get(i).add(Integer.parseInt(sb.toString()));

            // i를 j + (i - j)로 나누어 dp[j]와 dp[i-j]의 모든 조합에 사칙연산 수행
            for (int j = 1; j < i; j++) {
                int k = i - j;

                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }

            // 원하는 숫자를 만들 수 있다면 i 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8번까지 사용해도 만들 수 없는 경우
        return -1;
    }
}
