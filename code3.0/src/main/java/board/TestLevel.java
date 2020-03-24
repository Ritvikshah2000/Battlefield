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
    public static int[][] map;
    public static Tile[][] tiles = new Tile[Tile.GRIDSIZE][Tile.GRIDSIZE]; //grid
    public static final int TILESIZE = Tile.TILESIZE;
    public static ArrayList<Tile> barrierList = new ArrayList<Tile>();

    public TestLevel(int mapindex)
    {
        this.map = new Map(mapindex).getMap();

        for (int i=0; i<map.length; i++)
            for (int j=0; j<map[0].length; j++)
            {
                if (map[j][i] == 0) // 0: barrier
                {
                    tiles[i][j] = new Tile<Void>(2, new Rectangle( i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE), true, null);
                    barrierList.add(tiles[i][j]);
                }

                if (map[j][i] == 1) // 1: grass
                    tiles[i][j] = new Tile<Void>(1, new Rectangle( i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE), false, null);

                if (map[j][i] == 2) // 2: key reward
                    addReward(i, j, new KeyReward(i, j));

                if (map[j][i] == 3) // 3: freeze reward
                    addReward(i, j, new Freeze(i, j));

                if (map[j][i] == 4) // 4: health reward
                    addReward(i, j, new HealthReward(i,j));

                if (map[j][i] == 5) // 5: health bomb
                    addBomb(i, j, new HealthBomb(i, j));

                if (map[j][i] == 6) // 6: score bomb
                    addBomb(i, j, new ScoreBomb(i,j));

                if (map[j][i] == 7) // 7: end point
                    setEndPoint(i, j, new EndPoint());
            }
    }

    public static void addGrass(int x, int y){
        TestLevel.tiles[x][y] = new Tile<Void>(1, new Rectangle( x * Tile.TILESIZE, y * Tile.TILESIZE, Tile.TILESIZE, Tile.TILESIZE), false, null);
    }

    public void addBomb(int x, int y, Bomb bomb){
        tiles[x][y] = new Tile<Bomb>(1, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, bomb);
        Main.bombs.add(bomb);
    }

    public void addReward(int x, int y, Reward reward){
        tiles[x][y] = new Tile<Reward>(1, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, reward);
        Main.rewards.add(reward);
    }

    public void setEndPoint(int x, int y, EndPoint e){
        tiles[x][y] = new Tile<EndPoint>(0, new Rectangle( x * TILESIZE, y * TILESIZE, TILESIZE, TILESIZE), false, e);
    }

    public void update(Graphics2D g) {
        for(int x = 0; x < tiles.length; x++)
            for(int y = 0; y < tiles[0].length;y++)
                tiles[x][y].update(g);
    }
}
