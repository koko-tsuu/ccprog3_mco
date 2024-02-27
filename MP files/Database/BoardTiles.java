import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * BoardTiles class is the class holding tiles and counts the tiles depending on the status.
 */
public class BoardTiles {
    private Tile[][] farmingTiles = new Tile[10][5];
    private List<String> scatterRocks;
    private int activeTiles;
    private int inactiveTiles;
    private int witheredTiles;
    private int rockTiles;

    /**
     * fileCheck() is a method that returns true or false depending on the selected String in scatterRocks
     * @param counter is the counter for the list of strings
     * @return boolean that checks if there's a rock on it
     */
    public boolean fileCheck(int counter){
        if (scatterRocks.get(counter).equals("true")) {
            return true;

        }
        else
            return false;
    }

    /**
     * BoardTiles constructor that reads a text file to create a tile board.
     */
    public BoardTiles() {
        String filename = "rocks.txt";
        Path pathToText = Paths.get(filename);
        // get strings from text file
        try {
            scatterRocks = Files.readAllLines(pathToText.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("rocks.txt was not found.");

        }

        // make the tile board
        int counter = 0;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 5; j++) {
                farmingTiles[i][j] = new Tile(fileCheck(counter));
                counter++;
            }
    }

    /**
     * resetBoard() is a method that recreates the same Tile board for subsequent games.
     */
    public void resetBoard(){
        int counter = 0;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 5; j++) {
                farmingTiles[i][j] = new Tile(fileCheck(counter));
                counter++;
            }
    }

    /**
     * checkTiles() is a method that checks the status of all tiles and tallies them up.
     */
    public void checkTiles(){
        activeTiles=0;
        inactiveTiles=0;
        witheredTiles=0;
        rockTiles=0;

        // count for all tiles
        for (int i=0; i<10; i++)
        {
            for (int j=0; j<5; j++)
            {
               if(farmingTiles[i][j].getWither())
                   witheredTiles++;
               else if(farmingTiles[i][j].getCrop().getName().compareTo("null") != 0)
                   activeTiles++;
               else if (farmingTiles[i][j].getRock())
                   rockTiles++;
               else
                   inactiveTiles++;

            }
        }
    }

    /**
     * getInactiveTiles() is a method that returns the number of inactive tiles.
     * @return inactiveTiles is an integer that stores the number of inactive tiles on the board
     */
    public int getInactiveTiles(){
        return inactiveTiles;
    }

    /**
     * getWitheredTiles() is a method that returns the number of withered tiles.
     * @return witheredTiles is an integer that stores the number of withered tiles on the board
     */
    public int getWitheredTiles(){
        return witheredTiles;
    }

    /**
     * getRockTiles() is a method that returns the number of rock tiles.
     * @return rockTiles is an integer that stores the number of rock tiles on the board
     */
    public int getRockTiles(){
        return rockTiles;
    }

    /**
     * getBoard() is a method that returns the tile board.
     * @return farmingTiles is the tile board.
     */

    public Tile[][] getBoard(){
        return farmingTiles;
    }

    /**
     * getTile() is a method that returns the tile of the board.
     * @param i is an integer that describes the row coordinate of the tile
     * @param j is an integer that describes the column coordinate of the tile
     * @return Tile is a tile on the board
     */
    public Tile getTile(int i, int j){
        return farmingTiles[i][j];
    }
}
