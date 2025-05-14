import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 도착 지점 기준으로 정렬
                return o1[1] - o2[1];
            }
        });
        
        int cam = -30001;
        for (int route[] : routes) {
            if (cam < route[0]) {
                cam = route[1];
                answer++;
            }
        }
        
        return answer;
    }
}