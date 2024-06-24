import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		GameWorld.player = new Player(100, 300, 0, 0);
		addKeyListener(GameWorld.player);
		GameWorld.PlayerBullets = new Vector<PlayerBullet>();
		GameWorld.enemies = new Vector<Enemy>();
		GameWorld.enemies.add(new EnemyBase(100, 50, 1, 0));
		while(true) {
			clear();
			GameWorld.player.draw(this);
			GameWorld.player.move();
			movePlayerBullet();
			moveEnemies();
			checkPlayerAndEnemies();
			checkPlayerBulletsAndEnemies();
			sleep(0.03);
		}
	}
	
	public void checkPlayerAndEnemies() {
		for(int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			if(checkHit(GameWorld.player,e)) {
				System.out.println("やられた！");
				GameWorld.player.y = -1000;
			}
		}
	}
	
	public void checkPlayerBulletsAndEnemies() {
		int i = 0;
		while(i < GameWorld.PlayerBullets.size()) {
			PlayerBullet b = GameWorld.PlayerBullets.get(i);
			int j = 0;
			int hits = 0;
			while(j < GameWorld.enemies.size()) {
				Enemy e = GameWorld.enemies.get(j);
				if(checkHit(e,b)) {
				   System.out.println("ヒット！");
				   hits++;
				   e.life--;
			    } 
				if(e.life <= 0){
			    	GameWorld.enemies.remove(j);
			    }else {
			    	j++;           
			    }
		     }
			if(hits > 0) {
				GameWorld.PlayerBullets.remove(i);
			}else {
			i++;
			}
	     }
	}
	
	public boolean checkHit(Character a, Character b) {
		return(Math.abs(a.x - b.x) <= 20 && Math.abs(a.y - b.y) <= 20);
	}

	private void moveEnemies() {
		for(int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
	}

	private void movePlayerBullet() {
		int i = 0;
		while(i < GameWorld.PlayerBullets.size()) {
			PlayerBullet b = GameWorld.PlayerBullets.get(i);
			b.Pdraw(this);
			b.move();
			if(b.y < 0) {
				GameWorld.PlayerBullets.remove(i);
			} else {
			    i++;
			}
		}
	}
	 
}
