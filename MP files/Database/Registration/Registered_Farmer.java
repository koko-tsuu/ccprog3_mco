/**
 * Registered_Farmer class extending to the Registration class.
 */
public class Registered_Farmer extends Registration {
    /**
     * Registered_Farmer constructor with predetermined values.
     */
    public Registered_Farmer() {
        super("Registered Farmer", 1, 5, 1, 1, 0, 0, 200);
    }

    /**
     * toString() is a method that prints out the values in Registered_Farmer.
     * @return String containing the values in the class
     */
    @Override
    public String toString() {
        return super.toString(super.getType(), super.getMinimumLevel(), super.getBonusEarnings(), super.getSeedCostReduce(), super.getWaterBonusLimit(),
                super.getFertilizerBonusLimit(), super.getRegistrationFee());
    }
}
