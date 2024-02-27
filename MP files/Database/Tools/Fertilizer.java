/**
 * Fertilizer class extending to the Tool class.
 */
public class Fertilizer extends Tool{

    /**
     * Fertilizer constructor with predetermined values.
     */
    public Fertilizer(){
        super(10, 4);
    }

    /**
     * Fertilizing() is a method that allows the user to fertilize a tile.
     * @param tile is a tile on the board
     * @param status is the status of the Player
     * @param overallStats takes note of the number of times the Player has done an action
     * @return String that describes the results
     */
    public String Fertilizing(Tile tile, Status status, OverallStats overallStats){

        // Crop exists on tile and Player has enough coins
        if (!tile.getWither() && (tile.getCrop().getName().compareTo("null") != 0) && status.getObjectCoins() >= super.getCost()) {
            tile.setFertilizer(tile.getFertilizer()+1);
            overallStats.setTimesFertilized(overallStats.getTimesFertilized()+1);
            return "Fertilizing successful. " + super.printandUpdateSuccessResults(status);
        }
        // Crop withered
        else if(tile.getWither())
            return "Plant is currently withered. Cannot fertilize.";

        // Not enough coins
        else if (status.getObjectCoins() < super.getCost())
            return "Not enough coins.";

        // Other conditions
        else
            return "No plant to fertilize on this tile.";
    }
    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(){
        return super.toString("Fertilizer helps nurture the crop. Make sure to not overdo on the fertilizer.",
                    super.getCost(), super.getExp());
    }
}
