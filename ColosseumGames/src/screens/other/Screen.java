package screens.other;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PShape;

public abstract class Screen {
	
	public static final int SCREEN_WIDTH = 1300, SCREEN_HEIGHT = 800;
	public static final int HERCULES = 1, ACHILLES = 2, CHIRON = 3, HELEN = 4, PERSEUS = 5;
	
	private int volume;
	
	private DrawingSurface surface;
	
	private boolean isSoundOn;
	
	private char upKey, downKey, leftKey, rightKey;
	
	private int specificHero;
	
	public Screen(DrawingSurface surface) {
		this.surface = surface;
		
		specificHero = HERCULES;
		
		upKey = 'W';
		downKey = 'S';
		leftKey = 'A';
		rightKey = 'D';
	}
	
	public abstract void setup();
	
	public abstract void draw();
	
	public abstract void mousePressed();
	
	public abstract void mousedReleased();
	
	public abstract void mouseDragged();
	
	public abstract void mouseClicked();
	
	public abstract void keyPressed();
	
	public abstract void keyReleased();
	
	/**
	 * Creates a hover effect when user's mouse is over a button
	 * @param rect represents the button in question
	 * @param shape represents the button itself
	 * @param color1 the color of the button when the user's mouse is not over the button
	 * @param color2 the color of the button when the user's mouse is over the button
	 */
	public void hover(Rectangle rect, PShape shape, int color1, int color2) {
		if (rect.contains(surface.mouseX, surface.mouseY)) {
			shape.setFill(color2);
		}
		else {
			shape.setFill(color1);
		}
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setSound(boolean isSoundOn) {
		this.isSoundOn = isSoundOn;
	}
	
	public boolean getSound() {
		return isSoundOn;
	}
	
	public void setUpKey(char key) {
		upKey = key;
	}
	
	public void setDownKey(char key) {
		downKey = key;
	}
	
	public void setLeftKey(char key) {
		leftKey = key;
	}
	
	public void setRightKey(char key) {
		rightKey = key;
	}
	
	public char getUpKey() {
		return upKey;
	}
	
	public char getDownKey() {
		return downKey;
	}
	
	public char getLeftKey() {
		return leftKey;
	}
	
	public char getRightKey() {
		return rightKey;
	}
	
	public void setSpecificHero(int x) {
		specificHero = x;
	}
	
	public int getSpecificHero() {
		return specificHero;
	}
}
