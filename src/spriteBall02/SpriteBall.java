package spriteBall02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SpriteBall extends JFrame implements ActionListener {
	int ball_x, ball_y;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpriteBall() {
		add(new Ball());
		Timer timer = new Timer(20, this);
		timer.start();
	}

	class Ball extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			Rectangle r = new Rectangle(ball_x, ball_y, 10, 10);
			g.setColor(Color.black);
			g.fillRect(r.x, r.y, r.width, r.height);

		}
	}

	/** Main method */
	public static void main(String[] args) {
		SpriteBall s = new SpriteBall();
		s.setTitle("Sprite Ball");
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setResizable(false);
		s.setSize(300, 300);
		s.setLocationRelativeTo(null);
		s.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (ball_x > getWidth()) {
			ball_x = 0;
			ball_y = 0;
		} else {
			ball_x += 2;
			ball_y += 2;
		}
		repaint();
	}

}
