package enemies;

import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import processing.core.PApplet;
import processing.core.PImage;

public class Hydramite extends Enemy{
	private ArrayList<PImage> images;
	private int imageNumber;
	private boolean position;


	public Hydramite(double speed, double atkSpeed, double HP, double range, double damage, int x, int y, int w,
			int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/Hydramite/HydramiteWalkRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydramite/HydramiteWalkRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydramite/HydramiteWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/Hydramite/HydramiteWalkLeft2.png"));
		this.setImages(images);

	}

	@Override
	public void behave(Character c, PApplet marker) {
		this.walk(getDirectionToPlayer(c));
		animateWalk(getDirectionToPlayer(c));
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

	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return imageNumber;
	}

	@Override
	public void animateWalk(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1|| dir == 3 || dir ==4)
		{
			if (position == false)
			{
				imageNumber = 0;
				position = true;
			}
			else
			{
				imageNumber = 1;
				position = false;
			}
			
		}
		
		if (dir == 2|| dir == 3 || dir ==4)//down
		{
			if (position == false)
			{
				imageNumber = 2;
				position = true;
			}
			else
			{
				imageNumber = 3;
				position = false;
			}
		}
	}

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		
	}

	
}
