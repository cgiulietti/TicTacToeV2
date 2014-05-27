package Game;

import TicTacToeUtils.*;

public class TicTacToeLogicImpl implements TicTacToeLogic {

   protected static final int EMPTY_CELL = 0;
   protected static final int PLAYER1_CELL = 1;
   protected static final int PLAYER2_CELL = 2;
   
   private boolean currentPlayer;
   private boolean isGameOver;
   private Boolean winner = null;
   private int[][] grid = new int[TicTacToeUI.GRID_SIZE][TicTacToeUI.GRID_SIZE];

   public TicTacToeLogicImpl() {
      super();
      
      /* initialize the grid */
      for (int i=0; i<TicTacToeUI.GRID_SIZE; i++){
         for (int j=0; j<TicTacToeUI.GRID_SIZE; j++){
            grid[i][j] = EMPTY_CELL;
         }
      }
      
      /* start with player 1 */
      currentPlayer = PLAYER1;
      
      isGameOver = false;
   }
   
   @SuppressWarnings("finally")
   @Override
   public boolean makeMoveAndCheckIfOver( int x, int y ){

      try{
         if ( grid[x][y] == EMPTY_CELL ){

            if ( currentPlayer == PLAYER1 ){
               grid[x][y] = PLAYER1_CELL;
            }else{
               grid[x][y] = PLAYER2_CELL;
            }

            /* check if game is won by player after the move,
             * or if it is tied
             */
            if ( checkIfCurrentPlayerWon() ){
               isGameOver = true;
               winner = new Boolean(currentPlayer);
            }else if ( checkIfTiedGame() ){
               isGameOver = true;
            }

            /* finally change the player */
            changePlayer();

         }
      }catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Invalid coordinates! Grid size is "+TicTacToeUI.GRID_SIZE);
      }finally{
         return isGameOver;
      }

   }

   @Override
   public String getWinnerName() {
	   String player = "No winner";

	   try{
		   if ( winner == PLAYER1 ){
			   player = "Player1";
		   }

		   if ( winner == PLAYER2 ){
			   player = "Player2";
		   }
	   }catch(NullPointerException e){}

	   return player;
   }

   @Override
   public boolean getLastPlayerMadeMove() {
	   return !currentPlayer;
   }

   @Override
   public Boolean getWinner() {
	   return winner;
   }
   
   
   /*  
    * internal methods (the ones with package accessibility are set so for testing purposes)
    */
   
   private void changePlayer( ){ 

	   if ( currentPlayer == PLAYER1 ){
		   currentPlayer = PLAYER2;
	   }else{
		   currentPlayer = PLAYER1;
	   }

   }

   boolean checkIfCurrentPlayerWon() {

	   int currPlayerCell;
	   int row, col;

	   if ( currentPlayer == PLAYER1 ){
		   currPlayerCell = PLAYER1_CELL;
	   }else{
		   currPlayerCell = PLAYER2_CELL;
	   }

	   /* 
	    * There is no need to check starting from each cell, it is sufficient
	    * to check just the first row and column and all possible winning
	    * combinations will be checked
	    */

	   /* check on first row */
	   row = 0;
	   for (col = 0; col < TicTacToeUI.GRID_SIZE; col++) {
		   for (Direction direction : Direction.values()) {
			   if ( checkWinner(row,col,0,currPlayerCell,direction) ) 
				   return true;
		   }
	   }

	   /* check on first column */
	   col = 0;
	   for (row = 0; row < TicTacToeUI.GRID_SIZE; row++) {
		   for (Direction direction : Direction.values()) {
			   if ( checkWinner(row,col,0,currPlayerCell,direction) )
				   return true;
		   }
	   }

	   return false;

   }

   /* Note: this method is designed and optimized to work only if starting from 
    * a cell in the bound of the grid. Cannot be used starting from internal cells
    */
   boolean checkWinner(int row, int col, int count, int currPlayer, Direction direction) {
	   Coordinates coordinates;

	   while ( GridUtil.isInBound(row, col, TicTacToeUI.GRID_SIZE) ){
		   if ( grid[row][col] == currPlayer ){
			   count++;
			   if ( count == TicTacToeUI.GRID_SIZE ) return true;

			   coordinates = GridUtil.nextMove(row, col, direction);
			   row = coordinates.row;
			   col = coordinates.column;
		   }else{
			   break;
		   }
	   }

	   return false;

   }

   boolean checkIfTiedGame() {

	   for (int i = 0; i < TicTacToeUI.GRID_SIZE; i++) {
		   for (int j = 0; j < TicTacToeUI.GRID_SIZE; j++) {
			   if ( grid[i][j] == EMPTY_CELL ) return false;
		   }
	   }

	   return true;
   }

   
   /* for testing purposes */
   
   int[][] getGrid() {
      return grid;
   }
   
   void setCurrentPlayer( boolean player ) {
      currentPlayer = player;
   }
   
   boolean getCurrentPlayer() {
      return currentPlayer;
   }
}
