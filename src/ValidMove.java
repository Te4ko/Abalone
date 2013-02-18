
public class ValidMove {
	
	int player1 = 1;		//char player1 = 'O';
	int player2 = 2;		//char player2 = '@';
	int emptySpace = 0;		//char emptySpace = ' ';
	
	
	// MOVEMENT CODES are as follows:
	// UPLEFT 	-- 11
	// UPRIGHT 	-- 12
	// DOWNLEFT -- 21
	// DOWNRIGHT-- 22
	
	
	//TODO --- For ATTACK CASES:
	//		--- Count how many MARBLES each player has
	//		--- if attackingPlayer <= attackedPlayer -- Illegal move
	//		  --- else move the marbles in all positions - ADD an opponent marble in the specified place &
	//													 - Overlap a player marble on the opponent
	//
	//		  --- if the opponent goes out of the board, countP1++;
	// 		- add exception for valid move
	
	
	OrderCompare compare = new OrderCompare();
	
	//test valid moves
	public int validMove(int player, int board[][], int x[], int y[], int movement){
		
		
		if(movement == 11){ //UPLEFT
			
			x = compare.orderCompare(x,"inc");
			y = compare.orderCompare(y,"inc");

			if(x[2] != -1 && (board[x[2]][y[2]] == emptySpace || board[x[2]-1][y[2]-1] != player)) return 0;
			if(x[1] != -1 && (board[x[1]][y[1]] == emptySpace || board[x[1]-1][y[1]-1] != player)) return 0;
			if(board[x[0]][y[0]] == emptySpace || board[x[0]-1][y[0]-1] == player) return 0;
			
			return 1;
			// WE HAVE:
			// UPLEFT - if 3 - move the third
			//		  - if > 2 - move the second
			//		  - if >= 1 - move the marble
		}
		
		else if(movement == 12){ //UPRIGHT
			
			x = compare.orderCompare(x,"inc");
			y = compare.orderCompare(y,"dec");
			
			if(x[2] != -1 && (board[x[2]][y[2]] == emptySpace || board[x[2]-1][y[2]+1] != player)) return 0;
			if(x[1] != -1 && (board[x[1]][y[1]] == emptySpace || board[x[1]-1][y[1]+1] != player)) return 0;
			if(board[x[0]][y[0]] == emptySpace || board[x[0]-1][y[0]+1] == player) return 0;
			
			return 1;	
		}
		
		else if(movement == 22){ //DOWNRIGHT
			
			x = compare.orderCompare(x,"dec");
			y = compare.orderCompare(y,"dec");
			
			if(x[2] != -1 && (board[x[2]][y[2]] == emptySpace || board[x[2]+1][y[2]+1] != player)) return 0;
			if(x[1] != -1 && (board[x[1]][y[1]] == emptySpace || board[x[1]+1][y[1]+1] != player)) return 0;
			if(board[x[0]][y[0]] == emptySpace || board[x[0]+1][y[0]+1] == player) return 0;
			
			return 1;	
		}
		
		else if(movement == 21){ //DOWNLEFT
			
			x = compare.orderCompare(x,"dec");
			y = compare.orderCompare(y,"inc");
			
			if(x[2] != -1 && (board[x[2]][y[2]] == emptySpace || board[x[2]+1][y[2]-1] != player)) return 0;
			if(x[1] != -1 && (board[x[1]][y[1]] == emptySpace || board[x[1]+1][y[1]-1] != player)) return 0;
			if(board[x[0]][y[0]] == emptySpace || board[x[0]+1][y[0]-1] == player) return 0;
			
			return 1;	
		}
		
		return 1;
		
	}
}
