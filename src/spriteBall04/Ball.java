package spriteBall04;

import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	int x, y;
	int xa, ya;
	final static int speed = 2;
	final static int ball_width = 10;
	final static int ball_height = 10;
	Rectangle ball;
	Random rand;

	public Ball() {
		rand = new Random();
		ball = new Rectangle(x, y, ball_width, ball_height);
	}

	public Rectangle getBall() {
		return ball;
	}

	public void move() {
		if (x + xa < 0) {
			xa = speed;
		}
		if (x + xa > GameSpriteBall.game.getWidth() - 15) {
			xa = -speed;
		}
		if (y + ya < 0) {
			ya = +speed;
		}

		x = x + xa;
		y = y + ya;
	}
}
