package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Hercules extends Hero {
	
	private ArrayList<PImage> images;

	public Hercules( double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		
		images = new ArrayList<PImage>();
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
		images.add(marker.loadImage("sprites/Heroes/Hercules/HerculesSelected.png"));
		images.add(marker.loadImage("sprites/Heroes/Hercules/PRESelectedHercules.png"));
		
		this.setImages(images);

		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		// TODO Auto-generated method stub
		
	}

}
