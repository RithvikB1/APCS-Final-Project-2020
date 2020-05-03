package other;

import java.util.ArrayList;

import characters.Hero;
import processing.core.*;
import processing.sound.*;

public class DrawingSurface extends PApplet {
	
	private PImage g, i, hercules, achilles;
	
	private Screen screen;
	private ArrayList<PImage> images;
	
	private String audioPath = "images/Music.wav";
	
	private SoundFile file;
	private Hero hero;
	
	public DrawingSurface() {
		screen = new Screen();
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
		
		if (screen.getScreenToggle() != 0) {
			screen.screenSifter(this,  images, mouseX, mouseY);
			
			if (screen.getScreenToggle() == 0)
			{
				hero = screen.choiceOfHero();
			}
			
			return;
		}
		
		image(g, 0, 0, 800, 600);
		
		hero.moveByVelocities();
		hero.spawn(this, hercules);
				
	}
	
	public void playSound() {
		if (screen.getIsSoundOn()) {
			file.amp((float)(screen.getVolume() / 100.0));
			
			if (!file.isPlaying())
				file.play();
		}
		else if (file.isPlaying()) {
			file.pause();
		}
	}
	
	public void mouseClicked() {
		screen.mouseClicked(mouseX, mouseY);
	}
	
	public void mouseDragged() {
		screen.mouseDragged(mouseX, mouseY, pmouseX, pmouseY);
	}
	
	public void mousePressed() {
		screen.mousePressed(mouseX, mouseY);
	}
	
	public void mouseReleased() {
		screen.mouseReleased(mouseX, mouseY);
	}
	
	public void keyPressed() {
		if (hero == null) {
			return;
		}
	
		if (keyCode == screen.getKeys()[0])
		{
			hero.walk(4);
		}
		
		if (keyCode == screen.getKeys()[2])
		{
			hero.walk(3);
		}
		
		if (keyCode == screen.getKeys()[1])
		{
			hero.walk(2);
		}
		
		if (keyCode == screen.getKeys()[3])
		{
			hero.walk(1);


		}
		
		
	}
	
	public void keyReleased() {
		
		screen.keyReleased(keyCode);
		
		if (hero == null)
			return;
		
		hero.walk(5);
	}
}