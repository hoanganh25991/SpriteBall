package spriteBall04;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 *JPanel used to paintComponent(){
 *paint something her like Ball, Fence
 *but if we make a class A extends JPanel, how can we control Ball hit Fence, game start, game over, 
 *most important thing is 'repaint()' method of frame, we have to pass these thing to class A???
 *most easier, inside paintComponent(), we can back to a method in JFrame
 *}
 */
public class GameSpriteBall extends JFrame implements ActionListener,
		KeyListener {
	static GameSpriteBall game;
	static Render render;
	static Ball ball;
	private static final long serialVersionUID = 1L;

	public GameSpriteBall() {
		addKeyListener(this);
		render = new Render();
		add(render);
		Timer timer = new Timer(20, this);
		timer.start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 10, 10);
		;
	}

	private class Render extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	/** Main method */
	public static void main(String[] args) {
		game = new GameSpriteBall();

		game.setTitle("sprite ball");
		game.setSize(300, 300);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setLocationRelativeTo(null);
		game.setVisible(true);

		game.ball = new Ball();

	}

}
