package characters;

import processing.core.PApplet;


public class Hero extends Character {
	
	

	public Hero(String spriteFile, double speed, double atkSpeed, double HP, double range, double damage, int x, int y,
			int w, int h) {
		super(spriteFile, speed, atkSpeed, HP, range, damage, x, y, w, h);
		
	}
	
	public void draw(PApplet marker)
	{
		spawn(marker);
		
		
	}
	
	public void walk(double dirX, double dirY)
	{
		
		super.moveByAmount(dirX, dirY);
		System.out.println(true);
	}


}
