package other;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	PImage g;
	
	private int cMouseX, cMouseY;
	
	public DrawingSurface() {
		Menu menu1 = new Menu();
		menu1.drawStartMenu(this, mouseX, mouseY);
	}
	
	public void draw() {
		background(0);
		Menu menu1 = new Menu();
		
		while (cMouseX == 0 && cMouseY == 0)
		{
			if (cMouseX != 0 & cMouseY != 0)
			{
				break;
			}
		}
		
		menu1.drawStartMenu(this, cMouseX, cMouseY);
		
	}
	
	public void mouseClicked()
	{
		cMouseX = mouseX;
		cMouseY = mouseY;
		
	}
}
