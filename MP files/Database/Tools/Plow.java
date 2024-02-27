/**
 * Plow class extending to the Tool class.
 */
public class Plow extends Tool{

    /**
     * Plow constructor with predetermined values.
     */
    public Plow(){
        super(0, 0.5);
    }

    /**
     * Plowing() is a method that allows the Player to plow a tile.
     * @param tile is a tile on the board
     * @param status is the status of the Player
     * @param overallStats takes note of the number of times the Player has done an action
     * @return String that describes the results
     */
    public String Plowing(Tile tile, Status status, OverallStats overallStats)
    {
        // Tile has a rock on it
        if (tile.getRock())
            return "Tile is currently obstructed by a rock. Cannot plow.";

        // Tile has a withered crop
        else if (tile.getWither())
            return "Tile is withered. Cannot plow.";

        // Tile is unplowed
        else if (tile.getUnplowed())
        {
            tile.setUnplowedToPlowed();
            overallStats.setTimesPlowed(overallStats.getTimesPlowed()+1);
            return "Tile has been plowed. " + "Gained " + super.getExp() + " exp! " + status.setExp(status.getExp()+super.getExp());
        }

        // Tile is already plowed
        else if (tile.getPlowed())
           return "Tile has already been plowed.";

        // Tile already has a crop planted
        else if (tile.getCrop().getName().compareTo("null") == 0)
            return "Tile already has a growing crop.";

        // Tile's crop is ready to harvest
        else if (tile.getHarvest())
            return "Tile currently available for harvest.";

        // Other conditions or error
        else
            return "Invalid";
    }

    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(){
        return super.toString("Plow allows you to plow any unplowed tile. Plow away!", super.getCost(), super.getExp());
    }
}
