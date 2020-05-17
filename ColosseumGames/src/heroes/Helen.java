package heroes;
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
	
	public Helen(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
		images = new ArrayList<>();
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

			marker.pushMatrix();
			marker.noFill();
			marker.stroke(255, 255, 0);
			marker.arc((float)x + 50, (float)y +  50, (float)getRange(), (float)getRange(), (float)0, 2*(float)Math.PI);
			for(Enemy e: enemies) {
				if(Math.sqrt(Math.pow(x + 50 - e.getX(), 2) + Math.pow(y + 50 - e.getY(), 2)) < getRange()/2) {
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

	
		
     	
	

}
