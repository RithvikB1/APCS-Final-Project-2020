package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that allows user to decide the difficulty of the game they would like to play
 * @author Rithvik
 *
 */
public class ChooseDifficulty extends Screen {
	
	private PImage background;
	
	private DrawingSurface surface;
	
	private Rectangle start, easy, medium, hard, backButton;
	
	private double[] multiplier;
	
	public ChooseDifficulty(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
		
		start = new Rectangle();
		easy = new Rectangle();
		medium = new Rectangle();
		hard = new Rectangle();
		backButton = new Rectangle();
		
		multiplier = new double[14];
	}

	@Override
	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	@Override
	public void draw() {
		surface.image(background, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
		start = new Rectangle(300, 600, 700, 100);
		easy = new Rectangle(50, 230, 400, 100);
		medium = new Rectangle(450, 230, 400, 100);
		hard = new Rectangle(850, 230, 400, 100);
		backButton = new Rectangle(25, 600, 200, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 300, 600, 700, 100, 20);
		PShape shape2 = surface.createShape(PConstants.RECT, 50, 230, 400, 100, 20);
		PShape shape3 = surface.createShape(PConstants.RECT, 450, 230, 400, 100, 20);
		PShape shape4 = surface.createShape(PConstants.RECT, 850, 230, 400, 100, 20);
		PShape shape5 = surface.createShape(PConstants.RECT, 25, 600, 200, 100, 20);
				
		PShape shape6 = surface.createShape(PConstants.RECT, 70, 330, 360, 200);
		PShape shape7 = surface.createShape(PConstants.RECT, 470, 330, 360, 200);
		PShape shape8 = surface.createShape(PConstants.RECT, 870, 330, 360, 200);
		
		hover(start, shape, 200, 100);
		hover(easy, shape2, 200, 100);
		hover(medium, shape3, 200, 100);
		hover(hard, shape4, 200, 100);
		hover(backButton, shape5, 200, 100);
		
		if (getDifficulty() == EASY) {
			shape2.setFill(surface.color(255, 0, 0));
			for(int i = 0; i < multiplier.length; i++) {
				multiplier[i] = 1;
			}
		}
		else if (getDifficulty() == MEDIUM) {
			shape3.setFill(surface.color(255, 0, 0));
			multiplier[0] = 3/2;
			multiplier[1] = 3/2;
			multiplier[2] = 1;
			multiplier[3] = 3/2;
			multiplier[4] = 2;
			multiplier[5] = 3/2;
			multiplier[6] = 3/2;
			multiplier[7] = 3;
			multiplier[8] = 1;
			multiplier[9] = 3/2;
			multiplier[10] = 3/2;
			multiplier[11] = 2;
			multiplier[12] = 2;
			multiplier[13] = 3/2;
			System.out.println("hi");
		}
		else if (getDifficulty() == HARD) {
			shape4.setFill(surface.color(255, 0, 0));
			multiplier[0] = 3;
			multiplier[1] = 5/2;
			multiplier[2] = 3/2;
			multiplier[3] = 2;
			multiplier[4] = 3;
			multiplier[5] = 2;
			multiplier[6] = 2;
			multiplier[7] = 5;
			multiplier[8] = 3/2;
			multiplier[9] = 2;
			multiplier[10] = 2;
			multiplier[11] = 3;
			multiplier[12] = 4;
			multiplier[13] = 2;
		}
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		surface.shape(shape4);
		surface.shape(shape5);
		
		surface.fill(0);
		surface.textSize(40);
		
		if (easy.contains(surface.mouseX, surface.mouseY)) {
			shape6.setFill(255);
			surface.shape(shape6);
			surface.text("Noob", 180, 435);
		}
		else if (medium.contains(surface.mouseX, surface.mouseY)) {
			shape7.setFill(255);
			surface.shape(shape7);
			surface.text("For the average jo", 580, 435);
		}
		else if (hard.contains(surface.mouseX, surface.mouseY)) {
			shape8.setFill(255);
			surface.shape(shape8);
			surface.text("Death", 980, 435);
		}
		
		surface.textSize(90);
		
		surface.text("Choose Difficulty", 300, 100);
		
		surface.textSize(75);
		
		surface.text("Start", 555, 670);
		surface.text("Easy", 160, 300);
		surface.text("Medium", 500, 300);
		surface.text("Hard", 950, 300);
		
		surface.textSize(50);
		surface.text("Back", 70, 670);
		
		setMultiplier(multiplier);
		
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
		if (easy.contains(surface.mouseX, surface.mouseY)) {
			setDifficulty(EASY);
		}
		if (medium.contains(surface.mouseX, surface.mouseY)) {
			setDifficulty(MEDIUM);
		}
		if (hard.contains(surface.mouseX, surface.mouseY)) {
			setDifficulty(HARD);
		}
		
		if (start.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.GAME_SCREEN);
		}
		else if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.CHOOSE_HERO);
		}
		
	}
	
	public void mouseScrolled() {
		
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
