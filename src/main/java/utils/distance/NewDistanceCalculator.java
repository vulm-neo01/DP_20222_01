package utils.distance;

import org.example.AlternativeDistanceCalculator;
import org.example.DistanceCalculator;

public class NewDistanceCalculator implements DistanceInterface {
    AlternativeDistanceCalculator alternativeDistanceCalculator;

    public NewDistanceCalculator() {
        this.alternativeDistanceCalculator = new AlternativeDistanceCalculator();
    }


    @Override
    public int calculateDistance(String address, String province) {
        String fullAddress = address + province;
        return alternativeDistanceCalculator.calculateDistance(fullAddress);
    }
}
