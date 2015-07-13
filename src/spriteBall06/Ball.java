package spriteBall06;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball {
	int x, y;
	final static int width = 10;
	final static int height = 10;
	final static int speed = 2;
	int xa, ya;
	JPanel panel;

	public void move() {
		if (x + xa < 0) {
			xa = +speed;
		}
		if (x + xa > panel.getWidth() - 10) {
			xa = -speed;
		}
		if (y + ya < 0) {
			ya = +speed;
		}
		x += xa;
		y += ya;
	}

	public boolean isGameOver() {
		return y + ya > panel.getHeight() - 10 - 15;
	}

	public Ball(JPanel panel) {
		this.panel = panel;
		xa = ya = speed;
		x = 0;
		y = 0;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}

}
