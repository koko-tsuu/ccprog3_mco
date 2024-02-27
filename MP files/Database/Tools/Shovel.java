/**
 * Shovel class extending the Tool class.
 * Allows user to remove an existing crop.
 */
public class Shovel extends Tool{

    /**
     * Shovel constructor with predetermined values.
     */
    public Shovel(){
        super(7, 2);
    }

    /**
     * Shoveling() is a method that allows the Player to shovel a crop.
     * @param tile is a tile on the board
     * @param status is the status of the Player
     * @return String that displays the result whether crop was shoveled or not
     */
    public String Shoveling(Tile tile, Status status){

        // Crop is withered and Player has sufficient ObjectCoins
        if (tile.getWither() && status.getObjectCoins()>=super.getCost())
        {
            tile.resetTile(false);
            return "Removed withered crop. " + super.printandUpdateSuccessResults(status);
        }

        // Crop is not withered and Player has sufficient ObjectCoins
        else if ((tile.getCrop().getName().compareTo("null") != 0) && status.getObjectCoins()>=super.getCost())
        {
            tile.resetTile(false);
            return "Removed growing crop. " + super.printandUpdateSuccessResults(status);
        }

        else if((tile.getUnplowed()) && status.getObjectCoins() >= super.getCost()){
            tile.resetTile(false);
            return "Shoveled... dirt? " + super.printandUpdateSuccessResults(status);
        }

        else if((tile.getPlowed()) && status.getObjectCoins() >= super.getCost()){
            tile.resetTile(false);
            return "Shoveled... smoother dirt? The tile has reverted to an unplowed tile. " +
                    super.printandUpdateSuccessResults(status);
        }

        // Player does not have enough ObjectCoins
        else if (status.getObjectCoins() < super.getCost())
            return "Not enough coins.";

        // Other conditions
        else
            return "Invalid";

    }
    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(){
        return super.toString
                ("Shovel allows you to... remove almost literally everything in your path. Except for rocks. This tool can probably make you broke." ,
                        super.getCost(), super.getExp());
    }
}
