public class ConstructStandardBoard{
		int board[][] = new int[9][17];		//char board[][] = new char[9][17];
		
		int player1 = 1;		//char player1 = 'O';
		int player2 = 2;		//char player2 = '@';
		int emptySpace = 0;		//char emptySpace = ' ';
		
		ConstructStandardBoard(){
		
		for(int i = 0; i <= 8; i++)
			for(int j = 0; j <= 16; j++)
				board[i][j] = emptySpace;
		
		for(int i = 4; i <= 12; i+=2){
			board[0][i] = player1;
			board[8][i] = player2;
		}
			
		for(int i = 3; i <= 13; i+=2){
			board[1][i] = player1;
			board[7][i] = player2;
		}
		
		for(int i = 6; i <= 10; i+=2){
			board[2][i] = player1;
			board[6][i] = player2;
		}	
		
	}
	
	public int[][] getBoard(){		//public char[][] getBoard(){
		return board;
	} 
	
/*		for(int i = 0; i<=8; i++){
      System.out.print('{');
			for(int j = 0; j<=16; j++)
				System.out.print(board[i][j] + ",");
			System.out.println("},");
		}*/
	}

