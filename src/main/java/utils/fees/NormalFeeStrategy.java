package utils.fees;

import entity.order.Order;
import utils.distance.DistanceInterface;

public class NormalFeeStrategy extends CalculateFee{
    public NormalFeeStrategy(DistanceInterface distanceCalculator){
        super(distanceCalculator);
    }
    @Override
    public int calculateFee(Order order, String address, String province) {
        return (int) (distanceCalculator.calculateDistance(address, province) * 1.2);
    }
}
