package level1;

import java.util.ArrayList;
import java.util.List;

public class 크레인인형뽑기 {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		List<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < moves.length; i++) {
			int x = moves[i] - 1;

			for (int y = 0; y < board.length; y++) {
				if (board[y][x] != 0) {
                    if(!arr.isEmpty() &&arr.get(arr.size()-1)==board[y][x]){
                        arr.remove(arr.size()-1);
                        answer+=2;
                    } else arr.add(board[y][x]);
                    board[y][x] = 0;
                    break;
				}
			}
		}
		return answer;
	}
}