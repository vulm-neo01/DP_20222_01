package utils.fees;

import entity.order.Order;
import utils.distance.DistanceInterface;

public class NewFeeStrategy extends CalculateFee{
    public NewFeeStrategy(DistanceInterface distanceCalculator){
        super(distanceCalculator);
    }
    private int calculateFeeBySizeAndWeight(Order order) {
        return 500;
    }
    @Override
    public int calculateFee(Order order, String address, String province) {
        return distanceCalculator.calculateDistance(address, province) + calculateFeeBySizeAndWeight(order) * 10;
    }
}
