package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that lists the game's awesome creators
 * @author Rithvik, Aditya, Richard
 *
 */
public class Credits extends Screen {

	private DrawingSurface surface;
	
	private PImage background;
	
	private Rectangle backButton;
	
	public Credits(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		backButton = new Rectangle();
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	public void draw() {
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		surface.fill(255);
		surface.rect(300, 150, 700, 500);
		
		surface.rect(300, 150, 700, 500, 20);
		
		surface.fill(140);
		surface.rect(300, 50, 700, 100, 20);
		
		backButton = new Rectangle(25, 620, 260, 130);
		PShape shape = surface.createShape(PConstants.RECT, 25, 620, 260, 130, 20);
		
		hover(backButton, shape, 240, 140);
		
		surface.shape(shape);
		
		surface.fill(0);
		surface.textSize(80);
		
		surface.text("Rithvik Bhakhri", 350, 275);
		surface.text("Aditya Senthilvel", 330, 425);
		surface.text("Richard Huang", 360, 575);
		
		surface.textSize(90);
		surface.text("Creators", 475, 125);
		
		surface.textSize(60);
		surface.text("Back", 90, 705);
		
	}

	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	public void mousedReleased() {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged() {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked() {
		if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
		}
		
	}

	public void keyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}

}
