package board;

import hazard.Bomb;
import hazard.HealthBomb;
import hazard.ScoreBomb;
import playgame.Main;
import reward.Freeze;
import reward.HealthReward;
import reward.KeyReward;
import reward.Reward;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class TestLevel {

    public static Tile[][] tiles = new Tile[Tile.GRIDSIZE][Tile.GRIDSIZE]; //grid
    public static final int TILESIZE = Tile.TILESIZE;
    public static ArrayList<Tile> barrierList = new ArrayList<Tile>();

    public TestLevel() {
        //initialise the board and boundaries
        populateField();
        barrierRow(0, 0, 19);
        barrierRow(19, 0, 19);
        barrierColumn(0, 0, 19);
        barrierColumn(19, 0, 19);

        //set up horizontal barriers
        barrierRow(7, 1, 5);
        barrierRow(12, 5, 13);
        barrierRow(7, 13, 17);
        //set up vertical barriers
        barrierColumn(5, 5, 7);
        barrierColumn(5, 12, 17);
        barrierColumn(10, 8, 12);
        barrierColumn(13, 1, 7);
        //populate Rewards
        addReward(3, 4, new KeyReward(3, 4));
        addReward(8, 4, new KeyReward(8, 4));
        addReward(3, 11, new KeyReward(3, 11));
        addReward(11, 15, new KeyReward(11, 15));
        addReward(18, 4, new KeyReward(18, 4));
        //populate Bonus Rewards
        addReward(3, 16, new Freeze(3, 16));
        addReward(15, 4, new HealthReward(15, 4));
        addReward(9, 15, new HealthReward(9, 15));
        //populate Hazards
        addBomb(8, 10, new HealthBomb(8, 10));
        addBomb(15, 15, new HealthBomb(15, 15));
        addBomb(11, 3, new ScoreBomb(11, 3));
        addBomb(17, 11, new ScoreBomb(17, 11));

        setEndPoint(18, 18, new EndPoint());
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

    public void barrierRow(int y, int start, int end){
        for(int x = start; x <= end; x++){
            tiles[x][y] = new Tile<Void>(2, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), true, null);
            barrierList.add(tiles[x][y]);
        }
    }

    public void barrierColumn(int x, int start, int end){
        for(int y = start; y < end; y++){
            tiles[x][y] = new Tile<Void>(3, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), true, null);
            barrierList.add(tiles[x][y]);
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