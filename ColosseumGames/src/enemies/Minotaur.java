package enemies;

import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import characters.Character;

/**
 * Creates a medium level enemy
 * 
 * @author Richard
 * @version 2.0
 *
 */
public class Minotaur extends Enemy {
	int reset = 0;
	long chargePlayer = System.currentTimeMillis();
	long seePlayer = 0;
	double originalSpeed;
	private ArrayList<PImage> images;
	private int imageNumber;
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
	public Minotaur(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		originalSpeed = this.getSpeed();
	}
	
	/**
	 * tells Minotaur objects how to attack the Hero objects
	 * @param c character objects that the Minotaur is targeting
	 * @param marker PApplet object needed to draw
	 */
	public void behave(Character c, PApplet marker) {
		
		if(Math.abs(this.getCenterX() - c.getCenterX()) < this.getRange()) {
			this.setVx(0);
			if(this.getCenterY() - c.getCenterY() > 0) {
				this.walk(4);
			}
			else {
				this.walk(2);
			}
		}
		if(Math.abs(this.getCenterY() - c.getCenterY()) < this.getRange()) {
			this.setVy(0);
			if(this.getCenterX() - c.getCenterX() > 0) {
				this.walk(3);
				animateWalk(2);
			}
			else {
				this.walk(1);
				animateWalk(1);
			}
		}
		if(reset == 0) {
			seePlayer = System.currentTimeMillis();
		} 
		else if(chargePlayer/1000 - seePlayer/1000 < 2) {
			chargePlayer = System.currentTimeMillis();
			reset++;

		}
		else {
			reset = 0;
			this.walk(getDirectionToPlayer(c));
			animateWalk(getDirectionToPlayer(c));
		}
		this.shoot(c.getCenterX(), c.getCenterY(), marker, c, this.getCenterX(), this.getCenterY());
		if(c.getVx() == 0 && c.getVy() == 0) {
			this.walk(getDirectionToPlayer(c));
			animateWalk(getDirectionToPlayer(c));
			this.setSpeed(2);
		}
		else {
			this.setSpeed(originalSpeed);
		}
		
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
		images = new ArrayList<>();
		
		marker.frameRate(60);
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurFacingRight.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurWalkRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurWalkRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurAttackRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurAttackRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Minotaur/MinotaurAttackLeft2.png"));
		
		setImages(images);
	}

	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return imageNumber;
	}

	@Override
	public void animateWalk(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1 || dir == 3 || dir ==4)
		{
			if (position == false)
			{
				imageNumber = 1;
				position = true;
			}
			else
			{
				imageNumber = 2;
				position = false;
			}
			
		}
		
		if (dir == 2|| dir == 3 || dir ==4)//down
		{
			if (position == false)
			{
				imageNumber = 4;
				position = true;
			}
			else
			{
				imageNumber = 5;
				position = false;
			}
		}
		
		
		
	}

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1)
		{
			if (position == false)
			{
				imageNumber = 6;
				position = true;
			}
			else
			{
				imageNumber = 7;
				position = false;
			}
			
		}
		
		if (dir == 2)//down
		{
			if (position == false)
			{
				imageNumber = 8;
				position = true;
			}
			else
			{
				imageNumber = 9;
				position = false;
			}
		}
		
	}

	

}
