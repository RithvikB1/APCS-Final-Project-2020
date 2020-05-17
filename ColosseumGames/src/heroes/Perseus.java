package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Perseus extends Hero {
	
	private ArrayList<PImage> images;
	private int imageNumber;
	private boolean position;

	public Perseus(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		
		images = new ArrayList<PImage>();
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusFacingRight.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusFacingFront.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusAttackRight2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusWalkRight2.png"));
		
		
		this.setImages(images);
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animate(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1)//right
		{
			if (position == false)
			{
				imageNumber = 18;
				position = true;
			}
			else
			{
				imageNumber = 19;
				position = false;
			}
			
		}
		
		if (dir == 2)//down
		{
			if (position == false)
			{
				imageNumber = 14;
				position = true;
			}
			else
			{
				imageNumber = 15;
				position = false;
			}
		}
		if (dir == 3)//left
		{
			if (position == false)
			{
				imageNumber = 16;
				position = true;
			}
			else
			{
				imageNumber = 17;
				position = false;
			}
		}
		if (dir == 4)//up
		{
			if (position == false)
			{
				imageNumber = 12;
				position = true;
			}
			else
			{
				imageNumber = 13;
				position = false;
			}
		}
		
		
	}

	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return imageNumber;
	}

	@Override
	public void setImageNumber(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1)
		{
			imageNumber = 0;
		}
		if (dir == 2)
		{
			imageNumber =1;
		}
		if (dir == 3)
		{
			imageNumber = 3;
		}
		if (dir == 4)
		{
			imageNumber = 2;
		}
		
	}

	

}
