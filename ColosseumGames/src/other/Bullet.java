package other;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import screens.other.Screen;

public class Bullet extends Rectangle2D.Double {
	PApplet marker;
	private double x, y, angle, speed, vx, vy;
	private int maxCollisions;
	private boolean withAngle;
	Character c;
	public Bullet(PApplet marker, double x, double y, double angle, double speed, boolean withAngle, int maxCollisions, Character c) {
		super(x, y, 20, 20);
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.speed = speed;
		this.withAngle = withAngle;
		this.marker = marker;
		this.maxCollisions = maxCollisions;
		this.c = c;
	}
	public boolean isCollision() {

		if(x < 40) {
			return true;
		} 
		if(y < 40) {
			y = 40;
			return true;
			//have 4 of these
		}
		if(x > Screen.SCREEN_WIDTH - 40) {
			x = Screen.SCREEN_WIDTH - 40 + 20;
			return true;
		}
		if(y > Screen.SCREEN_HEIGHT - 200) {
			y = Screen.SCREEN_HEIGHT - 200 + 20;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void launch(double x, double y, double angle, double speed, boolean withAngle) {
		vx = speed * Math.cos(angle);
		vy = speed * Math.sin(angle);
		super.x += vx;
		super.y += vy;
	}
	public void draw(PApplet marker) {
		
	}
	
}
