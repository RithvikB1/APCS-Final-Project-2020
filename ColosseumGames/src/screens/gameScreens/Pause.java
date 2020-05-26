package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PShape;
import processing.event.MouseEvent;
import screens.other.Screen;

/**
 * Creates a screen that pauses the game and gives user the option to resume or restart the game
 * @author Rithvik
 *
 */
public class Pause extends Screen {

	private DrawingSurface surface;
	
	private Rectangle resumeButton, restartButton;
	
	public Pause(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
	}

	public void setup() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		surface.pushStyle();
		
		surface.fill(0);
		surface.rect(250, 100, 800, 500);
	
		resumeButton = new Rectangle(270, 450, 200, 100);
		restartButton = new Rectangle(830, 450, 200, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 270, 450, 200, 100);
		PShape shape2 = surface.createShape(PConstants.RECT, 830, 450, 200, 100);
		
		hover(resumeButton, shape, 255, 180);
		hover(restartButton, shape2, 255, 180);
		
		surface.shape(shape);
		surface.shape(shape2);
		
		surface.fill(255);
		surface.textSize(70);
		
		surface.text("Paused", 540, 300);
		
		surface.fill(0);
		surface.textSize(40);
		
		surface.text("Resume", 300, 510);
		surface.text("Restart", 868, 510);
		
		surface.popStyle();
		
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
		if (resumeButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.GAME_SCREEN);
		}
		else if (restartButton.contains(surface.mouseX, surface.mouseY)) {
			surface.reset();
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
