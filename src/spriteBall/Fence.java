package spriteBall;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fence extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static int FENCE_WIDTH = 60;
	final static int FENCE_HEIGHT = 10;
	int x;
	int y;
	JFrame mGameFrame;

	public Fence(JFrame gameFrame) {
		mGameFrame = gameFrame;
		x = 0;
		y = getHeight() - 10;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawRect(x, mGameFrame.getHeight() - 10, FENCE_WIDTH, FENCE_HEIGHT);
	}

	public void move(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			x += 5;
			break;
		case KeyEvent.VK_RIGHT:
			x -= 5;
			break;
		}
	}

	public Rectangle getBound() {
		return new Rectangle(x, y, FENCE_WIDTH, FENCE_HEIGHT);
	}
}
