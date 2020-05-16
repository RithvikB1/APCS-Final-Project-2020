package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Perseus extends Hero {
	
	private ArrayList<PImage> images;

	public Perseus(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
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
		images.add(marker.loadImage("sprites/Heroes/Perseus/PerseusSelected.png"));
		images.add(marker.loadImage("sprites/Heroes/Perseus/PRESelectedPerseus.png"));
		
		this.setImages(images);
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		// TODO Auto-generated method stub
		
	}

}
