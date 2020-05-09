package other;

import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import enemies.Harpy;
import enemies.Minotaur;
import processing.core.*;
import processing.sound.*;

/**
 * Draws all game components such as screens and draws gameplay in action
 * 
 * @author Aditya
 *
 */
public class DrawingSurface extends PApplet {
	
	private Screen screen;
	
	private ArrayList<PImage> images, hercules, achilles, perseus, helen, chiron, harpy, minotaur, bigBoi, miniBoss, finalBoss, enemies;
	private ArrayList<ArrayList> heroes;
	private ArrayList<Enemy> enemiesInWave;
	
	private String audioPath = "files/audio/smash.wav";
	
	private SoundFile file;
	private Hero hero;
	private Wave wave;
	
	/**
	 * Creates a DrawingSurface that can have all game components
	 */
	public DrawingSurface() {
		screen = new Screen();
		wave = new Wave();
	}
	
	/**
	 * Loads all images, sounds, and sets temporary background color
	 */
	public void setup() {
		background(255);
		
		images = new ArrayList<>();
		heroes = new ArrayList<>();
		
		hercules = new ArrayList<>();
		achilles = new ArrayList<>();
		chiron = new ArrayList<>();
		helen = new ArrayList<>();
		perseus = new ArrayList<>();
		
		harpy = new ArrayList<>();
		minotaur = new ArrayList<>();
		enemies = new ArrayList<>();
		
		enemiesInWave = wave.getEnemyList();
		
		images.add(loadImage("files/images/Background.png"));
		images.add(loadImage("files/images/TitleScreen.png"));
		
		hercules.add(loadImage("sprites/Heroes/Hercules/FacingRight.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/FacingFront.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/FacingBack.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/FacingLeft.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/HerculesSelected.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/PRESelectedHercules.png"));
		hercules.add(loadImage("sprites/Heroes/Hercules/AttackBack.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/AttackFront.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/AttackLeft.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/AttackRight.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/WalkBack.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/WalkFront.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/WalkLeft.gif"));
		hercules.add(loadImage("sprites/Heroes/Hercules/WalkRight.gif"));
		
		achilles.add(loadImage("sprites/Heroes/Achilles/PRESelectedAchilles.png"));
		
		chiron.add(loadImage("sprites/Heroes/Chiron/Chiron.jpg"));
		
		helen.add(loadImage("sprites/Heroes/Helen/Helen.png"));
		
		perseus.add(loadImage("sprites/Heroes/Perseus/Perseus.png"));
		
		harpy.add(loadImage("sprites/Enemies/Harpy/WalkRight.png"));
		minotaur.add(loadImage("sprites/Enemies/Minotaur/MinotaurFacingRight.png"));
		
		enemies.add(loadImage("sprites/Enemies/Harpy/WalkRight.png"));
		enemies.add(loadImage("sprites/Enemies/Minotaur/MinotaurFacingRight.png"));
		
		heroes.add(hercules);
		heroes.add(achilles);
		heroes.add(chiron);
		heroes.add(helen);
		heroes.add(perseus);
		
		file = new SoundFile(this, audioPath);
	}
	
	/**
	 * Draws the screens, and starts game when user is done with start menus
	 */
	public void draw() {
		
		playSound();
		
		if (screen.getScreenToggle() != 0) {
			screen.screenSifter(this, images.get(1), heroes, mouseX, mouseY);
			
			if (screen.getScreenToggle() == 0)
			{
				hero = screen.choiceOfHero(heroes);
			}
			
			return;
		}
		
		image(images.get(0), 0, 0, 1300, 800);
		//when enemies HP = 0 remove from arraylist and arraylist => 0 start nextwave
		if(enemiesInWave.size() == 0) {
			wave.setWave(wave.getWave() + 1);
			wave.startWave(this, hero, enemies);
		}
		for(int i = 0; i < enemiesInWave.size(); i++) {
			if(!enemiesInWave.get(i).die()) {
				enemiesInWave.get(i).behave(hero, this);
				enemiesInWave.get(i).moveByVelocities();
				enemiesInWave.get(i).spawn(this);
			}
			else {
				if(enemiesInWave.get(i) instanceof Minotaur) {
					hero.setHP(hero.getHP() + 100);
				} else if(enemiesInWave.get(i) instanceof Harpy) {
					hero.setHP(hero.getHP() + 50);
				}
				enemiesInWave.remove(i);
			}
		}
		
		if(!hero.die()) {
			hero.moveByVelocities();
			hero.spawn(this);
			
			textSize(60);
//			
			fill(255);
			stroke(255);
			
			line(0, 700, 1300, 700);
			
			text("HP: " + (int)hero.getHP() + "/100000", 370, 770);
//			
			textSize(30);
//			fill(255);
//			
			text("Speed: " + (int)hero.getSpeed(), 150, 680);
			
			text("AttackSpeed: " + (int)hero.getAtkSpeed(), 544, 680);
			
			text("Damage: " + (int)hero.getDamage(), 961,680);
		}
		
		this.stroke(0);
		this.line(40, 40, 1260, 40);
		
		this.line(40, 40, 40, 600);
		
		this.line(40, 600, 1260, 600);
		
		this.line(1260, 40, 1260, 600);
		
		
	}
	
	/**
	 * Plays the sound in the game
	 */
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
	
	/**
	 * Dictates what happens with screen when mouse is clicked
	 */
	public void mouseClicked() {
		screen.mouseClicked(mouseX, mouseY);
	}
	
	/**
	 * Dictates what happens with a screen when mouse is dragged
	 */
	public void mouseDragged() {
		screen.mouseDragged(mouseX, mouseY, pmouseX, pmouseY);
		if(screen.getScreenToggle() == 0) {
			hero.shoot(mouseX, mouseY, this, enemiesInWave, hero.getX(), hero.getY());
		}
	}
	
	/**
	 * Dictates what happens with a screen when mouse is pressed
	 */
	public void mousePressed() {
		screen.mousePressed(mouseX, mouseY);
		if(screen.getScreenToggle() == 0) {
			hero.shoot(mouseX, mouseY, this, enemiesInWave, hero.getX(), hero.getY());
		}
	}
	
	/**
	 * Dictates what happens with a screen when mouse is released
	 */
	public void mouseReleased() {
		screen.mouseReleased(mouseX, mouseY);
	}
	
	/**
	 * Moves player according to what directional keys are pressed 
	 */
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
	
	/**
	 * Dictates what happens to screen if keys are released and updates hero accordingly
	 */
	public void keyReleased() {
		
		screen.keyReleased(keyCode);
		
		if (hero == null)
			return;
		
		hero.stop();
	}
}