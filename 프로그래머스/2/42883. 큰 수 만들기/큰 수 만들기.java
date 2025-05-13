import java.util.*;

class Solution {
    public String solution(String number, int k) {      
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] array = number.toCharArray();
        int length = array.length - k;

        int start = 0;
        for (int i = 0; i < length; i++) {
            char max = '0';
            // 한 자리씩 큰 수 확정하기
            for (int j = start; j <= i + k; j++) {
                if (array[j] > max) {
                    max = array[j];
                    start = j + 1; // 하나가 확정되면 다음 인덱스부터 봄
                }
            }
            sb.append(Character.toString(max));
        }
        
        answer = sb.toString();
        return answer;
    }
}