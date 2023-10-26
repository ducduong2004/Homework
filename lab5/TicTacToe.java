package lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	
	

	public TicTacToe(char[][] board) {
		super();
		this.board = board;
	}


	/*
	 * This method checks all rows and returns true if any of 
		them are marked with
	 * all of a single player's markers.
	 * Otherwise, returns false.
	 */
	public boolean checkRows() {
		int len = board.length;

		for(int row = 0; row < board.length; row++) {
			int count = 0;
			for(int col = 0; col < board[0].length; col++) {
				switch (board[row][col]) {
				case 'x':
				{
					++count;
					System.out.println(count);
					break;
				}
				case 'o':{
					--count;
					System.out.println(count);
					break;
				}

				}
			}
			if(count == len || count == -1 * len)
				return true;
		}

		return false;
	}


	/*
	 * This method checks all columns and returns true if any 
	of them are marked
	 * with all of a single player's.
	 * Otherwise, returns false.
	 */
	public boolean checkColumns() {
		int len = board.length;
		for(int col = 0; col < board.length; col++) {
			int count = 0;
			for(int row = 0; row < board[0].length; row++) {
				switch (board[row][col]) {
				case 'x':
				{
					++count;
					System.out.println(count);
					break;
				}
				case 'o':{
					--count;
					System.out.println(count);
					break;
				}

				}
			}
			if(count == len || count == -1 * len)
				return true;
		}

		return false;
	}

	/*
	 * This method checks both diagonals and returns true if 
	any of them are marked
	 * with all of a single player's markers. Otherwise, 
	returns false.
	 */
	public boolean checkDiagonals() {
		int len = board.length;
		int count = 0;
		for(int n = 0; n < len; n++)
		{
			switch (board[n][n]) {
			case 'x':
			{
				++count;
				System.out.println(count);
				break;
			}
			case 'o':{
				--count;
				System.out.println(count);
				break;
			}

			}
			if(count == len || count == -1 * len)
				return true;
		}
		
		count = 0;
		
		for(int i = 0; i < len; i++) {
			switch (board[len-i-1][i]) {
			case 'x':
			{
				++count;
				System.out.println(count);
				break;
			}
			case 'o':{
				--count;
				System.out.println(count);
				break;
			}

			}
			if(count == 3 || count == -3)
				return true;
		}
		
		return false;
	}



	public static void main(String[] args) {
		char[][] charArr = {{'x','a','a','a'},
							{'a','x','a','a'},
							{'a','a','x','a'},
							{'a','a','a','x'}};

		TicTacToe test = new TicTacToe(charArr);
		System.out.println(test.checkRows());
		System.out.println(test.checkColumns());
		System.out.println(test.checkDiagonals());


	}
}


