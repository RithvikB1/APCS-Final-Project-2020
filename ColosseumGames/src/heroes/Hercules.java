package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Hercules extends Hero {

	public Hercules(ArrayList<PImage> images, double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(images, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		marker.loadImage("sprites/Heroes/Hercules/HerculesFacingRight.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesFacingFront.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesFacingBack.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesFacingLeft.png");			
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackBack1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackBack2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackFront1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackFront2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackLeft1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackLeft2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackRight1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesAttackRight2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkBack1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkBack2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkFront1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkFront2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkLeft1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkLeft2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkRight1.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesWalkRight2.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesSelected.png");
		marker.loadImage("sprites/Heroes/Hercules/HerculesSelected.png");
		
		
		marker.loadImage("sprites/Heroes/Hercules/PRESelectedHercules.png");

		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		// TODO Auto-generated method stub
		
	}

}
