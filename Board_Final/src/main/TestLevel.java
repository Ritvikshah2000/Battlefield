//package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class TestLevel {

	public static Tile[][] tiles = new Tile[Tile.GRIDSIZE][Tile.GRIDSIZE]; //grid
	public static final int TILESIZE = Tile.TILESIZE;

	public TestLevel() {
		populateField();
		barrierRow(0, 0, 30);
		barrierRow(29, 0, 30);
		barrierColumn(0, 0, 30);
		barrierColumn(29, 0, 30);
		barrierRow(10, 10, 20);
		barrierRow(9, 10, 20);
		barrierRow(9, 10, 20);
		//barrierColumn(10, 11, 20);
		addBomb(15, 20, new HealthBomb(15, 20));
		//addBomb(35, 15, new HealthBomb(35,15));
		addReward(25, 15, new Freeze(25, 15));
		addReward(27, 7, new HealthReward(27, 7));
		addReward(17, 27, new HealthReward(17, 27));
		addReward(5, 20, new HealthReward(5, 20));

		for(int i=0;i<10;i++) {
			int x_rand = (int) (Math.random()*(28-2+1)+2);//generates random numbers between 2 and 28
			int y_rand = (int) (Math.random()*(28-2+1)+2);//generates random numbers between 2 and 28

		addReward(x_rand, y_rand, new KeyReward(x_rand,y_rand));
		}


		setEndPoint(28, 1, new EndPoint());


		//barrierColumn();
		// for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length;y++) {
		// 	if(x == 0 || x == 59){
		// 		tiles[x][y] = new Tile(3, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
		// 	}
		// 	else if(y == 0 || y == 59){
		// 		tiles[x][y] = new Tile(2, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
		// 	}else if((x == 15 && y == 15) || (x == 16 && y == 15 )||( x == 15 && y == 16) || (x == 16 && y == 16) ||
		// 	(x == 35 && y == 27) || (x == 35 && y == 28 )||( x == 36 && y == 27) || (x == 36 && y == 28) ||
		// 	(x == 48 && y == 57) || (x == 48 && y == 58 )||( x == 47 && y == 57) || (x == 47 && y == 58) ||
		// 	(x == 15 && y == 24) || (x == 16 && y == 25 )||( x == 15 && y == 24) || (x == 16 && y == 25)){
		// 		tiles[x][y] = new Tile(3, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), true);
		// 	}
		// 	else{
		// 		tiles[x][y] = new Tile(1, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false);
		// 	} //first argument is the id of case
		// }
	}

	public void update(Graphics2D g) {
		for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length;y++) {
			tiles[x][y].update(g);
		}
	}

	public void addBomb(int x, int y, Bomb bomb){
		tiles[x][y] = new Tile<Bomb>(1, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, bomb);
		Main.bombs.add(bomb);
	}

	public void addReward(int x, int y, Reward reward){
		tiles[x][y] = new Tile<Reward>(1, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, reward);
		Main.rewards.add(reward);
	}

	public void barrierRow(int y, int start, int num){
		int length;
		if(start + num > tiles.length){
			 length = tiles.length;
		 }else{
			 length = start + num;
		 }
		for(int x = start; x < length; x++){
			tiles[x][y] = new Tile<Void>(2, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), true, null);
		}
	}
	//redid teh definitions add start to COlumns

	public void barrierColumn(int x, int start, int num){
		int length;
		if(start + num > tiles.length){
			 length = tiles[0].length;
		 }else{
			 length = start + num;
		 }
		for(int y = start; y < length; y++){
			tiles[x][y] = new Tile<Void>(3, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), true, null);
		}
	}

	public void populateField(){
		for(int x = 0; x < tiles.length; x++) for(int y = 0; y < tiles[0].length; y++){
			tiles[x][y] = new Tile<Void>(1, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, null);
		}
	}

	public static void addGrass(int x, int y){
		TestLevel.tiles[x][y] = new Tile<Void>(1, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false, null);
	}

	public void setEndPoint(int x, int y, EndPoint e){
		tiles[x][y] = new Tile<EndPoint>(0, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, e);
	}

}
