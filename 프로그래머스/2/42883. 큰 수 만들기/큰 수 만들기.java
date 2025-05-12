import java.util.*;

class Solution {
    public String solution(String number, int k) {      
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        char[] array = number.toCharArray();
        int len = array.length - k;
        
        // 문자 비교를 시작하는 인덱스를 나타내는 start 변수 
        int start = 0;
        for (int i = 0; i < len; i++) {
            char max = '0';
            for (int j = start; j <= i + k; j++) {
                // 가장 큰수를 골라서 그 다음 인덱스를 시작 인덱스로 설정하기 
                if (array[j] > max) {
                    max = array[j];
                    start = j + 1;
                }
            }
            // 가장 큰 문자를 String에 넣어주기
            sb.append(Character.toString(max));
        }
        
        // k개의 수를 제거할 때 얻을 수 있는 가장 큰 숫자를 구하려 한다 
        answer = sb.toString();
        return answer;
    }
}