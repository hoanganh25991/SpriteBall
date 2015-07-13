package spriteBall06;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Fence {
	int x, y;
	final static int width = 50;
	final static int height = 10;
	final static int speed = 8;
	JPanel panel;

	public void move(int keyCode) {
		if (keyCode == KeyEvent.VK_LEFT) {
			x -= speed;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			x += speed;
		}
		// if x reach its limit, set to default
		if (x < 0) {
			x = 0;
		} else if (x > panel.getWidth() - width) {
			x = panel.getWidth() - width;
		}
	}

	public Fence(JPanel panel) {
		this.panel = panel;
		y = panel.getHeight() - height;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}
}
