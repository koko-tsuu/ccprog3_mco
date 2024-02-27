/**
 * Tool class is an abstract class to create new tools.
 */
public abstract class Tool {
    private final int cost;
    private final double exp;

    /**
     * Tool constructor. Gets its cost and exp gained per use.
     * @param cost is the cost of the tool per use
     * @param exp is the exp gained from using the tool
     */
    public Tool(int cost, double exp) {
            this.cost = cost;
            this.exp = exp;
        }

    /**
     * getCost() gets the cost of the tool.
     * @return cost is the cost of using the tool
     */
    public int getCost(){
        return cost;
    }

    /**
     * getExp() returns the exp of the tool after use.
     * @return exp is the exp gained from using the tool
     */
    public double getExp(){
        return exp;
    }

    /**
     * printandUpdateSuccessResults updates the coins and exp of the player after using a Tool.
     * @param status is the status of the Player
     * @return String displays the results after updating exp and cost
     */
    public String printandUpdateSuccessResults(Status status){

        status.setObjectCoins(status.getObjectCoins()-cost);
        return "Gained " + exp + " exp! " + status.setExp(status.getExp()+exp) + " Deducted " + cost +
                " coins. You currently have " + status.getObjectCoins() + " coins.";
    }

    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(String string, int cost, double exp){
        return string + "\n\n\nCost per use: " + cost + "\nExp per use: " + exp;
    }
}
