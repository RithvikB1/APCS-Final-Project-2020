package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import other.Bullet;
import processing.core.PApplet;
import processing.core.PImage;

public class Chiron extends Hero {
	
	private ArrayList<PImage> images;
	private boolean position;
	private int imageNumber;
	private ArrayList<Bullet> arrows;
	long previousShotTime = System.currentTimeMillis();

	public static final int SPEED = 20, ATK_SPEED = 15, HP = 45000, RANGE = 400, DAMAGE = 150;
	public static final int UP_SPEED = 10, UP_ATK_SPEED = 5, UP_HP = 5000, UP_RANGE = 50, UP_DAMAGE = 100;
	
	public Chiron(double speed, double atkSpeed, double HP, double range, double damage) {
		super(speed, atkSpeed, HP, range, damage);
		
		images = new ArrayList<PImage>();
		arrows = new ArrayList<Bullet>();

	}

	@Override
	public void setup(PApplet marker) {
		
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironFacingRight.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironFacingFront.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironFacingLeft.png"));			
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackBack1.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackBack2.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackFront1.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironAttackRight2.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkBack1.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkBack2.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkFront1.png"));
//		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkFront2.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkLeft1.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkLeft2.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkRight1.png"));
		images.add(marker.loadImage("sprites/Heroes/Chiron/ChironWalkRight2.png"));

//		

//		
		this.setImages(images);
		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		double angle = 0;
		double delay = (10/getAtkSpeed())*1000;
		long nextShotTime = System.currentTimeMillis();
		if(nextShotTime - previousShotTime > delay) {
			if(this.x - mouseX >= 0) {
				angle = Math.PI + Math.atan((mouseY-this.getY())/(mouseX - this.getX()));
				animateAttack(3);
			}
			else {
				angle = Math.atan((mouseY-this.getY())/(mouseX - this.getX()));	
				animateAttack(1);
			}
			arrows.add(new Bullet(this.x, this.y, angle));
			previousShotTime = System.currentTimeMillis();
		}
	}
	public ArrayList<Bullet> getArrows(){
		return arrows;
	}
	
	@Override
	public void animate(int dir) {
		// TODO Auto-generated method stub
		if (dir == 1)
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
		
		if (dir == 3)//down
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
	
	public void animateAttack(int dir)
	{
		if (dir == 1)
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
		
		if (dir == 3)//down
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
//		if (dir == 2)
//		{
//			imageNumber =1;
//		}
		if (dir == 3)
		{
			imageNumber = 1;
		}
//		if (dir == 4)
//		{
//			imageNumber = 2;
//		}

		
	}

	

}
