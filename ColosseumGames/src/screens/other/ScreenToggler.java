package screens.other;

public interface ScreenToggler {

	public static final int START_SCREEN = 0, CHOOSE_HERO = 1, CREDITS = 2, CHOOSE_DIFFICULTY = 3, RULES = 4,
			SETTINGS = 5, DEATH_MENU = 6, MERCHANT_MENU = 7, PAUSE_MENU = 8, GAME_SCREEN = 9, QUIT = 10;
	
	public void switchScreen(int x);
	
}
