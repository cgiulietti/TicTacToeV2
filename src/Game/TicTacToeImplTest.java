package Game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import TicTacToeUtils.Direction;

/* Test of the internal methods of TicTacToeImpl */
public class TicTacToeImplTest {

   public TicTacToeLogicImpl game;
   public int[][] grid;
   
   @Before
   public void setUp() throws Exception {
       game = new TicTacToeLogicImpl();
       grid = game.getGrid();
   }

   
   @Test
   public void testPlayer2WinsDiagonal1() throws Exception {  
	   /* case player2 winning in diagonal */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon()); 
	   assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_RIGHT));
	   assertEquals(true,game.checkWinner(2, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_LEFT));
	   assertEquals(false,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER)); 
	   assertEquals(false,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_CENTER)); 
	   assertEquals(false,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT)); 
	   assertEquals(false,game.checkWinner(1, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER)); 
	   assertEquals(false,game.checkWinner(0, 1, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER));
	   assertEquals(false,game.checkWinner(0, 1, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT));
   }  

   @Test
   public void testPlayer2WinsDiagonal2() throws Exception {
	   /* case player2 winning in diagonal */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon()); 
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(2, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_RIGHT)); 
	   assertEquals(true,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_LEFT));
	   assertEquals(false,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT)); 
	   assertEquals(false,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_RIGHT)); 
	   assertEquals(false,game.checkWinner(0, 1, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER));
   }

   @Test
   public void testPlayer2WinsFirstRow() throws Exception {
	   /* case player2 winning in first row */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT)); 
	   assertEquals(true,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.LEFT)); 
   }

   @Test
   public void testPlayer2WinsSecondRow() throws Exception {
	   /* case player2 winning in second row */
	   grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(1, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT)); 
	   assertEquals(true,game.checkWinner(1, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.LEFT)); 
	   assertEquals(false,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_RIGHT)); 
	   assertEquals(false,game.checkWinner(2, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.LEFT)); 
   }

   @Test
   public void testPlayer2WinsThirdRow() throws Exception {
	   /* case player2 winning in third row */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());   
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(2, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.RIGHT)); 
	   assertEquals(true,game.checkWinner(2, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.LEFT)); 
   }

   @Test
   public void testPlayer2WinsFirstColumn() throws Exception {
	   /* case player2 winning in first column */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon()); 
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER)); 
	   assertEquals(true,game.checkWinner(2, 0, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_CENTER)); 
   }

   @Test
   public void testPlayer2WinsSecondColumn() throws Exception {
	   /* case player2 winning in second column */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[1][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());     
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(0, 1, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER));
	   assertEquals(true,game.checkWinner(2, 1, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_CENTER));
   }

   @Test
   public void testPlayer2WinsThirdColumn() throws Exception {
	   /* case player2 winning in third column */
	   grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
	   grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;

	   game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
	   assertEquals(false,game.checkIfCurrentPlayerWon());
	   game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
	   assertEquals(true,game.checkIfCurrentPlayerWon());
	   assertEquals(true,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.DOWN_CENTER));
	   assertEquals(true,game.checkWinner(2, 2, 0, TicTacToeLogicImpl.PLAYER2_CELL, Direction.UP_CENTER));
   }
   
   @Test
   public void testPlayer1WinsDiagonal1() throws Exception {
      
      /* case player1 winning in diagonal */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.DOWN_RIGHT));
   }
    
   @Test
   public void testPlayer1WinsDiagonal2() throws Exception {
      /* case player1 winning in diagonal */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.DOWN_LEFT));
   }
      
   @Test
   public void testPlayer1WinsFirstRow() throws Exception {
      /* case player1 winning in first row */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.RIGHT));
   }
    
   @Test
   public void testPlayer1WinsSecondRow() throws Exception {
      /* case player1 winning in second row */
      grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(1, 0, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.RIGHT));
   }
    
   @Test
   public void testPlayer1WinsThirdRow() throws Exception {
      /* case player1 winning in third row */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(2, 0, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.RIGHT));
   }
    
   @Test
   public void testPlayer1WinsFirstColumn() throws Exception {
      /* case player1 winning in first column */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 0, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.DOWN_CENTER));
   }
    
   @Test
   public void testPlayer1WinsSecondColumn() throws Exception {
      /* case player1 winning in second column */
      grid[0][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());   
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 1, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.DOWN_CENTER));
   }
    
   @Test
   public void testPlayer1WinsThirdColumn() throws Exception {
      /* case player1 winning in third column */
      grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());     
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(true,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkWinner(0, 2, 0, TicTacToeLogicImpl.PLAYER1_CELL, Direction.DOWN_CENTER));
      
   }
   
   @Test
   public void testNobodyWinsFullGrid1() throws Exception {
      /* grid full */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkIfTiedGame());
   }
    
   @Test
   public void testNobodyWinsFullGrid2() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkIfTiedGame());
   } 
    
   @Test
   public void testNobodyWinsFullGrid3() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(true,game.checkIfTiedGame());
   } 
      
   @Test
   public void testNobodyWinsPartFullGrid1() throws Exception {
      /* grid partially full */
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());     
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }
    
   @Test
   public void testNobodyWinsPartFullGrid2() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL; grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.EMPTY_CELL; grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[1][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL; grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());     
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }
    
   @Test
   public void testNobodyWinsPartFullGrid3() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }

   @Test
   public void testNobodyWinsPartFullGrid4() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[1][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }
    
   @Test
   public void testNobodyWinsPartFullGrid5() throws Exception {
      grid[0][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[0][1] = TicTacToeLogicImpl.PLAYER2_CELL; grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL;   grid[1][2] = TicTacToeLogicImpl.PLAYER2_CELL;
      grid[2][0] = TicTacToeLogicImpl.PLAYER2_CELL; grid[2][1] = TicTacToeLogicImpl.PLAYER1_CELL; grid[2][2] = TicTacToeLogicImpl.PLAYER1_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());     
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }
    
   @Test
   public void testNobodyWinsEmptyGrid() throws Exception {
      /* empty grid */
      grid[0][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[0][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[0][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[1][0] = TicTacToeLogicImpl.PLAYER1_CELL; grid[1][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[1][2] = TicTacToeLogicImpl.EMPTY_CELL;
      grid[2][0] = TicTacToeLogicImpl.EMPTY_CELL;   grid[2][1] = TicTacToeLogicImpl.EMPTY_CELL; grid[2][2] = TicTacToeLogicImpl.EMPTY_CELL;
      
      game.setCurrentPlayer(TicTacToeLogic.PLAYER2);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      game.setCurrentPlayer(TicTacToeLogic.PLAYER1);
      assertEquals(false,game.checkIfCurrentPlayerWon());
      assertEquals(false,game.checkIfTiedGame());
   }
   
   
}
