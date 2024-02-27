/**
 * Legendary_Farmer class extending to the Registration class.
 */
public class Legendary_Farmer extends Registration{
    /**
     * Legendary_Farmer constructor with predetermined values.
     */
    public Legendary_Farmer() {
        super("Legendary Farmer", 3, 15, 4, 3, 2, 1, 400);
    }

    /**
     * toString() is a method that prints out the values in Legendary_Farmer.
     * @return String containing the values in the class
     */
    @Override
    public String toString() {
        return super.toString(super.getType(), super.getMinimumLevel(), super.getBonusEarnings(), super.getSeedCostReduce(), super.getWaterBonusLimit(),
                super.getFertilizerBonusLimit(), super.getRegistrationFee());
    }
}
