package capgemini.tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
	public static void main(String[] args) {
		char[] board = createBoard();
		selectLetter();
		showBoard(board);

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

	/**
	 * uc2
	 */
	public static void selectLetter() {
		System.out.println("Enter  the letter X or O:");
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		if (choice == 'O')
			System.out.println("Player has choosen " + choice + " and Computer has to choose X");
		else
			System.out.println("Player has choosen " + choice + " and Computer has to choose O");

	}

	/**
	 * uc3
	 */
	public static void showBoard(char[] board) {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");

	}

}
