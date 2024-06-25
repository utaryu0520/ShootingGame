
public class CurveEnemy extends Enemy{

	public CurveEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 2 + GameWorld.stage;
		score = 3;
	}
	
	public void move() {
		super.move();
		if(x < GameWorld.player.x) {
			x = x + GameWorld.stage;
		}
		if(x > GameWorld.player.x) {
			x = x - GameWorld.stage;
		}
	}

	public void draw(MyFrame f) {
		f.setColor(128, 0, 0);
		f.fillOval(x, y, 30, 30);
		f.setColor(128, 128, 128);
		f.fillOval(x + 5, y, 20, 30);
	}
}
