//Thomas Varano
//Oct 29, 2018

package com.varano.helloworld.ta.intro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class RPS3 {
	public static void main(String[] args) {
		int player = -1, computer = -1;
		int playAgain = -1;
		
		ImageIcon duringGame = new ImageIcon(RPS3.class.getResource("rps_1.jpeg"));
		ImageIcon gameOver = new ImageIcon(RPS3.class.getResource("rps_end.jpeg"));
		
		// UI 
		Font main = new Font("Comic Sans MS", Font.PLAIN, 18);
		
		UIManager.put("OptionPane.messageFont", main);
		UIManager.put("OptionPane.textFieldFont", main);
		
		UIManager.put("Panel.background", Color.BLUE);
		UIManager.put("OptionPane.background", Color.BLUE);
		UIManager.put("OptionPane.messageForeground", Color.RED);
		
		
		do {
			do {
				String[] options = {"Scissors", "Paper", "Rock"};
				player = JOptionPane.showOptionDialog(null, "Rock Paper or Scissors?", "RPS", 
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
						duringGame, options, options[(int) (Math.random() * 3)]);
				computer = (int) (Math.random() * 3);
				
				// scissor = 0, paper = 1, rock = 2
				if (player - computer == -1 || player - computer == 2) {
					// Player win
					JOptionPane.showMessageDialog(null, "Player won with " + options[player] +
							"\nvs. the computer with "+options[computer],
							"RPS", JOptionPane.INFORMATION_MESSAGE, gameOver);
				} else if (computer - player == -1 || computer - player == 2) {
					// computer win
					JOptionPane.showMessageDialog(null, "Computer won with " + options[computer] +
							"\nvs. the player with "+options[player],
							"RPS", JOptionPane.INFORMATION_MESSAGE, gameOver);
				} else {
					// Tie
					JOptionPane.showMessageDialog(null, "It was a tie, both with " + options[player],
							"RPS", JOptionPane.INFORMATION_MESSAGE, gameOver);
				}
				
			} while (player == computer);
				playAgain = JOptionPane.showOptionDialog(null, "The game is over. Play Again?", "RPS",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, gameOver, null, null);
		} while (playAgain == 0);
	}
}
