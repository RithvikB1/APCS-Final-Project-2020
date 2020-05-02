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
	private Hero hero;
	
	public DrawingSurface() {
		menu = new Menu();
	}
	
	public void setup() {
		background(255);
		setSize(800, 600);
		
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
		
		playSound();
		
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
		hero.spawn(this, hercules);
				
	}
	
	public void playSound() {
		if (menu.getIsSoundOn()) {
			file.amp((float)(menu.getVolume() / 100.0));
			if (!file.isPlaying())
				file.play();
		}
		else if (file.isPlaying()) {
			file.pause();
		}
		else {
			file.stop();
		}
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
		
		if (hero == null)
			return;
		
		hero.walk(5);
	}
}