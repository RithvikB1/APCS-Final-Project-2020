package other;

import java.awt.Rectangle;
import java.util.ArrayList;

import characters.Hero;
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
		adjuster = 240; // used for slider
		waveNumber = 20; 
		
		menuToggle = 1; // start menu, default
		specificHero = 1; // hercules, default
		
		isHeroPicked = false;                                         
		isSoundOn = false;
		                                                                                     
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
		
		if (chooseHeroButton.contains(mouseX, mouseY)) {
			shape.setFill(c2);
		}
		else if (quitButton.contains(mouseX, mouseY)) {
			shape2.setFill(c2);
		}
		else if (credits.contains(mouseX, mouseY)) {
			shape3.setFill(c2);
		}
		else if (howToPlay.contains(mouseX, mouseY)) {
			shape4.setFill(c2);
		}
		
		if (chooseHeroButton.contains(cmouseX, cmouseY)) { // chooseHero screen
			menuToggle = 2;
			resetClick();
			
			return;
		}
		else if (quitButton.contains(cmouseX, cmouseY)) {
			menuToggle = 3;
			resetClick();
			
			return;
		}
		else if (howToPlay.contains(cmouseX, cmouseY)) {
			menuToggle = 5;
			resetClick();
			
			return;
		}
		else if (credits.contains(cmouseX, cmouseY)) {
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
	
	public void drawHeroMenu(PApplet marker, ArrayList<PImage> images, /*int[] heroHealth, int[] heroAttackSpeed, int[] heroSpeed,*/ int mouseX, int mouseY) {
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
				menuToggle = 7;
				resetClick();
				
				return;
				
			}
		}
		
		// TODO: heroes will actually be images, rectangles are placeholders for now
		if (specificHero == 1) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(0);
			shape6.setVisible(false);
			marker.image(images.get(2), 215, 100, 350, 350);
		}
		else if (specificHero == 2) {
			shape6 = marker.createShape(PConstants.RECT, 215, 100, 350, 350);
			shape6.setFill(200);
			shape6.setVisible(false);
			marker.image(images.get(3), 215, 100, 350, 350);
			
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
			marker.text("Next", 350, 525);
		
		if (!isHeroPicked) 
			resetClick();
		
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
		Rectangle resetSettings = new Rectangle(540, 520, 60, 40);
		
		PShape shape = marker.createShape(PConstants.RECT, 450, 80, 60, 60); // on
		PShape shape2 = marker.createShape(PConstants.RECT, 510, 80, 60, 60); // off
		PShape shape3 = marker.createShape(PConstants.RECT, 35, 450, 130, 100, 20); // back button
		PShape shape4 = marker.createShape(PConstants.RECT, adjuster, 223, 30, 35); // slider
		PShape shape5 = marker.createShape(PConstants.RECT, 370, 360, 60, 60); // up key
		PShape shape6 = marker.createShape(PConstants.RECT, 370, 430, 60, 60); // down key
		PShape shape7 = marker.createShape(PConstants.RECT, 300, 430, 60, 60); // left key
		PShape shape8 = marker.createShape(PConstants.RECT, 440, 430, 60, 60); // right key
		PShape shape9 = marker.createShape(PConstants.RECT, 540, 520, 60, 40, 20); // reset 
	
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		int c3 = marker.color(255, 0, 0);
		
		shape3.setFill(c1);
		shape4.setFill(100);
		shape5.setFill(255);
		shape6.setFill(255);
		shape7.setFill(255);
		shape8.setFill(255);
		shape9.setFill(c1);
		
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
		else if (resetSettings.contains(mouseX, mouseY)) {
			shape9.setFill(c2);
		}
		
		if (upKey.contains(mouseX, mouseY)) {
			shape5.setFill(130);
		}
		else if (downKey.contains(mouseX, mouseY)) {
			shape6.setFill(130);
		}
		else if (leftKey.contains(mouseX, mouseY)) {
			shape7.setFill(130);
		}
		else if (rightKey.contains(mouseX, mouseY)) {
			shape8.setFill(130);
		}
		
		if (isUp) {
			shape5.setFill(c3);
		}
		else if (isDown) {
			shape6.setFill(c3);
		}
		else if (isLeft) {
			shape7.setFill(c3);
		}
		else if (isRight) {
			shape8.setFill(c3);
		}
		
		if (soundOn.contains(cmouseX, cmouseY)) {
			if (!isSoundOn && getVolume() == 0) 
				adjuster = 270;
			
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
		else if (resetSettings.contains(cmouseX, cmouseY)) {
			resetSettings();
			resetClick();
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
		marker.shape(shape9);
		
		marker.fill(0);
		
		marker.text("Back", 65, 510);
		marker.text("Sound?", 240, 120);
		marker.text("On", 460, 120);
		marker.text("Off", 515, 120);
		marker.text("Volume", 340, 198);
		marker.text("<", 229, 250);
		marker.text(">", 548, 250);
		marker.text("Change Keys", 300, 340);
		
		String keys[] = {keyUp + "", keyDown + "", keyLeft + "", keyRight + ""};
		int[] arrowNums = {38, 40, 37, 39};
		char arrows[] = {'\u2191', '\u2193', '\u2190', '\u2192'};
		
		int count = 0;
		
		for (String s : keys) {
			int count2 = 0;
			
			for (int x : arrowNums) {
				if (s.equals((char)x + "")) {
					keys[count] = arrows[count2] + "";
				}
				count2++;
			}
			
			count++;
		}
		
		marker.text(keys[0], 387, 400);
		marker.text(keys[1], 392, 470);
		marker.text(keys[2], 323, 470);
		marker.text(keys[3], 460, 470);
		
		marker.textSize(15);
		marker.text("Reset", 550, 545);
		
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
		
		if (backButton.contains(mouseX, mouseY)) {
			shape.setFill(c2);
		}
		
		if (backButton.contains(cmouseX, cmouseY)) {
			menuToggle = 1;
			resetClick();
			return;
		}
		
		marker.textSize(32);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 90, 510);
		
	}
	
	public void drawCredits(PApplet marker, PImage i, int mouseX, int mouseY) {
		
	}
	
	
	
	public void drawChooseGameScreen(PApplet marker, int mouseX, int mouseY) {
		marker.background(0);
		
		marker.fill(255);
		marker.rect(100, 100, 550, 150);
		
		Rectangle start = new Rectangle(215, 480, 350, 70);
		PShape shape = marker.createShape(PConstants.RECT, 215, 480, 350, 70, 20);
		
		shape.setFill(200);
		
		if (start.contains(mouseX, mouseY)) {
			shape.setFill(100);
		}
		
		if (start.contains(cmouseX, cmouseY)) {
			menuToggle = 0;
			resetClick();
			
			return;
		}
		
		marker.shape(shape);
		
		marker.textSize(32);
		
		marker.stroke(255);
		marker.text("Start", 350, 525);
	//	marker.line(x1, y1, x2, y2);
		
	}
	
	public int drawPauseMenu(PApplet marker, int mouseX, int mouseY) { // returns 1 if resume, 2 if quit, 0 otherwise
		marker.rect(200, 150, 400, 300, 7);
		
		Rectangle resumeButton = new Rectangle(230, 400, 90, 40);
		Rectangle quitButton = new Rectangle(480, 400, 90, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 230, 400, 90, 40);
		PShape shape2 = marker.createShape(PConstants.RECT, 480, 400, 90, 40);
		
		shape.setFill(255);
		shape2.setFill(255);
		
		if (resumeButton.contains(mouseX, mouseY)) {
			shape.setFill(180);
		}
		else if (quitButton.contains(mouseX, mouseY)) {
			shape2.setFill(180);
		}
		
		if (resumeButton.contains(cmouseX, cmouseY)) {
			return 1;
		}
		else if (quitButton.contains(cmouseX, cmouseY)) {
			return 2;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		
		return 0;
		
	}

	public boolean drawDeathMenu(PApplet marker, int mouseX, int mouseY) { // returns false if user would like to quit game, true if user would like to play game again
		return true;
	}

	public void drawMerchantMenu(PApplet marker) {
		
	}
	
	public void menuMaker(PApplet marker,  ArrayList<PImage> images, int mouseX, int mouseY) {
		
		if (menuToggle == 1) {
			drawStartMenu(marker, images.get(1), mouseX, mouseY);
		}
		else if (menuToggle == 2) {
			drawHeroMenu(marker, images, mouseX, mouseY);
		}
		else if (menuToggle == 3) {
			System.exit(0);
		}
		else if (menuToggle == 4) {
			drawSettingsMenu(marker, images.get(1), mouseX, mouseY);
		}
		else if (menuToggle == 5) {
			drawRulesScreen(marker, images.get(1), mouseX, mouseY);
		}
		else if (menuToggle == 6) {
			drawCredits(marker, images.get(1), mouseX, mouseY);
		}
		else if (menuToggle == 7) {
			drawChooseGameScreen(marker, mouseX, mouseY);
		}
		else if (menuToggle == 8) {
			drawPauseMenu(marker, mouseX, mouseY);
		}
	}
	
	public Hero choiceOfHero()
	{
		Hero h = null;
		if (specificHero == 1)
		{
//			System.out.println(true);
			h = new Hero("sprites/Hercules/FacingBack.png", 20, 10, 10 ,10, 10, 400, 300, 100, 100);
			
		}
		else if (specificHero == 2) 
		{
			h = new Hero("sprites/Achilles/PRESelectedAchilles.png", 10, 10, 10 ,10, 10, 400, 300, 100, 100);
		}
		
		else if (specificHero == 3)
		{
			
		}
		else if (specificHero == 4)
		{
			
		}
		else if (specificHero == 5)
		{
			
		}
		
		return h;
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
	
	public void mouseClicked(int mouseX, int mouseY) {
		cmouseX = mouseX;
		cmouseY = mouseY;
	}
	
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	
	public void mouseReleased(int mouseX, int mouseY) {
		
	}
	
	public void keyReleased(int keyCode) {
		char keyPressed = (char) keyCode;
		
		if (isUp) { 
			if (keyPressed != keyDown && keyPressed != keyLeft && keyPressed != keyRight)
				keyUp = keyPressed;
			else
				keyUp = '\u22A0';
		}
		else if (isDown) {
			if (keyPressed != keyUp && keyPressed != keyLeft && keyPressed != keyRight)
				keyDown = keyPressed;
			else
				keyDown = '\u22A0';
		}
		else if (isLeft) {
			if (keyPressed != keyDown && keyPressed != keyUp && keyPressed != keyRight)
				keyLeft = keyPressed;
			else
				keyLeft = '\u22A0';
		}
		else if (isRight) {
			if (keyPressed != keyDown && keyPressed != keyLeft && keyPressed != keyUp)
				keyRight = keyPressed;
			else
				keyRight = '\u22A0';
		}
		
		resetClick();
	}
	
	public void resetSettings() {
		adjuster = 240;
		isSoundOn = false;
		keyUp = 'W';
		keyDown = 'S';
		keyLeft = 'A';
		keyRight = 'D';
	}
	
	public void resetClick() {
		cmouseX = -1;
		cmouseY = -1;
	}
	
	public void setMenuToggle(int menuToggle) {
		this.menuToggle = menuToggle;
	}
	
	public int getVolume() {
		int volume = (int)((adjuster - 240) / 290.0 * 100);
		
		if (volume > 100) { // will not likely happen due to calculation, but to prevent sound library error
			volume = 100;
		}
		
		return volume;
	}
	
	public char[] getKeys() {
		char[] directionalKeys = {keyUp, keyDown, keyLeft, keyRight};
		
		return directionalKeys;
	}
	
	public int getDiffLevel() {
		return difficultyLevel;
	}
	
	public boolean getIsSoundOn() {
		return isSoundOn;
	}
	
	public int getMenuToggle() {
		return menuToggle;
	}
	
	public int getWaveNumber() {
		return waveNumber;
	}
	
}