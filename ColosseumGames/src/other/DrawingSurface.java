package other;

import processing.core.*;
import processing.sound.*;

public class DrawingSurface extends PApplet {
	
	private PImage g, i, hercules;
	
	private Menu menu;
	
	private String audioPath = "images/smash.wav";
	
	private SoundFile file;
	private int count;
	
	public DrawingSurface() {
		menu = new Menu();
	}
	
	public void setup() {
		background(255);
		
		g = loadImage("images/arenaBackground.jpg");
		i = loadImage("images/TitleScreen.png");
		hercules = loadImage("sprites/Hercules/FacingRight.png");
		
		file = new SoundFile(this, audioPath);
	}
	
	public void draw() {
		
		if (menu.getIsSoundOn()) {
			file.amp((float)(menu.getVolume() / 100.0));
			if (count == 0)
				file.play();
			count++;
		}
		else {
			count = 0;
			file.pause();
		}
		
		if (menu.getMenuToggle() != 0) {
			menu.menuMaker(this, i, hercules, mouseX, mouseY);
			
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