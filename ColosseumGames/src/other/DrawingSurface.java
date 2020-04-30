package other;

import processing.core.*;

public class DrawingSurface extends PApplet {
	
	private PImage g, i;
	
	private Menu menu;
	
	public DrawingSurface() {
		menu = new Menu();
	}
	
	public void setup() {
		background(255);
		
		g = loadImage("images/arenaBackground.jpg");
		i = loadImage("images/menuBackground.jpg");
	}
	
	public void draw() {
		if (menu.getMenuToggle() != 0) {
			menuMaker();
			
			return;
		}
		
		image(g, 0, 0, 800, 600);
		
	}
	
	public void mouseClicked() {
		menu.mouseClicked(mouseX, mouseY);
	}
	
	public void mouseDragged() {
		menu.mouseDragged(mouseX, mouseY);
	}
	
	public void mousePressed() {
		menu.mousePressed(mouseX, mouseY);
	}
	
	public void mouseReleased() {
		menu.mouseReleased(mouseX, mouseY);
	}
	
	public void menuMaker() {
		int menuToggle = menu.getMenuToggle();
		
		if (menuToggle == 1) {
			menu.drawStartMenu(this, i, mouseX, mouseY);
		}
		else if (menuToggle == 2) {
			menu.drawHeroMenu(this, mouseX, mouseY);
		}
		else if (menuToggle == 3) {
			System.exit(0);
		}
		else if (menuToggle == 4) {
			menu.drawSettingsMenu(this, i, mouseX, mouseY);
		}
		else if (menuToggle == 5) {
			menu.drawRulesScreen(this, i, mouseX, mouseY);
		}
		else if (menuToggle == 6) {
			menu.drawCredits(this, i, mouseX, mouseY);
		}
		else if (menuToggle == 7) {
			menu.drawPauseMenu(this, mouseX, mouseY);
		}
	}
}