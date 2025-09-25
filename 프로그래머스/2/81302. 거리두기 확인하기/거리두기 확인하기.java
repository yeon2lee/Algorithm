class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            answer[i] = check(place) ? 1 : 0;
        }
        
        return answer;
    }
    
    // 회의실별로 체크
    private boolean check(String[] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!isSafe(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // 거리두기 체크
    private boolean isSafe(String[] place, int x, int y) {
        // 거리 1 위치 확인
        int[] dx1 = {-1, 1, 0, 0};
        int[] dy1 = {0, 0, -1, 1};
        for (int d = 0; d < 4; d++) {
            int nx = x + dx1[d];
            int ny = y + dy1[d];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if (place[nx].charAt(ny) == 'P') {
                    return false;
                }
            }
        }
        
        // 거리 2 위치 확인
        int[] dx2 = {-2, 2, 0, 0};
        int[] dy2 = {0, 0, -2, 2};
        for (int d = 0; d < 4; d++) {
            int nx = x + dx2[d];
            int ny = y + dy2[d];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if (place[nx].charAt(ny) == 'P') {
                    int mx = (x + nx) / 2;
                    int my = (y + ny) / 2;
                    if (place[mx].charAt(my) == 'O') {
                        return false;
                    }
                }
            }
        }
        
        // 대각선 위치 확인
        int[] dx3 = {-1, -1, 1, 1};
        int[] dy3 = {-1, 1, -1, 1};
        for (int d = 0; d < 4; d++) {
            int nx = x + dx3[d];
            int ny = y + dy3[d];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if (place[nx].charAt(ny) == 'P') {
                    if (place[x].charAt(ny) == 'O' || place[nx].charAt(y) == 'O') {
                        return false;
                    }       
                }
            }
        }
        
        return true;
    }
}