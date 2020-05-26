package screens.gameScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import processing.event.MouseEvent;
import screens.other.Screen;

public class VictoryScreen extends Screen {

	private DrawingSurface surface;
	private PImage background, hercules, achilles, chiron, helen, perseus;
	private Rectangle restart;
	
	public VictoryScreen(DrawingSurface surface) {
		super(surface);
		
		this.surface = surface;
	}

	@Override
	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		hercules = surface.loadImage("sprites/Heroes/Hercules/HerculesFacingFront.png");
		achilles = surface.loadImage("sprites/Heroes/Achilles/AchillesFacingFront.png");
		chiron = surface.loadImage("sprites/Heroes/Chiron/ChironFacingRight.png");
		helen = surface.loadImage("sprites/Heroes/Helen/HelenFacingFront.png");
		perseus = surface.loadImage("sprites/Heroes/Perseus/PerseusFacingFront.png");
	}

	@Override
	public void draw() {
		surface.pushStyle();
	//	surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		PImage displayedHero;
		
		restart = new Rectangle(1000, 600, 100, 100);
		PShape shape = surface.createShape(PConstants.RECT, 1000, 600, 200, 130, 20);
		
		int c1 = surface.color(204, 153, 0);
		int c2 = surface.color(140, 153, 0);
		
		hover(restart, shape, c1, c2);
		
		if (getSpecificHero() == HERCULES) {
			displayedHero = hercules;
		}
		else if (getSpecificHero() == ACHILLES) {
			displayedHero = achilles;
		}
		else if (getSpecificHero() == CHIRON) {
			displayedHero = chiron;
		}
		else if (getSpecificHero() == HELEN) {
			displayedHero = helen;
		}
		else {
			displayedHero = perseus;
		}
		
		surface.shape(shape);
		
		surface.fill(0);
		surface.textSize(75);
		surface.text("Congratulations!" + "\n" + "You survived the", 300, 100);
		surface.text("Colosseum Games with: ", 200, 300);
		
		surface.textSize(60);
		surface.text("Restart", 1000, 680);
		
		//surface.image(displayedHero, 420, 300, 420, 420);
		
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
		if (restart.contains(surface.mouseX, surface.mouseY)) {
			surface.reset();
		}
		
	}

	@Override
	public void mouseWheel(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
