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
	public FinalBoss(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
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
