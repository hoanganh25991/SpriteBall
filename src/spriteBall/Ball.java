package spriteBall;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int BALL_WIDTH = 10;
	final static int BALL_HEIGHT = 10;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	Random rand;
	JFrame mGameFrame;

	public Ball(JFrame gameFrame) {
		mGameFrame = gameFrame;
		x = rand.nextInt(mGameFrame.getWidth());
		y = rand.nextInt(mGameFrame.getHeight());
	}

	public void move() {
		// case: hit left-wall
		if (x + xa < 0) {
			xa = +1;
		}
		// case : hit right-wall
		if (x + xa > mGameFrame.getWidth()) {
			xa = -1;
		}
		// case: hit celling-wall
		if (y + ya < 0) {
			ya = +1;
		}
		// case: hit bottom-wall <=> game over
		// case: hit the fence
		// deal in SpriteBal where we have both ball and fence
	}

	public Rectangle getBound() {
		return new Rectangle(x, y, BALL_WIDTH, BALL_HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawOval(x, y, BALL_WIDTH, BALL_HEIGHT);
	}
}
