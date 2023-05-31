package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class DeliveryInfo {
    //DP: Singteton Trong suốt chương chỉnh thì chỉ có một đối tượng Delivery duy nhất cho 1 tài khoản, một tài khoản có thể chỉnh sủa thoong tin vận chuyển
    // nhưng chỉ có một instance duy nhất để quản lý thông tin này.
    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;

    private static final DeliveryInfo deliveryInfo = new DeliveryInfo();
    private DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

    public static DeliveryInfo getInstance(){
        return deliveryInfo;
    }

    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
