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
	public Hydra(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		bullets = new ArrayList<Bullet>();
	}

	@Override
	public void setup(PApplet marker) {
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/Hydra/HydraAttackRight2.png"));
		this.setImages(images);
		
	}

	@Override
	public void behave(Character c, PApplet marker) {
		double angle = Math.atan((c.getY()-this.getY())/(c.getX() - this.getX()));
		if(bullets.size() == 0) {
			bullets.add(new Bullet(this.x, this.y, angle));
			bullets.add(new Bullet(this.x, this.y, angle + 0.1));
			bullets.add(new Bullet(this.x, this.y, angle - 0.1));
		}
	}
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}

	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void animate(int dir) {
		// TODO Auto-generated method stub
		
	}

	

}
