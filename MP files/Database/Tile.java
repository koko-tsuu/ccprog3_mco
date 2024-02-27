import java.util.concurrent.ThreadLocalRandom;
import java.lang.String;

/**
 * Tile class represents a tile on the board.
 * Tracks the status of the tile, the crop, and how many times it was watered and fertilized.
 */
public class Tile {
    private Crop currentCrop = new Crop();

    private boolean harvest;
    private boolean unplowed;
    private boolean plowed;

    private boolean rock;
    private boolean wither;
    private int days;

    private int water = 0;
    private int fertilizer = 0;

    /**
     * Tile constructor for a new tile.
     * @param rock_stat is a boolean dictating if there's a rock on the tile
     */
    public Tile(boolean rock_stat) {
        harvest = false;
        unplowed = true;
        plowed = false;

        rock = rock_stat;
        wither = false;
        days = -10;
    }

    /**
     * harvestCheck() is a method that updates a tile for each day passes.
     * Tile can either become withered, be ready for harvest, or not updated.
     */
    public String harvestCheck(){
        // crop is withered if water and fertilizer don't meet the crop's water needs and fertilizer needs
        // or if the crop was not harvested on the harvest day
        if(((days == -1) && !wither) || ((days == 0) && ((fertilizer < currentCrop.getFertilizer_Needs()) || (water < currentCrop.getWater_Needs()))) && !wither)
        {
            wither = true;
            harvest = false;
            return "Withered :(";
        }
        // crop is ready to be harvested as it meets the fertilizer and water needs of the crop
        else if (!wither && (days == 0) && (fertilizer >= currentCrop.getFertilizer_Needs()) && (water >= currentCrop.getWater_Needs()))
        {
            harvest = true;
            return "Ready for Harvest!";
        }
        else
            return "";
    }

    /**
     * getWater() is a method that returns the number of times the tile has been watered.
     * @return water is the number of times the tile has been watered
     */
    public int getWater() {return water;}

    /**
     * setWater() is a method that sets the number of times the tile has been watered.
     * @param water is the number of times the tile has been watered
     */
    public void setWater(int water) {this.water=water;}

    /**
     * getFertilizer() is a method that returns the number of times the tile has been fertilized.
     * @return fertilizer is the number of times the tile has been fertilized
     */
    public int getFertilizer() {return fertilizer;}

    /**
     * setFertilizer() is a method that sets the number of times the tile has been fertilized.
     * @param fertilizer is the number of times the tile has been fertilized
     */
    public void setFertilizer(int fertilizer){this.fertilizer=fertilizer;}

    /**
     * getDays() is a method that returns the number of days left for the crop to grow.
     * @return days is the number of days of the crop
     */
    public int getDays()
    {
        return days;
    }

    /**
     * setDays() is a method that sets the number of days for the crop to grow.
     * @param days is the number of days of the crop
     */
    public void setDays(int days)
    {
        this.days = days;
    }

    /**
     * getCrop() is a method that returns the crop of the tile.
     * @return currentCrop is the current crop of the tile.
     */
    public Crop getCrop()
    {
        return currentCrop;
    }

    /**
     * getWither() is a method that returns true or false to check if the crop has been withered
     * @return boolean that determines if the crop has already been withered
     */
    public boolean getWither(){
        return wither;
    }

    /**
     * getRock() is a method that returns true or false to check if the rock is present on the tile
     * @return boolean that determines if the tile has a rock on it
     */
    public boolean getRock(){
        return rock;
    }

    /**
     * getUnplowed() is a method that returns true or false to check if the tile is unplowed
     * @return boolean that determines if the tile is unplowed
     */
    public boolean getUnplowed(){
        return unplowed;
    }

    /**
     * getPlowed() is a method that returns true or false to check if the tile is plowed
     * @return boolean that determines if the tile is plowed
     */
    public boolean getPlowed(){
        return plowed;
    }

    /**
     * setUnplowedtoPlowed() is a method that sets the tile to plowed.
     */
    public void setUnplowedToPlowed(){
        unplowed = false;
        plowed = true;
    }

    /**
     * getHarvest() is a method that checks if the crop is ready to harvest
     * @return boolean that determines if the crop is ready to harvest
     */
    public boolean getHarvest(){
        return harvest;
    }

    /**
     * setRock() is a method that sets a value to rock to determine if the tile has a rock
     * @param rock is a boolean that determines if the tile has a rock
     */
    public void setRock(boolean rock){
        this.rock = rock;
    }

    /**
     * resetTile() is a method that resets the tile to an unplowed tile.
     * @param rock_stat is a boolean that dictates if the tile has a rock
     */
    public void resetTile(boolean rock_stat)
    {
        currentCrop.resetCrop();
        harvest = false;
        unplowed = true;
        plowed = false;
        water = 0;
        fertilizer = 0;
        rock = rock_stat;
        wither = false;
        days = -10;
    }


    /**
     * Planting() is a method that plants a crop into the tile.
     * @param tile is an array of tiles
     * @param x is an integer that describes the row coordinate of the tile
     * @param y is an integer that describes the column coordinate of the tile
     * @param seed is a Crop to be copied on the tile
     * @param status is the status of the Player
     * @param overallStats takes note of the number of times the Player has done an action
     * @return String that describes the results
     */
    public String Planting(Tile[][] tile, int x, int y, Crop seed, Status status, OverallStats overallStats)
    {
        // if the tile has no crop, plowed, and Player has sufficient object coins
        if (currentCrop.getName().equals("null") && plowed && status.getObjectCoins() >= seed.getSeed_Cost())
        {

            // if the seed type is a fruit tree
            if (seed.getType().compareTo("Fruit tree") == 0){

                // check if all tiles around are empty
                switch(seed.confirmPosition(tile, x, y)){

                    // All tiles are empty
                    case 1:
                        currentCrop.copyCrop(seed);
                        days = currentCrop.getHarvest_Days();
                        overallStats.setTimesPlanted(overallStats.getTimesPlanted() + 1);
                        status.setObjectCoins(status.getObjectCoins() - seed.getSeed_Cost() - status.getRegStatus().getSeedCostReduce());
                        plowed = false;
                        return "Deducted " + (seed.getSeed_Cost() + status.getRegStatus().getSeedCostReduce()) + " coins.\n" +
                                "You currently have " + status.getObjectCoins() + " coins.\n" +
                                "You have planted a " + currentCrop.getName() + "\nSuccessfully planted.";
                    // Occupied tile
                    case 0:
                        return "Selected tile is occupied.";

                    // Crop is planted at the border
                    case -1:
                        return "Planting at the borders is not allowed.";

                    // Occupied tiles
                    case -3:
                        return "The northwest tile is occupied.";
                    case -4:
                        return "The north tile is occupied.";
                    case -5:
                        return "The northeast tile is occupied.";
                    case -6:
                        return "The east tile is occupied.";
                    case -7:
                        return "The southeast tile is occupied.";
                    case -8:
                        return "The south tile is occupied.";
                    case -9:
                        return "The southwest tile is occupied.";
                    case -10:
                        return "The west tile is occupied.";
                    default:
                        return "Error";
                }
            }

            // crop type is not a fruit tree
            else {
                currentCrop.copyCrop(seed);
                days = currentCrop.getHarvest_Days();
                overallStats.setTimesPlanted(overallStats.getTimesPlanted() + 1);
                status.setObjectCoins(status.getObjectCoins() - seed.getSeed_Cost() - status.getRegStatus().getSeedCostReduce());
                plowed = false;
                return "Deducted " + (seed.getSeed_Cost() + status.getRegStatus().getSeedCostReduce()) + " coins.\n" +
                        "You currently have " + status.getObjectCoins() + " coins.\n" +
                        "You have planted a " + currentCrop.getName() + ".";
            }
        }

        // unplowed tile
        else if (unplowed)
            return "Tile is unplowed. Plow it first before planting.";

        // crop is already growing
        else if (!currentCrop.getName().equals("null"))
            return "There's already a crop growing on this tile.";

        // not enough object coins
        else if (status.getObjectCoins() < seed.getSeed_Cost())
            return "Not enough coins.";

        // other conditions
        else
            return "Error";
    }

    /**
     * harvest() is a method that allows the Player to harvest the crop.
     * @param status is the status of the Player
     * @param overallStats takes note of the number of times the Player has done an action
     * @return String that describes the results
     */
     public String harvest(Status status, OverallStats overallStats)
     {
         int randomNumber;
         double harvestTotal;
         double waterBonus;
         double fertilizerBonus;
         double finalHarvestPrice;
         int timesWaterCrop;
         int timesFertilizeCrop;

         // RNG number for produces harvested
         if (currentCrop.getMinimum_Products() != currentCrop.getMax_Products())
            randomNumber = ThreadLocalRandom.current().nextInt(currentCrop.getMinimum_Products(), currentCrop.getMax_Products()+1);

         // minimum product and maximum product are the same values
         else
            randomNumber = currentCrop.getMinimum_Products();

         // if ready to harvest
         if (harvest)
         {
             // if water exceeds the sum of water needs and bonus limit
             if(water > currentCrop.getWater_Needs() + currentCrop.getWater_Bonus() + status.getRegStatus().getWaterBonusLimit())
                 timesWaterCrop = currentCrop.getWater_Needs() + currentCrop.getWater_Bonus() + status.getRegStatus().getWaterBonusLimit();

             // if water doesn't exceed the bonus limit
             else
                 timesWaterCrop = water;

             // if fertilizer exceeds the sum of fertilizer needs and bonus limit
             if(fertilizer > currentCrop.getFertilizer_Needs() + currentCrop.getFertilizer_Bonus() + status.getRegStatus().getFertilizerBonusLimit())
                 timesFertilizeCrop = currentCrop.getFertilizer_Needs() + currentCrop.getFertilizer_Bonus() + status.getRegStatus().getFertilizerBonusLimit();

             // if fertilizer doesn't exceed the bonus limit
             else
                 timesFertilizeCrop = fertilizer;

             // calculations of final harvest price
             harvestTotal = randomNumber * (currentCrop.getBase_Price() + status.getRegStatus().getBonusEarnings());
             waterBonus = harvestTotal * 0.2 * (timesWaterCrop-1);
             fertilizerBonus = harvestTotal * 0.5 * timesFertilizeCrop;
             finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

             // if crop is a flower type
             if ("Flower".equalsIgnoreCase(currentCrop.getType()))
                 finalHarvestPrice = finalHarvestPrice * 1.1;

             // add coins and exp and adjust stats
             status.setObjectCoins(status.getObjectCoins()+finalHarvestPrice);

             overallStats.setTimesHarvested(overallStats.getTimesHarvested() + randomNumber);

             System.out.println();
             System.out.println();


             return "Harvested " + randomNumber + " " + currentCrop.getName() + "(s)! Received " + String.format("%.2f", finalHarvestPrice) + " coins! " +
                     "Gained " + currentCrop.getExp_gain() + " exp! " + status.setExp(status.getExp()+currentCrop.getExp_gain());
         }

         // harvest is false
         else
            return "Failed to harvest.";
     }

    /**
     * toString() is a method that prints out a description depending on the String that's passed
     * @param string is a string to determine which string to return
     * @return String is a description depending on the string being passed
     */
     public String toString(String string) {
         if (string.equals("Plant")) {
             return "Plant a crop. There's a lot of details in those crops, so make sure to read!";
         } else if (string.equals("Harvest")) {
             return "Harvest a crop. Get the fruits of your labour after a hard day.";
         } else if (string.equals("Check a Tile")) {
             if (wither)
                 return currentCrop.getName() + " withered :( Use a shovel to remove the withered crop. " +
                         "You have watered this tile " + water + " time(s) and fertilized the tile " + fertilizer +
                         " times.";
             else if (rock)
                 return "Tile is obstructed by a rock. Rock.";
             else if (!currentCrop.getName().equals("null"))
                 return "Current status of the selected tile: \n" + "Crop: " + currentCrop.getName() + "\nDays before harvest: " +
                         days + "\nYou have watered this tile " + water + " time(s) and fertilized the tile " + fertilizer +
                         " times.";
             else if (plowed)
                 return "Tile is currently plowed. Go plant!";
             else if (unplowed)
                 return "Selected tile is currently unplowed. Make sure to plow the tile first.";
             else if (harvest)
                 return currentCrop.getName() + "is or are ready to harvest! Harvest soon as possible so the crop doesn't wither.";

         } else
             return "Check a tile. Use your amazing psychic ability to know how is the crop or tile is doing. " +
                     "Select a tile on the board, click the OK button, and this box of text will change to reflect " +
                     "of the status of the tile.";

         return "";
     }

}
