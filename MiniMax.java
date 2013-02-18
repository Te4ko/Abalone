package Abalone;

class MiniMax{
    
    final int[] weight = {1,1,1,1,1,1,1};
        
    public int eval(int[][] board){
      int result = 0;
      result += weight[0]*gameResult(board);
      result += weight[1]*marbles(board);
      result += weight[2]*centreDistance(board);
      result += weight[3]*myGrouping(board);
      result += weight[4]*enemyGrouping(board);
      result += weight[5]*gameResult(board);
      result += weight[6]*gameResult(board);
      return result;
    }

    public int max(int[][] board, int depth){
        if(depth = 0){
          return eval(board);
        }
        else{
          int[][][] moves = board.getMoves();
          int[] values = new int[board];
          for(int i = 0; i < moves.length;i++){
            values[i]=min(board.apply(moves[i]), depth-1);
          }
          return max(values);
        }
    }
        
    public int min(int[][] board, int depth){
        if(depth = 0){
          return eval(board);
        }
        else{
          int[][][] moves = board.getMoves();
          int[] values = new int[board];
          for(int i = 0; i < moves.length;i++){
            values[i]=max(board.apply(moves[i]), depth-1);
          }
          return min(values);
        }
    }
    
    public int gameResult(int[][] board){
        return 1;
    }
    public int marbles(int[][] board){
        return 1;
    }
    public int centreDistance(int[][] board){
        return 1;
    }
    public int myGrouping(int[][] board){
        return 1;
    }
    public int enemyGrouping(int[][] board){
        return 1;
    }
    public int myAttack(int[][] board){
        return 1;
    }
    public int enemyAttack(int[][] board){
        return 1;
    }    
}
