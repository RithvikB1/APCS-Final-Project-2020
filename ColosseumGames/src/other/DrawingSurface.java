package other;

import processing.core.*;
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
	 * Creates a DrawingSurface that can have all game components
	 */
	public DrawingSurface() {
		screens = new Screen[] {new StartScreen(this), new ChooseHero(this), new Credits(this), new ChooseDifficulty(this), 
				new Rules(this), new Settings(this), new DeathMenu(this), new MerchantMenu(this), new Pause(this), 
				new GameScreen(this)};
		
		currentScreen = screens[0];
	}
	
	/**
	 * Loads all images, sounds, and sets temporary background color
	 */
	public void setup() {
		background(255);
		
		for (Screen s : screens) {
			s.setup();
		}
		
		audio = new SoundFile(this, "files/audio/smash.wav");
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
			for (Screen s : screens) {
				s.setSound(true);
				s.setVolume(currentScreen.getVolume());
			}
			audio.amp((float)(currentScreen.getVolume() / 100.0));
			
			if (!audio.isPlaying())
				audio.play();
		}
		else if (audio.isPlaying()) {
			for (Screen s : screens) {
				s.setSound(false);
				s.setVolume(currentScreen.getVolume());
			}
			audio.pause();
		}
	}
	
	/**
	 * Changes screen based on how user interacts with game
	 */
	public void toggleScreen(int x) {
		currentScreen = screens[x];
	}
}