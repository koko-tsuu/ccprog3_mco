/**
 * Status class that contains the player stats.
 */
public class Status {
    private double exp;
    private int level;
    private int days;
    private Registration regStatus;
    private double objectCoins;

    /**
     * Status constructor with predetermined values for the start of the game.
     */
    public Status(){
        exp = 0;
        level = 0;
        days = 1;
        regStatus = new Farmer();
        objectCoins = 100;

    }

    /**
     * statReset() is a method that resets the Player's status for subsequent games.
     */
    public void statReset() {
        exp = 0;
        level = 0;
        days = 1;
        this.regStatus = new Farmer();
        objectCoins = 100;
    }

    /**
     * setRegistration() is a method that sets the current Farmer type of the Player.
     * @param regis is a registration instance being passed
     * @return String describes the results
     */
    public String setRegistration(Registration regis){

        if (regStatus.getIndex() == regis.getIndex())
            return "Registration failed. You're already registered as a " + regStatus.getType() + ".";

        else if(regStatus.getIndex() > regis.getIndex())
            return "Registration failed. You cannot register to a lower farmer level.";

        // if level meets minimum level and Player has enough object coins to pay for registration
        else if ((regStatus.getIndex() < regis.getIndex()) &&(level >= regis.getMinimumLevel()) && (objectCoins>=regis.getRegistrationFee()))
        {
            regStatus.copyRegistration(regis);
            objectCoins-=regis.getRegistrationFee();
            return "Successfully registered! You are now " + regStatus.getType() + "! "
            + "Deducted " + regis.getRegistrationFee() + ". You currently have " + objectCoins + ".";
        }

        // minimum level not met
        else if (level < regis.getMinimumLevel())
            return "Registration failed. Minimum level not met.";

        // not enough coins
        else if (objectCoins < regis.getRegistrationFee())
            return "Registration failed. Not enough coins.";

        // other conditions
        else
            return "Error";
    }

    /**
     * getExp() is a method that returns the Player's exp.
     * @return exp is a double that represents the Player's current exp
     */
    public double getExp(){
        return exp;
    }

    /**
     * setExp() is a method that sets the Player's exp.
     * @param exp is a double representing experience points
     * @return String that describes the results
     */
    public String setExp(double exp) {
        this.exp = exp;

        // compare level from exp vs current level
        if ((int)(exp / 100) > level) {
            level = (int)exp/100;
            return "Level up! You're now at level " + level + "! You currently have " + exp + " exp. ";
        }
        else
            return "You currently have " + exp + " exp.";
    }

    /**
     * getDays() is a method that returns the current day.
     * @return days is an integer that represents the current day
     */
    public int getDays(){
        return days;
    }

    /**
     * setDays() is a method that sets the day.
     * @param days is an integer that represents the current day
     */
    public void setDays(int days){
        this.days = days;
    }

    /**
     * getRegStatus() is a method that returns the Player's farmer type.
     * @return regStatus is the Player's farmer type
     */
    public Registration getRegStatus() {
        return regStatus;
    }

    /**
     * getObjectCoins() is a method that returns the amount of object coins that the Player has.
     * @return objectCoins is the Player's current amount of object coins.
     */
    public double getObjectCoins() {
        return objectCoins;
    }

    /**
     * setObjectCoins() is a method that sets the amount of object coins that the Player has.
     * @param objectCoins is the Player's current amount of object coins.
     */
    public void setObjectCoins(double objectCoins){
        this.objectCoins = objectCoins;
    }

    /**
     * toString() is a method overrided to print out the values in the status class.
     * @return String that describes the results
     */
    public String toString()
    {
        return "Day " + days + "\n\nPlayer stats:" + "\nObjectCoins: " + String.format("%.2f", objectCoins) +
                "\nExperience: " + String.format("%.2f", exp)
                + "\nLevel: " + level
                + "\n\nRegistration Status: \n" + regStatus;
    }

}
