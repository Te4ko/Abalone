
public class PrintBoard {

	int i = 0;
	int j = 0;
	
	public void printBoard(int board[][], int player){
	
		// print the board  
	    for(i = 0; i <= 9; i++) System.out.print(i + " ");
	    for(i = 10; i <= 16; i++) System.out.print(i);
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
		// end of 'print the board'
		
		System.out.println("Player " + player + ":");
	}
}
