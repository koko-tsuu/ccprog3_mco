/**
 * Watering_Can class extending to the Tool class.
 */
public class Watering_Can extends Tool{

    /**
     * Watering_Can constructor with predetermined values.
     */
   public Watering_Can(){
       super(0, 0.5);
   }

    /**
     * Watering() is a method that adds 1 water to a tile.
     * @param tile is a tile on the board
     * @param status is the status of the Player
     * @param overallStats takes note of the number of times the Player has done an action
     * @return String that describes the results
     */
    public String Watering(Tile tile, Status status, OverallStats overallStats){
       // Crop exists on the tile and is not withered
        if ((tile.getCrop().getName().compareTo("null") != 0) && !tile.getWither()) {
            tile.setWater(tile.getWater()+1);
            overallStats.setTimesWatered(overallStats.getTimesWatered()+1);
            return "Watering successful. " + "Gained " + super.getExp() + " exp!" + status.setExp(status.getExp()+super.getExp());
        }

        // Crop is already withered
        else if (tile.getWither())
        {
            return "Crop is already withered.";
        }

        // Other conditions
        else
            return "No plant to water on this tile.";
    }

    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(){
        return super.toString
                ("Watering can allows you to water a tile. Have fun giving your plants a nice bath, water's free!",
                        super.getCost(), super.getExp());
    }
}
