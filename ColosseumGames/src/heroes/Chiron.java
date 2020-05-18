package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Chiron extends Hero {
	
	private ArrayList<PImage> images;
	private boolean position;
	private int imageNumber;

	public Chiron(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		
		images = new ArrayList<PImage>();
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		images = new ArrayList<>();
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
		// TODO Auto-generated method stub
		
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
