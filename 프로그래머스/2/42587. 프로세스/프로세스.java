import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
        }
        
        int index = 0;
        Integer[] array = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Collections.reverseOrder());
        while (true) {
            int[] peek = queue.peek();
            if (peek[1] == array[index]) {
                queue.poll();
                index++;
                if (peek[0] == location) {
                    break;
                }
            } else {
                int[] poll = queue.poll();
                queue.add(poll);
            }
        }
        
        return index;
    }
}