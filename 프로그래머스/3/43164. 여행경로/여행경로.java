import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] answer;
    static boolean found = false;
    
    public String[] solution(String[][] tickets) {
        
        visited = new boolean[tickets.length];
        
        // 티켓을 출발지→도착지 기준으로 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]); // 출발지가 같으면 도착지 기준
            }
            return a[0].compareTo(b[0]);
        });
        
        dfs("ICN", "ICN", tickets, 0);
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int depth){
        if (found) {
            return;
        }
        
        // 모든 티켓을 사용했을 경우
        if (depth == tickets.length){
            answer = route.split(" ");
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++){
            if (start.equals(tickets[i][0]) && !visited[i]){
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visited[i] = false;
            }
        }
    }
}
