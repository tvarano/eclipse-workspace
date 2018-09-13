//Thomas Varano
//Sep 7, 2018

package com.varano.helloworld.ta.intro;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe extends JPanel implements ActionListener {
	private static final String X = "X", O = "O", NONE = " ";
	private static final int PREF_W = 600, PREF_H = 800;
	private String[][] board;
	private JButton[][] buttons;
	private boolean xPlaying;
	private JPanel boardPanel, topBar;
	
	public TicTacToe() {
		super(new BorderLayout());
		boardPanel = new JPanel(new GridLayout(3, 3));
		topBar = new JPanel();
		topBar.setSize(PREF_W, 100);
		add(boardPanel, BorderLayout.CENTER);
		add(topBar, BorderLayout.NORTH);
		init();
	}
	
	
	public void init() {
		board = new String[3][3];
		
		buttons = new JButton[3][3];
		for (int row = 0; row < buttons.length; row++)
			for (int col = 0; col < buttons[row].length; col++) {
				buttons[row][col] = new JButton();
				buttons[row][col].addActionListener(this);
				buttons[row][col].setText(NONE);
				boardPanel.add(buttons[row][col]);
			}
		
		xPlaying = true;
		updateBoard();
	}
	
	public void updateBoard() {
		for (int row = 0; row < buttons.length; row++)
			for (int col = 0; col < buttons[row].length; col++) {
				board[row][col] = (buttons[row][col].getText());
				if (board[row][col] != NONE)
					buttons[row][col].setEnabled(false);
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((JButton) e.getSource()).setText(xPlaying ? X : O);
		updateBoard();
		xPlaying = !xPlaying;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}
	
	/**
	 * Creates the GUI of the game and shows it.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("AP Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TicTacToe());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/**
	 * Creates the program, shows a GUI in a new thread.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
