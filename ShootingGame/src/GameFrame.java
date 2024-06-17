import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player = new Player(100, 300, 0, 0);
		addKeyListener(GameWorld.player);
		GameWorld.PlayerBullets = new Vector<PlayerBullet>();
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullet();
			sleep(0.03);
		}
	}

	private void movePlayerBullet() {
		// TODO 自動生成されたメソッド・スタブ
		int i = 0;
		while(i < GameWorld.PlayerBullets.size()) {
			PlayerBullet b = GameWorld.PlayerBullets.get(i);
			b.draw(this);
			b.move();
			if(b.y < 0) {
				GameWorld.PlayerBullets.remove(i);
			} else {
			    i++;
			}
		}
	}
	 
}
