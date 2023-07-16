package utils.distance;

import org.example.DistanceCalculator;

public class NormalDistanceCalculator implements DistanceInterface{
    DistanceCalculator distanceCalculator;

    public NormalDistanceCalculator(){
        this.distanceCalculator = new DistanceCalculator();
    }
    @Override
    public int calculateDistance(String address, String province){
        return distanceCalculator.calculateDistance(address, province);
    }
}
