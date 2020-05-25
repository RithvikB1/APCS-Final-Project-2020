package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.*;
import processing.event.MouseEvent;
import screens.other.Screen;

/**
 * Creates a screen that is displayed at the start and allows user to either pick a hero, see the rules, see credits, or quit the program
 * @author Rithvik
 *
 */
public class StartScreen extends Screen {
	
	private PImage background;
	private Rectangle playButton, quitButton, credits, howToPlay;
	private DrawingSurface surface;
	
	public StartScreen(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		playButton = new Rectangle();
		quitButton = new Rectangle();
		credits = new Rectangle();
		howToPlay = new Rectangle();
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
	}

	public void draw() {
		surface.pushStyle();
		
		surface.tint(255, 200);
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		surface.popStyle();
		
		playButton = new Rectangle(200, 500, 900, 100);
		quitButton = new Rectangle(200, 630, 260, 100);
		credits = new Rectangle(520, 630, 260, 100);
		howToPlay = new Rectangle(840, 630, 260, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 200, 500, 900, 100, 20);
		PShape shape2 = surface.createShape(PConstants.RECT, 200, 630, 260, 100, 20);
		PShape shape3 = surface.createShape(PConstants.RECT, 520, 630, 260, 100, 20);
		PShape shape4 = surface.createShape(PConstants.RECT, 840, 630, 260, 100, 20); 
		
		int c1 = surface.color(204, 153, 0); // +230 -200
		int c2 = surface.color(140, 153, 0);
		
		shape.setFill(c1);
		shape2.setFill(c1);
		shape3.setFill(c1);
		shape4.setFill(c1);
		
		super.hover(playButton, shape, c1, c2);
		super.hover(quitButton, shape2, c1, c2);
		super.hover(credits, shape3, c1, c2);
		super.hover(howToPlay, shape4, c1, c2);
	
		surface.textSize(75);
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		surface.shape(shape4);
		
		surface.fill(0);
		surface.text("Play", 565, 570);
		
		surface.textSize(60);
		surface.text("Quit", 260, 700);
		surface.text("Credits", 550, 700);
		surface.text("Help", 900, 700);		
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
		if (playButton.contains(surface.mouseX, surface.mouseY)) { // chooseHero screen
			surface.toggleScreen(DrawingSurface.CHOOSE_HERO);
		}
		else if (quitButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.CONFIRM_QUIT);
		}
		else if (howToPlay.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.RULES);
		}
		else if (credits.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.CREDITS);
		}
	}
	
	public void mouseWheel(MouseEvent e) {
		
	}

	public void keyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}
}
