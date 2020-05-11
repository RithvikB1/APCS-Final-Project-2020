package other;

import java.awt.Dimension;
import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Main {

	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setLocation(65, 0);
		window.setMinimumSize(new Dimension(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT));
		window.setMaximumSize(new Dimension(Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT));
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
        
		canvas.requestFocus();
	}
}
