package other;
import java.util.ArrayList;

import characters.Enemy;
import characters.Character;
import enemies.*;
import processing.core.*;

/**
 * Used to show the multiple and varied waves presented in the game
 * @author Richard, Aditya
 * @version 2.0
 *
 */
public class Wave {
	
	private int wave;
	private ArrayList<Enemy> enemyList;
	
	/**
	 * Creates a wave object
	 */
	public Wave() {
		wave = 0;
		enemyList = new ArrayList<Enemy>();
	}
	
	/**
	 * Used to draw the waves as dependent on the current wave the user is on
	 * @param marker allows PApplet access
	 * @param enemies the sprites used for the enemies used in waves
	 * @param c the hero used as detection in the wave
	 */
	public void startWave(PApplet marker, Character c) {
		
		
		if(wave == 1) {
			Hydra hydra = new Hydra(20, 20, 20, 20, 20, 70, 250, 170, 170);
			enemyList.add(hydra);
			if(hydra.die()) {
				enemyList.add(new Hydramite(20, 20, 20, 20, 20, 20, 20, 20, 20));
				enemyList.add(new Hydramite(20, 20, 20, 20, 20, 20, 20, 20, 20));
				enemyList.add(new Hydramite(20, 20, 20, 20, 20, 20, 20, 20, 20));
			}
//			enemyList.add(new Harpy(5, 20, 20, 141, 20, 400, 20, 50, 50));
//			enemyList.add(new Harpy(5, 20, 20, 141, 20, 400, 400, 50, 50));
//			enemyList.add(new Harpy(5, 20, 20, 141, 20, 20, 300, 50, 50));
//			enemyList.add(new Harpy(5, 20, 20, 141, 20, 750, 300, 50, 50));
			
			setup(marker);
		

			//and so on
		}
		else if(wave == 2) {
			enemyList.add(new Minotaur(40, 20, 3000, 50, 100, 20, 300, 100, 100));
			enemyList.add(new Minotaur(40, 20, 3000, 50, 100, 20, 450, 100, 100));
			
			setup(marker);
		}
		else if(wave == 3) {
			enemyList.add(new Minotaur(0, 20, 10000, 50, 1000, 20, 450, 200, 200));
			setup(marker);
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
	/**
	 * gives the current list of enemies
	 * @return the current list of enemies in the game
	 */
	public ArrayList<Enemy> getEnemyList(){
		return enemyList;
	}
	
	public void setup(PApplet marker)
	{
		for (Enemy a : enemyList)
		{
			a.setup(marker);
		}
	}
}
