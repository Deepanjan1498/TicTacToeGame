package capgemini.tictactoegame;

import java.util.Scanner;

/**
 * @author Mentalist
 *
 */
public class TicTacToeGame {
	static char[] board;

	public static void main(String[] args) {
		board = createBoard();
		selectLetter();
		showBoard();
		chooseIndex();

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
	public static char selectLetter() {
		System.out.println("Enter  the letter X or O:");
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		if (choice == 'O')
			System.out.println("Player has choosen " + choice + " and Computer has to choose X");
		else
			System.out.println("Player has choosen " + choice + " and Computer has to choose O");
		return choice;
	}

	/**
	 * uc3
	 */
	public static void showBoard() {
		System.out.println("/---|---|---\\");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("/---|---|---\\");

	}

	/**
	 * uc4
	 * @return
	 */
	public static int chooseIndex() {

		System.out.println("Enter the location you want to move to :");
		Scanner s = new Scanner(System.in);
		int index = s.nextInt();
		if (board[index] == ' ')
			System.out.println("Index is free");
		else
			System.out.println("Choose another index");
		return index;
	}
	
	

}
