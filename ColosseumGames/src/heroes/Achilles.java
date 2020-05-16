package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Achilles extends Hero {
	
	private ArrayList<PImage> images;

	public Achilles(double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
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
		images.add(marker.loadImage("sprites/Heroes/Achilles/AchillesSelected.png"));
		images.add(marker.loadImage("sprites/Heroes/Achilles/PRESelectedAchilles.png"));
		
		this.setImages(images);
		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		// TODO Auto-generated method stub
		
	}

}
