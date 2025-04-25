class Solution {
    
    public int solution(int[][] sizes) {
        // 가장 긴 부분을 가로로 대치
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        
        int width = 0;
        int height = 0;
        for (int i = 0; i < sizes.length; i++) {
            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);
        }
        
        return width * height;
    }
}