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
	private int imageNumber;
	long previousShotTime;
	double delay;

	private boolean position;
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
	public Hydra(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		bullets = new ArrayList<Bullet>();
		previousShotTime = System.currentTimeMillis();
		delay = (10/getAtkSpeed())*1000;
	}

	@Override
	public void setup(PApplet marker) {
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/Hydra/HydraAttackRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydra/HydraAttackRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydra/HydraAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydra/HydraAttackLeft2.png"));
		this.setImages(images);
		
	}

	@Override
	public void behave(Character c, PApplet marker) {
		double angle = Math.atan((c.getCenterY()- (this.getCenterY() - 50))/(c.getCenterX() - (this.getCenterX() - 10)));
		long nextShotTime = System.currentTimeMillis();
		


		if(nextShotTime - previousShotTime > delay) {
			animateAttack(2);
			bullets.add(new Bullet(this.getCenterX() - 10, this.getCenterY() - 90, angle - 0.1));

			bullets.add(new Bullet(this.getCenterX() - 10, this.getCenterY() - 50, angle));
			
			bullets.add(new Bullet(this.getCenterX() - 10, this.getCenterY() + 10, angle + 0.1));

			previousShotTime = System.currentTimeMillis();
			animateAttack(2);

		}
		animateAttack(1);
		

	}
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}

	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return imageNumber;
	}

	@Override
	public void animateWalk(int dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		
		if (dir == 1)
		{
			imageNumber = 0;
				
		}
		
		if (dir == 2)//down
		{
			imageNumber =1;
		}
	}

	

}
