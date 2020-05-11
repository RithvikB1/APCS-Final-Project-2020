package characters;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import other.DrawingSurface;
import other.Screen;
import processing.core.PApplet;
import processing.core.PImage;
/**
 * Creates characters
 * 
 * @author Richard
 *
 */
public class Character extends Rectangle2D.Double {
	
	private PImage spriteImage;
	private double speed, atkSpeed, HP;
	private double range;
	private double damage;
	private int w, h;
	private double vx, vy;

	/**
	 * Creates a character either a playable hero or an enemy
	 * @param spriteImage the image of the character
	 * @param speed the character's speed
	 * @param atkSpeed the character's attack speed
	 * @param HP the character's HP
	 * @param range how far the character will shoot
	 * @param damage the amount of damage a character does
	 * @param x the top left x-coordinate of the character's hit box
	 * @param y the top left y-coordinate of the character's hit box
	 * @param w	the width of the character's hit box
	 * @param h the height of the character's hitbox
	 */
	public Character(PImage spriteImage, double speed, 
			double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		//velocities
		vx = 0;
		vy = 0;
		
		//sprite
		this.spriteImage = spriteImage;
		
		//stats
		this.speed = speed;
		this.atkSpeed = atkSpeed;
		this.HP = HP;
		
		//weapon stats
		this.range = range;
		this.damage = damage;
		
	}
	/**
	 * Moves the character to a specified x and y
	 * @param x the x to move the character to
	 * @param y the y to move the character to
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	/**
	 * Moves the character by a specified x and y amount
	 * @param x the x amount to move the character
	 * @param y the y amount to move the character
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	/**
	 * Moves the character by velocities
	 */
	public void moveByVelocities() {
		super.x += vx;
		super.y += vy;
		
		if(x < 40) {
			vx = 0;
			x = 40;
		} 
		if(y < 40) {
			vy = 0;
			y = 40; 
			//have 4 of these
		}
		if(x + w > Screen.SCREEN_WIDTH - 40) {
			vx = 0;
			x = Screen.SCREEN_WIDTH - 40 - w;
		}
		if(y + h > Screen.SCREEN_HEIGHT - 200) {
			vy = 0;
			y = Screen.SCREEN_HEIGHT - 200 - h;
		}
	}
	/**
	 * Sets x and y velocities of character
	 * @param vx the x velocity of the character
	 * @param vy the y velocity of the character
	 */
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	/**
	 * Accelerates the character by a given x and y  amount
	 * @param ax the x acceleration
	 * @param ay the y acceleration
	 */
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}
	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/**
	 * @return the atkSpeed
	 */
	public double getAtkSpeed() {
		return atkSpeed;
	}
	/**
	 * @param atkSpeed the atkSpeed to set
	 */
	public void setAtkSpeed(double atkSpeed) {
		this.atkSpeed = atkSpeed;
	}
	/**
	 * @return the hP
	 */
	public double getHP() {
		return HP;
	}
	/**
	 * @param hP the hP to set
	 */
	public void setHP(double hP) {
		HP = hP;
	}
	/**
	 * @return the range
	 */
	public double getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(double range) {
		this.range = range;
	}
	/**
	 * @return the damage
	 */
	public double getDamage() {
		return damage;
	}
	/**
	 * @param damage the damage to set
	 */
	public void setDamage(double damage) {
		this.damage = damage;
	}
	/**
	 * @return the vx
	 */
	public double getVx() {
		return vx;
	}
	/**
	 * @param vx the vx to set
	 */
	public void setVx(double vx) {
		this.vx = vx;
	}
	/**
	 * @return the vy
	 */
	public double getVy() {
		return vy;
	}
	/**
	 * @param vy the vy to set
	 */
	public void setVy(double vy) {
		this.vy = vy;
	}
	/**
	 * Detects whether a Character is hit by a shot
	 * @param shotX the x of the shot
	 * @param shotY the y of the shot
	 * @param shotWidth the width of the shot
	 * @param shotHeight the height of the shot
	 * @return true if the character is hit, otherwise false
	 */
	public boolean isHit(double shotX, double shotY, double shotWidth, double shotHeight) {
		
		return this.intersects(new Rectangle2D.Double(shotX, shotY, shotWidth, shotHeight));
	}
	
	/**
	 * Makes the character walk by changing velocities
	 * @param dir the direction the character should walk if dir is 1, the character moves right; 2: down; 3: left; 4: up; 5: the character stops moving
	 */
	public void walk(double dir) {
		//no collision in here
		//right
		if(dir == 1) {
			vx = speed;
			vy = 0;



		}
		//down
		if(dir == 2) {

			vy = speed;
			vx = 0;


		}
		//left
		if(dir == 3) {

			vx = -speed;
			vy = 0;


		}
		//up
		if(dir == 4) {

			vy = -speed;
			vx = 0;


		}
		//stop
		if(dir == 5) {
			vy = 0;
			vx = 0;
		}

	}
	
	/**
	 * Checks if the character is dead
	 * @return true if HP is 0 or less, otherwise false
	 */
	public boolean die() {
		if(HP <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Makes the character shoot
	 * @param mouseX the x coordinate of the direction to shoot
	 * @param mouseY the y coordinate of the direction to shoot
	 * @param shotLength the length of the shot
	 * @param marker the PApplet to draw the shot
	 */
	public void shoot(int mouseX, int mouseY, double shotLength, PApplet marker) {
		double shotX = x;
		double shotY = y;
		
		double angle = Math.atan((mouseY - y)/(mouseX - x));
		if(mouseX - x< 0) {
			angle += Math.PI;
		}
		double maxXPoint = range * Math.cos(angle) + x;
		double maxYPoint = range * Math.sin(angle) + y;
		marker.line((float)shotX, (float)shotY, (float)maxXPoint, (float)maxYPoint);		
			
	}
	/**
	 * Draws the character
	 * @param marker the PApplet to draw the character
	 */
	public void spawn(PApplet marker) {
		marker.image(spriteImage, (float)x, (float)y, w ,h);
	}	
	
}
