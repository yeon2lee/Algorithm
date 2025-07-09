class Solution {
    int[] discountRates = {10, 20, 30, 40};
    int maxPlusUsers = 0;
    int maxRevenue = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 모든 할인 조합을 완전탐색
        dfs(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxPlusUsers, maxRevenue};
    }

    // depth: 현재 이모티콘 인덱스
    // discounts: 현재까지의 할인율 조합
    private void dfs(int depth, int[] discounts, int[][] users, int[] emoticons) {
        if (depth == emoticons.length) {
            evaluate(discounts, users, emoticons);
            return;
        }
        for (int rate : discountRates) {
            discounts[depth] = rate;
            dfs(depth + 1, discounts, users, emoticons);
        }
    }

    private void evaluate(int[] discounts, int[][] users, int[] emoticons) {
        int plusUsers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int userRate = user[0]; // 이 사용자에게 필요한 최소 할인율
            int userLimit = user[1]; // 이 금액 이상이면 플러스 가입
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userRate) {
                    sum += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (sum >= userLimit) {
                plusUsers++;
            } else {
                revenue += sum;
            }
        }

        if (plusUsers > maxPlusUsers || (plusUsers == maxPlusUsers && revenue > maxRevenue)) {
            maxPlusUsers = plusUsers;
            maxRevenue = revenue;
        }
    }
}
