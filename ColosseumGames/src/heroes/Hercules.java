package heroes;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Hercules extends Hero {
	
	private ArrayList<PImage> images;
	
	private boolean position;
	private int imageNumber;
	
	private int currentDir;
	private long previousShotTime;
	
	public static final int SPEED = 20, ATK_SPEED = 10, HP = 10000, RANGE = 100, DAMAGE = 100;

	public Hercules(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage);
		
		images = new ArrayList<>();
		
		position = false;
		
		previousShotTime = System.currentTimeMillis();
	}

	@Override
	public void setup(PApplet marker) {
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesFacingRight.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesFacingFront.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesAttackRight2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesWalkRight2.png"));
		
		
		this.setImages(images);

		
	}
	
	public void animate(int dir)
	{
		if (dir == 1)
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
		if (dir == 3)
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
		if (dir == 4)
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
	
	public int getImageNumber()
	{
		return imageNumber;
	}
	
	public void setImageNumber(int dir)
	{
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
	
	public void animateAttack(int dir)
	{
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

	
}
