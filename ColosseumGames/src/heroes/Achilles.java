package heroes;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Achilles extends Hero {
	
	private ArrayList<PImage> images;
	private int imageNumber;
	private boolean position;
	
	private int currentDir;
	private long previousShotTime;
	
	public static final int SPEED = 10, ATK_SPEED = 10, HP = 10000, RANGE = 100, DAMAGE = 100;
	public static final int UP_SPEED = 2, UP_ATK_SPEED = 2, UP_HP = 500, UP_RANGE = 2, UP_DAMAGE = 15;
	
	public Achilles(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage);
		
		images = new ArrayList<>();
		position = false;
		previousShotTime = System.currentTimeMillis();
	}

	@Override
	public void setup(PApplet marker) {
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesFacingRight.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesFacingFront.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesAttackRight2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesWalkRight2.png"));
		
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
			attackBox = new Rectangle((int)(getX() + getWidth()), (int)getY(), (int)range, (int)range);
		else if (currentDir == 2) // down
			attackBox = new Rectangle((int)getX(), (int)(getY() + getHeight()), (int)range, (int)range);
		else if (currentDir == 3) // left
			attackBox = new Rectangle((int)(getCenterX() - getWidth() * 2 + (getWidth() / 2)), (int)getY(), (int)range, (int)range);
		else // up
			attackBox = new Rectangle((int)getX(), (int)(getCenterY() - (getHeight() / 2 + getHeight())), (int)range, (int)range);
		
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
