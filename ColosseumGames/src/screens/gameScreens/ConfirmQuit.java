package screens.gameScreens;

import other.DrawingSurface;
import processing.core.PImage;
import screens.other.Screen;

/**
 * Creates a screen that confirms if user wants to quit or not, and if so, allows user to terminate program
 * @author Rithvik
 *
 */
public class ConfirmQuit extends Screen {

	private DrawingSurface surface;
	
	private PImage background;
	
	public ConfirmQuit(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	public void draw() {
		
		
	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousedReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}

}
