package heroes;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Helen extends Hero {
	int firstShot = 0;
	long previousShotTime = System.currentTimeMillis();
	
	private ArrayList<PImage> images;
	private boolean position;
	private int imageNumber;
	
	public static final int SPEED = 20, ATK_SPEED = 10, HP = 100000, RANGE = 400, DAMAGE = 500;
	public static final int UP_SPEED = 2, UP_ATK_SPEED = 2, UP_HP = 500, UP_RANGE = 2, UP_DAMAGE = 15;
	
	public Helen(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage);
		
		images = new ArrayList<>();
	}

	@Override
	public void setup(PApplet marker) {
	
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingRight.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingFront.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingLeft.png"));			
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackRight2.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkBack1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkBack2.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkFront1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenWalkRight2.png"));
		
		this.setImages(images);
		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		double delay = (10/getAtkSpeed())*1000;
		long nextShotTime = System.currentTimeMillis();
		
		
		if(nextShotTime - previousShotTime > delay) {
			if (mouseX < this.x)
			{
				animateAttack(3);
			}
			else
			{
				animateAttack(1);
			}

			marker.pushMatrix();
			marker.noFill();
			marker.stroke(255, 255, 0);
			marker.arc((float)x + 50, (float)y +  50, (float)getRange(), (float)getRange(), (float)0, 2*(float)Math.PI);
			Ellipse2D.Double hit = new Ellipse2D.Double(x + 50 - this.getRange()/2, y + 50 - this.getRange()/2, (float)getRange(), (float)getRange());
			for(Enemy e: enemies) {
				if(hit.intersects(e)) {
					e.setHP(e.getHP() - getDamage());
				}
			}
			marker.popMatrix();
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
				imageNumber = 14;
				position = true;
			}
			else
			{
				imageNumber = 15;
				position = false;
			}
			
		}
		
		if (dir == 2)//down
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
		if (dir == 3)//left
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
		if (dir == 4)//up
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
		if (dir == 3)
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
		if (dir == 1)
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
		
		
	}

	
		
     	
	

}
