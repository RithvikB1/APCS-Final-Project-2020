package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.event.MouseEvent;
import screens.other.Screen;

/**
 * Creates a screen that displays the rules of the game 
 * @author Rithvik
 *
 */
public class Rules extends Screen {

	private DrawingSurface surface;
	
	private PImage background, rules;
	
	private Rectangle backButton, slider;
	
	private int rulesX, rulesY, sliderY;
	
	private boolean isLocked;
	
	
	public Rules(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		backButton = new Rectangle();
		slider = new Rectangle();
		
		rulesX = 250;
		rulesY = 0;
		
		sliderY = 0;
		
	}

	@Override
	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		rules = surface.loadImage("files/images/howtoplay.png");
		
	}

	public void draw() {
		surface.pushStyle();
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		surface.image(rules, rulesX, rulesY, 800, 1200);
		
		backButton = new Rectangle(20, 600, 200, 130);
		slider = new Rectangle(1100, sliderY, 50, 70);
		PShape shape = surface.createShape(PConstants.RECT, 20, 600, 200, 130, 20);
		PShape shape2 = surface.createShape(PConstants.RECT, 1100, 0, 50, SCREEN_HEIGHT);
		PShape shape3 = surface.createShape(PConstants.RECT, 1100, sliderY, 50, 70);
		
		int c1 = surface.color(204, 153, 0);
		int c2 = surface.color(140, 153, 0);
		
		shape2.setFill(surface.color(100));
		
		hover(backButton, shape, c1, c2);
		hover(slider, shape3, c1, c2);
		
		if (isLocked)
			shape3.setFill(c2);
		
		surface.textSize(60);
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		surface.fill(0);
		surface.text("Back", 60, 685);
		surface.popStyle();
		
	}

	@Override
	public void mousePressed() {
		if (slider.contains(surface.mouseX, surface.mouseY)) {
			isLocked = true;
		}
		
	}

	@Override
	public void mousedReleased() {
		isLocked = false;
	}

	@Override
	public void mouseDragged() {
		if (isLocked) {
			if (surface.mouseY > surface.pmouseY) {
				sliderY += 3;
				rulesY += 1;
			}
			else if (surface.mouseY < surface.pmouseY) {
				sliderY -= 3;
				rulesY -= 1;
			}
		}
	}

	public void mouseClicked() {
		if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
		}
		
	}
	
	public void mouseWheel(MouseEvent e) {
		if (e.getCount() > 0) {
			rulesY += 1;
			sliderY += 3;
		}
		else if (e.getCount() < 0) {
			rulesY -= 1;
			sliderY -= 3;
		}
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
