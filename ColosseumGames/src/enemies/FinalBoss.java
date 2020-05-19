package enemies;

import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Creates the hardest and last enemy user has to face
 * 
 * @author ?
 * @version 2.0
 *
 */
public class FinalBoss extends Enemy {
	double angle;
	private ArrayList<PImage> images;

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
	public FinalBoss(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		angle = 0;
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/Harpy/HarpyAttackRight1.png"));
		this.setImages(images);

	}

	@Override
	public void behave(Character c, PApplet marker) {
		// TODO Auto-generated method stub
		
		marker.noFill();
		marker.arc((float)x, (float)y,(float)getRange()*2, (float)getRange()*2, 0, 2*(float)Math.PI);
		marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y));
		marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y));
		marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y));
		marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y));
		marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y));

		angle+= 0.05;
	}
	
	
	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void animateWalk(int dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		
	}

	

}
