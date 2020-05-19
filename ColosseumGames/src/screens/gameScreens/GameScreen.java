package screens.gameScreens;

import java.awt.Rectangle;
import java.util.ArrayList;

import characters.Enemy;
import characters.Hero;
import enemies.FinalBoss;
import enemies.Harpy;
import enemies.Hydra;
import enemies.Hydramite;
import enemies.Minotaur;
import heroes.*;
import other.Bullet;
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
	
	
	private ArrayList<Bullet> bullets, arrows;
	private Hercules herculesH;
	private Achilles achillesH;
	private Chiron chironH;
	private Helen helenH;
	private Perseus perseusH;
	
	public GameScreen(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
//		
		
		wave = new Wave();
		enemiesInWave = wave.getEnemyList();
//		
		
		bullets = new ArrayList<Bullet>();
		arrows = new ArrayList<Bullet>();
		
		keys = new boolean[4];
		
		herculesH = new Hercules(Hercules.SPEED, Hercules.ATK_SPEED, Hercules.HP, Hercules.RANGE, Hercules.DAMAGE);
		achillesH = new Achilles(Achilles.SPEED, Achilles.ATK_SPEED, Achilles.HP, Achilles.RANGE, Achilles.DAMAGE);
		chironH = new Chiron(Chiron.SPEED, Chiron.ATK_SPEED, Chiron.HP, Chiron.RANGE, Chiron.DAMAGE);
		helenH = new Helen(Helen.SPEED, Helen.ATK_SPEED, Helen.HP, Helen.RANGE, Helen.DAMAGE);
		perseusH = new Perseus(Perseus.SPEED, Perseus.ATK_SPEED, Perseus.HP, Perseus.RANGE, Perseus.DAMAGE);
		
	}

	public void setup() {
		background = surface.loadImage("files/images/Background.png");
				
	}
	
	public void draw() {
		surface.pushStyle();
		surface.noTint();
		pickHero();
		
//		if (wave.getWave() == 4) { // merchant menu
//			surface.tint(0, 255, 126);
//			surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
//			surface.toggleScreen(DrawingSurface.MERCHANT_MENU);
//		}
		if (hero.die()) {
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
			wave.startWave(surface, hero);
		}
		for(int i = 0; i < enemiesInWave.size(); i++) {
			if(!enemiesInWave.get(i).die()) {
				if(!hero.die()) {
					enemiesInWave.get(i).behave(hero, surface);
					enemiesInWave.get(i).moveByVelocities();
				}
				enemiesInWave.get(i).spawn(surface, enemiesInWave.get(i).getImageNumber());
				if(enemiesInWave.get(i) instanceof Hydra || enemiesInWave.get(i) instanceof FinalBoss) {
					bullets = enemiesInWave.get(i).getBullets();
					for(int b = 0; b < bullets.size(); b++) {
						if(!(bullets.get(b).getCollisionCounter() == 3)) {
							enemiesInWave.get(i).animateAttack(1);
							bullets.get(b).launch(50);
							bullets.get(b).moveByVelocities();
							bullets.get(b).draw(surface);
							if(bullets.get(b).intersects(hero)) {
								hero.setHP(hero.getHP() - enemiesInWave.get(i).getDamage());
							}
						}
						else {
							bullets.remove(b);
						}
					}

				}
			}
			else {
				if(enemiesInWave.get(i) instanceof Minotaur) {
					hero.setHP(hero.getHP() + 100);
				} else if(enemiesInWave.get(i) instanceof Harpy) {
					hero.setHP(hero.getHP() + 50);
				}
				else if(enemiesInWave.get(i) instanceof Hydra) {
					enemiesInWave.add(new Hydramite(20, 20, 20, 20, 2000, (int)enemiesInWave.get(i).getX() + 10,  (int)enemiesInWave.get(i).getY() + 50, 50, 50));
					enemiesInWave.add(new Hydramite(20, 20, 20, 20, 2000, (int)enemiesInWave.get(i).getX(),  (int)enemiesInWave.get(i).getY(), 50, 50));
					enemiesInWave.add(new Hydramite(20, 20, 20, 20, 2000, (int)enemiesInWave.get(i).getX() + 10,  (int)enemiesInWave.get(i).getY() + 50, 50, 50));
					hero.setHP(hero.getHP() + 500);
					for (Enemy a : enemiesInWave)
					{
						a.setup(surface);
					}
				}
				enemiesInWave.remove(i);
			}
		}
		if (!hero.die() && surface.mousePressed) {
			if(hero.isChiron()) {
				hero.shoot(surface.mouseX, surface.mouseY, surface, enemiesInWave, hero.getX(), hero.getY());
				arrows = hero.getArrows();
			}
			else {
				hero.shoot(surface.mouseX, surface.mouseY, surface, enemiesInWave, hero.getX(), hero.getY());
			}
		}
		for(int a = 0; a < arrows.size(); a++) {
			if(!(arrows.get(a).getCollisionCounter() == 1)) {
				arrows.get(a).launch(30);
				arrows.get(a).moveByVelocities();
				arrows.get(a).draw(surface);
				for(Enemy e : enemiesInWave) {
					if(arrows.get(a).intersects(e)) {
						e.setHP(e.getHP() - hero.getDamage());
					}
				}
				if(Math.sqrt(Math.pow(arrows.get(a).getX() - hero.getX(), 2) + Math.pow(arrows.get(a).getY() - hero.getY(), 2)) > hero.getRange()){
					arrows.remove(a);
				}
			}
			else {
				arrows.remove(a);
			}
		}
		
		if(!hero.die()) {
			hero.moveByVelocities();
			hero.spawn(surface, hero.getImageNumber());
			
			surface.textSize(60);
//			
			surface.fill(255);
			surface.stroke(255);
			
			surface.line(0, 700, 1300, 700);
			
			surface.text("HP: " + (int)hero.getHP() + "/"+ hero.getMaxHP(), 370, 770);
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
			hero = herculesH;
		}
		else if (getSpecificHero() == ACHILLES) {
			hero = achillesH;
		}
		else if (getSpecificHero() == CHIRON) {
			hero = chironH;
		}
		else if (getSpecificHero() == HELEN) {
			hero = helenH;
		}
		else if (getSpecificHero() == PERSEUS) {
			hero = perseusH;
		}
		
		System.out.println(getSpecificHero());
		hero.setup(surface);
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
				hero.animate(4);
		}
		else if (keys[1]) {
			if (keys[2]) 
				hero.walk(8); // down-left
			else if (keys[3])
				hero.walk(5); // down-right
			else 
				hero.walk(2); // up
				hero.animate(2);
		}
		else if (keys[2]) {
			hero.walk(3); // left
			hero.animate(3);
		}
		else if (keys[3]) {
			hero.walk(1); // right
			hero.animate(1);
		}
		
	}

	public void keyReleased() {
		if (surface.keyCode == getUpKey()) // up
			keys[0] = false;
			hero.setImageNumber(4);
		if (surface.keyCode == getLeftKey()) // left
			keys[2] = false;
			hero.setImageNumber(3);
		if (surface.keyCode == getDownKey()) // down
			keys[1] = false;
			hero.setImageNumber(2);
		if (surface.keyCode == getRightKey()) // right
			keys[3] = false;
			hero.setImageNumber(1);
		
		hero.walk(9);
	}

}
