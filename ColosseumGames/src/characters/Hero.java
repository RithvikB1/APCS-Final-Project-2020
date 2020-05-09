package characters;

import java.awt.geom.Line2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;


public class Hero extends Character {
	private PImage spriteImage;
	private double speed, atkSpeed, HP;
	private double range;
	private double damage;
	private int w, h;
	private double vx, vy;

	/**
	 * Creates a hero 
	 * @param spriteFile the image/looks of the hero
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
	public Hero(PImage spriteImage, double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(spriteImage, speed, atkSpeed, HP, range, damage, x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		//velocities
		vx = 0;
		vy = 0;
		
		//sprite
		this.spriteImage = spriteImage;
		
		//stats
		this.speed = speed;
		this.atkSpeed = atkSpeed;
		this.HP = HP;
		
		//weapon stats
		this.range = range;
		this.damage = damage;
		
	}
public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX, double shotY) {
		
		double angle = Math.atan((mouseY - y)/(mouseX - x));
		if(mouseX - x< 0) {
			angle += Math.PI;
		}
		double maxXPoint = range * Math.cos(angle) + shotX;
		double maxYPoint = range * Math.sin(angle) + shotY;
		Line2D shot = new Line2D.Double(shotX, shotY, maxXPoint, maxYPoint);

		marker.stroke(20);
		marker.line((float)shotX, (float)shotY, (float)maxXPoint, (float)maxYPoint);	
		for(Enemy e: enemies) {
			if(shot.intersects(e)) {
				e.setHP(e.getHP() - damage);
			}
		}
	}
	
	
	
	
	

	
	
	
	


}
