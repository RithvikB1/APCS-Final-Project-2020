package other;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {
	
	private PImage g, i;
	
	private int cmouseX, cmouseY;
	private int menuToggle;
	
	private Menu menu;
	
	public DrawingSurface() {
		menuToggle = 1;
		
		menu = new Menu();
		
	}//
	//called after object finished constructing
	//initialization 
	public void setup() {
		
		g = loadImage("images/arenaBackground.jpg");
		
		i = loadImage("images/menuBackground.jpg");
		
		//load all images in here
		/*
		 * 1. Load images then call methods
		 * 2. Each screen give setup method then call here
		 */
	}
	
	public void draw() {
		background(255);
		
		if (menuToggle != 0) {
			menuMaker();
			return;
		}
		
		image(g, 0, 0, 800, 600);
		
		
	}
	
	public void chooseCharacter()
	{
		int x;
		
	}
	
	public void mouseClicked()
	{
		cmouseX = mouseX;
		cmouseY = mouseY;
		
	}
	
	public void menuMaker() {
		menuToggle = menu.getMenuToggle();
		
		if (menuToggle == 1) {
			menu.drawStartMenu(this, i, mouseX, mouseY, cmouseX, cmouseY);
			cmouseX = -1;
			cmouseY = -1;
		}
		else if (menuToggle == 2) {
			System.exit(0);
		}
		else if (menuToggle == 3) {
			menu.drawSettingsMenu(this, i, mouseX, mouseY, cmouseX, cmouseY, pmouseX, pmouseY);
			cmouseX = -1;
			cmouseY = -1;
		}
		else if (menuToggle == 4) {
			menu.drawRulesScreen(this, i, mouseX, mouseY, cmouseX, cmouseY);
			cmouseX = -1;
			cmouseY = -1;
		}
	}
}