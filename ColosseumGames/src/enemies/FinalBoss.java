package enemies;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import characters.Character;
import characters.Enemy;
import other.Bullet;
import processing.core.PApplet;
import processing.core.PImage;
import screens.other.Screen;

/**
 * Creates the hardest and last enemy user has to face
 * 
 * @author ?
 * @version 2.0
 *
 */
public class FinalBoss extends Enemy {
	double angle;
	private ArrayList<Bullet> bullets; 
	private ArrayList<PImage> images;
	private ArrayList<Line2D.Double> lines;
	private ArrayList<Rectangle2D.Double> lava;
	int firstTP = 0;
	double previousHP;
	long previousShotTime = System.currentTimeMillis();
	private int imageNumber;
	private boolean position;

	/**
	 * Creates an Enemy
	 * @param speed how fast the enemy moves
	 * @param atkSpeed how fast the enemy attacks
	 * @param HP how much damage a enemy can take before dying
	 * @param range the distance a enemy can cover with their weapon
	 * @param damage the amount of damage the enemy can do with their weapon
	 * @param x the x position of the enemy
	 * @param y the x position of the enemy
	 * @param w how wide the enemy is
	 * @param h how tall the enemy is
	 */
	public FinalBoss(double speed, double atkSpeed, double HP, double range, double damage, int x,
			int y, int w, int h) {
		super(speed, atkSpeed, HP, range, damage, x, y, w, h);
		// TODO Auto-generated constructor stub
		angle = 0;
		lines = new ArrayList<Line2D.Double>();
		lava = new ArrayList<Rectangle2D.Double>();
		bullets = new ArrayList<Bullet>();

	}

	@Override
	public void setup(PApplet marker) {
		// TODO Auto-generated method stub
		images = new ArrayList<>();
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase2AttackLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase2AttackLeft2.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase2AttackRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase2AttackRight2.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase3AttackBack1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase3AttackBack2.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase3AttackFront1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase3AttackFront2.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase4AttackLeft1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase4AttackLeft2.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase4AttackRight1.png"));
		images.add(marker.loadImage("sprites/Enemies/FinalBoss/Phase4AttackRight2.png"));
		this.setImages(images);

	}

	@Override
	public void behave(Character c, PApplet marker) {
		// TODO Auto-generated method stub
		double playerAngle;
		if(c.getX() - this.getX() > 0) {
			playerAngle = Math.atan((c.getY()-this.getY())/(c.getX() - this.getX()));
		}
		else {
			playerAngle = Math.PI + Math.atan((c.getY()-this.getY())/(c.getX() - this.getX()));
		}
		if(this.getHP() > 7500) {
			marker.noFill();
			marker.strokeWeight(10);
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y));
			
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y);
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y)));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y));
	
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			if(bullets.size() == 0) {
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.4));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.4));
			}
			
			
			
			
			
			angle+= 0.05;
		}
		else if(this.getHP() > 5000) {
			marker.noFill();
			marker.strokeWeight(10);
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y));
			
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y);
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y)));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y));
	
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			if(bullets.size() == 0) {
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.4));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.2));
				
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.2));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.4));
			}
			
			angle+= 0.05;
			this.walk(getDirectionToPlayer(c));
		}
		else if(this.getHP() > 2500) {
			this.walk(9);
			if(firstTP == 0) {
				this.setCoordinates(Screen.SCREEN_WIDTH/4, 100);
				firstTP++;
				previousHP = this.getHP();
			}
			double delay = (10/getAtkSpeed())*1000;
			long nextShotTime = System.currentTimeMillis();

			if(nextShotTime - previousShotTime > delay) {
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.4));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.2));
				
				bullets.add(new Bullet(this.x, this.y, playerAngle));

				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.2));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.4));
				previousShotTime = System.currentTimeMillis();

			}
			marker.pushMatrix();
			marker.fill(255, 0, 0);
			marker.stroke(255, 0, 0);
			marker.rect(80, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250);
			marker.rect(3*Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250);
			
			marker.rect(20 + Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/2 - 20, 150);
			marker.rect(20 + Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT- 340, Screen.SCREEN_WIDTH/2 - 20, 150);
			marker.popMatrix();
			
			lava.add(new Rectangle2D.Double(80, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250));
			lava.add(new Rectangle2D.Double(3*Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250));
			lava.add(new Rectangle2D.Double(20 + Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/2 - 20, 150));
			lava.add(new Rectangle2D.Double(20 + Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT- 340, Screen.SCREEN_WIDTH/2 - 20, 150));
			
			for(int i = 0; i < lava.size(); i++) {
				if(lava.get(i).intersects(c)) {
					c.setHP(c.getHP() - 45);
				}
				lava.remove(i);
			}
			if(previousHP > this.getHP()) {
				previousHP = this.getHP();
				if(this.getX() == Screen.SCREEN_WIDTH/4) {
					if(this.getY() == 100) {
						this.setCoordinates(3*Screen.SCREEN_WIDTH/4, 100);
					}
					else {
						this.setCoordinates(Screen.SCREEN_WIDTH/4, 100);
					}
				}
				else if(this.getX() == 3*Screen.SCREEN_WIDTH/4) {
					if(this.getY() == 100) {
						this.setCoordinates(3*Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT -300);
					}
					else {
						this.setCoordinates(Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT -300);
					}
				}
			}

		}
		else {
			marker.pushMatrix();
			marker.fill(255, 0, 0);
			marker.stroke(255, 0, 0);
			marker.rect(80, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250);
			marker.rect(3*Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250);
			
			marker.rect(20 + Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/2 - 20, 150);
			marker.rect(20 + Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT- 340, Screen.SCREEN_WIDTH/2 - 20, 150);
			marker.popMatrix();
			
			lava.add(new Rectangle2D.Double(80, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250));
			lava.add(new Rectangle2D.Double(3*Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/4 - 60, Screen.SCREEN_HEIGHT-250));
			lava.add(new Rectangle2D.Double(20 + Screen.SCREEN_WIDTH/4, 60, Screen.SCREEN_WIDTH/2 - 20, 150));
			lava.add(new Rectangle2D.Double(20 + Screen.SCREEN_WIDTH/4, Screen.SCREEN_HEIGHT- 340, Screen.SCREEN_WIDTH/2 - 20, 150));
			
			for(int i = 0; i < lava.size(); i++) {
				if(lava.get(i).intersects(c)) {
					c.setHP(c.getHP() - 45);
				}
				lava.remove(i);
			}
			marker.pushMatrix();
			marker.noFill();
			marker.stroke(0);
			marker.strokeWeight(10);
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y));
			
			marker.line((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y);
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y);
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y)));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y)));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + x), (float)(getRange()*Math.sin(angle) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + x), (float)(getRange()*Math.sin(angle + Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + x), (float)(getRange()*Math.sin(angle + Math.PI) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + y), (float)x, (float)y));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + x), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + y), (float)x, (float)y));
			marker.popMatrix();
			angle+= 0.2;
			
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			this.walk(getDirectionToPlayer(c));
			double delay = (3/getAtkSpeed())*1000;
			long nextShotTime = System.currentTimeMillis();

			if(nextShotTime - previousShotTime > delay) {
				
				bullets.add(new Bullet(this.x, this.y, playerAngle + 1.2));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 1.1));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 1));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.9));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.8));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.7));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.6));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.5));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.4));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.2));
				bullets.add(new Bullet(this.x, this.y, playerAngle + 0.1));
				bullets.add(new Bullet(this.x, this.y, playerAngle));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.1));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.2));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.3));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.4));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.5));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.6));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.7));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.8));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 0.9));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 1));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 1.1));
				bullets.add(new Bullet(this.x, this.y, playerAngle - 1.2));
				previousShotTime = System.currentTimeMillis();

			}
			
		}
	}
	public int getDirectionToPlayer(Character c) {
		int direction = super.getDirectionToPlayer(c);
		if(this.x > c.getX()) {
			if(this.y < c.getY()) {
				direction = 8;
			}
			else if(this.y > c.getY() && Math.abs(this.y - c.getY()) > 21) {
				direction = 7;
			}
			
		}
		else if(this.x < c.getX()) {
			if(this.y < c.getY()) {
				direction = 5;
			}
			else if(this.y > c.getY()&& Math.abs(this.y - c.getY()) > 10) {
				direction = 6;
			}
			
		}
		return direction;
	}
	public ArrayList<Bullet> getBullets(){
		return bullets;
	}
	
	
	@Override
	public int getImageNumber() {
		// TODO Auto-generated method stub
		return imageNumber;
	}

	@Override
	public void animateWalk(int dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void animateAttack(int dir) {
		// TODO Auto-generated method stub
		if (dir % 4 == 1)
		{
			if (dir == 1)
			{
				if (position == false)
				{
					imageNumber = 0;
					position = true;
				}
				else
				{
					imageNumber = 0;
					position = false;
				}
			}
				
		}
		if (dir % 4 == 2)
		{
			if (dir == 2)
			{
				if (position == false)
				{
					imageNumber = 1;
					position = true;
				}
				else
				{
					imageNumber = 2;
					position = false;
				}
			}
			if (dir == 6)
			{
				if (position == false)
				{
					imageNumber = 3;
					position = true;
				}
				else
				{
					imageNumber = 4;
					position = false;
				}
			}
				
		}
		if (dir % 4 == 3)
		{
			if (dir == 3)
			{
				if (position == false)
				{
					imageNumber = 5;
					position = true;
				}
				else
				{
					imageNumber = 6;
					position = false;
				}
			}
			if (dir == 7)
			{
				if (position == false)
				{
					imageNumber = 7;
					position = true;
				}
				else
				{
					imageNumber = 8;
					position = false;
				}
			}
				
		}
		if (dir % 4 == 0)
		{
			if (dir == 4)
			{
				if (position == false)
				{
					imageNumber = 9;
					position = true;
				}
				else
				{
					imageNumber = 10;
					position = false;
				}
			}
			if (dir == 8)
			{
				if (position == false)
				{
					imageNumber = 11;
					position = true;
				}
				else
				{
					imageNumber = 12;
					position = false;
				}
			}
				
		}
		
		
	}

	

}
