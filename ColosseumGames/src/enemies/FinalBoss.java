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
 * @author Richard
 * @version 2.0
 *
 */
public class FinalBoss extends Enemy {
	double angle, delay;
	private ArrayList<Bullet> bullets; 
	private ArrayList<PImage> images;
	private ArrayList<Line2D.Double> lines;
	private ArrayList<Rectangle2D.Double> lava;
	int firstTP = 0;
	double previousHP;
	long previousShotTime = System.currentTimeMillis();
	private int imageNumber;
	private boolean position;
	private int phase;

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

	public void behave(Character c, PApplet marker, Screen s) {
		// TODO Auto-generated method stub
		double playerAngle;
		if(c.getX() - this.getX() > 0) {
			playerAngle = Math.atan((c.getCenterY()-this.getCenterY())/(c.getCenterX() - this.getCenterX()));
		}
		else {
			playerAngle = Math.PI + Math.atan((c.getCenterY()-this.getCenterY())/(c.getCenterX() - this.getCenterX()));
		}
		if(this.getHP() > 7500) {
			marker.noFill();
			phase = 1;
			marker.strokeWeight(10);
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()));
			
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY())));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
	
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			
			
			
			
			angle+= 0.05;
		}
		else if(this.getHP() > 5000 || (this.getHP() <= 7500 && s.getDifficulty() == 1)) {
			phase = 2;
			marker.noFill();
			marker.strokeWeight(10);
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()));
			
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY())));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
	
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			if(bullets.size() == 0) {
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.4));
				//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.3));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.2));
				
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.2));
				//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.3));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.4));
			}
			
			angle+= 0.05;
			animateAttack(getDirectionToPlayer(c));
			this.walk(getDirectionToPlayer(c));
		}
		else if(this.getHP() > 2500) {
			phase = 3;
			this.walk(9);
			animateAttack(getDirectionToPlayer(c));
			if(firstTP == 0) {
				this.setCoordinates(Screen.SCREEN_WIDTH/4, 100);
				firstTP++;
				previousHP = this.getHP();
			}
			double delay = (10/getAtkSpeed())*1000;
			long nextShotTime = System.currentTimeMillis();

			if(nextShotTime - previousShotTime > delay) {
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.4));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.3));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.2));
				
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle));

				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.2));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.3));
				bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.4));
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
			phase = 0;
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
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()));
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()));
			
			marker.line((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			marker.line((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY());
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY())));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY())));
			
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle) + this.getCenterX()), (float)(getRange()*Math.sin(angle) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 2*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 2*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + Math.PI) + this.getCenterX()), (float)(getRange()*Math.sin(angle + Math.PI) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 4*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 4*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			lines.add(new Line2D.Double((float)(getRange()*Math.cos(angle + 5*Math.PI/3) + this.getCenterX()), (float)(getRange()*Math.sin(angle + 5*Math.PI/3) + this.getCenterY()), (float)this.getCenterX(), (float)this.getCenterY()));
			marker.popMatrix();
			angle+= 0.07;
			
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).intersects(c)) {
					c.setHP(c.getHP() - this.getDamage());
				}
				lines.remove(i);
			}
			this.walk(getDirectionToPlayer(c));
			animateAttack(getDirectionToPlayer(c));
			long nextShotTime = System.currentTimeMillis();
			if(s.getDifficulty() == 3) {
				delay = (6/getAtkSpeed())*1000;
			} else {
				delay = (15/getAtkSpeed())*1000;
			}

			if(nextShotTime - previousShotTime > delay) {
				if(s.getDifficulty() == 3) {
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 1.2));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 1.1));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 1));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.9));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.8));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.7));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.6));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.5));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.4));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.3));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.2));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.1));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.1));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.2));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.3));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.4));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.5));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.6));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.7));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.8));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.9));
					//bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 1));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 1.1));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 1.2));
				}
				else {
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle + 0.4));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle));
					bullets.add(new Bullet(this.getCenterX(), this.getCenterY(), playerAngle - 0.4));
				}
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
		if (phase == 1)
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
		if (phase == 2)
		{
			if (dir == 8 || dir == 7)
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
			if (dir == 6 || dir == 5)
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
		if (phase== 3)
		{
			if (dir == 7 || dir == 6)
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
			if (dir == 8 || dir == 5)
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
		if (phase == 0)
		{
			if (dir == 8 || dir == 7)
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
			if (dir == 5 || dir == 6)
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

	@Override
	public void behave(Character c, PApplet marker) {
		// TODO Auto-generated method stub
		
	}

	

}
