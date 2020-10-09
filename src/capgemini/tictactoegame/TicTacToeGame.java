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

	/**
	 * uc13 args
	 */
	public static void main(String[] args) {
		Scanner sb = new Scanner(System.in);
		while (true) {
			System.out.println("Do you want to play another Game?(Y/N)");
			char answer = sb.next().charAt(0);
			if (answer == 'Y')
				Game();
			else
				System.out.println("Thank you for Playing");
		}
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
	public static void desiredMove(char[] board, int location, char playerMove) {
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
	public static String winnerCheck(char board[], char playerChoice) {
		int i = 0;
		int counter = 0;
		if ((board[0] == playerChoice && board[1] == playerChoice && board[2] == playerChoice)
				|| (board[3] == playerChoice && board[4] == playerChoice && board[5] == playerChoice)
				|| (board[6] == playerChoice && board[7] == playerChoice && board[8] == playerChoice)
				|| (board[0] == playerChoice && board[3] == playerChoice && board[6] == playerChoice)
				|| (board[1] == playerChoice && board[4] == playerChoice && board[7] == playerChoice)
				|| (board[2] == playerChoice && board[5] == playerChoice && board[8] == playerChoice)
				|| (board[0] == playerChoice && board[4] == playerChoice && board[8] == playerChoice)
				|| (board[2] == playerChoice && board[4] == playerChoice && board[6] == playerChoice))
			return "WIN";
		for (i = 0; i < 10; i++) {
			if (board[i] != ' ')
				counter++;
		}
		if (counter == 9)
			return "TIE";
		else
			return "TURN";
	}

	/**
	 * uc8 board playerChoice
	 * 
	 * @return
	 */
	public static int checkIfPlayerCouldWinAndGetIndex(char board[], char playerChoice) {
		int index;
		char secondBoard[] = new char[10];
		for (int i = 0; i < 10; i++) {
			secondBoard[i] = board[i];
			if (secondBoard[i] == ' ') {
				secondBoard[i] = playerChoice;
				if (winnerCheck(secondBoard, playerChoice).matches("WIN")) {
					index = i;
					return index;
				}
			}
		}
		return 0;
	}

	/**
	 * uc9 board opponentChoice
	 * 
	 * @return
	 */
	public static int computerPlayToBlockWin(char board[], char opponentChoice) {
		int index = 0;
		char secondBoard[] = new char[10];
		for (int i = 0; i < 10; i++) {
			secondBoard[i] = board[i];
			if (secondBoard[i] == ' ') {
				secondBoard[i] = opponentChoice;
				if (winnerCheck(secondBoard, opponentChoice).equals("WIN")) {
					index = i;
					return index;
				} else
					secondBoard[i] = ' ';
			}
		}
		return 0;
	}

	/**
	 * uc10 board
	 * 
	 * @return
	 */
	public static int computerMoveForOneOfAvailableCorners(char board[]) {
		int index = 0;
		int cornerIndex[] = { 0, 2, 6, 8 };
		for (int i = 0; i < 4; i++) {
			if (board[cornerIndex[i]] == ' ')
				index = cornerIndex[i];
		}
		return index;
	}

	/**
	 * uc11
	 * 
	 * @board
	 * @return
	 */
	public static int computerSubsequentChoices(char board[]) {
		int index = 4;
		if (board[index] == ' ')
			index = 4;
		else {
			for (int i = 1; i <= 8; i = i + 2) {
				if (board[i] == ' ') {
					index = i;
					break;
				}
			}
		}
		return index;
	}

	/**
	 * uc12
	 */
	public static void Game() {
		board = createBoard();
		int turnsNo = 1;
		char playerChoice = selectLetter();
		char computerChoice;
		char playingSide;
		if (playerChoice == 'X')
			computerChoice = 'O';
		else
			computerChoice = 'X';
		String firstMove = coinTossToDecideWhoGoesFirst();
		if (firstMove == "PLAYER")
			playingSide = playerChoice;
		else
			playingSide = computerChoice;
		System.out.println("Coin Toss Result is : " + firstMove + " begins the game.");
		while (turnsNo <= 9) {
			turnsNo++;
			if (playingSide != computerChoice) {
				int index = chooseIndex();
				desiredMove(board, index, playerChoice);
			} else {
				if (checkIfPlayerCouldWinAndGetIndex(board, computerChoice) != 0)
					desiredMove(board, checkIfPlayerCouldWinAndGetIndex(board, computerChoice), computerChoice);
				else if (computerPlayToBlockWin(board, playerChoice) != 0) {
					desiredMove(board, computerPlayToBlockWin(board, playerChoice), computerChoice);
				} else {
					int index = computerMoveForOneOfAvailableCorners(board);
					if (index == 0)
						index = computerSubsequentChoices(board);
					desiredMove(board, index, computerChoice);
				}
			}
			showBoard();
			if (winnerCheck(board, playingSide) == "WIN") {
				if (playingSide == computerChoice)
					System.out.println("Computer is Winner");
				else
					System.out.println("Player is Winner");
			} else
				System.out.println(winnerCheck(board, playingSide));
			if (playingSide == 'X')
				playingSide = 'O';
			else
				playingSide = 'X';
		}
	}
}
