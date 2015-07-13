package spriteBall06;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Render extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Game.game.paint(g);
	}
}
