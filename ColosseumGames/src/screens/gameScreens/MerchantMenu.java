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
public class MerchantMenu extends Screen {

	private DrawingSurface surface;
	
	private Rectangle atkSpeed, health, speed, range, confirm;
	
	private boolean isClicked1, isClicked2, isClicked3, isClicked4;
	
	private int specificStat;
	
	public MerchantMenu(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		isClicked1 = false;
		isClicked2 = false;
		isClicked3 = false;
		isClicked4 = false;
		
		atkSpeed = new Rectangle();
		health = new Rectangle();
		speed = new Rectangle();
		range = new Rectangle();
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
		
		surface.rect(100, 100, 1100, 440);
		surface.line(100, 200, 1200, 200);
		
		atkSpeed = new Rectangle(210, 250, 220, 100);
		health = new Rectangle(540, 250, 220, 100);
		speed = new Rectangle(870, 250, 220, 100);
		confirm = new Rectangle(485, 420, 330, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 210, 250, 220, 100);
		PShape shape2 = surface.createShape(PConstants.RECT, 540, 250, 220, 100);
		PShape shape3 = surface.createShape(PConstants.RECT, 870, 250, 220, 100);
		PShape shape4 = surface.createShape(PConstants.RECT, 485, 420, 330, 100);
		
		int c1 = surface.color(204, 153, 0); // +230 -200
		int c2 = surface.color(140, 153, 0);
		int c3 = surface.color(140, 220, 0);
		
		hover(atkSpeed, shape, c1, c2);
		hover(health, shape2, c1, c2);
		hover(speed, shape3, c1, c2);
		
		if (isClicked1) {
			shape.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked2) {
			shape2.setFill(surface.color(255, 0, 0));
		}
		else if (isClicked3) {
			shape3.setFill(surface.color(255, 0, 0));
		}
		
		if (isClicked1 || isClicked2 || isClicked3 || isClicked4) {
			hover(confirm, shape4, c1, c2);
			
			surface.shape(shape4);
		}
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		
		surface.fill(c3);
		surface.ellipseMode(PConstants.CORNER);
		surface.textSize(30);
		
		if (atkSpeed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(210, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[1], 295, 380);
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(540, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[3], 615, 380);
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			surface.arc(870, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			surface.fill(0);
			surface.text(displayUpgrades()[0], 960, 380);
		}
		
		surface.textSize(60);
		surface.fill(0);
		surface.text("Upgrade Stats", 450, 175);
		
		surface.textSize(40);
		surface.text("AtkSpeed", 230, 315);
		surface.text("Health", 590, 315);
		surface.text("Speed", 925, 315);
		
		if (isClicked1 || isClicked2 || isClicked3 || isClicked4) 
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
		}
		else if (health.contains(surface.mouseX, surface.mouseY)) {
			specificStat = HP;
			isClicked1 = false;
			isClicked2 = true;
			isClicked3 = false;
			isClicked4 = false;
		}
		else if (speed.contains(surface.mouseX, surface.mouseY)) {
			specificStat = SPEED;
			isClicked1 = false;
			isClicked2 = false;
			isClicked3 = true;
			isClicked4 = false;
		}
		
		if ((isClicked1 || isClicked2 || isClicked3 || isClicked4) && confirm.contains(surface.mouseX, surface.mouseY)) {
			setStat(specificStat);
			setDisplayShop(false);
			surface.update();
			surface.toggleScreen(DrawingSurface.GAME_SCREEN);
		}
		
	}
	
	public int[] displayUpgrades() {
		int[] upgrades = new int[4];
		
		if (getSpecificHero() == HERCULES) {
			upgrades[0] = Hercules.UP_SPEED;
			upgrades[1] = Hercules.UP_ATK_SPEED;
			upgrades[2] = Hercules.UP_RANGE;
			upgrades[3] = Hercules.UP_HP;
		}
		else if (getSpecificHero() == ACHILLES) {
			upgrades[0] = Achilles.UP_SPEED;
			upgrades[1] = Achilles.UP_ATK_SPEED;
			upgrades[2] = Achilles.UP_RANGE;
			upgrades[3] = Achilles.UP_HP;
		}
		else if (getSpecificHero() == CHIRON) {
			upgrades[0] = Chiron.UP_SPEED;
			upgrades[1] = Chiron.UP_ATK_SPEED;
			upgrades[2] = Chiron.UP_RANGE;
			upgrades[3] = Chiron.UP_HP;
		}
		else if (getSpecificHero() == HELEN) {
			upgrades[0] = Helen.UP_SPEED;
			upgrades[1] = Helen.UP_ATK_SPEED;
			upgrades[2] = Helen.UP_RANGE;
			upgrades[3] = Helen.UP_HP;
		}
		else if (getSpecificHero() == PERSEUS) {
			upgrades[0] = Perseus.UP_SPEED;
			upgrades[1] = Perseus.UP_ATK_SPEED;
			upgrades[2] = Perseus.UP_RANGE;
			upgrades[3] = Perseus.UP_HP;
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
