package other;
import java.util.ArrayList;

import characters.Enemy;
import characters.Character;
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
	ArrayList<Enemy> enemyList;
	
	public Wave() {
		wave = 1;
		enemyList = new ArrayList<Enemy>();
	}
	
	/**
	 * Used to draw the waves as dependent on the current wave the user is on
	 * @param marker allows PApplet access
	 */
	public void startWave(PApplet marker, Character c, ArrayList<PImage> enemies) {
		
		
		if(wave == 1) {
			enemyList.add(new Harpy(enemies.get(0), 10, 20, 20, 20, 20, 20, 20, 50, 50));
			//and so on
			for(Enemy e: enemyList) {
				e.behave(c);
				

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
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}
}
