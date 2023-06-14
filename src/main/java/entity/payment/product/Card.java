package entity.payment.product;

import java.time.LocalDate;

public abstract class Card {
    private String cardCode;
    private String owner;
    private String dateExpired;
    private String issueBank;
    private String validFrom;
    protected int cvvCode;

    public Card(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

    public Card(String cardCode, String owner, String issueBank, String validFrom) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.issueBank = issueBank;
        this.validFrom = validFrom;
    }

    public Card() {

    }
}
