class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; // 스테이지
        double[] fail = new double[N]; // 실패율
        int notClear[] = new int[N]; // 해당 스테이지(-1)를 클리어하지 못한 사용자 수

        for (int s : stages) {
            if (s != N + 1) {
                notClear[s - 1] += 1;
            }
        }        
        
        // 실패율 구하기
        int player = stages.length;// 초기사용자 = stages.length
        for (int i = 0; i < N; i++) {
            fail[i] = (double) notClear[i] / player; // 실패율 저장
            player -= notClear[i];
            answer[i] = i + 1;
        }
        
        double tmpFail = 0;
        int tmpAnswer = 0;
        // 실패율 정렬하면서 answer의 스테이지도 함께 순서바꿈
        for (int i = 0; i < N; i++){
            for (int j = 1; j < N - i; j++) {
                if (fail[j - 1] < fail[j]) {  // 가장 작은 수(맨뒤)부터 정렬
                    tmpFail = fail[j - 1];
                    fail[j - 1] = fail[j];
                    fail[j] = tmpFail;
                    
                    tmpAnswer = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tmpAnswer;
                }
            }
        }

        return answer;
    }
}