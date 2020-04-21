import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Character extends Rectangle2D.Double{
	String spriteFile, heroName;
	double speed, atkSpeed, HP;
	double range;
	double weaponDmg;
	int x, y, w, h;
	private double vx, vy;
	
	Line2D.Double leftHit, rightHit, topHit, bottomHit;
	

	public Character(String spriteFile, String heroName, double speed, 
			double atkSpeed, double HP, double range, double weaponDmg,
			int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		vx = 0;
		vy = 0;
		
		this.spriteFile = spriteFile;
		this.heroName = heroName;
		
		this.speed = speed;
		this.atkSpeed = atkSpeed;
		this.HP = HP;
		
		this.range = range;
		this.weaponDmg = weaponDmg;
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
	public double changeWeaponDmg(double increment) {
		weaponDmg += increment;
		return weaponDmg;
	}
	
	public boolean isHit(double shotX, double shotY, double shotWidth, double shotHeight) {
		
		
		return false;
	}
	public void draw(PApplet marker) {
		marker.image(marker.loadImage(spriteFile), x, y, w ,h);
	}
	
	
}
