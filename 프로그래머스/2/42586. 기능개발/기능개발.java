import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        
        int index = 0;
        int day = 1;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int now = queue.peek();
            if (now + speeds[index] * day >= 100) {
                queue.poll();
                index++;
                sum++;
            } else {
                if (sum != 0) {
                    list.add(sum);
                    sum = 0;
                }
                day++;
            }
        }
        list.add(sum);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}