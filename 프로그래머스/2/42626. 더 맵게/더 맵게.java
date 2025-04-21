import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.add(s);
        }
        
        return getCount(queue, K);
    }
    
    private int getCount(PriorityQueue<Integer> queue, int K) {
        int answer = 0;
        while (queue.size() > 1) {
            int peek = queue.peek();
            if (peek >= K) {
                return answer;
            }
            
            int first = queue.poll();
            int second = queue.poll();
            int newScoville = first + second * 2;
            queue.add(newScoville);
            answer++;
        }
        return queue.peek() >= K ? answer : -1;
    }
}