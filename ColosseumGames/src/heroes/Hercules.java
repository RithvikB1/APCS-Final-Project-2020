package heroes;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Hercules extends Hero {
	
	private ArrayList<PImage> images;
	private double range, damage;

	public Hercules( double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super( speed, atkSpeed, HP, range, damage, x, y, w, h);
		
		images = new ArrayList<PImage>();
		
		this.range = range;
		this.damage = damage;
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

	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		
		Line2D.Double line = new Line2D.Double(mouseX, mouseY, getX(), getY());
		int x = 0;
		int y = 0;
		
		if (mouseX < getCenterX() + getWidth() / 2) {
			x = -1;
		}
		else {
			x = 1;
		}
		
		if (mouseY < getCenterY() - getHeight() / 2) {
			y = -1;
		}
		else {
			y = 1;
		}
		
		Rectangle attackBox;
		
		if (x == 1 && y == 1)
			attackBox = new Rectangle((int)(getCenterX() + getWidth() / 2), (int)(getCenterY() - getHeight() / 2), (int)range, (int)range);
		else if (x == 1 && y == -1) 
			attackBox = new Rectangle((int)getX(), (int)(getY() + getHeight()), (int)range, (int)range);
		else if (x == -1 && y == 1)
			attackBox = new Rectangle((int)(getCenterX() - getWidth() * 2 + (getWidth() / 2)), (int)(getCenterY() - getHeight() / 2), (int)range, (int)range);
		else 
			attackBox = new Rectangle((int)(getCenterX() - getWidth() / 2), (int)(getCenterY() - (getHeight() / 2 + getHeight())), (int)range, (int)range);
			
		for (Enemy e : enemies) {
			Rectangle2D intersection = attackBox.createIntersection(e);
			
			if (e.contains(intersection)) {
				e.setHP(e.getHP() - damage);
			}
		}
		
		marker.rect((float)attackBox.getX(), (float)attackBox.getY(), (float)range, (float)range);
		
	}

}
