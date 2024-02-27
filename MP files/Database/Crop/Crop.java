/**
 * Crop class. To be extended by available crops in the game.
 * Also used to store the crop in a tile.
 */
public class Crop {
    private String name;
    private String type;

    private int harvest_Days;
    private int water_Needs;
    private int water_Bonus;
    private int fertilizer_Needs;
    private int fertilizer_Bonus;
    private int minimum_Products;
    private int max_Products;
    private int seed_Cost;
    private int base_Price;
    private double exp_gain;

    /**
     * Crop constructor for a tile without any crop planted.
     */
    public Crop(){
        this.name = "null";
        this.type = "null";
        this.harvest_Days = 0;
        this.water_Needs = 0;
        this.water_Bonus = 0;
        this.fertilizer_Needs = 0;
        this.fertilizer_Bonus = 0;
        this.minimum_Products = 0;
        this.max_Products = 0;
        this.seed_Cost = 0;
        this.base_Price = 0;
        this.exp_gain = 0;
    }

    /**
     * Crop constructor with passing of values.
     * @param name is a String for the crop name
     * @param type is a String for the crop type
     * @param harvest_Days is an integer for the number of days before harvest
     * @param water_Needs is an integer for the number of watering is needed for the crop
     * @param water_Bonus is an integer for the number of bonus watering that can be done
     * @param fertilizer_Needs is an integer for the number of fertilizers needed for the crop
     * @param fertilizer_Bonus is an integer for the number of bonus fertilizing that can be done
     * @param minimum_Products is an integer for the number of minimum products that can be produced
     * @param max_Products is an integer for the number of maximum products that can be produced
     * @param seed_Cost is an integer dictating the seed cost
     * @param base_Price is the base selling price per piece
     * @param exp_gain is the exp gained from harvesting a crop
     */
    public Crop(String name,
                String type,
                int harvest_Days,
                int water_Needs,
                int water_Bonus,
                int fertilizer_Needs,
                int fertilizer_Bonus,
                int minimum_Products,
                int max_Products,
                int seed_Cost,
                int base_Price,
                double exp_gain)
    {
        this.name = name;
        this.type = type;
        this.harvest_Days = harvest_Days;
        this.water_Needs = water_Needs;
        this.water_Bonus = water_Bonus;
        this.fertilizer_Needs = fertilizer_Needs;
        this.fertilizer_Bonus = fertilizer_Bonus;
        this.minimum_Products = minimum_Products;
        this.max_Products = max_Products;
        this.seed_Cost = seed_Cost;
        this.base_Price = base_Price;
        this.exp_gain = exp_gain;
    }

    /**
     * resetCrop() is a method that removes the crop in a tile.
     */
    public void resetCrop(){
        this.name = "null";
        this.type = "null";
        this.harvest_Days = 0;
        this.water_Needs = 0;
        this.water_Bonus = 0;
        this.fertilizer_Needs = 0;
        this.fertilizer_Bonus = 0;
        this.minimum_Products = 0;
        this.max_Products = 0;
        this.seed_Cost = 0;
        this.base_Price = 0;
        this.exp_gain = 0;
    }

    /**
     * copyCrop is used for planting a crop in the Tile class.
     * Copies the attributes of the passed crop
     * @param seed is the chosen seed to be planted on the crop
     */
    public void copyCrop(Crop seed) {
        this.name = seed.getName();
        this.type = seed.getType();
        this.harvest_Days = seed.getHarvest_Days();
        this.water_Needs = seed.getWater_Needs();
        this.water_Bonus = seed.getWater_Bonus();
        this.fertilizer_Needs = seed.getFertilizer_Needs();
        this.fertilizer_Bonus = seed.getFertilizer_Bonus();
        this.minimum_Products = seed.getMinimum_Products();
        this.max_Products = seed.getMax_Products();
        this.seed_Cost = seed.getSeed_Cost();
        this.base_Price = seed.getBase_Price();
        this.exp_gain = seed.getExp_gain();
    }

    /**
     * getName() is a method that returns the name of the crop.
     * @return name is a String that gives the name of the crop
     */
    public String getName(){
        return name;
    }

    /**
     * getType() is a method that returns the crop type.
     * @return type is a String that determines the crop type
     */
    public String getType(){ return type; }

    /**
     * getHarvest_Days() is a method that returns the number of days before the crop can be harvested
     * @return harvest_Days is an integer that determines the number of days before the crop can be harvested
     */
    public int getHarvest_Days(){
        return harvest_Days;
    }

    /**
     * getWater_Needs() is a method that returns the number of water needed for the crop.
     * @return water_Needs is an integer that determines the number of water needed for the crop
     */
    public int getWater_Needs(){
        return water_Needs;
    }

    /**
     * getWater_Bonus() is a method that returns the number of bonus water that a crop can receive
     * @return water_Bonus is an integer that determines the number of bonus water that a crop can receive
     */
    public int getWater_Bonus(){
        return water_Bonus;
    }

    /**
     * getFertilizer_Needs() is a method that returns the number of fertilizer needed for the crop.
     * @return fertilizer_Needs is an integer that determines the number of fertilizer needed for the crop.
     */
    public int getFertilizer_Needs(){
        return fertilizer_Needs;
    }

    /**
     * getFertilizer_Bonus() is a method that returns the number of bonus fertilizer that a crop can receive
     * @return fertilizer_Bonus is an integer that determines the number of bonus fertilizer that a crop can receive
     */
    public int getFertilizer_Bonus(){
        return fertilizer_Bonus;
    }

    /**
     * getMinimum_Products() is a method that returns the minimum number of products a crop can produce.
     * @return minimum_Products is an integer that determines the minimum number of products a crop can produce
     */
    public int getMinimum_Products(){
        return minimum_Products;
    }

    /**
     * getMax_Products() is a method that returns the maximum number of products a crop can produce.
     * @return max_Products is an integer that determines the maximum number of products a crop can produce
     */
    public int getMax_Products(){
        return max_Products;
    }

    /**
     * getSeed_Cost is a method that returns the seed cost.
     * @return seed_Cost is an integer determining the seed cost
     */
    public int getSeed_Cost(){
        return seed_Cost;
    }

    /**
     * getBase_Price() is a method that returns the base selling price per piece
     * @return base_Price is the base selling price per piece
     */
    public int getBase_Price(){
        return base_Price;
    }

    /**
     * getExp_gain() is a method that returns the exp gained from harvesting a crop
     * @return exp_gain is the exp gained from harvesting a crop
     */
    public double getExp_gain()
    {
        return exp_gain;
    }

    /**
     * confirmPosition() is a method that checks if the tiles around the selected tile are not obstructed by anything.
     * @param tile is a tile on the board
     * @param x determines the row
     * @param y determines the column
     * @return int that determines if the selected tile can be planted by a fruit tree
     */
    public int confirmPosition(Tile[][] tile, int x, int y)
    {
        if (x <= 0 || x >= 9 || y <= 0 || y >= 4)
            return -1;
        else {
            // top left
            if((tile[x-1][y-1].getCrop().getName().compareTo("null") != 0) || tile[x-1][y-1].getRock())
                return -3;
            // top
            else if((tile[x-1][y].getCrop().getName().compareTo("null") != 0) || tile[x-1][y].getRock())
                return -4;
            // top right
            else if((tile[x-1][y+1].getCrop().getName().compareTo("null") != 0) || tile[x-1][y+1].getRock())
                return -5;
            // right
            else if((tile[x][y+1].getCrop().getName().compareTo("null") != 0) || tile[x][y+1].getRock())
                return -6;
            // bottom right
            else if((tile[x+1][y+1].getCrop().getName().compareTo("null") != 0) || tile[x+1][y+1].getRock())
                return -7;
            // bottom
            else if ((tile[x+1][y].getCrop().getName().compareTo("null") != 0) || tile[x+1][y].getRock())
                return -8;
            //bottom left
            else if ((tile[x+1][y-1].getCrop().getName().compareTo("null") != 0) || tile[x+1][y-1].getRock())
                return -9;
            // left
            else if ((tile[x][y-1].getCrop().getName().compareTo("null") != 0) || tile[x][y-1].getRock())
                return -10;
            // center
            else if((tile[x][y].getCrop().getName().compareTo("null") != 0) || tile[x][y].getRock())
                return 0;
        }
        return 1;
    }


    /**
     * toString() is a method to print out the values of a Crop class.
     * @param status is status is the status of the Player
     * @return String that describes the results
     */
    public String toString(Status status)
    {
        if(type.compareTo("Fruit tree") == 0)
        {
            return "Note! This is a fruit tree. \n" +
                    "To plant this crop, there \n" +
                    "must be nothing occupied \n" +
                    "around the selected tile. \n" +
                    "You may plant non-fruit tree\n" +
                    "crops around it afterwards." +
                    "\n\nCrop: " + name + "\nHarvest Days: " + harvest_Days + "\nWater Needs: " +
                    water_Needs + "\nWater Bonus: " + water_Bonus + " + " + status.getRegStatus().getWaterBonusLimit()
                    + "\nFertilizer Requirement: " + fertilizer_Needs +
                    "\nFertilizer Bonus: " + fertilizer_Bonus + " + " + status.getRegStatus().getFertilizerBonusLimit() + "\nProducts Produced: " +
                    minimum_Products + "-" + max_Products + "\nSeed Cost: " + seed_Cost + "\nBase Selling Price: " +
                    base_Price + "\nExperience Gain: " + exp_gain;
        }
        else if(type.compareTo("Flower") == 0)
        {
            return "Roses are red,\n" +
                    "Violets are blue,\n" +
                    "If you plant this flower\n"+
                    "You get a 1.1% bonus\n" +
                    "For your hard work\n" +
                    "\n\nCrop: " + name + "\nHarvest Days: " + harvest_Days + "\nWater Needs: " +
                    water_Needs + "\nWater Bonus: " + water_Bonus + " + " + status.getRegStatus().getWaterBonusLimit()
                    + "\nFertilizer Requirement: " + fertilizer_Needs +
                    "\nFertilizer Bonus: " + fertilizer_Bonus + " + " + status.getRegStatus().getFertilizerBonusLimit() + "\nProducts Produced: " +
                    minimum_Products + "-" + max_Products + "\nSeed Cost: " + seed_Cost + "\nBase Selling Price: " +
                    base_Price + "\nExperience Gain: " + exp_gain;
        }

        else
            return "Crop: " + name + "\nHarvest Days: " + harvest_Days + "\nWater Needs: " +
                water_Needs + "\nWater Bonus: " + water_Bonus + " + " + status.getRegStatus().getWaterBonusLimit()
                + "\nFertilizer Requirement: " + fertilizer_Needs +
                 "\nFertilizer Bonus: " + fertilizer_Bonus + " + " + status.getRegStatus().getFertilizerBonusLimit() + "\nProducts Produced: " +
                minimum_Products + "-" + max_Products + "\nSeed Cost: " + seed_Cost + "\nBase Selling Price: " +
                base_Price + "\nExperience Gain: " + exp_gain;
    }


}
