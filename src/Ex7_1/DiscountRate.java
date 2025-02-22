package Ex7_1;
public class DiscountRate {
    public static final double serviceDiscountPremium = 0.20;
    public static final double serviceDiscountGold = 0.15;
    public static final double serviceDiscountSilver = 0.10;
    public static final double productDiscountPremium = 0.10;
    public static final double productDiscountGold = 0.10;
    public static final double productDiscountSilver = 0.10;

    public static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0.0; // No discount for non-members
        }
    }
    public static double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
            case "Gold":
            case "Silver":
                return productDiscountPremium;
            default:
                return 0.0; // No discount for non-members
        }
    }
}