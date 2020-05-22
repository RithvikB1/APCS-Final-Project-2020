package heroes;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Perseus extends Hero {
	
	private ArrayList<PImage> images;
	private int imageNumber;
	private boolean position;
	
	private int currentDir;
	private long previousShotTime;

	public static final int SPEED = 10, ATK_SPEED = 10, HP = 10000, RANGE = 100, DAMAGE = 100;
	public static final int UP_SPEED = 2, UP_ATK_SPEED = 2, UP_HP = 500, UP_RANGE = 2, UP_DAMAGE = 15;
	
	public Perseus(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage);
		
		images = new ArrayList<>();
		previousShotTime = System.currentTimeMillis();
	}

	@Override
	public void setup(PApplet marker) {
		
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

	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		
		Rectangle attackBox;
		double delay = (10/getAtkSpeed())*1000;
		long nextShotTime = System.currentTimeMillis();
		
		double range = getRange();
		double damage = getDamage();
		
		
		if (currentDir == 1) // right
		{
			attackBox = new Rectangle((int)(getX() + getWidth()), (int)getY(), (int)range, (int)range);
			animateAttack(currentDir);
		}	
		else if (currentDir == 2) // down
		{
			attackBox = new Rectangle((int)getX(), (int)(getY() + getHeight()), (int)range, (int)range);
			animateAttack(currentDir);
		}
		else if (currentDir == 3) // left
		{
			attackBox = new Rectangle((int)(getCenterX() - getWidth() * 2 + (getWidth() / 2)), (int)getY(), (int)range, (int)range);
			animateAttack(currentDir);
		}
		else // up
		{
			attackBox = new Rectangle((int)getX(), (int)(getCenterY() - (getHeight() / 2 + getHeight())), (int)range, (int)range);
			animateAttack(4);
		}
		
		if(nextShotTime - previousShotTime > delay) {
			for (Enemy e : enemies) {
				Rectangle2D intersection = attackBox.createIntersection(e);
				
				if (e.contains(intersection)) {
					e.setHP(e.getHP() - damage);
				}
			}
			
			marker.rect((float)attackBox.getX(), (float)attackBox.getY(), (float)range, (float)range);
			
			previousShotTime = System.currentTimeMillis();
		}
		
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
		
		currentDir = dir;
		
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

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1)
		{
			if (position == false)
			{
				imageNumber = 10;
				position = true;
			}
			else
			{
				imageNumber = 11;
				position = false;
			}
			
		}
		
		if (dir == 2)//down
		{
			if (position == false)
			{
				imageNumber = 6;
				position = true;
			}
			else
			{
				imageNumber = 7;
				position = false;
			}
		}
		if (dir == 3)
		{
			if (position == false)
			{
				imageNumber = 8;
				position = true;
			}
			else
			{
				imageNumber = 9;
				position = false;
			}
		}
		if (dir == 4)
		{
			if (position == false)
			{
				imageNumber = 4;
				position = true; 
			}
			else
			{
				imageNumber = 5;
				position = false;
			}
		}
		
	}

	

}
