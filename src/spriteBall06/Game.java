package spriteBall06;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Game implements ActionListener, KeyListener {
	static Game game;
	// inside this static, we hold
	Render render;
	static Ball ball;
	Fence fence;

	public Game() {
		Timer timer = new Timer(20, this);
		timer.start();
	}

	public static void main(String[] args) {
		game = new Game();
		JFrame frame = new JFrame();
		game.render = new Render();
		frame.add(game.render);
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		ball = new Ball(game.render);
		game.fence = new Fence(game.render);
	}

	public void paint(Graphics g) {
		ball.paint(g);
		game.fence.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ball = new Ball(render);
		render.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("dkm");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
