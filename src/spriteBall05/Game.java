package spriteBall05;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Rectangle ball;
	static Rectangle fence;
	static int xa, ya;
	final static int speed = 1;
	int fencespeed = 10;
	boolean gameover;

	public Game() {
		setVisible(true);
		setSize(200, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Render());
		addKeyListener(this);
		int ballX = (int) (Math.random() * getWidth());
		int ballY = (int) (Math.random() * getHeight());
		ball = new Rectangle(ballX, ballY, 10, 10);
		fence = new Rectangle(0, getHeight() - 38, 40, 10);
		xa = speed;
		ya = speed;
		Timer timer = new Timer(10, GameLoop);
		timer.start();
	}

	ActionListener GameLoop = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ball.x + xa < 0) {
				xa = +speed;
			}
			if (ball.x + xa > getWidth()) {
				xa = -speed;
			}
			if (ball.y + ya < 0) {
				ya = +speed;
			}
			if (ball.y + ya > getHeight() - 30) {
				gameover = true;
			}

			// System.out.println(ball.x + "," + ball.y);
			if (fence.intersects(ball)) {
				ya = -speed;
			}

			ball.x += xa;
			ball.y += ya;
			repaint();
		}
	};

	private class Render extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (gameover) {
				g.setColor(Color.black);
				g.drawString("game over ", getWidth() / 2 - 30, 20);
			} else {
				g.setColor(Color.BLACK);
				g.fillRect(ball.x, ball.y, 10, 10);

				g.setColor(Color.BLUE);
				g.fillRect(fence.x, fence.y, fence.width, fence.height);
			}
		}
	}

	/** Main method */
	public static void main(String[] args) {
		Game game = new Game();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (fencespeed > 15) {
			fencespeed = 10;
		} else {
			fencespeed += 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (fence.x - fencespeed < 0) {

			} else {
				fence.x -= fencespeed;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (fence.x + fencespeed > getWidth() - 10 - fence.width) {

			} else {
				fence.x += fencespeed;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameover = false;
			int ballX = (int) (Math.random() * getWidth());
			int ballY = (int) (Math.random() * getHeight());
			ball = new Rectangle(ballX, ballY, 10, 10);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
