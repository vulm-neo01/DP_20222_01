package entity.payment;

import java.util.HashMap;
import java.util.Map;

public class DomesticCard extends PaymentCard{

    // private String cardCode;
    // private String owner;
    private String dateExpired;
    protected int cvvCode;

    public DomesticCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    @Override()
    public Map<String, String> cardInfo() {
        Map<String, String> cartInfoMap = new HashMap<>();
        cartInfoMap.put("cardCode", this.cardCode);
        cartInfoMap.put("owner", this.owner);
        cartInfoMap.put("dateExpired", this.dateExpired);
        cartInfoMap.put("cvvCode", String.valueOf(this.cvvCode));
        return cartInfoMap;
    }
}
