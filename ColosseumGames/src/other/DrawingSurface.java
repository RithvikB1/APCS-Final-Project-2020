package other;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	private PImage g;
	
	private int cMouseX, cMouseY;
	
	private boolean isStartComplete;
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
		if (!(menuToggle == -1)) {
			int x = 0;
			
			if (menuToggle == 1) {
				x = 4;
			}
			else {
				x = menu.drawStartMenu(this, mouseX, mouseY, cMouseX, cMouseY);
			}
			
			if (x == -1) {
				return;
			}
			
			if (x == 1) {
				menuToggle = -1;
				cMouseX = -1;
				cMouseY = -1;
			}
			else if (x == 2) {
				System.exit(0);
			}
			else if (x == 3) {
				
			}
			else if (x == 4) {
				x = menu.drawRulesScreen(this, mouseX, mouseY, cMouseX, cMouseY);
				
				menuToggle = 1;
				
				if (x == 1) {
					menuToggle = 0;
				}
				
				cMouseX = -1;
				cMouseY = -1;
				
				
			} 
		}
		
	}
	
	public void mouseClicked()
	{
		cMouseX = mouseX;
		cMouseY = mouseY;
		
	}
}
