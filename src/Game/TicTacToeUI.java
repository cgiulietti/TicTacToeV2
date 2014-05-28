package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import TicTacToeUtils.Coordinates;


public class TicTacToeUI implements ActionListener {
   
   public static final int GRID_SIZE = 3;
   
   /* window and buttons */
   private JFrame window = new JFrame("Tic-Tac-Toe");
   private JButton button11 = new JButton(" ");
   private JButton button12 = new JButton(" ");
   private JButton button13 = new JButton(" ");
   private JButton button21 = new JButton(" ");
   private JButton button22 = new JButton(" ");
   private JButton button23 = new JButton(" ");
   private JButton button31 = new JButton(" ");
   private JButton button32 = new JButton(" ");
   private JButton button33 = new JButton(" ");

   private boolean freezed;
   private TicTacToeLogic gameLogic;

   public TicTacToeUI(){

      /* create window */
      window.setSize(300,300);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));

      /* add buttons */
      window.add(button11);
      window.add(button12);
      window.add(button13);
      window.add(button21);
      window.add(button22);
      window.add(button23);
      window.add(button31);
      window.add(button32);
      window.add(button33);

      /* add action listener */
      button11.addActionListener(this);
      button12.addActionListener(this);
      button13.addActionListener(this);
      button21.addActionListener(this);
      button22.addActionListener(this);
      button23.addActionListener(this);
      button31.addActionListener(this);
      button32.addActionListener(this);
      button33.addActionListener(this);

      window.setVisible(true);
      freezed = false;
      gameLogic = new TicTacToeLogicImpl();
      
   }

   public void actionPerformed(ActionEvent a) {
      
	   /* perform operation only if the window is not freezed */
	   if ( freezed == false ){

		   JButton button = (JButton) a.getSource();
		   Coordinates coordinates = getCoordinates(button);

		   if ( gameLogic.makeMoveAndCheckIfOver( coordinates.row, coordinates.column ) ){ 
			   if ( gameLogic.getWinnerName() != null ){
				   JOptionPane.showMessageDialog(window,gameLogic.getWinnerName()+ " won! (Click on the grid to start a new game)");
			   }else{
				   JOptionPane.showMessageDialog(window,"Tied game! (Click on the grid to start a new game)");
			   }
			   freezed = true;
		   }
		   
		   /* update the cell if necessary */
		   if ( button.getText() == " "){
			   if ( gameLogic.getLastPlayerMadeMove() == TicTacToeLogic.PLAYER1 ){
				   button.setText("O");
				   button.setForeground(Color.blue);
				   button.setFont(button.getFont().deriveFont(Font.BOLD));
			   }else{
				   button.setText("X");
				   button.setForeground(Color.red);
				   button.setFont(button.getFont().deriveFont(Font.BOLD));
			   }
		   }

	   }else{
		  freezed = false;
		  gameLogic = new TicTacToeLogicImpl();
		  resetUI();
	   }
     
   }

   private void resetUI() {
	   button11.setText(" ");
	   button12.setText(" ");
	   button13.setText(" ");
	   button21.setText(" ");
	   button22.setText(" ");
	   button23.setText(" ");
	   button31.setText(" ");
	   button32.setText(" ");
	   button33.setText(" ");
   }

/* return the coordinates given a button */
   private Coordinates getCoordinates (Object button) {
      
      Coordinates c = null;
      
      if ( button.equals(button11) ){
         c = new Coordinates(0, 0);
      }else if ( button.equals(button12) ){
         c = new Coordinates(0, 1);
      }else if ( button.equals(button13) ){
         c = new Coordinates(0, 2);
      }else if ( button.equals(button21) ){
         c = new Coordinates(1, 0);
      }else if ( button.equals(button22) ){
         c = new Coordinates(1, 1);
      }else if ( button.equals(button23) ){
         c = new Coordinates(1, 2);
      }else if ( button.equals(button31) ){
         c = new Coordinates(2, 0);
      }else if ( button.equals(button32) ){
         c = new Coordinates(2, 1);
      }else if ( button.equals(button33) ){
         c = new Coordinates(2, 2);
      }
      
      return c;
      
   }

   public static void main(String[] args){
      new TicTacToeUI();
   }

   
}
