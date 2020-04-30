package other;

import java.awt.Rectangle;
import processing.core.*;

public class Menu {
	
	private int difficultyLevel; // 1 is easy, 2 is medium, 3 is hard
	private int waveNumber;
	
	private int adjuster;
	private int menuToggle;
	private int specificHero;
	
	private boolean isHeroPicked; // does not have a getter, only for this class
	private boolean isSoundOn;
	
	private int cmouseX, cmouseY;
	private char keyUp, keyDown, keyLeft, keyRight;
	private boolean isUp, isDown, isLeft, isRight;

	public Menu() {
		difficultyLevel = 2; // medium 
		adjuster = 270; // actually used for slider, real volume given by getSoundVolume()
		waveNumber = 20; 
		
		menuToggle = 1; // start menu, default
		specificHero = 1; 
		
		isHeroPicked = false;
		isSoundOn = true;
		
		keyUp = 'W';
		keyDown = 'S';
		keyLeft = 'A';
		keyRight = 'D';
		
		isUp = false;
		isDown = false;
		isLeft = false;
		isRight = false;
		
	} 
	
	public void drawStartMenu(PApplet marker, PImage g, int mouseX, int mouseY) { 
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		Rectangle chooseHeroButton = new Rectangle(135, 370, 530, 60);
		Rectangle quitButton = new Rectangle(135, 450, 130, 100);
		Rectangle credits = new Rectangle(335, 450, 130, 100);
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
		else if (detectMouseRect(credits, mouseX, mouseY)) {
			shape3.setFill(c2);
		}
		else if (detectMouseRect(howToPlay, mouseX, mouseY)) {
			shape4.setFill(c2);
		}
		
		if (detectMouseRect(chooseHeroButton, cmouseX, cmouseY)) { // chooseHero screen
			menuToggle = 2;
			resetClick();
			
			return;
		}
		else if (detectMouseRect(quitButton, cmouseX, cmouseY)) {
			menuToggle = 3;
			resetClick();
			
			return;
		}
		else if (detectMouseRect(howToPlay, cmouseX, cmouseY)) {
			menuToggle = 5;
			resetClick();
			
			return;
		}
		else if (detectMouseRect(credits, cmouseX, cmouseY)) {
			menuToggle = 6;
			resetClick();
			
			return;
		}
	
		marker.textSize(32);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		
		marker.fill(0);
		marker.text("Play", 370, 410);
		marker.text("Quit", 165, 510);
		marker.text("Credits", 345, 510);
		marker.text("Lost?", 560, 510);
		
	}
	
	public void drawCredits(PApplet marker, PImage i, int mouseX, int mouseY) {
		
	}
	
	public void drawHeroMenu(PApplet marker, /*int[] heroHealth, int[] heroAttackSpeed, int[] heroSpeed,*/ int mouseX, int mouseY) {
		marker.background(marker.color(98, 102, 17));
		
		Rectangle previousArrow = new Rectangle(60, 225, 70, 140);
		Rectangle nextArrow = new Rectangle(650, 225, 70, 140);
		Rectangle start = new Rectangle(215, 480, 350, 70);
		Rectangle backButton = new Rectangle(35, 450, 130, 100);
		Rectangle settings = new Rectangle(600, 450, 130, 100);
		Rectangle hero = new Rectangle(215, 100, 350, 350);
		
		PShape shape = marker.createShape(PConstants.RECT, 60, 225, 70, 140); // previous Arrow
		PShape shape2 = marker.createShape(PConstants.RECT, 650, 225, 70, 140); // next Arrow
		PShape shape3 = marker.createShape(PConstants.RECT, 215, 480, 350, 70, 20); // start button
		PShape shape4 = marker.createShape(PConstants.RECT, 35, 450, 130, 100, 20); // back button
		PShape shape5 = marker.createShape(PConstants.RECT, 615, 450, 130, 100, 20); // settings button
		PShape shape6; // hero    
		
		boolean isScrollPicked = previousArrow.contains(cmouseX, cmouseY) || nextArrow.contains(cmouseX, cmouseY);
		int c1 = marker.color(201, 147, 28);
		int c2 = marker.color(143, 104, 19);
		int c3 = marker.color(152, 176, 19);
		int c4 = marker.color(122, 140, 17);
		int c5 = marker.color(230, 132, 21);
		int c6 = marker.color(153, 87, 12);
		
		shape.setFill(c3);
		shape2.setFill(c3);
		shape3.setFill(c5);
		shape4.setFill(c1);
		shape5.setFill(c1);
		
		if (previousArrow.contains(mouseX, mouseY)) {
			shape.setFill(c4);
		}
		else if (nextArrow.contains(mouseX, mouseY)) {
			shape2.setFill(c4);
		}
		else if (backButton.contains(mouseX, mouseY)) {
			shape4.setFill(c2);
		}
		else if (settings.contains(mouseX, mouseY)) {
			shape5.setFill(c2);
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
		else if (backButton.contains(cmouseX, cmouseY)) {
			menuToggle = 1;
			resetClick();
			
			return;
		}
		else if (settings.contains(cmouseX, cmouseY)) {
			menuToggle = 4;
			resetClick();
			
			return;
		}
		
		if (hero.contains(cmouseX, cmouseY)) { 
			isHeroPicked = true;
		}
		else if (isScrollPicked) {
			isHeroPicked = false;
		}
		
		if (isHeroPicked) {
			if (start.contains(mouseX, mouseY)) { 
				shape3.setFill(c6);
			}
			
			if (start.contains(cmouseX, cmouseY)) { 
				menuToggle = 0;
				return;
			}
		}
		
		// TODO: heroes will actually be images, rectangles are placeholders for now
		if (specificHero == 1) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(0);
		}
		else if (specificHero == 2) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(200);
		}
		else if (specificHero == 3) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(150);
		}
		else if (specificHero == 4) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(100);
		}
		else if (specificHero == 5) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(50);
		}
		else {
			shape6 = null;
		}
		
		marker.textSize(80);
		marker.text("Choose Hero", 140, 70);
		
		marker.textSize(60);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape4);
		marker.shape(shape5);
		marker.shape(shape6);
		
		if (isHeroPicked)
			marker.shape(shape3);
		
		marker.fill(0);
		marker.text("<", 70, 310);
		marker.text(">", 665, 310);
		
		marker.textSize(32);
		
		marker.text("Back", 65, 510);
		marker.text("Settings", 620, 510);
		
		if (isHeroPicked)
			marker.text("Start", 350, 525);
		
		if (!isHeroPicked) 
			resetClick();
		
	}

	public boolean drawDeathMenu(PApplet marker, int mouseX, int mouseY) { // returns false if user would like to quit game, true if user would like to play game again
		return true;
	}
	
	public int drawPauseMenu(PApplet marker, int mouseX, int mouseY) { // returns 1 if resume, 2 if quit, 0 otherwise
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

	public void drawMerchantMenu(PApplet marker) {
		
	}
	
	public void drawSettingsMenu(PApplet marker, PImage g, int mouseX, int mouseY) {
		marker.clear();
		
		marker.image(g, 0, 0, 800, 600);
		
		marker.fill(200, 150, 250);
		
		marker.rect(200, 10, 400, 500, 7);
		
		marker.stroke(0);
		
		// divider lines
		marker.line(200, 70, 600, 70);
		marker.line(200, 160, 600, 160);
		marker.line(200, 300, 600, 300);
		
		marker.line(240, 240, 560, 240); // volume line
		marker.line(400, 215, 400, 265); // halfway
		marker.line(320, 215, 320, 265); // first quarter
		marker.line(480, 215, 480, 265); // third quarter
		
		if (adjuster >= 530) {
			adjuster = 530;
		}
		else if (adjuster <= 240) {
			adjuster = 240;
		}
		
		Rectangle soundOn = new Rectangle(450, 80, 60, 60);
		Rectangle soundOff = new Rectangle(510, 80, 60, 60);
		Rectangle backButton = new Rectangle(35, 450, 130, 100);
		Rectangle sliderArea = new Rectangle(240, 240, 320, 35); // does not have a PShape, not to be confused with slider
		Rectangle upKey = new Rectangle(370, 360, 60, 60);
		Rectangle downKey = new Rectangle(370, 430, 60, 60);
		Rectangle leftKey = new Rectangle(300, 430, 60, 60);
		Rectangle rightKey = new Rectangle(440, 430, 60, 60);
		
		PShape shape = marker.createShape(PConstants.RECT, 450, 80, 60, 60); // on
		PShape shape2 = marker.createShape(PConstants.RECT, 510, 80, 60, 60); // off
		PShape shape3 = marker.createShape(PConstants.RECT, 35, 450, 130, 100, 20); // back button
		PShape shape4 = marker.createShape(PConstants.RECT, adjuster, 223, 30, 35); // slider
		PShape shape5 = marker.createShape(PConstants.RECT, 370, 360, 60, 60); // up key
		PShape shape6 = marker.createShape(PConstants.RECT, 370, 430, 60, 60); // down key
		PShape shape7 = marker.createShape(PConstants.RECT, 300, 430, 60, 60); // left key
		PShape shape8 = marker.createShape(PConstants.RECT, 440, 430, 60, 60); // right key
	
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		
		shape3.setFill(c1);
		shape4.setFill(100);
		shape5.setFill(255);
		shape6.setFill(255);
		shape7.setFill(255);
		shape8.setFill(255);
		
		if (isSoundOn) {
			shape.setFill(230);
			shape2.setFill(100);
		}
		else {
			shape.setFill(100);
			shape2.setFill(230);
		}
		
		if (soundOn.contains(mouseX, mouseY) && !isSoundOn) {
			shape.setFill(130);
		}
		else if (soundOff.contains(mouseX, mouseY) && isSoundOn) {
			shape2.setFill(130);
		}
		else if (backButton.contains(mouseX, mouseY)) {
			shape3.setFill(c2);
		}
		
		if (upKey.contains(mouseX, mouseY) || isUp) {
			shape5.setFill(130);
		}
		else if (downKey.contains(mouseX, mouseY) || isDown) {
			shape6.setFill(130);
		}
		else if (leftKey.contains(mouseX, mouseY) || isLeft) {
			shape7.setFill(130);
		}
		else if (rightKey.contains(mouseX, mouseY) || isRight) {
			shape8.setFill(130);
		}
		
		if (soundOn.contains(cmouseX, cmouseY)) {
			isSoundOn = true;
			resetClick();
		}
		else if (soundOff.contains(cmouseX, cmouseY)) {
			isSoundOn = false;
			adjuster = 240;
			resetClick();
		}
		else if (backButton.contains(cmouseX, cmouseY)) {
			menuToggle = 2;
			resetClick();
			
			return;
		}
		else if (sliderArea.contains(cmouseX, cmouseY)) {
			adjuster = cmouseX;
			resetClick();
		}
		else if (upKey.contains(cmouseX, cmouseY)) {
			isUp = true;
		}
		else if (downKey.contains(cmouseX, cmouseY)) {
			isDown = true;
		}
		else if (leftKey.contains(cmouseX, cmouseY)) {
			isLeft = true;
		}
		else if (rightKey.contains(cmouseX, cmouseY)) {
			isRight = true;
		}
		else {
			isUp = false;
			isDown = false;
			isLeft = false;
			isRight = false;
		}
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		marker.shape(shape5);
		marker.shape(shape6);
		marker.shape(shape7);
		marker.shape(shape8);
		
		marker.fill(0);
		
		marker.text("Back", 65, 510);
		marker.text("Sound?", 240, 120);
		marker.text("On", 460, 120);
		marker.text("Off", 515, 120);
		marker.text("Volume", 340, 198);
		marker.text("<", 229, 250);
		marker.text(">", 548, 250);
		marker.text("Change Keys", 300, 340);
		marker.text(keyUp, 387, 400);
		marker.text(keyDown, 392, 470);
		marker.text(keyLeft, 323, 470);
		marker.text(keyRight, 460, 470);
		
		marker.textSize(55);
		
		marker.text("Settings", 290, 57);
		
	}
	
	public void drawRulesScreen(PApplet marker, PImage g, int mouseX, int mouseY) {
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
			resetClick();
			return;
		}
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 90, 510);
		
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	
	public void mouseDragged(int mouseX, int mouseY, int pmouseX, int pmouseY) {
		if (menuToggle == 4) {
			Rectangle slider = new Rectangle(adjuster, 223, 30, 35);
			
			if (slider.contains(mouseX, mouseY)) {
				if (mouseX > pmouseX) {
					adjuster += 4;
				}
				else if (mouseX < pmouseX) {
					adjuster -= 4;
				}
			}
		}
	}
	
	public void mouseReleased(int mouseX, int mouseY) {
		
	}
	
	public void mouseClicked(int mouseX, int mouseY) {
		cmouseX = mouseX;
		cmouseY = mouseY;
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
		return (int)((adjuster - 240) / 290.0 * 100);
	}
	
	public int getWaveNumber() {
		return waveNumber;
	}
	
	public int getMenuToggle() {
		return menuToggle;
	}
	
	public int getSpecificHero() { 
		if (menuToggle == 0 && isHeroPicked) // if user starts game with hero selected
			return specificHero;
		else
			return 0;
	}
	
	public char[] getKeys() {
		char[] directionalKeys = {keyUp, keyDown, keyLeft, keyRight};
		
		return directionalKeys;
	}
	
	public boolean getIsSoundOn() {
		return isSoundOn;
	}
	
	public void setMenuToggle(int menuToggle) {
		this.menuToggle = menuToggle;
	}
	
	public void resetClick() {
		cmouseX = -1;
		cmouseY = -1;
	}

	public void keyReleased(int keyCode) {
		char keyPressed = (char) keyCode;
		
		if (isUp) { 
			if (keyPressed != keyDown && keyPressed != keyLeft && keyPressed != keyRight)
				keyUp = keyPressed;
		}
		else if (isDown) {
			if (keyPressed != keyUp && keyPressed != keyLeft && keyPressed != keyRight)
				keyDown = keyPressed;
		}
		else if (isLeft) {
			if (keyPressed != keyDown && keyPressed != keyUp && keyPressed != keyRight)
				keyLeft = keyPressed;
		}
		else if (isRight) {
			if (keyPressed != keyDown && keyPressed != keyLeft && keyPressed != keyUp)
				keyRight = keyPressed;
		}
		
		resetClick();
	}

	public void keyPressed(int keyCode) {
		// TODO Auto-generated method stub
		
	}
	
	public void menuMaker(PApplet marker, PImage i, int mouseX, int mouseY) {
		
		if (menuToggle == 1) {
			drawStartMenu(marker, i, mouseX, mouseY);
		}
		else if (menuToggle == 2) {
			drawHeroMenu(marker, mouseX, mouseY);
		}
		else if (menuToggle == 3) {
			System.exit(0);
		}
		else if (menuToggle == 4) {
			drawSettingsMenu(marker, i, mouseX, mouseY);
		}
		else if (menuToggle == 5) {
			drawRulesScreen(marker, i, mouseX, mouseY);
		}
		else if (menuToggle == 6) {
			drawCredits(marker, i, mouseX, mouseY);
		}
		else if (menuToggle == 7) {
			drawPauseMenu(marker, mouseX, mouseY);
		}
	}
	
}