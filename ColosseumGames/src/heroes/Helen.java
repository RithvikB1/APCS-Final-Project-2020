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
	
	public Helen(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		
		images = new ArrayList<PImage>();
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingRight.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingFront.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingBack.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenFacingLeft.png"));			
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackBack1.png"));
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackBack2.png"));
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackFront1.png"));
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackFront2.png"));
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackLeft1.png"));
		//images.add(marker.loadImage("sprites/Heroes/Helen/HelenAttackLeft2.png"));
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
		images.add(marker.loadImage("sprites/Heroes/Helen/HelenSelected.png"));
		images.add(marker.loadImage("sprites/Heroes/Helen/PRESelectedHelen.png"));
		
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
				if(Math.sqrt(Math.pow(x + 50 - e.getX(), 2) + Math.pow(y + 50 - e.getY(), 2)) < getRange()) {
					e.setHP(e.getHP() - getDamage());
				}
			}
			marker.popMatrix();
			previousShotTime = System.currentTimeMillis();
		}
	}
		
     	
	

}
