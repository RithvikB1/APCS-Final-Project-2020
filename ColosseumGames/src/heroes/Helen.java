package heroes;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import processing.core.PApplet;
import processing.core.PImage;

public class Helen extends Hero {
	int firstShot = 0;
	long previousShotTime = 0;
	
	public Helen(ArrayList<PImage> images, double speed, double atkSpeed, double HP, double range, double damage,
			int x, int y, int w, int h) {
		super(images, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shoot(double mouseX, double mouseY, PApplet marker, ArrayList<Enemy> enemies, double shotX,
			double shotY) {
		double delay = (10/getAtkSpeed())*1000;
		long nextShotTime = System.currentTimeMillis();
		if(firstShot == 0) {
			
			marker.pushMatrix();
			marker.noFill();
			marker.stroke(255, 0, 0);
			marker.arc((float)x + 50, (float)y +  50, (float)getRange(), (float)getRange(), (float)0, 2*(float)Math.PI);
			for(Enemy e: enemies) {
				if(Math.sqrt(Math.pow(x + 50 - e.getX(), 2) + Math.pow(y + 50 - e.getY(), 2)) < getRange()) {
					e.setHP(e.getHP() - getDamage());
				}
			}
			marker.popMatrix();
			firstShot++;
			previousShotTime = System.currentTimeMillis();
		}
		else {
			if(nextShotTime - previousShotTime > delay) {
				
				marker.pushMatrix();
				marker.noFill();
				marker.stroke(255, 0, 0);
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
	

}
