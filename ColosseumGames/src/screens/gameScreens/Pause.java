package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PShape;
import screens.other.Screen;

public class Pause extends Screen {

	private DrawingSurface surface;
	
	private Rectangle resumeButton, quitButton;
	
	public Pause(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

	public void draw() {
		surface.pushStyle();
		
		surface.fill(0);
		surface.rect(250, 100, 800, 500);
	
		resumeButton = new Rectangle(270, 450, 200, 100);
		quitButton = new Rectangle(830, 450, 200, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 270, 450, 200, 100);
		PShape shape2 = surface.createShape(PConstants.RECT, 830, 450, 200, 100);
		
		hover(resumeButton, shape, 255, 180);
		hover(quitButton, shape2, 255, 180);
		
		surface.shape(shape);
		surface.shape(shape2);
		
		surface.fill(255);
		surface.textSize(70);
		
		surface.text("Paused", 540, 300);
		
		surface.fill(0);
		surface.textSize(40);
		
		surface.text("Resume", 300, 510);
		surface.text("Quit", 885, 510);
		
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
			surface.switchScreen(DrawingSurface.GAME_SCREEN);
		}
		else if (quitButton.contains(surface.mouseX, surface.mouseY)) {
			surface.switchScreen(DrawingSurface.QUIT);
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
