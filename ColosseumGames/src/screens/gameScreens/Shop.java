package screens.gameScreens;

import java.awt.Rectangle;

import heroes.*;
import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PShape;
import processing.event.MouseEvent;
import screens.other.Screen;

/**
 * Creates a screen that allows user to upgrade their stats
 * @author Rithvik
 */
public class Shop extends Screen {

	private DrawingSurface surface;
	
	private Rectangle atkSpeed, health, speed, range, damage, confirm;
	
	private boolean isClicked1, isClicked2, isClicked3, isClicked4, isClicked5;
	
	private int specificStat;
	
	public Shop(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		isClicked1 = false;
		isClicked2 = false;
		isClicked3 = false;
		isClicked4 = false;
		isClicked5 = false;
		
		atkSpeed = new Rectangle();
		health = new Rectangle();
		speed = new Rectangle();
		range = new Rectangle();
		damage = new Rectangle();
		
		confirm = new Rectangle();
		
		specificStat = NONE;
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		surface.pushStyle();
		surface.fill(200, 150, 250);
		surface.stroke(0);
		
		surface.rect(0, 100, SCREEN_WIDTH, 440);
		surface.line(100, 200, 1200, 200);
		
		atkSpeed = new Rectangle(80, 250, 200, 100);
		health = new Rectangle(310, 250, 200, 100);
		speed = new Rectangle(540, 250, 200, 100);
		range = new Rectangle(770, 250, 200, 100);
		damage = new Rectangle(1000, 250, 200, 100);
		
		confirm = new Rectangle(485, 420, 330, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 80, 250, 200, 100);
		PShape shape2 = surface.createShape(PConstants.RECT, 310, 250, 200, 100);
		PShape shape3 = surface.createShape(PConstants.RECT, 540, 250, 200, 100);
		PShape shape4 = surface.createShape(PConstants.RECT, 770, 250, 200, 100);
		PShape shape5 = surface.createShape(PConstants.RECT, 1000, 250, 200, 100);
		
		PShape shape6 = surface.createShape(PConstants.RECT, 485, 420, 330, 100);
		
		int c1 = surface.color(204, 153, 0); // +230 -200
		int c2 = surface.color(140, 153, 0);
		int c3 = surface.color(140, 220, 0);
		
		hover(atkSpeed, shape, c1, c2);
		hover(health, shape2, c1, c2);
		hover(speed, shape3, c1, c2);
		hover(range, shape4, c1, c2);
		hover(damage, shape5, c1, c2);
		
		if (isClicked1) {
			shape.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked2) {
			shape2.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked3) {
			shape3.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked4) {
			shape4.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked5) {
			shape5.setFill(surface.color(255, 0, 0));
		}
		
		if (isClicked1 || isClicked2 || isClicked3 || isClicked4 || isClicked5) {
			hover(confirm, shape6, c1, c2);
			
			surface.shape(shape6);
		}
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		surface.shape(shape4);
		surface.shape(shape5);
		
		surface.fill(c3);
		surface.ellipseMode(PConstants.CORNER);
		surface.textSize(30);
		
		if (atkSpeed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(80, 300, 200, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[1], 165, 380);
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(310, 300, 200, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[3], 350, 380);
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(540, 300, 200, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[0], 620, 380);
		}
		else if (range.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(770, 300, 200, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[2], 860, 380);
		}
		else if (damage.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(1000, 300, 200, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[4], 1080, 380);
		}
		
		surface.textSize(60);
		surface.fill(0);
		surface.text("Upgrade Stats", 450, 175);
		
		surface.textSize(40);
		surface.text("AtkSpeed", 90, 315);
		surface.text("Health", 350, 315);
		surface.text("Speed", 580, 315);
		surface.text("Range", 805, 315);
		surface.text("Damage", 1015, 315);
		
		if (isClicked1 || isClicked2 || isClicked3 || isClicked4 || isClicked5) 
			surface.text("Confirm", 570, 485);
		
		surface.update();
		
		surface.popStyle();
		
	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousedReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked() {
		
		if (atkSpeed.contains(surface.mouseX, surface.mouseY)) {
			specificStat = ATK_SPEED;
			isClicked1 = true;
			isClicked2 = false;
			isClicked3 = false;
			isClicked4 = false;
			isClicked5 = false;
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			specificStat = HP;
			isClicked1 = false;
			isClicked2 = true;
			isClicked3 = false;
			isClicked4 = false;
			isClicked5 = false;
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			specificStat = SPEED;
			isClicked1 = false;
			isClicked2 = false;
			isClicked3 = true;
			isClicked4 = false;
			isClicked5 = false;
		}
		else if (range.contains(surface.mouseX, surface.mouseY)) {
			specificStat = RANGE;
			isClicked1 = false;
			isClicked2 = false;
			isClicked3 = false;
			isClicked4 = true;
			isClicked5 = false;
		}
		else if (damage.contains(surface.mouseX, surface.mouseY)) {
			specificStat = DAMAGE;
			isClicked1 = false;
			isClicked2 = false;
			isClicked3 = false;
			isClicked4 = false;
			isClicked5 = true;
		}
		
		if ((isClicked1 || isClicked2 || isClicked3 || isClicked4 || isClicked5) && confirm.contains(surface.mouseX, surface.mouseY)) {
			setStat(specificStat);
			setDisplayShop(false);
			surface.update();
			surface.toggleScreen(DrawingSurface.GAME_SCREEN);
		}
		
	}
	
	public int[] displayUpgrades() {
		int[] upgrades = new int[5];
		
		if (getSpecificHero() == HERCULES) {
			upgrades[0] = Hercules.UP_SPEED;
			upgrades[1] = Hercules.UP_ATK_SPEED;
			upgrades[2] = Hercules.UP_RANGE;
			upgrades[3] = Hercules.UP_HP;
			upgrades[4] = Hercules.UP_DAMAGE;
		}
		else if (getSpecificHero() == ACHILLES) {
			upgrades[0] = Achilles.UP_SPEED;
			upgrades[1] = Achilles.UP_ATK_SPEED;
			upgrades[2] = Achilles.UP_RANGE;
			upgrades[3] = Achilles.UP_HP;
			upgrades[4] = Achilles.UP_DAMAGE;
		}
		else if (getSpecificHero() == CHIRON) {
			upgrades[0] = Chiron.UP_SPEED;
			upgrades[1] = Chiron.UP_ATK_SPEED;
			upgrades[2] = Chiron.UP_RANGE;
			upgrades[3] = Chiron.UP_HP;
			upgrades[4] = Chiron.UP_DAMAGE;
		}
		else if (getSpecificHero() == HELEN) {
			upgrades[0] = Helen.UP_SPEED;
			upgrades[1] = Helen.UP_ATK_SPEED;
			upgrades[2] = Helen.UP_RANGE;
			upgrades[3] = Helen.UP_HP;
			upgrades[4] = Helen.UP_DAMAGE;
		}
		else if (getSpecificHero() == PERSEUS) {
			upgrades[0] = Perseus.UP_SPEED;
			upgrades[1] = Perseus.UP_ATK_SPEED;
			upgrades[2] = Perseus.UP_RANGE;
			upgrades[3] = Perseus.UP_HP;
			upgrades[4] = Perseus.UP_DAMAGE;
		}
		
		return upgrades;
	}
	
	public void mouseWheel(MouseEvent e) {
		
	}

	@Override
	public void keyPressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased() {
		// TODO Auto-generated method stub
		
	}

}
