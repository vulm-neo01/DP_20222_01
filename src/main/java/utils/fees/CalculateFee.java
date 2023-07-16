package utils.fees;

import entity.order.Order;
import utils.distance.DistanceInterface;

public abstract class CalculateFee {
    protected DistanceInterface distanceCalculator;

    public CalculateFee(DistanceInterface distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }
    public abstract int calculateFee(Order order, String address, String province);
}
