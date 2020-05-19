package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that allows user to pick their hero
 * @author Rithvik
 *
 */
public class ChooseHero extends Screen {

	private PImage background, hercules1, hercules2, achilles1, achilles2, chiron, helen1, helen2, perseus1, perseus2, chiron2;
	
	private DrawingSurface surface;
	
	private Rectangle previousArrow, nextArrow, next, backButton, settings, hero;
	
	private boolean isHeroPicked;
	
	public ChooseHero(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		previousArrow = new Rectangle();
		nextArrow = new Rectangle();
		next = new Rectangle();
		backButton = new Rectangle();
		settings = new Rectangle();
		hero = new Rectangle();
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
		hercules1 = surface.loadImage("sprites/Heroes/Hercules/PRESelectedHercules.png");
		hercules2  = surface.loadImage("sprites/Heroes/Hercules/HerculesSelected.png");
		
		achilles1 = surface.loadImage("sprites/Heroes/Achilles/PRESelectedAchilles.png");
		achilles2 = surface.loadImage("sprites/Heroes/Achilles/AchillesSelected.png");
		
		chiron = surface.loadImage("sprites/Heroes/Chiron/PRESelectedChiron.png");
		chiron2 = surface.loadImage("sprites/Heroes/Chiron/ChironSelected.png");
		
		helen1 = surface.loadImage("sprites/Heroes/Helen/PRESelectedHelen.png");
		helen2 = surface.loadImage("sprites/Heroes/Helen/HelenSelected.png");
		
		perseus1 = surface.loadImage("sprites/Heroes/Perseus/PRESelectedPerseus.png");
		perseus2 = surface.loadImage("sprites/Heroes/Perseus/PerseusSelected.png");
	}

	public void draw() {
		surface.image(background, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
		previousArrow = new Rectangle(80, 215, 100, 200);
	    nextArrow = new Rectangle(1120, 215, 100, 200);
		next = new Rectangle(370, 630, 560, 100); // next screen
		backButton = new Rectangle(60, 630, 260, 100);
		settings = new Rectangle(980, 630, 260, 100);
		
		hero = new Rectangle(450, 100, 420, 420);
		
		PShape shape = surface.createShape(PConstants.RECT, 80, 215, 100, 200); // previous Arrow
		PShape shape2 = surface.createShape(PConstants.RECT, 1120, 215, 100, 200); // next Arrow
		PShape shape3 = surface.createShape(PConstants.RECT, 385, 630, 560, 100, 20); // start button
		PShape shape4 = surface.createShape(PConstants.RECT, 30, 630, 295, 100, 20); // back button
		PShape shape5 = surface.createShape(PConstants.RECT, 1007, 630, 260, 100, 20); // settings button 
		
		PShape shape6 = surface.createShape(PConstants.RECT, 450, 540, 420, 70, 20);
		
		int c1 = surface.color(201, 147, 28);
		int c2 = surface.color(143, 104, 19);
		int c3 = surface.color(152, 176, 19);
		int c4 = surface.color(122, 140, 17);
		int c5 = surface.color(230, 132, 21);
		int c6 = surface.color(153, 87, 12);
		
		shape6.setFill(255);
		
		hover(previousArrow, shape, c3, c4);
		hover(nextArrow, shape2, c3, c4);
		hover(backButton, shape4, c1, c2);
		hover(settings, shape5, c1, c2);
		
		if (isHeroPicked) {
			hover(next, shape3, c5, c6);
		}
		
		surface.textSize(60);
		surface.fill(0);
		
		// heroes 3-5 are placeholder images for now
		if (getSpecificHero() == HERCULES) {
			if (isHeroPicked) 
				surface.image(hercules2, 450, 100, 420, 420);
			else 
				surface.image(hercules1, 450, 100, 420, 420);
			
			surface.shape(shape6);
			surface.text("Hercules", 530, 590);
		}
		else if (getSpecificHero() == ACHILLES) {
			if (isHeroPicked) 
				surface.image(achilles2, 450, 100, 420, 420);
			else 
				surface.image(achilles1, 450, 100, 420, 420);
			
			surface.shape(shape6);
			surface.text("Achilles", 550, 590);
		}
		else if (getSpecificHero() == CHIRON) {
			if (isHeroPicked) 
				surface.image(chiron2, 450, 100, 420, 420);
			else 
				surface.image(chiron, 450, 100, 420, 420);
			surface.shape(shape6);
			surface.text("Chiron", 560, 590);
		}
		else if (getSpecificHero() == HELEN) {
			if (isHeroPicked) 
				surface.image(helen2, 450, 100, 420, 420);
			else 
				surface.image(helen1, 450, 100, 420, 420);
			
			surface.shape(shape6);
			surface.text("Helen", 570, 590);
		}
		else if (getSpecificHero() == PERSEUS) {
			if (isHeroPicked) 
				surface.image(perseus2, 450, 100, 420, 420);
			else 
				surface.image(perseus1, 450, 100, 420, 420);
			
			surface.shape(shape6);
			surface.text("Perseus", 550, 590);
		}
		
		surface.textSize(80);
		surface.text("Choose Hero", 400, 70);
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape4);
		surface.shape(shape5);
		
		if (isHeroPicked) 
			surface.shape(shape3);
	
		surface.text("<", 100, 335);
		surface.text(">", 1140, 335);
		
		surface.textSize(60);
		surface.text("Settings", 1020, 700);
		surface.text("Back", 105, 700);
		
		if (isHeroPicked)
			surface.text("Next", 590, 700);
		
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

	public void mouseClicked() {
		boolean isScrollPicked = previousArrow.contains(surface.mouseX, surface.mouseY) || nextArrow.contains(surface.mouseX, surface.mouseY);
		int x = getSpecificHero();
		
		if (previousArrow.contains(surface.mouseX, surface.mouseY)) {
			if (x != HERCULES) {
				x--;
				setSpecificHero(x);
			}
			else 
				setSpecificHero(PERSEUS);
		}
		else if (nextArrow.contains(surface.mouseX, surface.mouseY)) {
			if (x != PERSEUS) {
				x++;
				setSpecificHero(x);
			}
			else 
				setSpecificHero(HERCULES);
		}
		else if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.START_SCREEN);
		}
		else if (settings.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.SETTINGS);
		}
		
		if (hero.contains(surface.mouseX, surface.mouseY)) { 
			isHeroPicked = true;
			
		}
		else if (isScrollPicked) {
			isHeroPicked = false;
		}
		
		if (isHeroPicked) {
			
			if (next.contains(surface.mouseX, surface.mouseY)) { 
				surface.toggleScreen(DrawingSurface.CHOOSE_DIFFICULTY);
			}
		}
		
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
