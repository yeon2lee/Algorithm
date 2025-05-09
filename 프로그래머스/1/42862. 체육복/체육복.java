import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(reserve);
        Arrays.sort(lost);
            
        // 도난 당하지 않은 학생 수
        answer = n - lost.length;
        
        // 여벌이 있지만 본인이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1; // 이미 처리된 학생은 -1로 표시
					reserve[j] = -1;
                    break;
				}
			}
		}
        
        // 체육복을 빌릴 수 있는 경우 (앞번호 또는 뒷번호)
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
					answer++;
					reserve[j] = -1;  // 이미 빌려준 학생은 제외
					break;
				}
			}
		}
        
        return answer;
    }
}