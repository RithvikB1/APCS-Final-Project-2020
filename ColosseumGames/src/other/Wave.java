package other;
import java.util.ArrayList;

import characters.Enemy;
import enemies.*;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to show the multiple and varied waves presented in the game
 * @author Richard, Aditya
 *
 */
public class Wave {
	private int wave;
	
	public Wave() {
		wave = 1;
		
	}
	
	/**
	 * Used to draw the waves as dependent on the current wave the user is on
	 * @param marker allows PApplet access
	 */
	public void startWave(PApplet marker, ArrayList<PImage> enemies) {
		ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
		BigBoi bigBoi;
		MediumBoi mediumBoi;
		SmallBoi smallBoi;
		
		if(wave == 1) {
			enemyList.add(new SmallBoi(enemies.get(0), 20, 20, 20, 20, 20, 20, 20, 20, 20));
			//and so on
			for(Enemy e: enemyList) {
				//e.spawn(marker);
			}
		}
		else if(wave == 2) {

		}
		else if(wave == 3) {

		}
		else if(wave == 4) {

		}
		else if(wave == 5) {

		}
		else if(wave == 6) {

		}
		else if(wave == 7) {

		}

	}
	
	/**
	 * Changes to specified wave
	 * @param newWave the specified wave
	 */
	public void setWave(int newWave){
		this.wave = newWave;
	}
	
	/**
	 * Gets the current wave the user is on
	 * @return the current wave
	 */
	public int getWave() {
		return wave;
	}
}
