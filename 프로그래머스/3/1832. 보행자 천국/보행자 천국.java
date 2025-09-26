class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp_down = new int[m][n];   // 위쪽에서 온 경우
        int[][] dp_right = new int[m][n];  // 왼쪽에서 온 경우

        dp_down[0][0] = 1;   // 아래로 출발하는 시드
        dp_right[0][0] = 0;  // 오른쪽 시드는 0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) { // 막힘
                    dp_down[i][j] = 0;
                    dp_right[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    if (cityMap[i - 1][j] == 2) { // 위 칸이 직진 전용이면 아래로만 유지
                        dp_down[i][j] = dp_down[i - 1][j] % MOD;
                    } else {
                        dp_down[i][j] = (dp_down[i - 1][j] + dp_right[i - 1][j]) % MOD;
                    }
                }

                if (j > 0) {
                    if (cityMap[i][j - 1] == 2) { // 왼 칸이 직진 전용이면 오른쪽으로만 유지
                        dp_right[i][j] = dp_right[i][j - 1] % MOD;
                    } else {
                        dp_right[i][j] = (dp_down[i][j - 1] + dp_right[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return (dp_down[m - 1][n - 1] + dp_right[m - 1][n - 1]) % MOD;
    }
}
