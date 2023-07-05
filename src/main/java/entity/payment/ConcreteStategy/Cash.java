package entity.payment.ConcreteStategy;

import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.context.OrderByCash;

import java.util.Hashtable;
import java.util.Map;

public class Cash extends PaymentStrategy {

    private String name;
    private String address;
    private String phoneNumber;

    public Cash(int amount, String contents, String name, String address, String phoneNumber) {
        super();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        payOrderContext = new OrderByCash();
    }

    public Cash(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Map<String, String> order() {
        Map<String, String> result = new Hashtable<String, String>();
        result.put("RESULT", "PAYMENT FAILED!");
        try {
            payOrderContext.payOrder(new Cash(getName(), getAddress(), getAddress()), getAmount(), getContents());

            result.put("RESULT", "PAYMENT SUCCESSFUL!");
            result.put("MESSAGE", "You have successfully paid the order!");
        } catch (PaymentException | UnrecognizedException ex) {
            result.put("MESSAGE", ex.getMessage());
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
