/**
 * Distinguished_Farmer class extending to the Registration class.
 */
public class Distinguished_Farmer extends Registration{

    /**
     * Distinguished_Farmer constructor with predetermined values.
     */
    public Distinguished_Farmer() {
        super("Distinguished Farmer", 2, 10, 2, 2, 1, 0, 300);
    }

    /**
     * toString() is a method that prints out the values in Distinguished_Farmer.
     * @return String containing the values in the class
     */
    @Override
    public String toString() {
        return super.toString(super.getType(), super.getMinimumLevel(), super.getBonusEarnings(), super.getSeedCostReduce(), super.getWaterBonusLimit(),
                super.getFertilizerBonusLimit(), super.getRegistrationFee());
    }
}
