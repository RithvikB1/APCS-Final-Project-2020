package enemies;

import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;

public class Hydramite extends Enemy{
	private ArrayList<PImage> images;


	public Hydramite(double speed, double atkSpeed, double HP, double range, double damage, int x, int y, int w,
			int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/Hydramite/HydramiteWalkRight1.png"));
		this.setImages(images);

	}

	@Override
	public void behave(Character c, PApplet marker) {
		this.walk(getDirectionToPlayer(c));
		if(Math.abs(c.getX() - this.getX()) <= getSpeed() && Math.abs(c.getY() - this.getY()) <= getSpeed()) {
			c.setHP(c.getHP() - getDamage());
			this.setHP(0);
		}
	}
	public int getDirectionToPlayer(Character c) {
		int direction = super.getDirectionToPlayer(c);
		if(this.x > c.getX()) {
			if(this.y < c.getY()) {
				direction = 8;
			}
			else if(this.y > c.getY() && Math.abs(this.y - c.getY()) > 21) {
				direction = 7;
			}
			
		}
		else if(this.x < c.getX()) {
			if(this.y < c.getY()) {
				direction = 5;
			}
			else if(this.y > c.getY()&& Math.abs(this.y - c.getY()) > 10) {
				direction = 6;
			}
			
		}
		return direction;
	}
}
