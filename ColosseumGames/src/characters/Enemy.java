package characters;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Character;
import other.Bullet;
import processing.core.PApplet;
import screens.other.Screen;

/**
 * 
 * @author Richard, Rithvik, Aditya
 * @version 2.0
 *
 */
public abstract class Enemy extends Character {
	
	private double range;
	private double damage;
	
	
	/**
	 * Creates an Enemy
	 * @param speed how fast the enemy moves
	 * @param atkSpeed how fast the enemy attacks
	 * @param HP how much damage a enemy can take before dying
	 * @param range the distance a enemy can cover with their weapon
	 * @param damage the amount of damage the enemy can do with their weapon
	 * @param x the x position of the enemy
	 * @param y the x position of the enemy
	 * @param w how wide the enemy is
	 * @param h how tall the enemy is
	 */
	public Enemy(double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		
		
		//weapon stats
		this.range = range;
		this.damage = damage;
	}
	
	/**
	 * Sets up images for enemy
	 * @param marker allows PApplet access
	 */
	public abstract void setup(PApplet marker);
	
	/**
	 * Dictates how an enemy will behave
	 * @param c character the enemy wants to kill
	 * @param marker draws the enemy
	 */
	public abstract void behave(Character c, PApplet marker);

	/**
	 * Gets the direction away from the player
	 * @param c the Character object that the Enemy object is receiving the opposite direction
	 * @return the direction that the Enemy object will walk
	 */
	public int getDirectionAwayFromPlayer(Character c)
	{
		int directionAway = 9;
		if(this.x > c.getX()) {
			if(this.y + 10 < c.getY()) {
				directionAway = 6;
			}
			else if(this.y > c.getY()) {
				directionAway = 5;
			}
			else {
				directionAway = 1;
			}
		}
		else if(this.x < c.getX()) {
			if(this.y < c.getY()) {
				directionAway = 7;
			}
			else if(this.y > c.getY()) {
				directionAway = 8;
			}
			else {
				directionAway = 3;
			}
		}
		return directionAway;
		
	}
	
	/**
	 * tells the Enemy object the direction another Character object
	 * @param c Character object that the Enemy object is tracking
	 * @return the direction to the Character object
	 */
	public int getDirectionToPlayer(Character c) {
		int directionToPlayer = 0;
		
		if(this.y - c.getY() < 10) {
			directionToPlayer = 2;
		}
		if(this.y - c.getY() > 10) {
			directionToPlayer = 4;
		}
		if(this.x - c.getX() > 10) {
			directionToPlayer = 3; 
		}
		if(this.x - c.getX() < 10) {
			directionToPlayer =  1;
		}
		return directionToPlayer;
	}
	
	/**
	 * gives the image number from the ArrayList images
	 * @return the index of images
	 */
	public abstract int getImageNumber();
	
	/**
	 * gives Enemy objects the appearance to walk
	 * @param dir the direction the hero is facing
	 */
	public abstract void animateWalk(int dir);
	
	/**
	 * gives Enemy objects the appearance of attacking
	 * @param dir the direction of the enemy attack
	 */
	public abstract void animateAttack(int dir);
	
	
	/**
	 * allows the Enemy object to attack another Character object
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 * @param marker PApplet object needed to draw the shots
	 * @param hero the Character that the Enemy object is aiming at
	 * @param shotX the current x position of the shot
	 * @param shotY the current y position of the shot
	 */
	public void shoot(double mouseX, double mouseY, PApplet marker, Character hero, double shotX, double shotY) {
		double angle = Math.atan((mouseY - y)/(mouseX - x));
		if(mouseX - x< 0) {
			angle += Math.PI;
		}
		double maxXPoint = range * Math.cos(angle) + shotX;
		double maxYPoint = range * Math.sin(angle) + shotY;
		Line2D shot = new Line2D.Double(shotX, shotY, maxXPoint, maxYPoint);
		
		if (maxXPoint > shotX)
		{
			animateAttack(1);
		}
		else
		{
			animateAttack(2);
		}
		if(shot.intersects(new Rectangle2D.Double(hero.getX() - 10, hero.getY() - 10, hero.getWidth() + 20, hero.getHeight() + 20))) {
			hero.setHP(hero.getHP() - damage);
		}
		
			
	}
	/**
	 * Gets the bullets
	 * @return the bullets
	 */
	public ArrayList<Bullet> getBullets(){
		return null;
	}

	/**
	 * Sets enemy behavior
	 * @param c the character used to manipulate behavior
	 * @param marker allows PApplet access
	 * @param s gives screen access
	 */
	public void behave(Character c, PApplet marker, Screen s) {
		
	}
		
	
}

