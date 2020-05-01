package characters;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Character extends Rectangle2D.Double {
	
	private String spriteFile;
	private double speed, atkSpeed, HP;
	private double range;
	private double damage;
	private int w, h;
	private double vx, vy;
	private Character placeHolder;
	
	//have an arrayList of Pimages, which would have all the images ready to go and 
	//call methods to switch images
		
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
	
	
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAtkSpeed() {
		return atkSpeed;
	}

	public void setAtkSpeed(double atkSpeed) {
		this.atkSpeed = atkSpeed;
	}

	public double getHP() {
		return HP;
	}

	public void setHP(double hP) {
		HP = hP;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}
	//detects if user gets hit based on shot location
	public boolean isHit(double shotX, double shotY, double shotWidth, double shotHeight) {
		
		return this.intersects(new Rectangle2D.Double(shotX, shotY, shotWidth, shotHeight));
	}
	
	//PRECONDITION IS THAT DIRX AND DIRY ARE -1 < dir < 1, then it changes the velocities
	public void walk(double dirX, double dirY) {
		vx *= dirX * speed;
		vy *= dirY * speed;
	}
	public boolean die() {
		if(HP <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void shoot(int mouseX, int mouseY, PApplet marker) {
		int shootX = (int)x;
		int shootY = (int)y;
		while(Math.abs(shootX - x) < 20) {
			
			marker.rect(shootX++, shootY, shootX + 10, shootY + 5);
		}
			
	}
	public void spawn(PApplet marker) {
		marker.image(marker.loadImage(spriteFile), (float)x, (float)y, w ,h);
	}
	
	
	
	
}
