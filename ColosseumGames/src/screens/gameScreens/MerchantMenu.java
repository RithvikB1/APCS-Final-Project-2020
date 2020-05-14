package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that allows user to upgrade their stats
 * @author Rithvik
 *
 */
public class MerchantMenu extends Screen {

	private DrawingSurface surface;
	
	private int statPicked;
	private Rectangle atkSpeed, health, speed, confirm;
	
	public MerchantMenu(DrawingSurface surface) {
		super(surface);
		
		statPicked = 0;
		this.surface = surface;
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		surface.fill(200, 150, 250);
		surface.stroke(0);
		
		surface.rect(100, 100, 1100, 440);
		surface.line(100, 200, 1200, 200);
		
		atkSpeed = new Rectangle(210, 250, 220, 100);
		health = new Rectangle(540, 250, 220, 100);
		speed = new Rectangle(870, 250, 220, 100);
		confirm = new Rectangle(485, 420, 330, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 210, 250, 220, 100);
		PShape shape2 = surface.createShape(PConstants.RECT, 540, 250, 220, 100);
		PShape shape3 = surface.createShape(PConstants.RECT, 870, 250, 220, 100);
		PShape shape4 = surface.createShape(PConstants.RECT, 485, 420, 330, 100);
		
		boolean isClicked = statPicked == 1 || statPicked == 2 || statPicked == 3;
		
		int c1 = surface.color(204, 153, 0); // +230 -200
		int c2 = surface.color(140, 153, 0);
		int c3 = surface.color(140, 220, 0);
		
		hover(atkSpeed, shape, c1, c2);
		hover(health, shape2, c1, c2);
		hover(speed, shape3, c1, c2);
		
		if (statPicked == 1) {
			shape.setFill(surface.color(255, 0, 0));
			//statPicked = 1;
		}
		else if (statPicked == 2) {
			shape2.setFill(surface.color(255, 0, 0));
			//statPicked = 2;
		}
		else if (statPicked == 3) {
			shape3.setFill(surface.color(255, 0, 0));
			//statPicked = 3;
		}
		
		if (isClicked) {
			hover(confirm, shape4, c1, c2);
			
			surface.shape(shape4);
		}
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		
		surface.fill(c3);
		surface.ellipseMode(PConstants.CORNER);
		surface.textSize(30);
		
		if (atkSpeed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(210, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text("+5", 295, 380);
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(540, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text("+10", 615, 380);
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(870, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text("+5", 960, 380);
		}
		
		surface.textSize(60);
		surface.fill(0);
		surface.text("Upgrade Stats", 450, 175);
		
		surface.textSize(40);
		surface.text("AtkSpeed", 230, 315);
		surface.text("Health", 590, 315);
		surface.text("Speed", 925, 315);
		
		if (isClicked) 
			surface.text("Confirm", 570, 485);
		
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
		if (atkSpeed.contains(surface.mouseX, surface.mouseY)) {
			statPicked = 1;
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			statPicked = 2;
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			statPicked = 3;
		}
		else {
			statPicked = 0;
		}
		
		if (confirm.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.GAME_SCREEN);
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
