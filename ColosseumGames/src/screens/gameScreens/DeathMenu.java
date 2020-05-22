package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Displays a screen asking if user would like to restart game or quit the game if they die
 * @author Rithvik 
 *
 */
public class DeathMenu extends Screen {

	private DrawingSurface surface;
	
	private Rectangle quit, restart;
	
	public DeathMenu(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		quit = new Rectangle();
		restart = new Rectangle();
	}

	public void setup() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		surface.fill(200, 150, 250);
		surface.stroke(0);
		
		surface.rect(300, 100, 700, 440);
		surface.line(300, 200, 1000, 200);
		surface.line(650, 200, 650, 540);
		
		quit = new Rectangle(300, 200, 350, 340);
		restart = new Rectangle(650, 200, 350, 340);
		
		PShape shape = surface.createShape(PConstants.RECT, 300, 200, 350, 340);
		PShape shape2 = surface.createShape(PConstants.RECT, 650, 200, 350, 340);
		
		hover(quit, shape, 255, 120);
		hover(restart, shape2, 255, 120);
		
		surface.shape(shape);
		surface.shape(shape2);
		
		surface.textSize(60);
		surface.fill(0);
		surface.text("You Died!", 500, 175);
		surface.text("Quit", 410, 375);
		surface.text("Restart", 710, 375);
		
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
		if (quit.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.CONFIRM_QUIT);
		}
		else if (restart.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
//			resetSettings();
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
