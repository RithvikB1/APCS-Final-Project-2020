import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Character extends Rectangle2D.Double{
	
	private String spriteFile;
	private double speed, atkSpeed, HP;
	private double range;
	private double damage;
	private int x, y, w, h;
	private double vx, vy;
	
	private Line2D.Double leftHit, rightHit, topHit, bottomHit;
	

	public Character(String spriteFile, double speed, 
			double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		//velocities
		vx = 0;
		vy = 0;
		//sprite
		this.spriteFile = spriteFile;
		//stats
		this.speed = speed;
		this.atkSpeed = atkSpeed;
		this.HP = HP;
		//weapon stats
		this.range = range;
		this.damage = damage;
		
	}
	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void moveByVelocities() {
		super.x += vx;
		super.y += vy;
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	public double changeSpeed(double increment) {
		speed += increment;
		
		return speed;
	}
	
	public double changeAtkSpeed(double increment) {
		atkSpeed += increment;
		
		return atkSpeed;
	}
	
	public double changeHP(double increment) {
		HP += increment;
		
		return HP;
	}
	
	public double changeRange(double increment) {
		range += increment;
		
		return range;
	}
	
	public double changeDamage(double increment) {
		damage += increment;
		
		return damage;
	}
	
	public boolean isHit(double shotX, double shotY, double shotWidth, double shotHeight) {
		
		return false;
	}
	
	public void shoot() {
		
	}
	public void draw(PApplet marker) {
		marker.image(marker.loadImage(spriteFile), x, y, w ,h);
	}
	
	
}
