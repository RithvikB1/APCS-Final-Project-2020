package other;

import processing.core.*;
import processing.sound.*;

public class DrawingSurface extends PApplet {
	
	private PImage g, i;
	
	private Menu menu;
	
	private String audioPath = "images/smash.wav";
	
	private SoundFile file;
	
	public DrawingSurface() {
		menu = new Menu();
	}
	
	public void setup() {
		background(255);
		
		g = loadImage("images/arenaBackground.jpg");
		i = loadImage("images/menuBackground.jpg");
		
		file = new SoundFile(this, audioPath);
		file.play();
	}
	
	public void draw() {
		file.amp((float)(menu.getVolume() / 100.0));
		
		if (menu.getMenuToggle() != 0) {
			menu.menuMaker(this, i, mouseX, mouseY);
			
			return;
		}
		
		image(g, 0, 0, 800, 600);
		
	}
	
	public void mouseClicked() {
		menu.mouseClicked(mouseX, mouseY);
	}
	
	public void mouseDragged() {
		menu.mouseDragged(mouseX, mouseY, pmouseX, pmouseY);
	}
	
	public void mousePressed() {
		menu.mousePressed(mouseX, mouseY);
	}
	
	public void mouseReleased() {
		menu.mouseReleased(mouseX, mouseY);
	}
	
	public void keyPressed() {
		menu.keyPressed(keyCode);
	}
	
	public void keyReleased() {
		menu.keyReleased(keyCode);
	}
}