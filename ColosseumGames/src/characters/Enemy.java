package characters;

import characters.Character;
import processing.core.PApplet;

public abstract class Enemy extends Character {
	public Enemy(String spriteFile, double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(spriteFile, speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void behave(Character c, PApplet marker, int enemyType) {
		int vx = 0;
		int vy = 0;
		if(enemyType == 1) {
			this.shoot((int)c.getX(), (int)c.getY(), marker);
			if(c.getX() - this.getX() < 0) {
				vx = -1;
			}
			if(c.getX() - this.getX() > 0) {
				vx = 1;
			}
			if(c.getY() - this.getY() > 0) {
				vy = 1;
			}
			if(c.getY() - this.getY() < 0) {
				vy = -1;
			}
			this.walk(vx, vy);
		}
	}
}
