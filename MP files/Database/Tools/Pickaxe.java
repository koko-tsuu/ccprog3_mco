/**
 * Pickaxe class extending to the Tool class.
 */
public class Pickaxe extends Tool{

    /**
     * Pickaxe constructor with predetermined values.
     */
    public Pickaxe(){
        super(50, 15);
    }

    /**
     * Pickaxing() is a method that allows the Player to remove a rock on a crop.
     * @param tile is a tile on the board
     * @param status is the status of the Player
     * @return String that describes the results
     */
    public String Pickaxing(Tile tile, Status status){

        // Rock is present on the rock and object coins is sufficient
        if (tile.getRock() && status.getObjectCoins() >= super.getCost())
        {
            tile.setRock(false);
            return "Removed rock. " + super.printandUpdateSuccessResults(status);
        }

        // Not enough object coins and rock is present
        else if (status.getObjectCoins() < super.getCost() && tile.getRock())
            return "Not enough coins.";

        // Other conditions
        else
            return "No rock to remove.";
    }

    /**
     * toString() is a method that prints the tool description, cost, and exp gained.
     * @return String that describes the tool
     */
    public String toString(){
        return super.toString("Pickaxe allows you to remove a rock on a tile. Unfortunately, there's only a 0% " +
                "chance of getting a diamond in this game.", super.getCost(), super.getExp());
    }

}
