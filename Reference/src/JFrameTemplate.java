import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class JFrameTemplate extends JPanel
		implements
			MouseListener,
			MouseMotionListener,
			KeyListener,
			ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 1000;
	private static final int PREF_H = 800;
	private RenderingHints hints = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	private Timer timer;

	public JFrameTemplate() {
		setBackground(Color.WHITE);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		timer = new Timer(15, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(hints);
		g2.draw(new Rectangle(10, 10, 500, 400));
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("TITLE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JFrameTemplate());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragging the mouse");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("pressing the mouse");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keypress" + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}