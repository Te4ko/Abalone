class Board{
    private int board[][];
    Board(int i, int j){
  board = new int[i][j];
	for(int p=0;p<i;p++)
	    for(int q=0;q<j;q++)
		board[p][q]=-2;  //Due to some combinations not making sense
	for(int p=-(Math.abs(i/2));p<=0;p++)
	    for(int q=-(Math.abs(j/2));q<=p+i/2;q++)
		board[p+i/2][q+j/2]=0;
	for(int p=1;p<=i/2;p++)
	    for(int q=-(Math.abs(j/2))+p;q<=j/2;q++)
		board[p+i/2][q+j/2]=0;//Init of board
	for(int p=0;p<i;p++)
	    for(int q=0;q<j;q++)
		if(board[p][q]==0&&(q-p)>2||(p>=2&&p<=4&&q>=4&&q<=6&&Math.abs(p-q)>1)) board[p][q]=-1;//Init of white marbles (upper part of board) I know it's bad and doesn't cover the general case. If someone comes up with a better idea I am up for it.
	for(int p=0;p<i;p++)
	    for(int q=0;q<j;q++)
		if(board[p][q]==0&&(p-q)>2||(q>=2&&q<=4&&p>=4&&p<=6&&Math.abs(p-q)>1)) board[p][q]=1;//Init of black marbles
    }
    public int get(int i,int j){
	    return board[i][j];
    }
    public void set(int i,int j,int v){
	if(board[i][j]!=-2)
	    board[i][j]=v;
	else System.out.println("Invalid set location!");
    }
}

interface Marble{
    int pos[][] = new int[14][2];
    int[] getPos(int i);
    void select(int i,int j);
    void setPos(int i,int a,int b);
}

class WhiteMarbles implements Marble {
    private int pos[][] = new int[14][3];
    private Board board;
    WhiteMarbles(int i,int j){
	board = new Board(i,j);
	int s=0;
	for(int p=0;p<i;p++)
	    for(int q=0;q<j;q++){
		if(board.get(p,q)==-1){
		    pos[s][0]=p;
		    pos[s][1]=q;
		    pos[s][2]=0;
		    s++;
		}
	    }
    }
    public int[] getPos(int i){
	return pos[i];
    }
    public void select(int i,int j){
	int c=0;
	for(int p=0;p<14;p++)
	    if(pos[p][2]==2)
		c++;
	if(c>3) System.out.println("You can't select more marbles!");
	else{
	    if(board.get(i,j)==-1) board.set(i,j,2);
	    for(int p=0;p<14;p++)
		if(pos[p][0]==i)
		    if(pos[p][1]==j)
			pos[p][2]=2;}
    }//select is given the coordinates of a marble to be selected. It first checks if you can select more marbles, then it checks if the marble is of the correct kind and then it selects it.
    public void setPos(int i,int a,int b){
	if(pos[i][2]==2)
	    if(Math.abs(pos[i][0]-a)<2&&a>=0&&a<=8&&Math.abs(pos[i][1]-b)<2&&b>=0&&b<=8)
		{
		    pos[i][0]=a;
		    pos[i][1]=b;
		    pos[i][2]=0;
		}
	    else System.out.println("Not a valid move!");
	else System.out.println("Marble not selected!");
    }//setPos is given the number of a marble, it first checks if the marble is selected, then checks if the move is valid and then it makes the move.
    
}
	
class BlackMarbles implements Marble {
    private int pos[][] = new int[14][3];
    private Board board;
    BlackMarbles(int i,int j){
	board = new Board(i,j);
	int s=0;
	for(int p=0;p<i;p++)
	    for(int q=0;q<j;q++){
		if(board.get(p,q)==1){
		    pos[s][0]=p;
		    pos[s][1]=q;
		    pos[s][2]=0;
		    s++;
		}
	    }
    }
    public int[] getPos(int i){
	return pos[i];
    }
    public void select(int i,int j){
	int c=0;
	for(int p=0;p<14;p++)
	    if(pos[p][2]==2)
		c++;
	if(c>3) System.out.println("You can't select more marbles!");
	else{
	    if(board.get(i,j)==1) board.set(i,j,2);
	    for(int p=0;p<14;p++)
		if(pos[p][0]==i)
		    if(pos[p][1]==j)
			pos[p][2]=2;}
    }//select is given the coordinates of a marble to be selected. It first checks if you can select more marbles, then it checks if the marble is of the correct kind and then it selects it.
    public void setPos(int i,int a,int b){
	if(pos[i][2]==2)
	    if(Math.abs(pos[i][0]-a)<2&&a>=0&&a<=8&&Math.abs(pos[i][1]-b)<2&&b>=0&&b<=8)
		{
		    pos[i][0]=a;
		    pos[i][1]=b;
		    pos[i][2]=0;
		}
	    else System.out.println("Not a valid move!");
	else System.out.println("Marble not selected!");
    }//setPos is given the number of a marble, it first checks if the marble is selected, then checks if the move is valid and then it makes the move.
    
}
    

public class SimpleBoard2{
    public static void main(String[] args){
	/*Board test = new Board(9,9);
	for(int i=0;i<9;i++)
	    for(int j=0;j<9;j++)
		if(test.get(i,j)==1) System.out.println(i+" "+j);
		System.out.println(test.get(0,5));*/
	WhiteMarbles test = new WhiteMarbles(9,9);
	test.select(0,3);
	System.out.println(test.getPos(0)[0]+" "+test.getPos(0)[1]+" "+test.getPos(0)[2]);
	test.setPos(0,1,3);
	System.out.println(test.getPos(0)[0]+" "+test.getPos(0)[1]+" "+test.getPos(0)[2]);
    }
}
		
		
	
	
