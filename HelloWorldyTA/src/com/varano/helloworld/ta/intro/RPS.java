//Thomas Varano
//Oct 27, 2018

package com.varano.helloworld.ta.intro;

import javax.swing.JOptionPane;

public class RPS {
	public static void main(String[] args) {
		int playAgain = -1;
		do {
			String[] options = {"Paper", "Scissors", "Rock"};
			//prompt for input
			int playerMove = JOptionPane.showOptionDialog(null, "Choose one.", "RPS", 
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
					null, options, options[getRandomMove()]);
			
			//tell outcome and prompt play again
			int computerMove = getRandomMove();
			int winner = getWinner(playerMove, computerMove);
			
			//get message for the end.
			String winnerString = "";

			if (winner == 0) {
				//tie
				winnerString = "You tied, both with "+options[playerMove];
			} else if (winner == -1) {
				winnerString = "The CPU won, with "+options[computerMove] + " over your "+ options[playerMove];
			} else {
				winnerString = "You won! With "+ options[playerMove] + " over the CPU's "+options[computerMove];
			}
			
			
			playAgain = JOptionPane.showOptionDialog(null, winnerString + "\nPlay Again?", "RPS", 
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		} while (playAgain == 0);
	}
	
	//0 = paper, 1 = scissors, 2 = rock
	/**
	 * return 0 if tie, -1 for computer win, 1 for player win
	 */
	private static int getWinner(int playerMove, int computerMove) {
		if (computerMove == playerMove)
			return 0;
		
		if (playerMove == computerMove + 1)
			return 1;
		else if (playerMove == 0 && computerMove == 2)
			return 1;
		
		return -1;
	}
	
	private static int getRandomMove() {
		return (int)(Math.random() * 3);
	}
}
