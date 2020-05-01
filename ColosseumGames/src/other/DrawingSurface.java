package other;

import java.util.ArrayList;

import characters.Hero;
import processing.core.*;
import processing.sound.*;

public class DrawingSurface extends PApplet {
	
	private PImage g, i, hercules, achilles;
	
	private Menu menu;
	private ArrayList<PImage> images;
	
	private String audioPath = "images/smash.wav";
	
	private SoundFile file;
	private int count;
	private Hero hero;
	
	public DrawingSurface() {
		menu = new Menu();
	}
	
	public void setup() {
		background(255);
		
		g = loadImage("images/arenaBackground.jpg");
		i = loadImage("images/TitleScreen.png");
		hercules = loadImage("sprites/Hercules/FacingRight.png");
		achilles = loadImage("sprites/Achilles/PRESelectedAchilles.png");
		
		images = new ArrayList<>();
		images.add(g);
		images.add(i);
		images.add(hercules);
		images.add(achilles);
		
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
			menu.menuMaker(this,  images, mouseX, mouseY);
			
			if (menu.getMenuToggle() == 0)
			{
				hero = menu.choiceOfHero();
			}
			
			return;
		}
		
		image(g, 0, 0, 800, 600);
		
		hero.moveByVelocities();
		hero.draw(this);
				
		
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
		if (hero == null) {
			return;
		}
	
		if (keyCode == menu.getKeys()[0])
		{
			hero.walk(4);
		}
		
		if (keyCode == menu.getKeys()[2])
		{
			hero.walk(3);
		}
		
		if (keyCode == menu.getKeys()[1])
		{
			hero.walk(2);
		}
		
		if (keyCode == menu.getKeys()[3])
		{
			hero.walk(1);


		}
		
		
	}
	
	public void keyReleased() {
		
		menu.keyReleased(keyCode);
		hero.walk(5);
	}
}