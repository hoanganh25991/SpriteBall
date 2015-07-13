package spriteBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SpriteBall extends JFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static SpriteBall frame;
	Ball mBall;
	Fence mFence;
	boolean mGameOver;

	public SpriteBall() {

		setSize(300, 300);
		setTitle("Sprite Ball");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		mBall = new Ball(frame);
		mFence = new Fence(frame);
		add(mBall);
		add(mFence);

		addKeyListener(this);
		Timer timer = new Timer(15, this);
		timer.start();
	}

	/** Main method */
	public static void main(String[] args) {
		frame = new SpriteBall();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mBall.move();
		// case: hit fence
		if (mFence.getBound().intersects(mBall.getBound())) {
			mBall.ya = -1;
		}
		// case: game over
		if (mBall.y + mBall.ya < 0) {
			mGameOver = true;
		}

		if (mGameOver) {
			mBall = new Ball(frame);
			mFence = new Fence(frame);
		}
		frame.repaint();
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
}
