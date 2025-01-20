class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        int[] score = new int[3];
        int index = -1;
        for (int i = 0; i < dart.length; i++) {
            //숫자인 경우
            if (dart[i] == '1' && dart[i + 1] == '0') { //10점인 경우
                index++;
                score[index] = 10;
                i++;
                continue;
            } else if (dart[i] >= '0' && dart[i] <= '9') {
                index++;
                score[index] = Integer.parseInt(String.valueOf(dart[i]));
                continue;
            }
            
            //문자인 경우
            switch (dart[i]) {
                case 'D':
                    score[index] = (int) Math.pow(score[index], 2);
                    break;
                case 'T':
                    score[index] = (int) Math.pow(score[index], 3);
                    break;
                case '*':
                    score[index] *= 2;
                    if (index > 0) {
                        score[index - 1] *= 2;
                    }
                    break;
                case '#':
                    score[index] *= -1;
                    break;
            }
        }
        
        //점수 계산
        for (int s : score) {
            answer += s;
        }
        
        return answer;
    }
}