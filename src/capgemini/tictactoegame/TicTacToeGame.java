package capgemini.tictactoegame;

public class TicTacToeGame {
	public static void main(String[] args) {
		createBoard();
	}

	/**
	 * uc1
	 * 
	 * @return
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

}
