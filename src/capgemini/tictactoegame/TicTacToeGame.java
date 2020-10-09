package capgemini.tictactoegame;

import java.util.Scanner;

/**
 * @author Mentalist
 *
 */
public class TicTacToeGame {
	static final int HEADS = 1;
	static final int TAILS = 0;
	static final String PLAYER = "Player starts first.";
	static final String COMPUTER = "Computer starts first";
	static char[] board;

	public static void main(String[] args) {
		board = createBoard();
		char playerChoice = selectLetter();
		showBoard();
		String firstMove = coinTossToDecideWhoGoesFirst();
		System.out.println("Coin Toss Result is : " + firstMove);
		if (firstMove == "Player") {
			int indexToMove = chooseIndex();
			desiredMove(indexToMove, playerChoice);
		}
		System.out.println(checkIfPlayerCouldWin(board, playerChoice));
		System.out.println("Checking Winner after Every move:" + winnerCheck(board, playerChoice));
		showBoard();
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
	 * 
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

	/**
	 * uc5 @ location @ playerMove
	 */
	public static void desiredMove(int location, char playerMove) {
		if (board[location] == ' ')
			board[location] = playerMove;
		else
			System.out.println("Index is not free.Choose another index for move");

	}

	/**
	 * uc6
	 * 
	 * @return
	 */
	public static String coinTossToDecideWhoGoesFirst() {
		int toss = (int) (Math.random() * 10) % 2;
		if (toss == TAILS)
			return PLAYER;
		else
			return COMPUTER;
	}

	/**
	 * uc7 playerChoice
	 * 
	 * @return
	 */
	public static boolean winnerCheck(char board[], char playerChoice) {
		if ((board[0] == playerChoice && board[1] == playerChoice && board[2] == playerChoice)
				|| (board[3] == playerChoice && board[4] == playerChoice && board[5] == playerChoice)
				|| (board[6] == playerChoice && board[7] == playerChoice && board[8] == playerChoice)
				|| (board[0] == playerChoice && board[3] == playerChoice && board[6] == playerChoice)
				|| (board[1] == playerChoice && board[4] == playerChoice && board[7] == playerChoice)
				|| (board[2] == playerChoice && board[5] == playerChoice && board[8] == playerChoice)
				|| (board[0] == playerChoice && board[4] == playerChoice && board[8] == playerChoice)
				|| (board[2] == playerChoice && board[4] == playerChoice && board[6] == playerChoice))
			return true;
		else
			return false;
	}

	/**
	 * uc8 
	 * board 
	 * playerChoice
	 * @return
	 */
	public static boolean checkIfPlayerCouldWin(char board[], char playerChoice) {
		char secondBoard[] = new char[10];
		for (int i = 0; i < 10; i++)
			secondBoard[i] = board[i];
		return winnerCheck(secondBoard, playerChoice);
	}

}
