package other;

import java.awt.Rectangle;
import processing.core.*;

public class Menu {
	
	private int difficultyLevel; // 1 is easy, 2 is medium, while 3 is hard
	private int soundVolume;
	private int waveNumber;
	
	private int menuToggle;
	private int specificHero;
	
	private boolean isSoundOn;

	public Menu() {
		difficultyLevel = 2; // medium 
		soundVolume = 30;
		waveNumber = 20; 
		menuToggle = 1; // start menu default
		specificHero = 1;
		
		isSoundOn = true;
		
	} 
	
	public void drawStartMenu(PApplet marker, PImage g, int mouseX, int mouseY, int cmouseX, int cmouseY) { // returns 1 (start), 2 (quit), 3 (settings), and 4 (how to play). Returns	
																						 // 0 if nothing is clicked
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		Rectangle chooseHeroButton = new Rectangle(135, 370, 530, 60);
		Rectangle quitButton = new Rectangle(135, 450, 130, 100);
		Rectangle settings = new Rectangle(335, 450, 130, 100);
		Rectangle howToPlay = new Rectangle(535, 450, 130, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 135, 370, 530, 60, 20);
		PShape shape2 = marker.createShape(PConstants.RECT, 135, 450, 130, 100, 20);
		PShape shape3 = marker.createShape(PConstants.RECT, 335, 450, 130, 100, 20);
		PShape shape4 = marker.createShape(PConstants.RECT, 535, 450, 130, 100, 20); 
		
		int c1 = marker.color(204, 153, 0); // +230 -200
		int c2 = marker.color(140, 153, 0);
		
		shape.setFill(c1);
		shape2.setFill(c1);
		shape3.setFill(c1);
		shape4.setFill(c1);
		
		if (detectMouseRect(chooseHeroButton, mouseX, mouseY)) {
			shape.setFill(c2);
		}
		else if (detectMouseRect(quitButton, mouseX, mouseY)) {
			shape2.setFill(c2);
		}
		else if (detectMouseRect(settings, mouseX, mouseY)) {
			shape3.setFill(c2);
		}
		else if (detectMouseRect(howToPlay, mouseX, mouseY)) {
			shape4.setFill(c2);
		}
		
		if (detectMouseRect(chooseHeroButton, cmouseX, cmouseY)) { // chooseHero screen
			menuToggle = 2;
			return;
		}
		else if (detectMouseRect(quitButton, cmouseX, cmouseY)) {
			menuToggle = 3;
			return;
		}
		else if (detectMouseRect(settings, cmouseX, cmouseY)) {
			menuToggle = 4;
			return;
		}
		else if (detectMouseRect(howToPlay, cmouseX, cmouseY)) {
			menuToggle = 5;
			return;
		}
	
		marker.textSize(32);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		
		marker.fill(0);
		marker.text("Choose Hero", 300, 410);
		marker.text("Quit", 165, 510);
		marker.text("Settings", 340, 510);
		marker.text("Lost?", 560, 510);
		
	}
	
	public void drawHeroMenu(PApplet marker, int[] heroHealth, int[] heroAttackSpeed, int[] heroSpeed, int mouseX, int mouseY, int cmouseX, int cmouseY) {
		marker.fill(255);
		
		Rectangle previousArrow = new Rectangle(60, 225, 70, 140);
		Rectangle nextArrow = new Rectangle(650, 225, 70, 140);
		Rectangle start = new Rectangle(215, 480, 350, 70);
		Rectangle backButton = new Rectangle(35, 450, 130, 100);
		Rectangle hero = new Rectangle(215, 100, 350, 350);
		
		PShape shape = marker.createShape(PConstants.RECT, 60, 225, 70, 140); // previous Arrow
		PShape shape2 = marker.createShape(PConstants.RECT, 650, 225, 70, 140); // next Arrow
		PShape shape3 = marker.createShape(PConstants.RECT, 215, 480, 350, 70); // start button
		PShape shape4 = marker.createShape(PConstants.RECT, 35, 450, 130, 100); // back button
		PShape shape5; // hero
		
		shape.setFill(100);
		shape2.setFill(100);
		shape3.setFill(100);
		shape4.setFill(150);
		
		if (previousArrow.contains(mouseX, mouseY)) {
			shape.setFill(200);
		}
		else if (nextArrow.contains(mouseX, mouseY)) {
			shape2.setFill(200);
		}
		else if (start.contains(mouseX, mouseY)) { // probably shouldn't be here, but will be fixed later
			shape3.setFill(200);
		}
		else if (backButton.contains(mouseX, mouseY)) {
			shape4.setFill(240);
		}
		else if (hero.contains(mouseX, mouseY)) { // TODO: show stats
			
		}
		
		if (previousArrow.contains(cmouseX, cmouseY)) {
			if (specificHero != 1)
				specificHero--;
			else 
				specificHero = 5;
		}
		else if (nextArrow.contains(cmouseX, cmouseY)) {
			if (specificHero != 5) 
				specificHero++;
			else 
				specificHero = 1;
		}
		else if (start.contains(cmouseX, cmouseY)) { // probably shouldn't be here, but will be fixed later
			menuToggle = 0;
			return;
		}
		else if (backButton.contains(cmouseX, cmouseY)) {
			menuToggle = 1;
			return;
		}
		else if (hero.contains(cmouseX, cmouseY)) { // TODO: start button becomes available
			
		}
		
		// TODO: heroes will actually be images, rectangles are placeholders for now
		if (specificHero == 1) {
			shape5 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape5.setFill(0);
		}
		else if (specificHero == 2) {
			shape5 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape5.setFill(200);
		}
		else if (specificHero == 3) {
			shape5 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape5.setFill(150);
		}
		else if (specificHero == 4) {
			shape5 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape5.setFill(100);
		}
		else if (specificHero == 5) {
			shape5 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape5.setFill(50);
		}
		else {
			shape5 = null;
		}
		
		marker.textSize(60);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		marker.shape(shape5);
		
		marker.fill(0);
		marker.text("<", 70, 310);
		marker.text(">", 665, 310);
		
		marker.textSize(32);
		
		marker.text("Start", 350, 525);
		marker.text("Back", 65, 510);
		
	}

	public boolean drawDeathMenu(PApplet marker, int mouseX, int mouseY, int cmouseX, int cmouseY) { // returns false if user would like to quit game, true if user would like to play game again
		return true;
	}
	
	public int drawPauseMenu(PApplet marker, int mouseX, int mouseY, int cmouseX, int cmouseY) { // returns 1 if resume, 2 if quit, 0 otherwise
		marker.rect(200, 150, 400, 300, 7);
		
		Rectangle resumeButton = new Rectangle(230, 400, 90, 40);
		Rectangle quitButton = new Rectangle(480, 400, 90, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 230, 400, 90, 40);
		PShape shape2 = marker.createShape(PConstants.RECT, 480, 400, 90, 40);
		
		shape.setFill(255);
		shape2.setFill(255);
		
		if (detectMouseRect(resumeButton, mouseX, mouseY)) {
			shape.setFill(180);
		}
		else if (detectMouseRect(quitButton, mouseX, mouseY)) {
			shape2.setFill(180);
		}
		
		if (detectMouseRect(resumeButton, cmouseX, cmouseY)) {
			return 1;
		}
		else if (detectMouseRect(quitButton, cmouseX, cmouseY)) {
			return 2;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		
		return 0;
		
	}

	public void drawMerchantMenu(PApplet marker, int cmouseX, int cmouseY) {
		
	}
	
	public void drawSettingsMenu(PApplet marker, PImage g, int mouseX, int mouseY, int cmouseX, int cmouseY, int pMouseX, int pMouseY) {
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		marker.fill(200, 150, 250);
		
		marker.rect(200, 10, 400, 500, 7);
		marker.stroke(0);
		marker.line(200, 70, 600, 70);
		
		Rectangle backButton = new Rectangle(35, 450, 130, 100);
		PShape shape = marker.createShape(PConstants.RECT, 35, 450, 130, 100, 20);
		
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		
		shape.setFill(c1);
		
		if (detectMouseRect(backButton, mouseX, mouseY)) {
			shape.setFill(c2);
		}
		
		if (detectMouseRect(backButton, cmouseX, cmouseY)) {
			menuToggle = 1;
			return;
		}
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 65, 510);
		
	}
	
	public void drawRulesScreen(PApplet marker, PImage g, int mouseX, int mouseY, int cmouseX, int cmouseY) {
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		Rectangle backButton = new Rectangle(60, 450, 130, 100);
		PShape shape = marker.createShape(PConstants.RECT, 60, 450, 130, 100, 20);
		
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		
		shape.setFill(c1);
		
		if (detectMouseRect(backButton, mouseX, mouseY)) {
			shape.setFill(c2);
		}
		
		if (detectMouseRect(backButton, cmouseX, cmouseY)) {
			menuToggle = 1;
			return;
		}
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 90, 510);
		
	}
	
	private boolean detectMouseRect(Rectangle rect, int detectX, int detectY) {
		if (detectX >= rect.getX() && detectX <= rect.getX() + rect.getWidth() && detectY >= rect.getY() && detectY <= rect.getY() + rect.getHeight()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getDiffLevel() {
		return difficultyLevel;
	}
	
	public int getVolume() {
		return soundVolume;
	}
	
	public int getWaveNumber() {
		return waveNumber;
	}
	
	public int getMenuToggle() {
		return menuToggle;
	}
	
	public int getSpecificHero() {
		return specificHero;
	}
	
	public boolean getIsSoundOn() {
		return isSoundOn;
	}
	
	
}