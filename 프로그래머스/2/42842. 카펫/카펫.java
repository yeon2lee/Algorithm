class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int column = 1; column <= yellow; column++) {
            int row = yellow / column;

            /*
            노란 격자 행 길이*2 + 노란 격자 열 길이*2 + 4 = 갈색 격자 개수
            -> yellow/column*2 + column*2 + 4 = (yellow/column + column)*2 + 4 = brown
            */
            if (yellow % column == 0 && ((row + column) * 2 + 4) == brown) {
                return new int[] {row + 2, column + 2};
            }
        }
        return answer;
    }
}