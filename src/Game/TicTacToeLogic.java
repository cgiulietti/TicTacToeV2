package Game;

public interface TicTacToeLogic {

	public static final boolean PLAYER1 = true;
	public static final boolean PLAYER2 = false;

	/* mark the requested cell for the current player and return if game over */
	public boolean makeMoveAndCheckIfOver(int x, int y);

	/* get the last player that made a move */
	public boolean getLastPlayerMadeMove();

	/* return the name of the winner */
	public String getWinnerName();

	/* return winner as a boolean, null if no winner */
	public Boolean getWinner();
	
}
