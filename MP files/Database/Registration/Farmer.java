/**
 * Farmer class extending to the Registration class.
 */
public class Farmer extends Registration{
    /**
     * Farmer constructor with predetermined values.
     */
    public Farmer() {
        super("Farmer", 0, 0, 0, 0, 0, 0, 0);
    }

    /**
     * toString() is a method that prints out the values in Farmer.
     * @return String containing the values in the class
     */
    @Override
    public String toString() {
        return super.toString(super.getType(), super.getMinimumLevel(), super.getBonusEarnings(), super.getSeedCostReduce(), super.getWaterBonusLimit(),
                super.getFertilizerBonusLimit(), super.getRegistrationFee());
    }
}
