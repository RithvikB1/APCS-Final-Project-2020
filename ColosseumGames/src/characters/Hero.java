package characters;


import java.util.ArrayList;

import other.Bullet;
import processing.core.PApplet;

/**
 * Creates a playable hero that can perform several functions in-game
 * @author Richard, Aditya 
 * @version 2.0
 *
 */
public abstract class Hero extends Character {
	
	public static final int X = 600, Y = 300, WIDTH = 100, HEIGHT = 100;
	
	/**w
	 * Creates a hero 
	 * @param speed how fast the hero moves
	 * @param atkSpeed how fast the hero attacks
	 * @param HP how much damage a hero can take before dying
	 * @param range the distance a hero can cover with their weapon
	 * @param damage the amount of damage the hero can do with their weapon
	 * @param x the x position of the hero
	 * @param y the y position of the hero
	 * @param w how wide the hero is
	 * @param h how tall the hero is
	 */
	public Hero(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage, X, Y, WIDTH, HEIGHT);
	}
	
	/**
	 * Loads all the images for the Hero object
	 * @param marker accesses the PApplet 
	 */
	public abstract void setup(PApplet marker);
	
	/**
	 * Makes the hero be able to move fluidly
	 * @param dir the direction the hero is facing
	 */
	public abstract void animate(int dir);
	
	/**
	 * gets specific image the hero is on
	 * @return the current image
	 */
	public abstract int getImageNumber();
	
	/**
	 * sets the specific image the hero will be on
	 * @param dir the direction the hero is facing
	 */
	public abstract void setImageNumber(int dir);
	
	/**
	 * gives the Hero object the ability to attack Enemy objects
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 * @param marker allows PApplet access
	 * @param enemies the arraylist of enemies used for detection
	 * @param shotX the current x position of the shot
	 * @param shotY the current y position of the shot
	 */
	public abstract void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX, double shotY);
	public boolean isChiron() {
		return false;
	}
	public ArrayList<Bullet> getArrows(){
		return null;
	}
}