package myAbalone.org;

import java.util.ArrayList;
import java.util.Scanner;

/*This Board class consists of three parts:
 * 	the main method handling the game progress (whose turn it is, if the game has ended etc.)
 * 	the GUI hubs currently called print and readMove
 * 	the move methods determining the possible moves
 * 
 * 	A move is described by an Array:
 * 	if the marbles are moved along the common line, the array has four entries:
 * 	[x,y,dx,dy] where (x,y) is the starting point of the line and [dx,dy] is the vector which the line follows
 * 	if the marbles form a line which is moved by a broadside move the array has 7 entries
 * 	[x,y,ox,oy,dx,dy,l] where the line has length l starting at (x,y) and going along (ox,oy) and is moved in the direction of (dx,dy)
 * */

public class Board{
    // Just some constants
    final int INVALID = -1;
    final int FREE = 0;
    final int WHITE = 1;
    final int BLACK = 2;
    final int[][] dir = {{-1,-1},{-1,0},{0,-1},{0,1},{1,1},{1,0}};
    final int[][] orientations = {{1,0},{1,1},{0,1}}; 
    final int[][] def = {
	    {2,2,2,2,2,-1,-1,-1,-1},
	    {2,2,2,2,2,2,-1,-1,-1},
	    {0,0,2,2,2,0,0,-1,-1},
	    {0,0,0,0,0,0,0,0,-1},
	    {0,0,0,0,0,0,0,0,0},
	    {-1,0,0,0,0,0,0,0,0},
	    {-1,-1,0,0,1,1,1,0,0},
	    {-1,-1,-1,1,1,1,1,1,1},
	    {-1,-1,-1,-1,1,1,1,1,1}
    };
    int cplayer;	// the current playes
    int[] selected;	// the current selection of marbles
    int[][] board;	// the current board positions

/*    // Main responsible for calling the appropriate Methods
    public static void main(String[] args){
	Board b = new Board();
	while(b.getMarbles(1).size() > 8 && b.getMarbles(2).size() > 8){
	    b.print();
	    int [] m = readMove();
	    if( b.isPossibleMove(m, b.getCPlayer())){
		b.move(m);
		b.setCPlayer(3 - b.getCPlayer());
	    }
	    else{
		System.out.println("Invalid move");
	    }
	}
    }*/
    public boolean isPossibleMove(int[] m, int cPlayer) {
	if(m.length == 4){
	    System.out.println("Line Attempt");
	    return isPossibleLineMove(m[0], m[1], m[2], m[3], cPlayer);
	}
	if(m.length == 7){
	    System.out.println("broad attempt");
	    return isPossibleBroadMove(m[0], m[1], m[2], m[3], m[4], m[5], m[6], cPlayer);
	}
	return false;
    }
    private static int[] readMove() {

	Scanner input = new Scanner(System.in);
	
	int[] ret = null ;
	do{
	    String c = input.next();
	    if(c.equals("l")){
		ret = new int[4];
		ret[0] = input.nextInt();
		ret[1] = input.nextInt();
		ret[2] = input.nextInt();
		ret[3] = input.nextInt();
	    }
	    else if(c.equals("b")){
		ret = new int[7];
		ret[0] = input.nextInt();
		ret[1] = input.nextInt();
		ret[2] = input.nextInt();
		ret[3] = input.nextInt();
		ret[4] = input.nextInt();
		ret[5] = input.nextInt();
		ret[6] = input.nextInt();
		}
	} while(ret == null);
	return ret;
    }
    // Initialisation of default Board
    public Board(){
	initDefault();
    }
    // Set default values
    private void initDefault() {
	this.cplayer = 1;
	this.selected = null;
	this.board = def;
    }
    public int[][] getBoard(){
	return this.board;
    }

    // Set a single field to value v
    public void setField(int x,int y, int v){
	try {
	    if(this.getField(x, y) != INVALID){
		this.board[y][x] = v;}
	} catch (Exception e) {
	}
    }
    // Get a single value
    public int getField(int x, int y){
	try {
	    return board[y][x];
	} catch (Exception e) {
	    return INVALID;
	}
    }
    public int getCPlayer(){
	return this.cplayer;
    }
    public void setCPlayer(int p){
	this.cplayer = p;
    }

    // Print the whole board
    public void print(){
	System.out.println(this.getCPlayer());
	for(int y = 0; y < this.board.length; y++){
	    System.out.print(new String(new char[Math.abs(y-4)]).replace("\0", " "));
	    for(int x = 0; x < this.board[y].length; x++){
		if(board[y][x]!=-1){System.out.print(board[y][x] + " ");}
	    }
	    System.out.println();
	}
    }
    // Get the marbles of a single player
    public ArrayList<int[]> getMarbles(int player){
	ArrayList<int[]> ret = new ArrayList<int[]>();
	for(int y = 0; y < this.board.length; y++){
	    for(int x = 0; x < this.board[y].length; x++){
		if(board[y][x] == player){
		    int[] pair = {x,y};
		    ret.add(pair);
		}
	    }
	}
	return ret;
    }
    // Get all possible Moves for player p
    public ArrayList<int[]> getMoves(int player){
	ArrayList<int[]> moves = new ArrayList<int[]>();
	moves.addAll(this.getLineMoves(player));
	moves.addAll(this.getBroadSideMoves(player));
	return moves;
    }
    // Get the possible broadside moves
    private ArrayList<int[]> getBroadSideMoves(int player) {
	ArrayList<int[]> moves = new ArrayList<int[]>();
	for(int[] marble : getMarbles(player)){			// For every marble of the player
	    for(int[] d : dir){
		for(int[] or: orientations){

		    if(isPossibleBroadMove(marble[0], marble[1], or[0], or[1], d[0], d[1] , 2, player)){
			int[] move = {marble[0], marble[1], or[0], or[1], d[0], d[1], 2};
			moves.add(move);
		    }
		    if(isPossibleBroadMove(marble[0], marble[1], or[0], or[1], d[0], d[1] , 3, player)){
			int[] move = {marble[0], marble[1], or[0], or[1], d[0], d[1], 3};
			moves.add(move);
		    }
		}
	    }
	}
	return moves;
    }
    private boolean isPossibleBroadMove(int x, int y, int ox, int oy, int dx, int dy, int length, int p) {
	for(int i = 0; i< length;i++){
	    int f = this.getField(x + i*ox, y + i*oy);
	    int off = this.getField(x + i*ox + dx, y + i*oy + dy);
	    if(f != p || off != FREE){
		return false;
	    }
	}
	return true;
    }
    // Get the possile moves along a line
    public ArrayList<int[]> getLineMoves(int player) {
	ArrayList<int[]> moves = new ArrayList<int[]>();	// List accumulating all the moves
	for(int[] marble : getMarbles(player)){			// For every marble of the player
	    for(int[] d : dir){					// ...check every off the possible directions
		if(isPossibleLineMove(marble[0], marble[1],d[0],d[1], player)){
		    int[] move = {marble[0], marble[1],  d[0], d[1]};
		    moves.add(move);
		}
	    }
	}
	return moves;
    }
    private boolean isPossibleLineMove(int x, int y, int dx, int dy, int p) {
	if(this.getField(x, y) != p){return false;}
	int[] d = {dx, dy};
	if(!isDir(d)){return false;}
	int f1 = this.getField(x + dx, y + dy);
	if(f1 == FREE){	// if the field is free add the move
	    return true;
	}
	else if(f1==INVALID){return false;}	// if the next field is invalid break
	else if(f1 == p){		// if the next field is occupied by the player's own marble
	    int f2 = this.getField(x + 2*dx, y + 2*dy);

	    // ############### TWO IN A ROW ###############
	    if(f2 == FREE){		// if it is free add the move
		return true;
	    }
	    else if(f2==INVALID){return false;}	// if the field is invalid break
	    else if(f2!=p){		// if it is occupied by the player's opponent
		int f3 = this.getField(x + 3*dx, y + 3*dy);
		if(f3 ==FREE || f3 ==INVALID){
		    return true;
		}
	    }
	    else{
		// ############### THREE IN A ROW ###############

		int f3 = this.getField(x + 3*dx, y + 3*dy);
		int f4 = this.getField(x + 4*dx, y + 4*dy);
		int f5 = this.getField(x + 5*dx, y + 5*dy);
		if(f3 == INVALID || f3 == p){
		    return false;
		}
		else if (f3 == FREE){
		    return true;
		}
		else{
		    if(f4 == FREE || f4 == INVALID){
			return true;
		    }
		    else if(f4 == p){return false;}
		    else{
			if(f5 == INVALID || f5 == FREE){
			    return true;
			}
		    }
		}
	    }
	}
	return false;
    }
    private boolean isDir(int[] d) {
	for(int[] di:dir){
	    if(di[0] == d[0] && di[1] == d[1]){return true;}
	}
	return false;
    }
    // Apply the move described by m
    public int move(int[] m){
	int cx = m[0];
	int cy = m[1];
	int tmp = 0;
	int tmpn;
	int c = 0;
	if(m.length == 4){				//move along a line {x,y,dx,dy}
	    do {
		tmpn = getField(cx, cy);
		setField(cx, cy, tmp);
		cx += m[2];
		cy += m[3];
		tmp = tmpn;
		c++;
	    } while (tmp!=0);
	}
	else{						// broadside move
	    for(int i = 0; i< m[6];i++){
		this.setField(m[0] + i*m[2], m[1] + i*m[3], FREE);
		this.setField(m[0] + i*m[2] + m[4], m[1] + i*m[3] + m[5], this.getCPlayer());
	    }
	}
	return c;
    }
    //reverses the move m
    public int[] reverse(int[] m, int l) {
	int[] rev = new int[m.length];
	if(m.length == 4){
	    rev[0] = m[0] + l * m[2];
	    rev[1] = m[1] + l * m[3];
	    rev[2] = -m[2];
	    rev[3] = -m[3];
	}
	else{
	    rev[0] = m[0] + l * m[2];
	    rev[1] = m[1] + l * m[3];
	    rev[2] = -m[2];
	    rev[3] = -m[3];
	    rev[4] = m[0] + l * m[2];
	    rev[5] = m[1] + l * m[3];
	    rev[6] = -m[2];

	}
	return rev;
    }
}
