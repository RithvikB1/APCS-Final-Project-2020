package other;
import java.util.ArrayList;

import characters.Enemy;
import enemies.*;
import processing.core.PApplet;

public class Wave {
	private int wave;
	public Wave() {
		wave = 1;
		
	}
	
	public void startWave(PApplet marker) {
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		BigBoi bigBoi;
		MediumBoi mediumBoi;
		SmallBoi smallBoi;
		
		if(wave == 1) {
			enemies.add(new SmallBoi("small.png", 20, 20, 20, 20, 20, 20, 20, 20, 20));
			//and so on
			for(Enemy e: enemies) {
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
	public void setWave(int newWave){
		this.wave = newWave;
	}
	public int getWave() {
		return wave;
	}
}
