package screens.startScreens;

import java.awt.Rectangle;

import other.DrawingSurface;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PShape;
import screens.other.Screen;

/**
 * Creates a screen that has adjustable settings for sound, volume, and user-dependent keys
 * @author Rithvik
 *
 */
public class Settings extends Screen {

	private DrawingSurface surface;
	
	private PImage background;
	
	private int adjuster;
	
	private boolean isUp, isDown, isLeft, isRight;
	
	private Rectangle soundOn, soundOff, backButton, sliderArea, upKey, downKey, leftKey, rightKey, resetSettings, slider;
	
	public Settings(DrawingSurface surface) {
		super(surface);
		
		adjuster = 400;
		
		this.surface = surface;
	}

	public void setup() {
		background = surface.loadImage("files/images/Arena.png");
		
	}

	public void draw() {
		surface.image(background, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		
		surface.fill(200, 150, 250);
		
		surface.rect(325, 50, 650, 650, 7);
		
		surface.stroke(0);
		
		// divider lines
		surface.line(325, 130, 975, 130);
		surface.line(325, 260, 975, 260);
		surface.line(325, 420, 975, 420);
		
		surface.line(400, 370, 900, 370); // volume line
		surface.line(650, 330, 650, 410); // halfway
		surface.line(525, 330, 525, 410); // first quarter
		surface.line(775, 330, 775, 410); // third quarter
		
		if (adjuster >= 860) {
			adjuster = 860;
		}
		else if (adjuster <= 400) {
			adjuster = 400;
		}
		
		soundOn = new Rectangle(740, 152, 80, 80);
		soundOff = new Rectangle(820, 152, 80, 80);
		backButton = new Rectangle(25, 620, 260, 130);
		sliderArea = new Rectangle(400, 350, 900, 50); // does not have a PShape, not to be confused with slider
		upKey = new Rectangle(610, 515, 80, 80);
		downKey = new Rectangle(610, 605, 80, 80);
		leftKey = new Rectangle(520, 605, 80, 80);
		rightKey = new Rectangle(700, 605, 80, 80);
		resetSettings = new Rectangle(1000, 650, 150, 100);
		
		PShape shape = surface.createShape(PConstants.RECT, 740, 152, 80, 80); // on
		PShape shape2 = surface.createShape(PConstants.RECT, 820, 152, 80, 80); // off
		PShape shape3 = surface.createShape(PConstants.RECT, 25, 620, 260, 130, 20); // back button
		PShape shape4 = surface.createShape(PConstants.RECT, adjuster, 345, 40, 50); // slider (30, 35)
		PShape shape5 = surface.createShape(PConstants.RECT, 610, 515, 80, 80); // up key
		PShape shape6 = surface.createShape(PConstants.RECT, 610, 605, 80, 80); // down key
		PShape shape7 = surface.createShape(PConstants.RECT, 520, 605, 80, 80); // left key
		PShape shape8 = surface.createShape(PConstants.RECT, 700, 605, 80, 80); // right key
		PShape shape9 = surface.createShape(PConstants.RECT, 1000, 650, 150, 100, 20); // reset 
	
		int c1 = surface.color(204, 153, 0);
		int c2 = surface.color(140, 153, 0);
		int c3 = surface.color(255, 0, 0);
		
		shape3.setFill(c1);
		shape4.setFill(100);
		shape5.setFill(255);
		shape6.setFill(255);
		shape7.setFill(255);
		shape8.setFill(255);
		shape9.setFill(c1);
		
		if (getSound()) {
			shape.setFill(230);
			shape2.setFill(100);
		}
		else {
			shape.setFill(100);
			shape2.setFill(230);
		}
		
		if (soundOn.contains(surface.mouseX, surface.mouseY) && !getSound()) {
			shape.setFill(130);
		}
		else if (soundOff.contains(surface.mouseX, surface.mouseY) && getSound()) {
			shape2.setFill(130);
		}
		
		setVolume((int)((adjuster - 400) / 460.0 * 100));
		
		hover(backButton, shape3, c1, c2);
		hover(upKey, shape5, 255, 130);
		hover(downKey, shape6, 255, 130);
		hover(leftKey, shape7, 255, 130);
		hover(rightKey, shape8, 255, 130);
		hover(resetSettings, shape9, c1, c2);
		
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
		
		surface.shape(shape);
		surface.shape(shape2);
		surface.shape(shape3);
		surface.shape(shape4);
		surface.shape(shape5);
		surface.shape(shape6);
		surface.shape(shape7);
		surface.shape(shape8);
		surface.shape(shape9);
		
		surface.fill(0);
		surface.textSize(50);
		
		surface.text("Sound?", 360, 210);
		surface.text("On", 745, 210);
		surface.text("Off", 820, 210);
		surface.text("Volume", 550, 310);
		surface.text("<", 382, 385);
		surface.text(">", 880, 385);
		surface.text("Change Keys", 500, 475);
		
		String keys[] = {getUpKey() + "", getDownKey() + "", getLeftKey() + "", getRightKey() + ""};
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
		
		surface.text(keys[0], 630, 575);
		surface.text(keys[1], 635, 665);
		surface.text(keys[2], 540, 665);
		surface.text(keys[3], 720, 665);
		
		surface.textSize(40);
		surface.text("Reset", 1020, 710);
		
		surface.textSize(60);
		
		surface.text("Back", 90, 705);
		
		surface.textSize(70);
		
		surface.text("Settings", 530, 110);
		
	}

	/**
	 * Resets all changed settings back to default values before player changed them
	 */
	public void resetSettings() {
		adjuster = 400;
		setSpecificHero(HERCULES);
		setSound(false);
		
		setUpKey('W');
		setDownKey('S');
		setLeftKey('A');
		setRightKey('D');
	}
	
	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousedReleased() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged() {
		slider = new Rectangle(adjuster, 345, 40, 50);
			
		if (slider.contains(surface.mouseX, surface.mouseY)) {
			if (surface.mouseX > surface.pmouseX) {
				adjuster += 4;
			}
			else if (surface.mouseX < surface.pmouseX) {
				adjuster -= 4;
			}
		}
	}

	public void mouseClicked() {
		if (soundOn.contains(surface.mouseX, surface.mouseY)) {
			if (!getSound() && getVolume() == 0) 
				adjuster = 450;
			
			setSound(true);
			System.out.println("yes");
		}
		else if (soundOff.contains(surface.mouseX, surface.mouseY)) {
			setSound(false);
			adjuster = 400;
		}
		else if (backButton.contains(surface.mouseX, surface.mouseY)) {
			surface.toggleScreen(DrawingSurface.CHOOSE_HERO);
		}
		else if (sliderArea.contains(surface.mouseX, surface.mouseY)) {
			adjuster = surface.mouseX;
		}
		else if (upKey.contains(surface.mouseX, surface.mouseY)) {
			isUp = true;
		}
		else if (downKey.contains(surface.mouseX, surface.mouseY)) {
			isDown = true;
		}
		else if (leftKey.contains(surface.mouseX, surface.mouseY)) {
			isLeft = true;
		}
		else if (rightKey.contains(surface.mouseX, surface.mouseY)) {
			isRight = true;
		}
		else if (resetSettings.contains(surface.mouseX, surface.mouseY)) {
//			resetSettings();
		}
		else {
			isUp = false;
			isDown = false;
			isLeft = false;
			isRight = false;
		}
		
	}
	
	public void mouseScrolled() {
		
	}

	@Override
	public void keyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased() {
		char keyPressed = (char) surface.keyCode;
		
		if (isUp) { 
			if (keyPressed != getDownKey() && keyPressed != getLeftKey() && keyPressed != getRightKey())
				setUpKey(keyPressed);
			else
				setUpKey('\u22A0');
		}
		else if (isDown) {
			if (keyPressed != getUpKey() && keyPressed != getLeftKey() && keyPressed != getRightKey())
				setDownKey(keyPressed);
			else
				setDownKey('\u22A0');
		}
		else if (isLeft) {
			if (keyPressed != getDownKey() && keyPressed != getUpKey() && keyPressed != getRightKey())
				setLeftKey(keyPressed);
			else
				setLeftKey('\u22A0');
		}
		else if (isRight) {
			if (keyPressed != getDownKey() && keyPressed != getLeftKey() && keyPressed != getUpKey())
				setRightKey(keyPressed);
			else
				setRightKey('\u22A0');
		}
		
	}

}
