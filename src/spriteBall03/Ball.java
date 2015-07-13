package spriteBall03;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball extends JPanel {
	int frameWidth, frameHeight;
	final static int ball_width = 10;
	final static int ball_height = 10;
	final static int speed = 2;
	Random rand;
	int x, y;
	int xa = speed, ya = speed;

	public Ball(JFrame s) {
		frameWidth = s.getWidth();
		frameHeight = s.getHeight();
		rand = new Random();
		x = rand.nextInt(frameWidth);
		y = rand.nextInt(frameHeight);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Rectangle r = new Rectangle(x, y, ball_width, ball_height);
		g.fillRect(r.x, r.y, r.width, r.height);
	}

	public void move() {
		if (x + xa < 0) {
			xa = speed;
		}
		if (x + xa > frameWidth - 15) {
			xa = -speed;
		}
		if (y + ya < 0) {
			ya = +speed;
		}
		if (y + ya > frameHeight - 35) {
			ya = -speed;
		}
		x = x + xa;
		y = y + ya;
	}
}
