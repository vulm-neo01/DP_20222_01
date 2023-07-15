package entity.payment;

/**
 * @author
 */
public class CreditCard {
    // SOLID_OCP: Vi phạm OCP do hệ thống khó mở rộng để thêm các hình thức thanh toán khác (vd: Cash, EWallet,...)

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }
}
