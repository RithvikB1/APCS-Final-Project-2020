package screens.other;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PShape;

/**
 * Used to create screens that are essential to game
 * @author Rithvik
 *
 */
public abstract class Screen {
	
	public static final int SCREEN_WIDTH = 1300, SCREEN_HEIGHT = 800;
	public static final int HERCULES = 1, ACHILLES = 2, CHIRON = 3, HELEN = 4, PERSEUS = 5;
	
	private int volume;
	
	private DrawingSurface surface;
	
	private boolean isSoundOn;
	
	private char upKey, downKey, leftKey, rightKey;
	
	private int specificHero;
	
	/**
	 * Creates a new Screen
	 * @param surface the drawing surface used to draw the screen
	 */
	public Screen(DrawingSurface surface) {
		this.surface = surface;
		
		specificHero = HELEN;
		
		upKey = 'W';
		downKey = 'S';
		leftKey = 'A';
		rightKey = 'D';
	}
	
	/**
	 * Loads in images for screen
	 */
	public abstract void setup();
	
	/**
	 * Draws the screen/menu
	 */
	public abstract void draw();
	
	/**
	 * Dictates what happens when mouse is pressed
	 */
	public abstract void mousePressed();
	
	/**
	 * Dictates what happens in screen when mouse is released
	 */
	public abstract void mousedReleased();
	
	/**
	 * Dictates what happens in screen when mouse is dragged
	 */
	public abstract void mouseDragged();
	
	/**
	 * Dictates what happens in screen when mouse is clicked
	 */
	public abstract void mouseClicked();
	
	/**
	 * Dictates what happens in screen when key is pressed
	 */
	public abstract void keyPressed();
	
	/**
	 * Dictates what happens in screen when key is released
	 */
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
	
	/**
	 * Changes volume accordingly
	 * @param volume the new volume 
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	/**
	 * Gets the volume of the screen
	 * @return the volume 
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Changes the state of sound
	 * @param true if sound is on, false if not
	 */
	public void setSound(boolean isSoundOn) {
		this.isSoundOn = isSoundOn;
	}
	
	/**
	 * Tells whether sound is on or not
	 * @return true if sound is on, false if not
	 */
	public boolean getSound() {
		return isSoundOn;
	}
	
	/**
	 * Changes the key used for up movement
	 * @param key the new key for up
	 */
	public void setUpKey(char key) {
		upKey = key;
	}
	
	/**
	 * Changes the key used for down movement
	 * @param key the new key for down
	 */
	public void setDownKey(char key) {
		downKey = key;
	}
	
	/**
	 * Changes the key used for left movement
	 * @param key the new key for left
	 */
	public void setLeftKey(char key) {
		leftKey = key;
	}
	
	/**
	 * Changes the key used for right movement
	 * @param key the new key for right
	 */
	public void setRightKey(char key) {
		rightKey = key;
	}
	
	/**
	 * Gets the key used for upwards movement
	 * @return the key used to go up
	 */
	public char getUpKey() {
		return upKey;
	}
	
	/**
	 * Gets the key used for downwards movement
	 * @return the key used to go down
	 */
	public char getDownKey() {
		return downKey;
	}
	
	/**
	 * Gets the key used for leftwards movement
	 * @return the key used to go left
	 */
	public char getLeftKey() {
		return leftKey;
	}
	
	/**
	 * Gets the key used for rightwards movement
	 * @return the key used to go right
	 */
	public char getRightKey() {
		return rightKey;
	}
	
	/**
	 * Changes the hero in view
	 * @param x the new hero in view
	 */
	public void setSpecificHero(int x) {
		specificHero = x;
	}
	
	/**
	 * Gets the hero in view
	 * @return the hero as an int
	 */
	public int getSpecificHero() {
		return specificHero;
	}
}
