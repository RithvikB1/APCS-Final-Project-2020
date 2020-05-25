package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.event.MouseEvent;
import screens.other.Screen;

/**
 * Creates a screen that confirms if user wants to quit or not, and if so, allows user to terminate program
 * @author Rithvik
 *
 */
public class ConfirmQuit extends Screen {

	private DrawingSurface surface;
	
	private PImage background;
	
	private Rectangle backButton, quitButton;
	
	public ConfirmQuit(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	public void draw() {
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		surface.fill(255);
		
		backButton = new Rectangle(25, 620, 260, 130);
		quitButton = new Rectangle(1015, 620, 260, 130);
		
		PShape shape = surface.createShape(PConstants.RECT, 25, 620, 260, 130, 20); // back button
		PShape shape2 = surface.createShape(PConstants.RECT, 1015, 620, 260, 130, 20); // quit button
		
		int c1 = surface.color(204, 153, 0); // +230 -200
		int c2 = surface.color(140, 153, 0);
		
		hover(backButton, shape, c1, c2);
		hover(quitButton, shape2, c1, c2);
		
		surface.shape(shape);
		surface.shape(shape2);
		
		surface.fill(0);
		surface.textSize(75);
		surface.text("Are you sure you want to quit?", 100, 160);
		
		surface.textSize(60);
		surface.text("Back", 85, 700);
		surface.text("Quit", 1075, 700);
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
		if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
		}
		else if (quitButton.contains(surface.mouseX, surface.mouseY)) {
			System.exit(0);
		}
		
	}
	
	public void mouseWheel(MouseEvent e) {
		
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
