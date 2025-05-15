import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int index = 0; // 몸무게가 작은 사람의 위치
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                answer++;
                index++;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}