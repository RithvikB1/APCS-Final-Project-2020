package other;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	private PImage g;
	
	private int cMouseX, cMouseY;
	private int menuToggle;
	
	private Menu menu;
	
	public DrawingSurface() {
		menu = new Menu();
		
		menuToggle = 0;
	}
	
	public void draw() {
		background(255);
		
		if (!(menuToggle == -1)) {
			startMenuDirects();
			return;
		}
		
		g = loadImage("images/arenaBackground.jpg");
		image(g, 0, 0, 800, 600);
	}
	
	public void startMenuDirects() {
		if (!(menuToggle == -1)) { //stops when game is started
			
			int x;
			
			if (menuToggle == 3 || menuToggle == 4) {
				x = menuToggle;
			}
			else {
				x = menu.drawStartMenu(this, mouseX, mouseY, cMouseX, cMouseY);
			}
			
			if (x == 0) {
				return;
			}
			else if (x == 1) {
				menuToggle = -1;
				cMouseX = -1;
				cMouseY = -1;
			}
			else if (x == 2) {

				
				System.exit(0);
			}
			else if (x == 3) {
				x = menu.drawSettingsMenu(this, mouseX, mouseY, cMouseX, cMouseY);
				
//				menuToggle = 3;
			}
			else if (x == 4) {
				x = menu.drawRulesScreen(this, mouseX, mouseY, cMouseX, cMouseY);
				
				menuToggle = 4;
				
				if (x == 1) 
					menuToggle = 1;
				
				cMouseX = -1;
				cMouseY = -1;
				
				
			} 
		}
		
	}
	
	public void chooseCharacter()
	{
		
	}
	
	public void mouseClicked()
	{
		cMouseX = mouseX;
		cMouseY = mouseY;
		
	}
}
