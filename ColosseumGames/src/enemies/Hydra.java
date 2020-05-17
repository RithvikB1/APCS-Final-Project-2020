package enemies;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import other.Bullet;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Creates a high level enemy
 * 
 * @author ?
 * @version 2.0
 *
 */
public class Hydra extends Enemy {
	private ArrayList<Bullet> bullets; 
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
	public Hydra(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void behave(Character c, PApplet marker) {
		// TODO Auto-generated method stub
		
	}
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	public void shoot(double mouseX, double mouseY, PApplet marker, Character hero, double shotX, double shotY) {
		double angle = Math.atan((mouseY - y)/(mouseX - x));
		if(mouseX - x< 0) {
			angle += Math.PI;
		}
		double maxXPoint = getRange() * Math.cos(angle) + shotX;
		double maxYPoint = getRange() * Math.sin(angle) + shotY;
		Line2D shot = new Line2D.Double(shotX, shotY, maxXPoint, maxYPoint);
		
		if(shot.intersects(new Rectangle2D.Double(hero.getX() - 10, hero.getY() - 10, hero.getWidth() + 20, hero.getHeight() + 20))) {
			hero.setHP(hero.getHP() - getDamage());
		}
		marker.pushStyle();
		
		marker.strokeWeight(10);
		marker.stroke(255, 0, 0);
		marker.line((float)shotX, (float)shotY, (float)maxXPoint, (float)maxYPoint);
		
		marker.popStyle();
			
	}

}
