import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        // 도착시간을 '분'으로 변환해 우선순위 큐에 담기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String tt : timetable) {
            int time = Integer.parseInt(tt.substring(0, 2)) * 60 + Integer.parseInt(tt.substring(3));
            pq.add(time);
        }
        
        int start = 9 * 60; // 현재 시간 (9시로 시작)
        int last = 0; // 마지막 시간
        int total = 0; // 셔틀버스 탑승 인원
        for (int i = 0; i < n; i++) {
            total = 0; 
            while (!pq.isEmpty()) {
                int now = pq.peek();
                // 버스 시간보다 이전에 도착했고,
                // 마지막에 셔틀 버스에 탄 인원이 m보다 작다면, 셔틀 버스에 탈 수 있음
                if (now <= start && total < m) {
                    pq.poll();
                    total++;
                } else {
                    break;
                }
                last = now - 1; // 마지막 시간을 현재 크루의 시간 -1로 재설정
            }
            start += t; // 셔틀버스가 지나갔으니 시간 더하기
        }
        
        // 마지막 셔틀 버스에 탄 인원이 m보다 작다면, 해당 셔틀 버스에 콘이 탈 수 있음
        if (total < m) {
            last = start - t;
        }
        
        // 시간 정보 '시간:분' 형태로 출력하기 
        String hour = String.format("%02d", last / 60);
        String minute = String.format("%02d", last % 60);
        return hour + ":" + minute;
    }
}