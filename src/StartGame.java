import java.util.*;

public class StartGame {
	
	public static void main(String args[]){
		
		//declarations 
		ConstructStandardBoard gameBoard = new ConstructStandardBoard();
		int board[][] = gameBoard.getBoard();			//initialize the board
		
				
		int x[] = new int[3];
		int y[] = new int[3];
		
		
		String movement; 	//args[6];
		int player = 0;
		
		int i = 0;
		int j = 0;
		
		int turn = 0;
		//end of declarations
		
	
		//TODO If player inserts illegal move, don't turn to the next
		
		
		GameMoves newBoard = new GameMoves();		//initialize the board
		
		PrintBoard print = new PrintBoard();		//initialize the print function

		
		// play for a number of turns
		// TODO keep a count
		
		Scanner scan = new Scanner(System.in);		//get the input
		String input = null;
		String[] parts = null;
		
		turn = 0;
		
		while(turn < 5){
			print.printBoard(board, turn%2+1);
			
			input = scan.nextLine();
			parts = input.split(" ");
			
			x[0] = Integer.parseInt(parts[0]);
			y[0] = Integer.parseInt(parts[1]);
			x[1] = Integer.parseInt(parts[2]);			// get the values
			y[1] = Integer.parseInt(parts[3]);
			x[2] = Integer.parseInt(parts[4]);
			y[2] = Integer.parseInt(parts[5]);
			
			movement = parts[6];
			
			board = newBoard.gameMoves(turn%2+1, board, x, y, movement);
			if(turn%2+1 != newBoard.getPlayerTurn())
				turn++;
			}
		
		}
	
}
