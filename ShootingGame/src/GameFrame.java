import java.util.Vector;

public class GameFrame extends MyFrame{
	public void run() {
		     GameWorld.player = new Player(100, 300, 0, 0);
		     addKeyListener(GameWorld.player);
		     GameWorld.stage = 1;
		     GameWorld.score = 0;
         while(true) {
			GameWorld.player.x = 100;
			GameWorld.player.y = 300;
		    GameWorld.PlayerBullets = new Vector<PlayerBullet>();
		    GameWorld.enemies = new Vector<Enemy>();
		    GameWorld.enemies.add(new EnemyBase(100, 50, 1, 0));
		    GameWorld.enterPressed = false;
		    while(true) {
		        clear();
		        drawString("Stage " + GameWorld.stage, 300,50,15);
		        drawString("Score " + GameWorld.score, 300, 80, 15);
		        GameWorld.player.draw(this);
		        GameWorld.player.move();
		        movePlayerBullet();
		        moveEnemies();
		        checkPlayerAndEnemies();
		        checkPlayerBulletsAndEnemies();
		        if(GameWorld.enemies.size() == 0) {
		            setColor(0, 0, 0);
		            drawString("GAME CLEAR!", 100, 200, 40);
		            if(GameWorld.enterPressed) {
		            	GameWorld.stage++;
		                break;
		                }
		            }else if(GameWorld.player.y < 0) {
		                setColor(0, 0, 0);
		                drawString("GAME OVER", 100, 200, 40);
		                if(GameWorld.enterPressed) {
		                	GameWorld.stage = 1;
		                	GameWorld.score = 0;
		                    break;
		                }
		            }
		        sleep(0.03);
		    }
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
					GameWorld.score += e.score;
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
		int i = 0;
		while(i < GameWorld.enemies.size()) {
			Enemy e = GameWorld.enemies.get(i);
			if(e.y > 400) {
				GameWorld.enemies.remove(i);
			}else {
				i++;
			}
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
