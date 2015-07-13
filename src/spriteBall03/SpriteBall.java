package spriteBall03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SpriteBall extends JFrame implements ActionListener, KeyListener {
	static Ball ball;
	static Fence fence;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpriteBall() {
		setTitle("sprite ball");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		ball = new Ball(this);
		fence = new Fence(this);
		add(ball);
		add(fence);
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
		ball.move();
		repaint();

	}

	public static void main(String[] args) {
		new SpriteBall();

	}

}
