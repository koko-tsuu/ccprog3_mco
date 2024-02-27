/**
 * Registration class to be extended to other classes.
 * Contains values to be stored for registration benefits.
 */
public class Registration {
    private String type;
    private int minimumLevel;
    private int index;
    private int bonusEarnings;
    private int seedCostReduce;
    private int waterBonusLimit;
    private int fertilizerBonusLimit;
    private int registrationFee;

    /**
     * Registration constructor with values to be passed.
     * @param type is a String that labels the farmer type
     * @param minimumLevel is an integer that talks about the minimum level required to register
     * @param bonusEarnings is an integer that determines the additional earnings gained per produce
     * @param seedCostReduce is an integer that determines the discount of the seed cost
     * @param waterBonusLimit is an integer that determines the additional water bonus limit for a crop
     * @param fertilizerBonusLimit is an integer that determines the additional fertilizer bonus limit for a crop
     * @param registrationFee is an integer that determines the registration fee
     */
    public Registration(String type,
                        int index,
                        int minimumLevel,
                        int bonusEarnings,
                        int seedCostReduce,
                        int waterBonusLimit,
                        int fertilizerBonusLimit,
                        int registrationFee) {
        this.type = type;
        this.index = index;
        this.minimumLevel = minimumLevel;
        this.bonusEarnings = bonusEarnings;
        this.seedCostReduce = seedCostReduce;
        this.waterBonusLimit = waterBonusLimit;
        this.fertilizerBonusLimit = fertilizerBonusLimit;
        this.registrationFee = registrationFee;
    }

    /**
     * copyRegistration() is a method that copies the passed registration
     * @param registration is the registration type with all of its values
     */
    public void copyRegistration(Registration registration) {
        this.type = registration.getType();
        this.index = registration.getIndex();
        this.minimumLevel = registration.getMinimumLevel();
        this.bonusEarnings = registration.getBonusEarnings();
        this.seedCostReduce = registration.getSeedCostReduce();
        this.waterBonusLimit = registration.getWaterBonusLimit();
        this.fertilizerBonusLimit = registration.getFertilizerBonusLimit();
        this.registrationFee = getRegistrationFee();
    }

    /**
     * getType() is a method that returns the type
     * @return type is a String that labels the farmer type
     */
    public String getType(){
        return type;
    }

    /**
     * getIndex() is a method that returns the index.
     * @return index is an integer that contains the index of the farmer type.
     */

    public int getIndex(){
        return index;
    }
    /**
     * getMinimumLevel() is a method that returns the value of minimumLevel.
     * @return minimumLevel is an integer is the minimum level of the registration type
     */
    public int getMinimumLevel(){
        return minimumLevel;
    }


    /**
     * getBonusEarnings() is a method that returns the value of bonusEarnings.
     * @return bonusEarnings is an integer that determines the bonus earnings gained per produce
     */
    public int getBonusEarnings(){
        return bonusEarnings;
    }

    /**
     * getSeedCostReduce() is a method that returns the value of seedCostReduce.
     * @return seedCostReduce is an integer that determines the cost reduced for all crops
     */
    public int getSeedCostReduce(){
        return seedCostReduce;
    }


    /**
     * getWaterBonusLimit() is a method that returns the value of waterBonusLimit.
     * @return waterBonusLimit is an integer that determines the water bonus limit of a crop
     */
    public int getWaterBonusLimit(){
        return waterBonusLimit;
    }

    /**
     * getFertilizerBonusLimit() is a method that returns the value of fertilizerBonusLimit.
     * @return fertilizerBonusLimit is an integer that determines the fertilizer bonus limit of a crop
     */
    public int getFertilizerBonusLimit(){
        return fertilizerBonusLimit;
    }

    /**
     * getRegistrationFee() is a method that returns the value of registrationFee.
     * @return registrationFee is an integer that determines the registration fee of a farmer type.
     */
    public int getRegistrationFee(){
        return registrationFee;
    }


    /**
     * toString() is a method overrided to print out the values in the registration class.
     * @param type is the farmer type.
     * @param minimumLevel is the minimum level needed to register.
     * @param bonusEarnings is an integer that determines the bonus earnings gained per produce
     * @param seedCostReduce is an integer that determines the cost reduced for all crops
     * @param waterBonusLimit is an integer that determines the water bonus limit of a crop
     * @param fertilizerBonusLimit is an integer that determines the fertilizer bonus limit of a crop
     * @param registrationFee  is an integer that determines the registration fee of a farmer type.
     * @return String containing the values in the registration class.
     */
    public String toString(String type, int minimumLevel, int bonusEarnings, int seedCostReduce, int waterBonusLimit, int fertilizerBonusLimit, int registrationFee)
    {
        return "Type: " + type + "\nMinimum Level Required: " + minimumLevel + "\nBonus Earnings per Produce: " +
                bonusEarnings + "\nSeed Cost Reduction: -" + seedCostReduce + "\nWater Bonus Limit Increase: " +
                waterBonusLimit + "\nFertilizer Bonus Limit Increase: " + fertilizerBonusLimit + "\nRegistration Fee: "
                + registrationFee;
    }

    /**
     * toString() is a method used to print the description of registering.
     * @param string is used to determine which toString() method to use
     * @return String containing the description of registering.
     */
    public String toString(String string){
        if (string.equals("Register")){
            return "Register to get more bonus benefits and get even more money! Costs money to register though.";
        }
        return "Invalid";
    }
}

