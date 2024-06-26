import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Character implements KeyListener{
	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillRect(x, y + 20, 30, 10);
		f.setColor(200, 200, 200);
		f.fillRect(x + 10, y, 10, 30);
	}
	
	public Player(int x,int y,int vx,int vy) {
		super(x, y, vx, vy);
	}
	
	public void move() {
		super.move();
		if(x < 0) x = 0;
		if(x > 370) x = 370;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			vx = -5;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			vx = 5;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			GameWorld.PlayerBullets.add(new PlayerBullet(x + 10, y -  20, 5, -10));
			GameWorld.PlayerBullets.add(new PlayerBullet(x + 10, y -  20, 0, -10));
			GameWorld.PlayerBullets.add(new PlayerBullet(x + 10, y -  20, -5, -10));
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("Enterキーが押されました");
			GameWorld.enterPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			vx = 0;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			vx = 0;
		}	
	}
}
