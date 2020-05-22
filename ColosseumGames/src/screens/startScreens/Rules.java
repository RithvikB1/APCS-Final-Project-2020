package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that displays the rules of the game 
 * @author Rithvik
 *
 */
public class Rules extends Screen {

	private DrawingSurface surface;
	
	private PImage background;
	
	private Rectangle backButton;
	
	public Rules(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		backButton = new Rectangle();
	}

	@Override
	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	public void draw() {
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		backButton = new Rectangle(60, 600, 260, 130);
		PShape shape = surface.createShape(PConstants.RECT, 60, 600, 260, 130, 20);
		
		int c1 = surface.color(204, 153, 0);
		int c2 = surface.color(140, 153, 0);
		
		hover(backButton, shape, c1, c2);
		
		surface.textSize(60);
		
		surface.shape(shape);
		surface.fill(0);
		surface.text("Back", 120, 685);
		
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

	public void mouseClicked() {
		if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
		}
		
	}
	
	public void mouseScrolled() {
		
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
