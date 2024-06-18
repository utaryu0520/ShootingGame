
public class EnemyBase extends Enemy{

	public EnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
	}
	
	public void draw(MyFrame f) {
		f.setColor(128, 0, 0);
		f.fillOval(x, y, 32, 32);
		f.setColor(200, 200, 200);
		f.fillOval(x - 16, y + 9, 64, 16);
	}
	
	public void move() {
		super.move();
		if(x > 300)vx = -1;
		if(x < 100)vx = 1;
		if(Math.random() < 0.04) {
<<<<<<< HEAD
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, 2));
		}
		if(Math.random() < 0.04) {
			GameWorld.enemies.add(new RandomEnemy(x, y, 0, 1));
=======
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, 3));
		}
		if(Math.random() < 0.04) {
			GameWorld.enemies.add(new DropEnemy(x, y, 0, 3));
>>>>>>> 練習問題P216
		}
	}
}
