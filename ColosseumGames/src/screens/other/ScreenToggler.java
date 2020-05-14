package screens.other;

/**
 * Used to toggle between screens
 * @author Rithvik
 *
 */
public interface ScreenToggler {

	public static final int START_SCREEN = 0, CHOOSE_HERO = 1, CREDITS = 2, CHOOSE_DIFFICULTY = 3, RULES = 4,
			SETTINGS = 5, DEATH_MENU = 6, MERCHANT_MENU = 7, PAUSE_MENU = 8, GAME_SCREEN = 9, QUIT = 10;
	
	/**
	 * Changes the screen to a new screen
	 * @param x the int representation of the new screen
	 */
	public void toggleScreen(int x);
	
}
