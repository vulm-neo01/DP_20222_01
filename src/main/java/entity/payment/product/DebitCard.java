package entity.payment.product;

public class DebitCard extends Card {
    public DebitCard(String cardCode, String owner, String issueBank, String validFrom) {
        super(cardCode, owner, issueBank, validFrom);
    }

    public DebitCard(){

    }
}
