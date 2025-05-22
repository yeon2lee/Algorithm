class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int dp1[] = new int[n]; // 첫 번째 집 O (첫 번째 집 index = 0)
        int dp2[] = new int[n]; // 첫 번째 집 X
        
        // 1. 첫 번째 집 털 경우 -> 2번째집 못 터니까 두개의 dp의 값은 money[0]이다.
        dp1[0] = money[0];
        dp1[1] = money[0];
        for (int i = 2; i < n-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        
        // 2. 첫 번째 집 안 털면 -> dp2[0]의 값은 0이니까 따로 설정하지 않아도 됨. 그리고 마지막 집까지 순회
        dp2[1] = money[1];
        for (int i = 2; i < n; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp1[n-2], dp2[n-1]);
    }
}