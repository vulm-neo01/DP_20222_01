package entity.payment;

/**
 * @author
 */
public class CreditCard {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;
    // có data coupling do 2class PaymentController và CreditCard tương tác với nhau thông qua dữ liệu để tính toán phuogw thưc trả tiền
    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
