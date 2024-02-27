/**
 * OverallStats class takes note of all times the Player has plowed, planted, watered,
 * fertilized, and harvested in one game session.
 */
public class OverallStats {
    private int timesAllPlowed;
    private int timesAllPlanted;
    private int timesAllWatered;
    private int timesAllFertilized;
    private int timesAllHarvested;

    /**
     * OverallStats constructor for the first game.
     */
    public OverallStats(){
        timesAllPlowed = 0;
        timesAllPlanted = 0;
        timesAllWatered = 0;
        timesAllFertilized = 0;
        timesAllHarvested = 0;
    }

    /**
     * resetOverallStats() resets all stats for the subsequent games.
     */
    public void resetOverallStats(){
        timesAllPlowed = 0;
        timesAllPlanted = 0;
        timesAllWatered = 0;
        timesAllFertilized = 0;
        timesAllHarvested = 0;
    }

    /**
     * getTimesPlowed() is a method that gets the value of how many times the Player has plowed.
     * @return timesAllPlowed is an integer that shows how many times the Player has plowed overall
     */
    public int getTimesPlowed() {
        return timesAllPlowed;
    }

    /**
     * setTimesPlowed() is a method that sets the value of timesAllPlowed.
     * @param timesAllPlowed is an integer that shows how many times the Player has plowed overall
     */
    public void setTimesPlowed(int timesAllPlowed) {
        this.timesAllPlowed = timesAllPlowed;
    }

    /**
     * getTimesFertilized() is a method that gets the value of timesAllFertilized.
     * @return timesAllFertilized is an integer that shows how many times the Player has used a fertilizer overall
     */
    public int getTimesFertilized() {
        return timesAllFertilized;
    }

    /**
     * setTimesFertilized() is a method that sets the value of timesAllFertilized.
     * @param timesAllFertilized is an integer that shows how many times the Player has used a fertilizer overall
     */
    public void setTimesFertilized(int timesAllFertilized) {
        this.timesAllFertilized = timesAllFertilized;
    }

    /**
     * getTimesHarvested() is a method that gets the value of timesAllHarvested.
     * @return timesAllHarvested is an integer that shows how many times the Player has harvested a crop overall
     */
    public int getTimesHarvested() {
        return timesAllHarvested;
    }

    /**
     * setTimesHarvested() is a method that sets the value of timesAllHarvested.
     * @param timesAllHarvested is an integer that shows how many times the Player has harvested a crop overall
     */
    public void setTimesHarvested(int timesAllHarvested) {
        this.timesAllHarvested = timesAllHarvested;
    }

    /**
     * getTimesPlanted() is a method that returns the value of timesAllPlanted.
     * @return timesAllPlanted is an integer that shows how many times the Player has planted overall
     */
    public int getTimesPlanted() {
        return timesAllPlanted;
    }

    /**
     * setTimesPlanted() is a method that sets the value of timesAllPlanted.
     * @param timesAllPlanted is an integer that shows how many times the Player has planted overall
     */
    public void setTimesPlanted(int timesAllPlanted) {
        this.timesAllPlanted = timesAllPlanted;
    }

    /**
     * getTimesWatered() is a method that returns the value of timesAllWatered.
     * @return timesAllWatered is an integer that shows how many times the Player has watered overall
     */

    public int getTimesWatered() {
        return timesAllWatered;
    }

    /**
     * setTimesWatered() is a method that sets the value of timesAllWatered.
     * @param timesAllWatered is an integer that shows how many times the Player has watered overall
     */

    public void setTimesWatered(int timesAllWatered) {
        this.timesAllWatered = timesAllWatered;
    }

    /**
     * toString() is a method that prints the values of the Player's overall stats.
     * @param overallStats is the overall stats of the player
     * @return String prints the values in overallStats
     */
    public String toString(OverallStats overallStats) {
        return "You have... \nPlowed " + overallStats.getTimesPlowed() + " times" + "\nPlanted " + overallStats.getTimesPlanted() + " times"
                + "\nWatered " + overallStats.getTimesWatered() + " times" + "\nFertilized " + overallStats.getTimesFertilized() + " times" +
                "\nHarvested " + overallStats.getTimesHarvested() + " times";
    }
}
