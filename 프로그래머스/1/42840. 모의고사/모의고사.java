import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] n1 = {1, 2, 3, 4, 5};
        int[] n2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] n3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];  
        for (int i = 0; i < answers.length; i++) {
            if (n1[i % 5] == answers[i]) {
                scores[0]++;
            }
            if (n2[i % 8] == answers[i]) {
                scores[1]++;
            }
            if (n3[i % 10] == answers[i]) {
                scores[2]++;
            }
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> winners = new ArrayList<>();
        if (scores[0] == maxScore) {
            winners.add(1);
        }
        if (scores[1] == maxScore) {
            winners.add(2);
        }
        if (scores[2] == maxScore) {
            winners.add(3);
        }
        
        return winners.stream().mapToInt(Integer::intValue).toArray();
    }
}
