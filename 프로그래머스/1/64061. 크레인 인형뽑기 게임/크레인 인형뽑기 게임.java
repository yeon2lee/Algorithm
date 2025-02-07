import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        //board에 인형이 들어있는 행 구하기
        int[] order = new int[board.length];
        for (int j = 0; j < board[0].length; j++) {
            order[j] = board.length - 1;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != 0) {
                    order[j] = i;
                    break;
                }
            }
        }
      
        Stack<Integer> basket = new Stack<>();
        basket.push(-1);
        for (int move : moves) {
            move--;
            int item = board[order[move]][move]; //크레인 작동 시 뽑은 인형
            board[order[move]][move] = 0;
            if (item == basket.peek()) { //뽑은 인형과 바구니 위에 있는 인형의 종류가 같다면
                basket.pop();
                answer += 2;
            } else { //바구니에 인형을 담아줌
                if (item != 0) {
                    basket.push(item);                                    
                }
            }
            
            if (order[move] < board.length - 1) { //크레인 가장 아래까지 도달했을 때
                order[move]++;             
            }
        }
        
        return answer;
    }
}