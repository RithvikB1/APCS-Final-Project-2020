package other;

import java.awt.Rectangle;
import java.util.ArrayList;

import characters.Hero;
import processing.core.*;

/**
 * Represents the screen that shows up primarily, as dependent on how user progresses through game
 * 
 * @author Rithvik
 * @version 2.0
 *
 */
public class Screen {
	
	private int difficultyLevel, adjuster, screenToggle, specificHero;
	
	private boolean isHeroPicked; // does not have a getter, only for this class
	private boolean isSoundOn;
	
	private int cmouseX, cmouseY;
	private char keyUp, keyDown, keyLeft, keyRight;
	private boolean isUp, isDown, isLeft, isRight;
	
	public static final int SCREEN_WIDTH = 1300, SCREEN_HEIGHT = 800;
	
	public static final int HERCULES = 1, ACHILLES = 2, CHIRON = 3, HELEN = 4, PERSEUS = 5;
	
	public static final int EASY = 1, MEDIUM = 2, HARD = 3;
	
	public static final int QUIT = -1, PLAY_GAME = 0, START_MENU = 1, CHOOSE_HERO = 2, CONFIRM_QUIT = 3, 
			SETTINGS_MENU = 4, RULES_SCREEN = 5, CREDITS_SCREEN = 6, CHOOSE_GAME = 7,
			PAUSE_MENU = 8, UPGRADE_MENU = 9, DEATH_MENU = 10, LOADING_SCREEN = 11;
	
	/**
	 * Creates a new screen object
	 */
	public Screen() {
		difficultyLevel = MEDIUM; 
		adjuster = 400; // used for slider, volume 0 by default
		
		screenToggle = START_MENU; 
		specificHero = HERCULES; 
		
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
		marker.pushStyle();
		
		marker.tint(255, 200);
		marker.image(g, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
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
			screenToggle = RULES_SCREEN;
			
			return;
		}
		else if (credits.contains(cmouseX, cmouseY)) {
			screenToggle = CREDITS_SCREEN;
			
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
	 * @param g the background image used in the menu
	 * @param heroes the array of images that will be used for the hero sprites
	 * @param mouseX the current x position of user mouse
	 * @param mouseY the current y position of user mouse
	 * @pre heroes must store exactly 5 arraylists, which in turn each are of type PImage
	 */
	public void drawHeroMenu(PApplet marker, PImage g, ArrayList<ArrayList> heroes, /*int[] heroHealth, int[] heroAttackSpeed, int[] heroSpeed,*/ int mouseX, int mouseY) {
		
		marker.image(g, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
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
			if (specificHero != HERCULES)
				specificHero--;
			else 
				specificHero = PERSEUS;
		}
		else if (nextArrow.contains(cmouseX, cmouseY)) {
			if (specificHero != PERSEUS) 
				specificHero++;
			else 
				specificHero = HERCULES;
		}
		else if (backButton.contains(cmouseX, cmouseY)) {
			screenToggle = START_MENU;
			
			return;
		}
		else if (settings.contains(cmouseX, cmouseY)) {
			screenToggle = SETTINGS_MENU;
			
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
		if (specificHero == HERCULES) {
			marker.image((PImage) heroes.get(0).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Hercules", 530, 590);
		}
		else if (specificHero == ACHILLES) {
			marker.image((PImage) heroes.get(1).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Achilles", 550, 590);
		}
		else if (specificHero == CHIRON) {
			marker.image((PImage) heroes.get(2).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Chiron", 560, 590);
		}
		else if (specificHero == HELEN) {
			marker.image((PImage) heroes.get(3).get(0), 450, 100, 420, 420);
			marker.shape(shape6);
			marker.text("Helen", 570, 590);
		}
		else if (specificHero == PERSEUS) {
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
		marker.image(g, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
		marker.fill(200, 150, 250);
		
		marker.rect(325, 50, 650, 650, 7);
		
		marker.stroke(0);
		
		// divider lines
		marker.line(325, 130, 975, 130);
		marker.line(325, 260, 975, 260);
		marker.line(325, 420, 975, 420);
		
		marker.line(400, 370, 900, 370); // volume line
		marker.line(650, 330, 650, 410); // halfway
		marker.line(525, 330, 525, 410); // first quarter
		marker.line(775, 330, 775, 410); // third quarter
		
		if (adjuster >= 860) {
			adjuster = 860;
		}
		else if (adjuster <= 400) {
			adjuster = 400;
		}
		
		Rectangle soundOn = new Rectangle(740, 152, 80, 80);
		Rectangle soundOff = new Rectangle(820, 152, 80, 80);
		Rectangle backButton = new Rectangle(25, 620, 260, 130);
		Rectangle sliderArea = new Rectangle(400, 350, 900, 50); // does not have a PShape, not to be confused with slider
		Rectangle upKey = new Rectangle(610, 515, 80, 80);
		Rectangle downKey = new Rectangle(610, 605, 80, 80);
		Rectangle leftKey = new Rectangle(520, 605, 80, 80);
		Rectangle rightKey = new Rectangle(700, 605, 80, 80);
		Rectangle resetSettings = new Rectangle(1000, 650, 150, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 740, 152, 80, 80); // on
		PShape shape2 = marker.createShape(PConstants.RECT, 820, 152, 80, 80); // off
		PShape shape3 = marker.createShape(PConstants.RECT, 25, 620, 260, 130, 20); // back button
		PShape shape4 = marker.createShape(PConstants.RECT, adjuster, 345, 40, 50); // slider (30, 35)
		PShape shape5 = marker.createShape(PConstants.RECT, 610, 515, 80, 80); // up key
		PShape shape6 = marker.createShape(PConstants.RECT, 610, 605, 80, 80); // down key
		PShape shape7 = marker.createShape(PConstants.RECT, 520, 605, 80, 80); // left key
		PShape shape8 = marker.createShape(PConstants.RECT, 700, 605, 80, 80); // right key
		PShape shape9 = marker.createShape(PConstants.RECT, 1000, 650, 150, 100, 20); // reset 
	
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
				adjuster = 450;
			
			isSoundOn = true;
			resetClick();
		}
		else if (soundOff.contains(cmouseX, cmouseY)) {
			isSoundOn = false;
			adjuster = 400;
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
		marker.textSize(50);
		
		marker.text("Sound?", 360, 210);
		marker.text("On", 745, 210);
		marker.text("Off", 820, 210);
		marker.text("Volume", 550, 310);
		marker.text("<", 382, 385);
		marker.text(">", 880, 385);
		marker.text("Change Keys", 500, 475);
		
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
		
		marker.text(keys[0], 630, 575);
		marker.text(keys[1], 635, 665);
		marker.text(keys[2], 540, 665);
		marker.text(keys[3], 720, 665);
		
		marker.textSize(40);
		marker.text("Reset", 1020, 710);
		
		marker.textSize(60);
		
		marker.text("Back", 90, 705);
		
		marker.textSize(70);
		
		marker.text("Settings", 530, 110);
		
	}
	
	/**
	 * Creates a screen that describes to the user how the game works
	 * @param marker allows PApplet access
	 * @param g the background for the screen
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawRulesScreen(PApplet marker, PImage g, int mouseX, int mouseY) {
		marker.image(g, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
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
		marker.text("Back", 120, 685);
		
	}
	
	/**
	 * Creates a screen that credits the wonderful people that made this program.
	 * @param marker allows PApplet access
	 * @param i the background for the screen
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawCreditsScreen(PApplet marker, PImage i, int mouseX, int mouseY) {
		marker.image(i, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
		marker.fill(255);
		marker.rect(300, 150, 700, 500);
		
		Rectangle backButton = new Rectangle(25, 620, 260, 130);
		PShape shape = marker.createShape(PConstants.RECT, 25, 620, 260, 130, 20);
		
		int c1 = marker.color(204, 153, 0);
		int c2 = marker.color(140, 153, 0);
		
		hover(backButton, shape, mouseX, mouseY, c1, c2);
		
		if (backButton.contains(cmouseX, cmouseY)) {
			screenToggle = START_MENU;
			
			return;
		}
		
		marker.shape(shape);
		
		marker.fill(0);
		marker.textSize(80);
		
		marker.text("Rithvik Bhakhri", 350, 275);
		marker.text("Aditya Senthilvel", 330, 425);
		marker.text("Richard Huang", 360, 575);
		
		marker.textSize(60);
		
		marker.text("Back", 90, 705);
	}
	
	/**
	 * Creates a screen where user can choose difficulty level and wave number
	 * @param marker allows PApplet access
	 * @param background the background image of the choose difficulty screen
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawChooseDiffScreen(PApplet marker, PImage background, int mouseX, int mouseY) {
		marker.image(background, 0, 0, Screen.SCREEN_WIDTH, Screen.SCREEN_HEIGHT);
		
		Rectangle start = new Rectangle(300, 600, 700, 100);
		Rectangle easy = new Rectangle(50, 230, 400, 100);
		Rectangle medium = new Rectangle(450, 230, 400, 100);
		Rectangle hard = new Rectangle(850, 230, 400, 100);
		Rectangle backButton = new Rectangle(25, 600, 200, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 300, 600, 700, 100, 20);
		PShape shape2 = marker.createShape(PConstants.RECT, 50, 230, 400, 100, 20);
		PShape shape3 = marker.createShape(PConstants.RECT, 450, 230, 400, 100, 20);
		PShape shape4 = marker.createShape(PConstants.RECT, 850, 230, 400, 100, 20);
		PShape shape5 = marker.createShape(PConstants.RECT, 25, 600, 200, 100, 20);
				
		PShape shape6 = marker.createShape(PConstants.RECT, 70, 330, 360, 200);
		PShape shape7 = marker.createShape(PConstants.RECT, 470, 330, 360, 200);
		PShape shape8 = marker.createShape(PConstants.RECT, 870, 330, 360, 200);
		
		hover(start, shape, mouseX, mouseY, 200, 100);
		hover(easy, shape2, mouseX, mouseY, 200, 100);
		hover(medium, shape3, mouseX, mouseY, 200, 100);
		hover(hard, shape4, mouseX, mouseY, 200, 100);
		hover(backButton, shape5, mouseX, mouseY, 200, 100);
		
		if (easy.contains(cmouseX, cmouseY) || difficultyLevel == EASY) {
			shape2.setFill(marker.color(255, 0, 0));
			
			difficultyLevel = EASY;
		}
		if (medium.contains(cmouseX, cmouseY) || difficultyLevel == MEDIUM) {
			shape3.setFill(marker.color(255, 0, 0));
			
			difficultyLevel = MEDIUM;
		}
		if (hard.contains(cmouseX, cmouseY) || difficultyLevel == HARD) {
			shape4.setFill(marker.color(255, 0, 0));
			
			difficultyLevel = HARD;
		}
		
		if (start.contains(cmouseX, cmouseY)) {
			screenToggle = PLAY_GAME;
			
			return;
		}
		else if (backButton.contains(cmouseX, cmouseY)) {
			screenToggle = CHOOSE_HERO;
			isHeroPicked = false;
			
			return;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		marker.shape(shape3);
		marker.shape(shape4);
		marker.shape(shape5);
		
		marker.fill(0);
		marker.textSize(40);
		
		if (easy.contains(mouseX, mouseY)) {
			shape6.setFill(255);
			marker.shape(shape6);
			marker.text("Details", 180, 435);
		}
		else if (medium.contains(mouseX, mouseY)) {
			shape7.setFill(255);
			marker.shape(shape7);
			marker.text("Details", 580, 435);
		}
		else if (hard.contains(mouseX, mouseY)) {
			shape8.setFill(255);
			marker.shape(shape8);
			marker.text("Details", 980, 435);
		}
		
		marker.textSize(90);
		
		marker.text("Choose Difficulty", 300, 100);
		
		marker.textSize(75);
		
		marker.text("Start", 555, 670);
		marker.text("Easy", 160, 300);
		marker.text("Medium", 500, 300);
		marker.text("Hard", 950, 300);
		
		marker.textSize(50);
		marker.text("Back", 70, 670);
		
	}
	
	/**
	 * Creates a menu that shows up when user has paused the game, with an option to resume the game
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawPauseMenu(PApplet marker, int mouseX, int mouseY) { 
		marker.pushStyle();
		
		marker.fill(0);
		marker.rect(250, 100, 800, 500);
	
		Rectangle resumeButton = new Rectangle(270, 450, 200, 100);
		Rectangle quitButton = new Rectangle(830, 450, 200, 100);
		
		PShape shape = marker.createShape(PConstants.RECT, 270, 450, 200, 100);
		PShape shape2 = marker.createShape(PConstants.RECT, 830, 450, 200, 100);
		
		hover(resumeButton, shape, mouseX, mouseY, 255, 180);
		hover(quitButton, shape2, mouseX, mouseY, 255, 180);
		
		if (resumeButton.contains(cmouseX, cmouseY)) {
			screenToggle = PLAY_GAME;
			return;
		}
		else if (quitButton.contains(cmouseX, cmouseY)) {
			screenToggle = QUIT;
			return;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		
		marker.fill(255);
		marker.textSize(70);
		
		marker.text("Paused", 540, 300);
		
		marker.fill(0);
		marker.textSize(40);
		
		marker.text("Resume", 300, 510);
		marker.text("Quit", 885, 510);
		
		marker.popStyle();
	}

	/**
	 * Creates a menu that shows up when player dies, with options to restart or quit game
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void drawDeathMenu(PApplet marker, int mouseX, int mouseY) { 
		marker.fill(200, 150, 250);
		marker.stroke(0);
		
		marker.rect(300, 100, 700, 440);
		marker.line(300, 200, 1000, 200);
		marker.line(650, 200, 650, 540);
		
		Rectangle quit = new Rectangle(300, 200, 350, 340);
		Rectangle restart = new Rectangle(650, 200, 350, 340);
		
		PShape shape = marker.createShape(PConstants.RECT, 300, 200, 350, 340);
		PShape shape2 = marker.createShape(PConstants.RECT, 650, 200, 350, 340);
		
		hover(quit, shape, mouseX, mouseY, 255, 120);
		hover(restart, shape2, mouseX, mouseY, 255, 120);
		
		if (quit.contains(cmouseX, cmouseY)) {
			screenToggle = QUIT;
			
			return;
		}
		else if (restart.contains(cmouseX, cmouseY)) {
			screenToggle = START_MENU;
			resetSettings();
			resetClick();
			
			return;
		}
		
		marker.shape(shape);
		marker.shape(shape2);
		
		marker.textSize(60);
		marker.fill(0);
		marker.text("You Died!", 500, 175);
		marker.text("Quit", 410, 375);
		marker.text("Restart", 710, 375);
	}

	/**
	 * Creates a menu that shows up when user wants to upgrade stats or weapons with a merchant
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
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
	 * Creates a 5 second transition between some screens as needed
	 * @param marker allows PApplet access
	 * @param mouseX the current x position of the user mouse
	 * @param mouseY the current y position of the user mouse
	 */
	public void loadingScreen(PApplet marker, int mouseX, int mouseY) {
		
	}
	
	/**
	 * Toggles between screens to decide when to appropriately display which screen
	 * @param marker allows PApplet access
	 * @param background the image used as a background of the menus
	 * @param heroes the images used as backgrounds or hero sprites in the game screens
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
		else if (screenToggle == QUIT) { // will eventually confirm quit
			System.exit(0);
		}
		else if (screenToggle == SETTINGS_MENU) {
			drawSettingsMenu(marker, background, mouseX, mouseY); // no resetting click due to key manipulation involved
		}
		else if (screenToggle == RULES_SCREEN) {
			drawRulesScreen(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == CREDITS_SCREEN) {
			drawCreditsScreen(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == CHOOSE_GAME) {
			drawChooseDiffScreen(marker, background, mouseX, mouseY);
			resetClick();
		}
		else if (screenToggle == PAUSE_MENU) {
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
		
		if (specificHero == HERCULES)
		{
			h = new Hero((PImage) heroes.get(0).get(0), 20, 10, 10000, 100, 100, 600, 300, 100, 100);
			
		}
		else if (specificHero == ACHILLES) 
		{
			h = new Hero((PImage) heroes.get(1).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		
		else if (specificHero == CHIRON)
		{
			h = new Hero((PImage) heroes.get(2).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		else if (specificHero == HELEN)
		{
			h = new Hero((PImage) heroes.get(3).get(0), 10, 10, 100000 ,10, 10, 400, 300, 100, 100);
		}
		else if (specificHero == PERSEUS)
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
		specificHero = HERCULES;
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
		if (screenToggle == SETTINGS_MENU) {
			
			Rectangle slider = new Rectangle(adjuster, 345, 40, 50);
			
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
		int volume = (int)((adjuster - 400) / 460.0 * 100);
		
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
	
}