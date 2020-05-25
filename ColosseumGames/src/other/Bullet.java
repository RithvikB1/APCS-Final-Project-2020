package other;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PApplet;
import screens.other.Screen;

public class Bullet extends Rectangle2D.Double {
	PApplet marker;
	private double vx, vy, angle;
	private int side;
	private int collisionCounter;
	public Bullet(double x, double y, double angle) {
		super(x, y, 20, 20);
		this.angle = angle;
	}
	public boolean isCollision() {

		if(super.x < 40) {
			side = 2;
			super.x = 90;
			return true;
		} 
		if(super.y < 40) {
			side = 1;
			super.y = 90;
			
			return true;
			//have 4 of these
		}
		if(super.x > Screen.SCREEN_WIDTH - 40) {
			side = 2;
			super.x = Screen.SCREEN_WIDTH - 90;
			return true;
		}
		if(super.y > Screen.SCREEN_HEIGHT - 250) {
			side = 1;
			super.y = Screen.SCREEN_HEIGHT - 300;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void launch(double speed) {
		if(!isCollision()) {
			vx = speed * Math.cos(angle);
			vy = speed * Math.sin(angle);
		} else {
			collisionCounter++;
			if(side == 1) {
				angle = 2*Math.PI - angle;
			}
			if(side == 2) {
				angle = Math.PI - angle;
			}
		}
		
		
	}
	public void moveByVelocities(){
		if(!isCollision()) {
			super.x += vx;
			super.y += vy;
		}
	

	}
	public int getCollisionCounter() {
		return collisionCounter;
	}
	public void draw(PApplet marker, int r, int g, int b) {
		marker.pushMatrix();
		marker.strokeWeight(2);
		marker.fill(r, g, b);
		marker.rect((float)super.x, (float)super.y, 20, 20);
		marker.popMatrix();
	}
	
}
