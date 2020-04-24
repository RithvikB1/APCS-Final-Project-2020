package other;

import java.awt.Rectangle;

import processing.core.*;

public class Menu {
	
	private int difficultyLevel; // 1 is easy, 2 is medium, while 3 is hard. Default is medium.
	private int soundVolume;
	
	private boolean isSoundOn;

	public Menu() {
		difficultyLevel = 2; 
		soundVolume = 20;
		
		isSoundOn = true;
		
	}
	
	public int drawStartMenu(PApplet marker, PImage g, int mouseX, int mouseY, int cmouseX, int cmouseY) { // returns 1 (start), 2 (quit), 3 (settings), and 4 (how to play). Returns	
																						 // 0 if nothing is clicked
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		Rectangle startButton = new Rectangle(60, 450, 130, 100);
		Rectangle quitButton = new Rectangle(240, 450, 130, 100);
		Rectangle settings = new Rectangle(420, 450, 130, 100);
		Rectangle howToPlay = new Rectangle(600, 450, 130, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 60, 450, 130, 100);
		PShape shape2 = marker.createShape(PConstants.RECT, 240, 450, 130, 100);
		PShape shape3 = marker.createShape(PConstants.RECT, 420, 450, 130, 100);
		PShape shape4 = marker.createShape(PConstants.RECT, 600, 450, 130, 100);
		
		shape.setFill(255);
		shape2.setFill(255);
		shape3.setFill(255);
		shape4.setFill(255);
		
		if (detectMouseRect(startButton, mouseX, mouseY)) {
			shape.setFill(180);
		}
		else if (detectMouseRect(quitButton, mouseX, mouseY)) {
			shape2.setFill(180);
		}
		else if (detectMouseRect(settings, mouseX, mouseY)) {
			shape3.setFill(180);
		}
		else if (detectMouseRect(howToPlay, mouseX, mouseY)) {
			shape4.setFill(180);
		}
		
		if (detectMouseRect(startButton, cmouseX, cmouseY)) {
			return 1;
		}
		else if (detectMouseRect(quitButton, cmouseX, cmouseY)) {
			return 2;
		}
		else if (detectMouseRect(settings, cmouseX, cmouseY)) {
			return 3;
		}
		else if (detectMouseRect(howToPlay, cmouseX, cmouseY)) {
			return 4;
		}
	
		marker.textSize(32);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		
		marker.fill(0);
		marker.text("Start", 90, 510);
		marker.text("Quit", 270, 510);
		marker.text("Settings", 425, 510);
		marker.text("Lost?", 630, 510);
		
		return 0;
		
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
	
	public int drawSettingsMenu(PApplet marker, int mouseX, int mouseY, int cmouseX, int cmouseY, int pMouseX, int pMouseY) {
		marker.clear();
		marker.fill(200);
		
		marker.rect(200, 150, 400, 300, 7);
		marker.stroke(0);
		marker.line(200, 200, 600, 200);
		
		
		return 0;
	}
	
	public int drawRulesScreen(PApplet marker, int mouseX, int mouseY, int cmouseX, int cmouseY) {
		marker.clear();
		PImage g = marker.loadImage("images/menuBackground.jpg");
		marker.image(g, 0, 0, 800, 600);
		
		Rectangle backButton = new Rectangle(60, 450, 130, 100);
		PShape shape = marker.createShape(PConstants.RECT, 60, 450, 130, 100);
		
		shape.setFill(255);
		
		if (detectMouseRect(backButton, mouseX, mouseY)) {
			shape.setFill(180);
		}
		
		if (detectMouseRect(backButton, cmouseX, cmouseY)) {
			return 1;
		}
		
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 90, 510);
		
		return 0;
		
		
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
	
	public boolean getIsSoundOn() {
		return isSoundOn;
	}
	
	
}
