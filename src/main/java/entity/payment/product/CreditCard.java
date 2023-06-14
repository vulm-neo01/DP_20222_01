package entity.payment.product;

/**
 * @author
 */
public class CreditCard extends Card{

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        super(cardCode, owner, dateExpired, cvvCode);
    }

    public CreditCard(){

    }
}
