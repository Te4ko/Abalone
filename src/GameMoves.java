
public class GameMoves {
	
	int player1 = 1;		
	int player2 = 2;		
	int emptySpace = 0;	
	int playerState = 0;
	
	int playerMarbles;
	int opponentMarbles;
	
	
	int result = 0;
	public int[][] gameMoves(int player, int board[][], int[] x, int y[], String movement){
		
		ValidMove verification = new ValidMove();  //initialize the verification function
		
		
		playerState = 20;
		
		//TODO LEFT & RIGHT cases malfunction from time to time, look into them
		
		
		//count marbles for player
		playerMarbles = 0;
		if(x[0] != -1) playerMarbles ++;
		if(x[1] != -1) playerMarbles ++;
		if(x[2] != -1) playerMarbles ++;
		
		
		//switch case
		Cases currentCase = Cases.valueOf(movement.toUpperCase()); 

	      switch (currentCase) {
	          case LEFT:
	        	  if (x[1] != -1 || board[x[0]][y[0]] == emptySpace || board[x[0]][y[0]-2] != emptySpace) 
	        		  if(result == 0){
		        		  System.out.println("Illegal Move");
		        	  	  playerState = player;
		        	  }
	        	  else {
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]][y[0]-2] = player;
	        	  }
	        	  break;
	        	  
	          case RIGHT:
	        	  if (x[1] != -1 || board[x[0]][y[0]] == emptySpace || board[x[0]][y[0]+2] != emptySpace) 
	        		  if(result == 0){
		        		  System.out.println("Illegal Move");
		        	  	  playerState = player;
		        	  }
	        	  else {
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]][y[0]+2] = player;
	        	  }
	        	  break;
	        	  
	          case UPLEFT:
	      		  result = verification.validMove(player,board, x, y, 11);
	      		  if(result == 0){
	        		  System.out.println("Illegal Move");
	        	  	  playerState = player;
	        	  }	  
	        	  else{
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]-1][y[0]-1] = player;
	        		  if(x[1] != -1) {
	        			  board [x[1]][y[1]] = emptySpace;
	        			  board [x[1]-1][y[1]-1] = player;
	        		  }
	        		  if(x[2] != -1) {
	        			  board [x[2]][y[2]] = emptySpace;
	        			  board [x[2]-1][y[2]-1] = player;
	        		  }
	        	  }
	        	  break;
	        	  
	          case UPRIGHT:
	      		  result = verification.validMove(player,board, x, y, 12);
	        	  if(result == 0){
	        		  System.out.println("Illegal Move");
	        	  	  playerState = player;
	        	  }	  
	        	  else{
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]-1][y[0]+1] = player;
	        		  if(x[1] != -1) {
	        			  board [x[1]][y[1]] = emptySpace;
	        			  board [x[1]-1][y[1]+1] = player;
	        		  }
	        		  if(x[2] != -1) {
	        			  board [x[2]][y[2]] = emptySpace;
	        			  board [x[2]-1][y[2]+1] = player;
	        		  }
	        	  }
	        	  break;
	        	  
	          case DOWNLEFT:
	        	  result = verification.validMove(player, board, x, y, 21);
	        	  if(result == 0){
	        		  System.out.println("Illegal Move");
	        	  	  playerState = player;
	        	  }	  
	        	  else{
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]+1][y[0]-1] = player1;
	        		  if(x[1] != -1) {
	        			  board [x[1]][y[1]] = emptySpace;
	        			  board [x[1]+1][y[1]-1] = player1;
	        		  }
	        		  if(x[2] != -1) {
	        			  board [x[2]][y[2]] = emptySpace;
	        			  board [x[2]+1][y[2]-1] = player1;
	        		  }
	        	  }
	        	  break;
	        	  
	          case DOWNRIGHT:
	        	  result = verification.validMove(player, board, x, y, 22);
	        	  if(result == 0){
	        		  System.out.println("Illegal Move");
	        	  	  playerState = player;
	        	  }	  
	        	  else{
	        		  board [x[0]][y[0]] = emptySpace;
	        		  board [x[0]+1][y[0]+1] = player1;
	        		  if(x[1] != -1) {
	        			  board [x[1]][y[1]] = emptySpace;
	        			  board [x[1]+1][y[1]+1] = player1;
	        		  }
	        		  if(x[2] != -1) {
	        			  board [x[2]][y[2]] = emptySpace;
	        			  board [x[2]+1][y[2]+1] = player1;
	        		  }
	        	  }
	        	  break;
	        	  
	      }
		
	      return board;
		
		//end of switch case
		
		
		/*// print the board
		
	      
	    for(i = 0; i <= 10; i++) System.out.print(i + " ");
	    for(i = 11; i <= 15; i++) System.out.print(i);
	    System.out.println();
	    
		for(i = 0; i <= 8; i++){
			for (j = 0; j <= 16; j++){
				if (board[i][j] == 1) 
					System.out.print("O" + "|");
				else if (board[i][j] == 2) 				//conversion from int to 
					System.out.print("@" + "|");		//char to look prettier
				else System.out.print(" " + "|");
				
			}
			System.out.println(i);
		}
		// end of 'print the board'*/
		
	}

	public int getPlayerTurn(){
		return playerState;
	}
	
	
	public enum Cases{
		LEFT,
		RIGHT,
		UPLEFT,
		UPRIGHT,
		DOWNLEFT,
		DOWNRIGHT
	}
	
	
}
