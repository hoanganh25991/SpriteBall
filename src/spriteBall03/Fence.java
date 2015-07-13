package spriteBall03;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fence extends JPanel {
	int framewidth, frameheight;
	final static int fence_width = 50;
	final static int fence_height = 10;
	int x;
	int speed = 3;

	public Fence(JFrame frame) {
		framewidth = frame.getWidth();
		frameheight = frame.getHeight();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Rectangle r = new Rectangle(x, frameheight - 45, fence_width,
				fence_height);
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	public void move(int keycode) {
		switch (keycode) {
		case KeyEvent.VK_LEFT:
			x += speed;
			break;
		case KeyEvent.VK_RIGHT:
			x -= speed;
			break;
		}
	}
}
