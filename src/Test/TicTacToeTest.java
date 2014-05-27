package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import Game.TicTacToeLogic;
import Game.TicTacToeLogicImpl;

public class TicTacToeTest {

	public TicTacToeLogicImpl game;
	
    @Before
    public void setUp() throws Exception {
        game = new TicTacToeLogicImpl();
    }

    /* Tests GetLastPlayerMadeMove */
    
    @Test
    public void testGetLastPlayerMadeMove() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
    	
    }
    
    @Test
    public void testGetLastPlayerMadeMoveClickOnSameCell() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
	
    }
    
    
    /* Tests when Player1 wins */
    
    @Test
    public void testPlayer1WinsDiagonal1() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }

    @Test
    public void testPlayer1WinsDiagonal2() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }
   
    @Test
    public void testPlayer1WinsFirstRow() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(true,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }

    @Test
    public void testPlayer1WinsSecondRow() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }
    
    @Test
    public void testPlayer1WinsThirdRow() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }
    
    @Test
    public void testPlayer1WinsFirstCol() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }

    @Test
    public void testPlayer1WinsSecondCol() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	assertEquals("Player1",game.getWinnerName());
    	
    }
    
    @Test
    public void testPlayer1WinsThirdCol() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(TicTacToeLogic.PLAYER1,game.getWinner());
    	
    }
    
    /* Tests when Player2 wins */
    
    @Test
    public void testPlayer2WinsDiagonal1() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(true,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsDiagonal2() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(true,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsFirstRow() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(true,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsSecondRow() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
      assertEquals(true,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsThirdRow() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(true,game.makeMoveAndCheckIfOver(2, 1));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsFirstCol() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(true,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsSecondCol() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(true,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    @Test
    public void testPlayer2WinsThirdCol() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
      assertEquals(true,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(TicTacToeLogic.PLAYER2,game.getWinner());
      assertEquals("Player2",game.getWinnerName());
      
    }
    
    /* Tests when game tied */
    
    @Test
    public void testTiedGame1() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 0));
    	assertNull(game.getWinner());
    	assertEquals("No winner",game.getWinnerName());
    	
    }
    
    @Test
    public void testTiedGame2() throws Exception {
    	
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 0));
    	assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
    	assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
    	assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
    	assertEquals(true,game.makeMoveAndCheckIfOver(2, 0));
    	assertNull(game.getWinner());
    	assertEquals("No winner",game.getWinnerName());
    	
    }
    
    /* Tests when bad input */
    
    @Test
    public void testBadInput() throws Exception {
      
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 5));
      assertEquals(false,game.makeMoveAndCheckIfOver(-1, 0));
      assertEquals(false,game.makeMoveAndCheckIfOver(23, 25));
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 1));
      assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
      assertEquals(false,game.makeMoveAndCheckIfOver(2, 0));
      assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
      assertEquals(false,game.makeMoveAndCheckIfOver(0, 1));
      assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
      assertEquals(false,game.makeMoveAndCheckIfOver(-4, 100));
      assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
      assertEquals(false,game.makeMoveAndCheckIfOver(-21, -6));
      assertEquals(TicTacToeLogic.PLAYER1,game.getLastPlayerMadeMove());
      assertEquals(false,game.makeMoveAndCheckIfOver(1, 2));
      assertEquals(TicTacToeLogic.PLAYER2,game.getLastPlayerMadeMove());
      assertNull(game.getWinner());
      
    }
    
    
}
