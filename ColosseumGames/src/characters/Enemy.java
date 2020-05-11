package characters;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import characters.Character;
import processing.core.PApplet;
import processing.core.PImage;
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
	 * @param spriteImage the image of the character
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
	public Enemy(PImage spriteImage, double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(spriteImage, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		
		
		//weapon stats
		this.range = range;
		this.damage = damage;
	}
	
	/**
	 * Dictates how an enemy will behave
	 * @param c character the enemy wants to kill
	 * @param marker draws the enemy
	 */
	public void behave(Character c, PApplet marker) {
		int vx = 0;
		int vy = 0;
		

	}
	/**
	 * 
	 * @param c the Character object that the Enemy object is receiving the opposite direction
	 * @param distance the distance required to stay away from the Character object
	 * @return the direction that the Enemy object will walk
	 */
	public int getDirectionAwayFromPlayer(Character c, double distance)
	{
		int directionAway = 0;
		if(Math.abs(this.x - c.getX()) < distance) {
			if(this.x - c.getX() < 0) {
				directionAway = 1;
			}
			else {
				directionAway = 3;
			}
		}
		if(Math.abs(this.y - c.getY()) < distance) {
			if(this.y - c.getY() < 0) {
				directionAway = 4;
			}
			else {
				directionAway = 2;
			}
		}
		if(Math.abs(this.y - c.getY()) < distance + 10 || Math.abs(this.x - c.getX()) < distance + 10) {
			
			directionAway = 5;
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
		
		if(shot.intersects(new Rectangle2D.Double(hero.getX() - 10, hero.getY() - 10, hero.getWidth() + 20, hero.getHeight() + 20))) {
			hero.setHP(hero.getHP() - damage);
		}
		marker.pushStyle();
		
		marker.strokeWeight(10);
		marker.stroke(255, 0, 0);
		marker.line((float)shotX, (float)shotY, (float)maxXPoint, (float)maxYPoint);
		
		marker.popStyle();
			
	}
		
	
}

