import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // peek으로 가장 위에 있는 숫자 확인한 후 중복 아닌 숫자만 push
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int peek = stack.peek();
            if (arr[i] != peek) {
                stack.push(arr[i]);
            }
        }
        
        // Object 배열을 int 배열로 변환
        Object[] objArray = stack.toArray();
        int[] answer = new int[objArray.length];
        for (int i = 0; i < objArray.length; i++) {
            answer[i] = (int) objArray[i];
        }
        
        return answer;
    }
}