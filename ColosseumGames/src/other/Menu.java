package other;

import java.awt.Rectangle;

import processing.core.*;

public class Menu {
	
	private int difficultyLevel; // 1 is easy, 2 is medium, while 3 is hard. Default is medium.

	public Menu() {
		difficultyLevel = 2; 
	}
	
	public int drawStartMenu(PApplet marker, int mouseX, int mouseY, int cMouseX, int cMouseY) { // returns 1 (start), 2 (quit), 3 (settings), and 4 (how to play). Returns
																								 // -1 if nothing is clicked
		marker.clear();
		
		PImage g = marker.loadImage("images/menuBackground.jpg");
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
		
		if (detectMouseRect(startButton, cMouseX, cMouseY)) {
			return 1;
		}
		else if (detectMouseRect(quitButton, cMouseX, cMouseY)) {
			return 2;
		}
		else if (detectMouseRect(settings, cMouseX, cMouseY)) {
			return 3;
		}
		else if (detectMouseRect(howToPlay, cMouseX, cMouseY)) {
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
		
		return -1;
		
	}

	public boolean drawDeathMenu(PApplet marker, int cMouseX, int cMouseY) { // returns false if user would like to quit game, true if user would like to play game again
		return true;
	}
	
	public void drawPauseMenu(PApplet marker, int cMouseX, int cMouseY) { 
		
	}
	
	public void drawMerchantMenu(PApplet marker, int cMouseX, int cMouseY) {
		
	}
	
	public void drawSettingsMenu(PApplet marker, int cMouseX, int xMouseY, int pMouseX, int pMouseY) {
		
	}
	
	public void drawRulesScreen(PApplet marker) {
		
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
	
	
}
