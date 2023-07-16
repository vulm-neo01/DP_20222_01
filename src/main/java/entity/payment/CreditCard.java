package entity.payment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class CreditCard extends PaymentCard {

    // private String cardCode;
    // private String owner;
    private String dateExpired;
    protected int cvvCode;

    public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    @Override()
    public Map<String, String> toTransactionMap() {
        Map<String, String> transactionMap = new HashMap<>();
        transactionMap.put("cardCode", this.cardCode);
        transactionMap.put("owner", this.owner);
        transactionMap.put("dateExpired", this.dateExpired);
        transactionMap.put("cvvCode", String.valueOf(this.cvvCode));
        return transactionMap;
    }

}
