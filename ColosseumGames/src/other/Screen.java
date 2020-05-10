package other;

import java.awt.Rectangle;
import java.util.ArrayList;

import characters.Hero;
import processing.core.*;

/**
 * Represents the screen that shows up primarily, as dependent on how user progresses through game
 * 
 * @author Rithvik
 *
 */
public class Screen {
	
	private int difficultyLevel; // 1 is easy, 2 is medium, 3 is hard
	private int waveNumber;

	private int adjuster;
	private int screenToggle;
	private int specificHero;
	
	private boolean isHeroPicked; // does not have a getter, only for this class
	private boolean isSoundOn;
	
	private int cmouseX, cmouseY;
	private char keyUp, keyDown, keyLeft, keyRight;
	private boolean isUp, isDown, isLeft, isRight;
	
	private int statPicked;
	
	public static final int SCREEN_WIDTH = 1300;
	public static final int SCREEN_HEIGHT = 800;
	
	public static final int PLAY_GAME = 0, START_MENU = 1, CHOOSE_HERO = 2, QUIT = 3, SETTINGS = 4, HOW_TO_PLAY = 5, 
			CREDITS = 6, CHOOSE_GAME = 7, PAUSE = 8, UPGRADE_MENU = 9, DEATH_MENU = 10;
	/**
	 * Creates a new screen object
	 */
	public Screen() {
		difficultyLevel = 2; // medium by default
		adjuster = 240; // used for slider, volume 0 by default
		waveNumber = 20;  // 20 waves by default
		
		screenToggle = START_MENU; // start menu, default
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
	
	/**
	 * Creates the start menu, the menu that first appears to the user. Allows progressing to next menus.
	 * @param marker allows PApplet access
	 * @param g the image that will be used as the background for the start screen
	 * @param mouseX the current x position of user mouse
	 * @param mouseY the current y position of user mouse
	 */
	public void drawStartMenu(PApplet marker, PImage g, int mouseX, int mouseY) { 
		marker.clear();
		marker.pushStyle();
		
		marker.tint(255, 200);
		marker.image(g, 0, 0, 1300, 800);
		
		marker.popStyle();
		
		Rectangle playButton = new Rectangle(200, 500, 900, 100);
		Rectangle quitButton = new Rectangle(200, 630, 260, 100);
		Rectangle credits = new Rectangle(520, 630, 260, 100);
		Rectangle howToPlay = new Rectangle(840, 630, 260, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 200, 500, 900, 100, 20);
		PShape shape2 = marker.createShape(PConstants.RECT, 200, 630, 260, 100, 20);
		PShape shape3 = marker.createShape(PConstants.RECT, 520, 630, 260, 100, 20);
		PShape shape4 = marker.createShape(PConstants.RECT, 840, 630, 260, 100, 20); 
		
		int c1 = marker.color(204, 153, 0); // +230 -200
		int c2 = marker.color(140, 153, 0);
		
		shape.setFill(c1);
		shape2.setFill(c1);
		shape3.setFill(c1);
		shape4.setFill(c1);
		
		hover(playButton, shape, mouseX, mouseY, c1, c2);
		hover(quitButton, shape2, mouseX, mouseY, c1, c2);
		hover(credits, shape3, mouseX, mouseY, c1, c2);
		hover(howToPlay, shape4, mouseX, mouseY, c1, c2);
		
		if (playButton.contains(cmouseX, cmouseY)) { // chooseHero screen
			screenToggle = CHOOSE_HERO;
			
			return;
		}
		else if (quitButton.contains(cmouseX, cmouseY)) {
			screenToggle = QUIT;
			
			return;
		}
		else if (howToPlay.contains(cmouseX, cmouseY)) {
			screenToggle = HOW_TO_PLAY;
			
			return;
		}
		else if (credits.contains(cmouseX, cmouseY)) {
			screenToggle = CREDITS;
			
			return;
		}
	
		marker.textSize(75);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		
		marker.fill(0);
		marker.text("Play", 565, 570);
		
		marker.textSize(60);
		marker.text("Quit", 260, 700);
		marker.text("Credits", 550, 700);
		marker.text("Help", 900, 700);
		
	}
	
	/**
	 * Creates a menu that allows the user to choose a hero. Allows going back to the start screen, going to settings menu,
	 * and going to the chooseGamePlay Screen if hero is picked
	 * @param marker allows PApplet access
	 * @param heroes the array of images that will be used for the hero sprites
	 * @param mouseX the current x position of user mouse
	 * @param mouseY the current y position of user mouse
	 * @pre heroes must store exactly 5 arraylists, which in turn each are of type PImage
	 */
	public void drawHeroMenu(PApplet marker, PImage g, ArrayList<ArrayList> heroes, /*int[] heroHealth, int[] heroAttackSpeed, int[] heroSpeed,*/ int mouseX, int mouseY) {
		
		marker.image(g, 0, 0, 1300, 800);
		
		Rectangle previousArrow = new Rectangle(80, 215, 100, 200);
		Rectangle nextArrow = new Rectangle(1120, 215, 100, 200);
		Rectangle next = new Rectangle(370, 630, 560, 100); // next screen
		Rectangle backButton = new Rectangle(60, 630, 260, 100);
		Rectangle settings = new Rectangle(980, 630, 260, 100);
		
		Rectangle hero = new Rectangle(450, 100, 420, 420);
		
		PShape shape = marker.createShape(PConstants.RECT, 80, 215, 100, 200); // previous Arrow
		PShape shape2 = marker.createShape(PConstants.RECT, 1120, 215, 100, 200); // next Arrow
		PShape shape3 = marker.createShape(PConstants.RECT, 385, 630, 560, 100, 20); // start button
		PShape shape4 = marker.createShape(PConstants.RECT, 30, 630, 295, 100, 20); // back button
		PShape shape5 = marker.createShape(PConstants.RECT, 1007, 630, 260, 100, 20); // settings button 
		
		PShape shape6 = marker.createShape(PConstants.RECT, 450, 540, 420, 70, 20);
		
		boolean isScrollPicked = previousArrow.contains(cmouseX, cmouseY) || nextArrow.contains(cmouseX, cmouseY);
		
		int c1 = marker.color(201, 147, 28);
		int c2 = marker.color(143, 104, 19);
		int c3 = marker.color(152, 176, 19);
		int c4 = marker.color(122, 140, 17);
		int c5 = marker.color(230, 132, 21);
		int c6 = marker.color(153, 87, 12);
		
		shape6.setFill(255);
		
		hover(previousArrow, shape, mouseX, mouseY, c3, c4);
		hover(nextArrow, shape2, mouseX, mouseY, c3, c4);
		hover(backButton, shape4, mouseX, mouseY, c1, c2);
		hover(settings, shape5, mouseX, mouseY, c1, c2);
		
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
			screenToggle = START_MENU;
			
			return;
		}
		else if (settings.contains(cmouseX, cmouseY)) {
			screenToggle = SETTINGS;
			
			return;
		}
		
		if (hero.contains(cmouseX, cmouseY)) { 
			isHeroPicked = true;
			
		}
		else if (isScrollPicked) {
			isHeroPicked = false;
		}
		
		if (isHeroPicked) {
			
			hover(next, shape3, mouseX, mouseY, c5, c6);
			
			if (next.contains(cmouseX, cmouseY)) { 
				screenToggle = CHOOSE_GAME;
				
				return;
				
			}
		}
		
		marker.textSize(60);
		marker.fill(0);
		
		// heroes 3-5 are placeholder images for now
		if (specificHero == 1) {
			marker.image((PImage) heroes.get(0).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Hercules", 530, 590);
		}
		else if (specificHero == 2) {
			marker.image((PImage) heroes.get(1).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Achilles", 550, 590);
		}
		else if (specificHero == 3) {
			marker.image((PImage) heroes.get(2).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Chiron", 560, 590);
		}
		else if (specificHero == 4) {
			marker.image((PImage) heroes.get(3).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Helen", 570, 590);
		}
		else if (specificHero == 5) {
			marker.image((PImage) heroes.get(4).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Perseus", 550, 590);
		}
		
		marker.textSize(80);
		marker.text("Choose Hero", 400, 70);
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape4);
		marker.shape(shape5);
		
		if (isHeroPicked)
			marker.shape(shape3);
	
		marker.text("<", 100, 335);
		marker.text(">", 1140, 335);
		
		marker.textSize(60);
		marker.text("Settings", 1020, 700);
		marker.text("Back", 105, 700);
		
		if (isHeroPicked)
			marker.text("Next", 590, 700);
		
	}
	
	/**
	 * Creates a screen which allows user to confirm whether or not they want to quit the program.
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawConfirmQuit(PApplet marker, int mouseX, int mouseY) {
		
		marker.fill(255);
		marker.rect(250, 150, 300, 300);
	}
	
	/**
	 * Creates a menu that allows user to decide whether they want sound, to change the volume of the sound, and
	 * to change the keys that determine hero movement
	 * @param marker allows PApplet access
	 * @param g the image used as a background for the menu
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawSettingsMenu(PApplet marker, PImage g, int mouseX, int mouseY) {
		marker.clear();
		
		marker.image(g, 0, 0, 1300, 800);
		
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
		
		hover(backButton, shape3, mouseX, mouseY, c1, c2);
		hover(upKey, shape5, mouseX, mouseY, 255, 130);
		hover(downKey, shape6, mouseX, mouseY, 255, 130);
		hover(leftKey, shape7, mouseX, mouseY, 255, 130);
		hover(rightKey, shape8, mouseX, mouseY, 255, 130);
		hover(resetSettings, shape9, mouseX, mouseY, c1, c2);
		
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
			screenToggle = CHOOSE_HERO;
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
			resetClick();
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
	
	/**
	 * Creates a screen that describes to the user how the game works
	 * @param marker allows PApplet access
	 * @param g the background for the screen
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawRulesScreen(PApplet marker, PImage g, int mouseX, int mouseY) {
		marker.clear();
		
		marker.image(g, 0, 0, 1300, 800);
		
		Rectangle backButton = new Rectangle(60, 600, 260, 130);
		PShape shape = marker.createShape(PConstants.RECT, 60, 600, 260, 130, 20);
		
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		
		hover(backButton, shape, mouseX, mouseY, c1, c2);
		
		if (backButton.contains(cmouseX, cmouseY)) {
			screenToggle = START_MENU;
			
			return;
		}
		
		marker.textSize(60);
		
		marker.shape(shape);
		marker.fill(0);
		marker.text("Back", 120, 690);
		
	}
	
	/**
	 * Creates a screen that credits the wonderful people that made this program.
	 * @param marker allows PApplet access
	 * @param i the background for the screen
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawCreditsScreen(PApplet marker, PImage i, int mouseX, int mouseY) {
		
	}
	
	/**
	 * Creates a screen where user can choose difficulty level and wave number
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawChooseGameScreen(PApplet marker, int mouseX, int mouseY) {
		marker.background(0);
		
		marker.fill(255);
		//marker.rect(100, 100, 550, 150);
		
		Rectangle start = new Rectangle(300, 600, 700, 100);
		PShape shape = marker.createShape(PConstants.RECT, 300, 600, 700, 100, 20);
		
		hover(start, shape, mouseX, mouseY, 200, 100);
		
		if (start.contains(cmouseX, cmouseY)) {
			screenToggle = PLAY_GAME;
			
			return;
		}
		
		marker.shape(shape);
		
		marker.textSize(75);
		
		marker.fill(0);
		marker.text("Start", 555, 670);
		
	}
	
	/**
	 * Creates a menu that shows up when user has paused the game, with an option to resume the game
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawPauseMenu(PApplet marker, int mouseX, int mouseY) { // returns 1 if resume, 2 if quit, 0 otherwise
		marker.rect(200, 150, 400, 300, 7);
	
		Rectangle resumeButton = new Rectangle(230, 400, 90, 40);
		Rectangle quitButton = new Rectangle(480, 400, 90, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 230, 400, 90, 40);
		PShape shape2 = marker.createShape(PConstants.RECT, 480, 400, 90, 40);
		
		hover(resumeButton, shape, mouseX, mouseY, 255, 180);
		hover(quitButton, shape2, mouseX, mouseY, 255, 180);
		
		if (resumeButton.contains(cmouseX, cmouseY)) {
			return;
		}
		else if (quitButton.contains(cmouseX, cmouseY)) {
			return;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		
	}

	/**
	 * Creates a menu that shows up when player dies, with options to restart or quit game
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawDeathMenu(PApplet marker, int mouseX, int mouseY) { 
	
	}

	/**
	 * Creates a menu that shows up when user wants to upgrade stats or weapons with a merchant
	 * @param marker allows PApplet access
	 */
	public void drawMerchantMenu(PApplet marker, int mouseX, int mouseY) {	
		marker.fill(200, 150, 250);
		marker.stroke(0);
		
		marker.rect(100, 100, 1100, 440);
		marker.line(100, 200, 1200, 200);
		
		Rectangle atkSpeed = new Rectangle(210, 250, 220, 100);
		Rectangle health = new Rectangle(540, 250, 220, 100);
		Rectangle speed = new Rectangle(870, 250, 220, 100);
		Rectangle confirm = new Rectangle(485, 420, 330, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 210, 250, 220, 100);
		PShape shape2 = marker.createShape(PConstants.RECT, 540, 250, 220, 100);
		PShape shape3 = marker.createShape(PConstants.RECT, 870, 250, 220, 100);
		PShape shape4 = marker.createShape(PConstants.RECT, 485, 420, 330, 100);
		
		boolean isClicked = atkSpeed.contains(cmouseX, cmouseY) || health.contains(cmouseX, cmouseY) || speed.contains(cmouseX, cmouseY);
		
		int c1 = marker.color(204, 153, 0); // +230 -200
		int c2 = marker.color(140, 153, 0);
		int c3 = marker.color(140, 220, 0);
		
		hover(atkSpeed, shape, mouseX, mouseY, c1, c2);
		hover(health, shape2, mouseX, mouseY, c1, c2);
		hover(speed, shape3, mouseX, mouseY, c1, c2);
		
		if (atkSpeed.contains(cmouseX, cmouseY)) {
			shape.setFill(marker.color(255, 0, 0));
			//statPicked = 1;
		}
		else if (health.contains(cmouseX, cmouseY)) {
			shape2.setFill(marker.color(255, 0, 0));
			//statPicked = 2;
		}
		else if (speed.contains(cmouseX, cmouseY)) {
			shape3.setFill(marker.color(255, 0, 0));
			//statPicked = 3;
		}
		else {
			resetClick();
		}
		
		if (isClicked) {
			hover(confirm, shape4, mouseX, mouseY, c1, c2);
			
			marker.shape(shape4);
		}
		
		if (confirm.contains(cmouseX, cmouseY)) {
			screenToggle = PLAY_GAME;
			resetClick();
			
			return;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		
		marker.fill(c3);
		marker.ellipseMode(PConstants.CORNER);
		marker.textSize(30);
		
		if (atkSpeed.contains(mouseX, mouseY)) {
			marker.arc(210, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			marker.fill(0);
			marker.text("+5", 295, 380);
		}
		else if (health.contains(mouseX, mouseY)) {
			marker.arc(540, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			marker.fill(0);
			marker.text("+10", 615, 380);
		}
		else if (speed.contains(mouseX, mouseY)) {
			marker.arc(870, 300, 220, 100, 0, PConstants.PI, PConstants.OPEN);
			marker.fill(0);
			marker.text("+5", 960, 380);
		}
		
		marker.textSize(60);
		marker.fill(0);
		marker.text("Upgrade Stats", 450, 175);
		
		marker.textSize(40);
		marker.text("AtkSpeed", 230, 315);
		marker.text("Health", 590, 315);
		marker.text("Speed", 925, 315);
		
		if (isClicked) 
			marker.text("Confirm", 570, 485);
	}
	
	/**
	 * Toggles between screens to decide when to appropriately display which screen
	 * @param marker allows PApplet access
	 * @param images the images used as backgrounds or hero sprites in the game screens
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 * @pre heroes must store exactly 5 arraylists, which in turn each are of type PImage
	 */
	public void screenSifter(PApplet marker, PImage background, ArrayList<ArrayList> heroes, int mouseX, int mouseY) {
		if (screenToggle == START_MENU) {
			drawStartMenu(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == CHOOSE_HERO) {
			drawHeroMenu(marker, background, heroes, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == QUIT) {
			drawConfirmQuit(marker, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == SETTINGS) {
			drawSettingsMenu(marker, background, mouseX, mouseY); // no resetting click due to key manipulation involved
		}
		else if (screenToggle == HOW_TO_PLAY) {
			drawRulesScreen(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == CREDITS) {
			drawCreditsScreen(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == CHOOSE_GAME) {
			drawChooseGameScreen(marker, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == PAUSE) {
			drawPauseMenu(marker, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == UPGRADE_MENU) {
			drawMerchantMenu(marker, mouseX, mouseY);
		}
		else if (screenToggle == DEATH_MENU) {
			drawDeathMenu(marker, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == -1) { // special value for quitting the program
			System.exit(0);
		}
	}
	
	/**
	 * Creates and returns a hero based on what the user chose
	 * @param heroes an arraylist that stores all the images of all heroes in the game
	 * @return the hero that the player chose
	 * @pre heroes must store exactly 5 arraylists, which in turn each are of type PImage
	 */
	public Hero choiceOfHero(ArrayList<ArrayList> heroes)
	{
		Hero h = null;
		
		if (specificHero == 1)
		{
			h = new Hero((PImage) heroes.get(0).get(0), 20, 10, 10000, 100, 100, 600, 300, 100, 100);
			
			
		}
		else if (specificHero == 2) 
		{
			h = new Hero((PImage) heroes.get(1).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		
		else if (specificHero == 3)
		{
			h = new Hero((PImage) heroes.get(2).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		else if (specificHero == 4)
		{
			h = new Hero((PImage) heroes.get(3).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		else if (specificHero == 5)
		{
			h = new Hero((PImage) heroes.get(4).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		
		return h;
	}
	
	/**
	 * Creates a hover effect when user's mouse is over a button
	 * @param rect represents the button in question
	 * @param shape represents the button itself
	 * @param color1 the color of the button when the user's mouse is not over the button
	 * @param color2 the color of the button when the user's mouse is over the button
	 * @param mouseX the current x position of the user's mouse
	 * @param mouseY the current x position of the user's mouse
	 */
	public void hover(Rectangle rect, PShape shape, int mouseX, int mouseY, int color1, int color2) {
		if (rect.contains(mouseX, mouseY)) {
			shape.setFill(color2);
		}
		else {
			shape.setFill(color1);
		}
	}
	
	/**
	 * Makes the settings reset back to default values 
	 */
	public void resetSettings() {
		adjuster = 240;
		specificHero = 1;
		isHeroPicked = false;
		isSoundOn = false;
		keyUp = 'W';
		keyDown = 'S';
		keyLeft = 'A';
		keyRight = 'D';
	}
	
	/**
	 * Redirects the clicked position of the user mouse to undefined values 
	 */
	public void resetClick() {
		cmouseX = -1;
		cmouseY = -1;
	}
	
	/**
	 * Dictates what happens if a user drags the mouse
	 * @param mouseX the current x position of the user's mouse
	 * @param mouseY the current y position of the user's mouse
	 * @param pmouseX the previous x position of the user's mouse
	 * @param pmouseY the previous y position of the user's mouse
	 */
	public void mouseDragged(int mouseX, int mouseY, int pmouseX, int pmouseY) {
		if (screenToggle == 4) {
			
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
	
	/**
	 * Dictates what happens if a user clicks with the mouse
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void mouseClicked(int mouseX, int mouseY) {
		cmouseX = mouseX;
		cmouseY = mouseY;
	}
	
	/**
	 * Dictates what happens if a user presses the mouse
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void mousePressed(int mouseX, int mouseY) {
		
	}
	
	/**
	 * Dictates what happens if a user releases the mouse
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void mouseReleased(int mouseX, int mouseY) {
		
	}
	
	/**
	 * Dictates what happens if a user releases keys. Used to change keys.
	 * @param keyCode the ASCII value of the pressed key
	 */
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
	
	/**
	 * Allows switching to a specified screen
	 * @param screenToggle the user desired screen 
	 */
	public void setScreenToggle(int screenToggle) {
		this.screenToggle = screenToggle;
	}
	
	/**
	 * Calculates the volume of the sound
	 * @return the volume as an int out of 100
	 */
	public int getVolume() {
		int volume = (int)((adjuster - 240) / 290.0 * 100);
		
		if (volume > 100) { // will not likely happen due to calculation, but to prevent sound library error
			volume = 100;
		}
		
		return volume;
	}
	
	/**
	 * Gets the specified, or default if not changed, keys used for directional movement
	 * @return the character array of keys used for movement
	 */
	public char[] getKeys() {
		char[] directionalKeys = {keyUp, keyDown, keyLeft, keyRight};
		
		return directionalKeys;
	}
	
	/**
	 * Gets the current screen position
	 * @return the current screen as an int
	 */
	public int getScreenToggle() {
		return screenToggle;
	}
	
	/**
	 * Gets whether or not the sound is on
	 * @return true if sound is on, false if not
	 */
	public boolean getIsSoundOn() {
		return isSoundOn;
	}
	
	/**
	 * Gets the difficulty level as user specifies
	 * @return the difficulty level as 1, 2, or 3 
	 */
	public int getDiffLevel() {
		return difficultyLevel;
	}
	
	/**
	 * Gets the number of waves the user wants to play through
	 * @return the specified number of waves
	 */
	public int getWaveNumber() {
		return waveNumber;
	}
	
}