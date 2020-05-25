package screens.other;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PShape;
import processing.event.MouseEvent;

/**
 * Used to create screens that are essential to game
 * @author Rithvik
 *
 */
public abstract class Screen {
	                                                                                                      
	public static final int SCREEN_WIDTH = 1300, SCREEN_HEIGHT = 800;
	public static final int HERCULES = 1, ACHILLES = 2, CHIRON = 3, HELEN = 4, PERSEUS = 5;
	public static final int EASY = 1, MEDIUM = 2, HARD = 3;
	public static final int NONE = 0, ATK_SPEED = 1, SPEED = 2, HP = 3, RANGE = 4;
	
	private DrawingSurface surface;
	
	private int volume, difficulty, specificHero, selectedStat;
	
	private boolean isSoundOn, displayShop;
	
	private char upKey, downKey, leftKey, rightKey;
	
	private double[] multiplier;
	
	/**
	 * Creates a new Screen
	 * @param surface the drawing surface used to draw the screen
	 */
	public Screen(DrawingSurface surface) {
		this.surface = surface;
		
		volume = 30;
		difficulty = MEDIUM;
		specificHero = HERCULES;
		selectedStat = NONE;
		
		isSoundOn = false;
		displayShop = false;
		
		upKey = 'W';
		downKey = 'S';
		leftKey = 'A';
		rightKey = 'D';
		
		multiplier = new double[14];
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
	 * Dictates what happens in screen when mouse is used to scroll
	 */
	public abstract void mouseWheel(MouseEvent e);
	
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
	
	public void resetSettings() {
		surface.noTint();
		
		volume = 30;
		difficulty = MEDIUM;
		specificHero = HERCULES;
		selectedStat = NONE;
		
		isSoundOn = true;
		displayShop = false;
		
		upKey = 'W';
		downKey = 'S';
		leftKey = 'A';
		rightKey = 'D';
		
		multiplier = new double[14];
	}
	
	/**
	 * Changes volume accordingly
	 * @param vol the new volume 
	 */
	public void setVolume(int vol) {
		volume = vol;
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
	 * @param sound true if sound is on, false if not
	 */
	public void setSound(boolean sound) {
		isSoundOn = sound;
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
	
	/**
	 * Sets the difficulty of the game
	 * @param diff the difficulty of the game
	 */
	public void setDifficulty(int diff) {
		difficulty = diff;
	}
	
	/**
	 * Gets the difficulty
	 * @return difficulty level as an int
	 */
	public int getDifficulty() {
		return difficulty;
	}
	
	/**
	 * 
	 * @param stat
	 */
	public void setStat(int stat) {
		selectedStat = stat;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getStat() {
		return selectedStat;
	}
	
	/**
	 * 
	 * @param isShop
	 */
	public void setDisplayShop(boolean isShop) {
		displayShop = isShop;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDisplayShop() {
		return displayShop;
	}
	
	/**
	 * 
	 * @param m
	 */
	public void setMultiplier(double[] m) {
		multiplier = m;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[] getMultiplier() {
		return multiplier;
	}
}
