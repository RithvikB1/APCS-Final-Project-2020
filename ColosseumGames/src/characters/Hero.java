package characters;


import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Creates a playable hero that can perform several functions in-game
 * @author Richard, Aditya 
 * @version 2.0
 *
 */
public abstract class Hero extends Character {
	
	
	
	/**w
	 * Creates a hero 
	 * @param spriteImage the image of the character
	 * @param speed how fast the hero moves
	 * @param atkSpeed how fast the hero attacks
	 * @param HP how much damage a hero can take before dying
	 * @param range the distance a hero can cover with their weapon
	 * @param damage the amount of damage the hero can do with their weapon
	 * @param x the x position of the hero
	 * @param y the y position of the hero
	 * @param w how wide the hero is
	 * @param h how tall the hero is
	 */
	public Hero( double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		this.x = x;
		this.y = y;
		

		
		

	}
	
	public abstract void setup(PApplet marker);
	
	public abstract void animate(int dir);
	
	public abstract int getImageNumber();
	
	public abstract void setImageNumber(int dir);
	
	/**
	 * gives the Hero object the ability to attack Enemy objects
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 * @param marker allows PApplet access
	 * @param enemies the arraylist of enemies used for detection
	 * @param shotX the current x position of the shot
	 * @param shotY the current y position of the shot
	 */
	public abstract void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX, double shotY);

//		double angle = Math.atan((mouseY - y)/(mouseX - x));
//		if(mouseX - x< 0) {
//			angle += Math.PI;
//		}
//		double maxXPoint = range * Math.cos(angle) + shotX;
//		double maxYPoint = range * Math.sin(angle) + shotY;
//		Line2D shot = new Line2D.Double(shotX, shotY, maxXPoint, maxYPoint);
//
//		marker.pushStyle();
//
//		marker.stroke(20);
//		marker.strokeWeight(10);
//		marker.line((float)shotX, (float)shotY, (float)maxXPoint, (float)maxYPoint);	
//		for(Enemy e: enemies) {
//			if(shot.intersects(e)) {
//				e.setHP(e.getHP() - damage);
//			}
//		}
//
//		marker.popStyle();
	
}