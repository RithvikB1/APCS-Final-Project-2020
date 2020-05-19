package other;
import java.util.ArrayList;

import characters.Enemy;
import characters.Character;
import enemies.*;
import processing.core.*;
import screens.other.Screen;

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
	 * @param c the hero used as detection in the wave
	 */
	public void startWave(PApplet marker, Character c) {
		
		
		if(wave == 1) {
			enemyList.add(new FinalBoss(100, 100, 100000, 350, 20, 500, 300, 100, 100));
//			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
//			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));

			
			setup(marker);
		

			//and so on
		}
		else if(wave == 2) {
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, 20, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, Screen.SCREEN_HEIGHT - 300, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			
			setup(marker);
		}
		else if(wave == 3) {
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, 20, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT - 300, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2 - 100, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			setup(marker);
		}
		else if(wave == 4) {
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, 20, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT - 300, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, 20, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, Screen.SCREEN_HEIGHT - 300, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			setup(marker);

		}
		else if(wave == 5) {			
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT - 300, 50, 50));
	
			enemyList.add(new Harpy(7, 30, 500, 141, 200, 20, Screen.SCREEN_HEIGHT/2 - 50, 100, 100));
			setup(marker);


		}
		else if(wave == 6) {
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, 50, 100, 100));
			setup(marker);

		}
		else if(wave == 7) {
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, 50, 100, 100));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			setup(marker);

		}
		else if(wave == 8) {
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, 50, 100, 100));
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, Screen.SCREEN_HEIGHT - 350, 100, 100));

			setup(marker);

		}
		else if(wave == 9) {
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, 50, 100, 100));
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, Screen.SCREEN_HEIGHT - 350, 100, 100));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH - 50, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, 20, Screen.SCREEN_HEIGHT/2 - 50, 50, 50));
			setup(marker);

		}
		else if(wave == 10) {
			enemyList.add(new Minotaur(40, 20, 10000, 50, 5000, 20, 450, 150, 150));
			setup(marker);

		}
		else if(wave == 11) {
			enemyList.add(new Hydra(0, 0, 4000, 0, 200, 50, Screen.SCREEN_HEIGHT/2 - 150, 200, 200));
			setup(marker);

		}
		else if(wave == 12) {
			enemyList.add(new Hydra(0, 0, 4000, 0, 200, 50, Screen.SCREEN_HEIGHT/2 - 150, 200, 200));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, 20, 50, 50));
			enemyList.add(new Harpy(7, 30, 350, 141, 100, Screen.SCREEN_WIDTH/2, Screen.SCREEN_HEIGHT - 300, 50, 50));
			setup(marker);

		}
		else if(wave == 13) {
			enemyList.add(new Hydra(0, 0, 4000, 0, 200, 50, Screen.SCREEN_HEIGHT/2 - 150, 200, 200));
			enemyList.add(new Minotaur(40, 20, 1000, 50, 1000, Screen.SCREEN_WIDTH/2 - 100, 50, 100, 100));
			
			setup(marker);

		}
		else if(wave == 14) {
			enemyList.add(new Hydra(0, 0, 4000, 0, 200, 50, Screen.SCREEN_HEIGHT/2 - 150, 200, 200));
			enemyList.add(new Harpy(7, 30, 500, 141, 200, 20, Screen.SCREEN_HEIGHT/2 - 50, 100, 100));

			setup(marker);

		}
		else if(wave == 15) {
			enemyList.add(new Hydra(0, 0, 4000, 0, 200, 50, Screen.SCREEN_HEIGHT/2 - 150, 200, 200));
			enemyList.add(new Minotaur(40, 20, 10000, 50, 5000, 20, Screen.SCREEN_HEIGHT/2 - 50, 150, 150));

			setup(marker);

		}
		else if(wave == 16) {
			wave = 1;

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
