package other;

import processing.core.*;
import processing.event.MouseEvent;
import processing.sound.SoundFile;
import screens.gameScreens.*;
import screens.other.Screen;
import screens.other.ScreenToggler;
import screens.startScreens.*;

/**
 * Draws all game components such as screens and draws gameplay in action
 * 
 * @author Aditya
 * @version 2.0
 *
 */
public class DrawingSurface extends PApplet implements ScreenToggler {
	
	private Screen[] screens;
	private Screen currentScreen;
	
	private SoundFile audio;
	
	/**
	 * Loads all images, sounds, and sets temporary background color
	 */
	public void setup() {
		reset();
	}
	
	/**
	 * Draws the screens, and starts game when user is done with start menus
	 */
	public void draw() {
		playSound();
		
		currentScreen.draw();
	}
	
	/**
	 * Dictates what happens with screen when mouse is clicked
	 */
	public void mouseClicked() {
		currentScreen.mouseClicked();
	}
	
	/**
	 * Dictates what happens with a screen when mouse is dragged
	 */
	public void mouseDragged() {
		currentScreen.mouseDragged();
	}
	
	/**
	 * Dictates what happens with a screen when mouse is pressed
	 */
	public void mousePressed() {
		currentScreen.mousePressed();
	}
	
	/**
	 * Dictates what happens with a screen when mouse is released
	 */
	public void mouseReleased() {
		currentScreen.mousedReleased();
	}
	
	/**
	 * 
	 */
	public void mouseWheel(MouseEvent e) {
		currentScreen.mouseWheel(e);
	}
	
	/**
	 * Moves player according to what directional keys are pressed 
	 */
	public void keyPressed() {
		currentScreen.keyPressed();
	}
	
	/**
	 * Dictates what happens to screen if keys are released and updates hero accordingly
	 */
	public void keyReleased() {
		currentScreen.keyReleased();
	}
	
	/**
	 * Plays the sound in the game
	 */
	public void playSound() {
		if (currentScreen.getSound()) {
			audio.amp((float)(currentScreen.getVolume() / 100.0));
			
			if (!audio.isPlaying())
				audio.play();
		}
		else if (audio.isPlaying()) {
			audio.pause();
		}
	}

	public void toggleScreen(int x) {
		currentScreen = screens[x];
	}

	/**
	 * Updates all screens with the settings the current one has
	 */
	public void update() {
		int volume = currentScreen.getVolume();
		int specificHero = currentScreen.getSpecificHero();
		int difficulty = currentScreen.getDifficulty();
		int stat = currentScreen.getStat();
		
		boolean isSoundOn = currentScreen.getSound();
		boolean isShop = currentScreen.getDisplayShop();
		
		char upKey = currentScreen.getUpKey();
		char downKey = currentScreen.getDownKey();
		char leftKey = currentScreen.getLeftKey();
		char rightKey =  currentScreen.getRightKey();
		
		double[] multiplier = currentScreen.getMultiplier();
		
		for (Screen s : screens) {
			s.setVolume(volume);
			s.setSpecificHero(specificHero);
			s.setDifficulty(difficulty);
			s.setStat(stat);
			s.setSound(isSoundOn);
			s.setDisplayShop(isShop);
			s.setUpKey(upKey);
			s.setDownKey(downKey);
			s.setLeftKey(leftKey);
			s.setRightKey(rightKey);
			s.setMultiplier(multiplier);
		}
	}
	
	/**
	 * Restarts the program, basically
	 */
	public void reset() {
		background(255);
		
		screens = new Screen[] {new StartScreen(this), new ChooseHero(this), new Credits(this), new ChooseDifficulty(this), 
				new Rules(this), new Settings(this), new DeathMenu(this), new Shop(this), new Pause(this), 
				new GameScreen(this), new ConfirmQuit(this), new VictoryScreen(this)};
		
		for (Screen s : screens) {
			s.setup();
		}
		
		currentScreen = screens[0];
		
		audio = new SoundFile(this, "files/audio/smash.wav");
	}
}