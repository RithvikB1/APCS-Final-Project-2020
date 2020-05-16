package screens.gameScreens;

import java.awt.Rectangle;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import enemies.Harpy;
import enemies.Minotaur;
import heroes.*;
import other.DrawingSurface;
import other.Wave;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.sound.SoundFile;
import screens.other.Screen;

/**
 * Creates a screen that has the components of the playable game
 * @author Aditya
 *
 */
public class GameScreen extends Screen {

	private DrawingSurface surface;
	
	private PImage background, hercules1, hercules2, achilles1, achilles2, chiron1, helen1, helen2, perseus1;
	
	private ArrayList<PImage> harpy, minotaur;
	private ArrayList<ArrayList> enemies;
	
	private ArrayList<Enemy> enemiesInWave;
	private Wave wave;
	
	private Hero hero;
	
	private boolean[] keys;
	
	private Rectangle pause;
	
	private ArrayList<PImage> hercules, achilles, chiron, helen, perseus;
	
	public GameScreen(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		enemies = new ArrayList<>();
		harpy = new ArrayList<>();
		minotaur = new ArrayList<>();
		
		wave = new Wave();
		enemiesInWave = wave.getEnemyList();
		
		hercules = new ArrayList<PImage>();
		achilles = new ArrayList<PImage>();
		chiron = new ArrayList<PImage>();
		helen = new ArrayList<PImage>();
		perseus = new ArrayList<PImage>();
		
		keys = new boolean[4];
	}

	public void setup() {
		background = surface.loadImage("files/images/Background.png");
		
		harpy.add(surface.loadImage("sprites/Enemies/Harpy/HarpyWalkRight2.png"));
		minotaur.add(surface.loadImage("sprites/Enemies/Minotaur/MinotaurFacingRight.png"));
		
		hercules1 = surface.loadImage("sprites/Heroes/Hercules/PRESelectedHercules.png");
		hercules2  = surface.loadImage("sprites/Heroes/Hercules/HerculesSelected.png");
		hercules.add(hercules1);
		hercules.add(hercules2);
		
		achilles1 = surface.loadImage("sprites/Heroes/Achilles/PRESelectedAchilles.png");
		achilles2 = surface.loadImage("sprites/Heroes/Achilles/AchillesSelected.png");
		achilles.add(achilles1);
		achilles.add(achilles2);
		
		chiron1 = surface.loadImage("sprites/Heroes/Chiron/Chiron.jpg");
		chiron.add(chiron1);
		
		helen1 = surface.loadImage("sprites/Heroes/Helen/PRESelectedHelen.png");
		helen2 = surface.loadImage("sprites/Heroes/Helen/HelenSelected.png");
		helen.add(helen1);
		helen.add(helen2);
		
		perseus1 = surface.loadImage("sprites/Heroes/Perseus/Perseus.png");
		perseus.add(perseus1);
		
		enemies.add(harpy);
		enemies.add(minotaur);
	}
	
	public void draw() {
		surface.pushStyle();
		surface.noTint();
		pickHero();
		
		if (wave.getWave() == 4) { // merchant menu
			surface.tint(0, 255, 126);
			surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			surface.toggleScreen(DrawingSurface.MERCHANT_MENU);
		}
		else if (hero.die()) {
			wave = new Wave();
			enemiesInWave = wave.getEnemyList();
			surface.tint(255, 126, 0);
			surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
			hero = null;
			surface.toggleScreen(DrawingSurface.DEATH_MENU);
			
			return;
		}
		else {
			surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		}
		
		//when enemies HP = 0 remove from arraylist and arraylist => 0 start nextwave
		if(enemiesInWave.size() == 0) {
			wave.setWave(wave.getWave() + 1);
			wave.startWave(surface, hero, enemies);
		}
		for(int i = 0; i < enemiesInWave.size(); i++) {
			if(!enemiesInWave.get(i).die()) {
				if(!hero.die()) {
					enemiesInWave.get(i).behave(hero, surface);
					enemiesInWave.get(i).moveByVelocities();
				}
				enemiesInWave.get(i).spawn(surface, 0);
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
		if (!hero.die() && surface.mousePressed)
			hero.shoot(surface.mouseX, surface.mouseY, surface, enemiesInWave, hero.getX(), hero.getY());
		
		if(!hero.die()) {
			hero.moveByVelocities();
			hero.spawn(surface, 1);
			
			surface.textSize(60);
//			
			surface.fill(255);
			surface.stroke(255);
			
			surface.line(0, 700, 1300, 700);
			
			surface.text("HP: " + (int)hero.getHP() + "/10000", 370, 770);
//			
			surface.textSize(30);
//			surface.fill(255);
//			
			surface.text("Speed: " + (int)hero.getSpeed(), 150, 680);
			
			surface.text("AttackSpeed: " + (int)hero.getAtkSpeed(), 544, 680);
			
			surface.text("Damage: " + (int)hero.getDamage(), 961,680);
		}
		
		pause = new Rectangle(1150, 10, 50, 50);
		PShape pause = surface.createShape(PConstants.RECT, 1150, 10, 50, 50);
		hover(this.pause, pause, 255, 150);
		surface.shape(pause);
		
		surface.stroke(0);
		
		surface.pushStyle();
		surface.strokeWeight(0);
		
		surface.line(40, 40, 1260, 40);
		
		surface.line(40, 40, 40, 600);
		
		surface.line(40, 600, 1260, 600);
		
		surface.line(1260, 40, 1260, 600);
		
		surface.strokeWeight(10);
		
		surface.line(1165, 20, 1165, 50);
		surface.line(1185, 20, 1185, 50);
		
		surface.popStyle();
		surface.popStyle();
		
	}
	
	public void pickHero() {
		if (hero != null) {
			return;
		}
		
		if (getSpecificHero() == HERCULES) {
			hero = new Hercules(hercules, 20, 10, 10000, 100, 100, 600, 300, 100, 100);
		}
		else if (getSpecificHero() == ACHILLES) {
			hero = new Achilles(achilles, 10, 10, 100000 ,100, 100, 600, 300, 100, 100);
		}
		else if (getSpecificHero() == CHIRON) {
			hero = new Chiron(chiron, 10, 10, 100000 ,100, 100, 600, 300, 100, 100);
		}
		else if (getSpecificHero() == HELEN) {
			hero = new Helen(helen, 10, 10, 300000, 400, 250, 600, 300, 100, 100);
		}
		else if (getSpecificHero() == PERSEUS) {
			hero = new Perseus(perseus, 10, 10, 100000 ,100, 100, 600, 300, 100, 100);
		}
	}

	public void mousePressed() {
		
	}

	public void mousedReleased() {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged() {
		if (!hero.die())
			hero.shoot(surface.mouseX, surface.mouseY, surface, enemiesInWave, hero.getX(), hero.getY());
		
	}

	public void mouseClicked() {
		if (pause.contains(surface.mouseX, surface.mouseY))
			surface.toggleScreen(DrawingSurface.PAUSE_MENU);
		
	}

	public void keyPressed() {
		if (hero == null || hero.die()) {
			return;
		}
		
		if (surface.keyCode == getUpKey()) // up
			keys[0] = true;
		if (surface.keyCode == getLeftKey()) // left
			keys[2] = true;
		if (surface.keyCode == getDownKey()) // down
			keys[1] = true;
		if (surface.keyCode == getRightKey()) // right
			keys[3] = true;
		
		if (keys[0]) {
			if (keys[2]) 
				hero.walk(7); // up-left
			else if (keys[3])
				hero.walk(6); // up-right
			else
				hero.walk(4); // up
		}
		else if (keys[1]) {
			if (keys[2]) 
				hero.walk(8); // down-left
			else if (keys[3])
				hero.walk(5); // down-right
			else 
				hero.walk(2); // up
		}
		else if (keys[2]) {
			hero.walk(3); // left
		}
		else if (keys[3]) {
			hero.walk(1); // right
		}
		
	}

	public void keyReleased() {
		if (surface.keyCode == getUpKey()) // up
			keys[0] = false;
		if (surface.keyCode == getLeftKey()) // left
			keys[2] = false;
		if (surface.keyCode == getDownKey()) // down
			keys[1] = false;
		if (surface.keyCode == getRightKey()) // right
			keys[3] = false;
		
		hero.walk(9);
	}

}
