package other;
import processing.core.PApplet;

public class Menu {

	private int difficultyLevel; // 1 is easy, 2 is medium, while 3 is hard. Default is easy.
	
	public Menu() {
		difficultyLevel = 1; 
	}
	
	public void drawStartMenu(PApplet marker, int mouseX, int mouseY) { // will change difficulty level according to user input
		
	}

	public boolean drawDeathMenu(PApplet marker, int mouseX, int mouseY) { // returns false if user would like to quit game, true if user would like to play game again
		return true;
	}
	
	public void drawPauseMenu(PApplet marker, int mouseX, int mouseY) { 

	}
	
	public void drawMerchantMenu(PApplet marker, int mouseX, int mouseY) {
		
	}
	
	public void drawRulesScreen(PApplet marker) {
		
	}
	
	public int getDiffLevel() {
		return difficultyLevel;
	}
	
	
}
