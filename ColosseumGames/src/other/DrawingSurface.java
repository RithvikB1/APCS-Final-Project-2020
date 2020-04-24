package other;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	private PImage g;
	
	private int cMouseX, cMouseY;
	
	public DrawingSurface() {
		
	}
	
	public void draw() {
		background(255);
		
		startMenuDirects();
	}
	
	public void startMenuDirects() {
		Menu menu = new Menu();
		
		int x = menu.drawStartMenu(this, mouseX, mouseY, cMouseX, cMouseY);
		
		if (x == -1) {
			return;
		}
		
		if (x == 1) {
			g = loadImage("images/arenaBackground.jpg");
			image(g, 0, 0, 800, 600);
		}
		else if (x == 2) {
			System.exit(0);
		}
		else if (x == 3) {
			
		}
		else if (x == 4) {
			
		}
	}
	
	public void mouseClicked()
	{
		cMouseX = mouseX;
		cMouseY = mouseY;
		
	}
}
