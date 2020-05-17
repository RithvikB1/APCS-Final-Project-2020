package enemies;

import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Creates an easy level enemy
 * 
 * @author Richard
 * @version 2.0
 *
 */
public class Harpy extends Enemy {
	
	private ArrayList<PImage> images;

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
	public Harpy( double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * tells Harpy objects how to attack the Hero objects
	 * @param c character objects that the Harpy is targeting
	 * @param marker PApplet object needed to draw
	 */
	public void behave(Character c, PApplet marker) {
		
		if(Math.sqrt(Math.pow((c.getX()-x), 2) + Math.pow(c.getY() - y, 2)) < 150) {
			this.walk(getDirectionAwayFromPlayer(c));
			this.shoot(c.getX(), c.getY(), marker, c, this.getX(), this.getY());
		}
		else if(Math.sqrt(Math.pow((c.getX()-x), 2) + Math.pow(c.getY() - y, 2)) > 162) {
			this.walk(getDirectionToPlayer(c));
		}
		else {
			walk(9);
			this.shoot(c.getX(), c.getY(), marker, c, this.getX(), this.getY());
		}
		
	}
	public int getDirectionToPlayer(Character c) {
		int direction = super.getDirectionToPlayer(c);
		if(this.x > c.getX()) {
			if(this.y < c.getY()) {
				direction = 8;
			}
			else if(this.y > c.getY() && Math.abs(this.y - c.getY()) > 21) {
				direction = 7;
			}
			
		}
		else if(this.x < c.getX()) {
			if(this.y < c.getY()) {
				direction = 5;
			}
			else if(this.y > c.getY()&& Math.abs(this.y - c.getY()) > 10) {
				direction = 6;
			}
			
		}
		return direction;
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		images = new ArrayList<>();
		
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyFacingRight.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyWalkRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyWalkRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyAttackRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyAttackRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyAttackLeft2.png"));
		
		this.setImages(images);
		
	}
}
