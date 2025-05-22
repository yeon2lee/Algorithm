import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length; // 삼각형의 높이

        // dp[i][j] = (i,j)까지 도달할 수 있는 최대 합
        int[][] dp = new int[height][height];

        // 첫 번째 꼭대기 값 초기화
        dp[0][0] = triangle[0][0];

        // 가장 왼쪽 열 초기화 (한 방향으로만 내려오는 경로)
        for (int i = 1; i < height; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
        }

        // dp 배열 채우기
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < triangle[i].length; j++) {
                // 왼쪽 위 or 오른쪽 위 중 큰 값 선택 + 현재 삼각형 값
                dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], 
                                    j < i ? dp[i-1][j] + triangle[i][j] : 0);
                // (j < i) 체크는 indexOutOfBounds 방지를 위한 예외처리 (생략해도 무방)
            }
        }

        // 마지막 줄 중 가장 큰 값이 최대 합
        for (int i = 0; i < height; i++) {
            answer = Math.max(answer, dp[height - 1][i]);
        }

        return answer;
    }
}