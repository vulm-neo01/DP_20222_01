package entity.payment.ConcreteStategy;

import entity.payment.context.OrderByEWallet;

import java.util.Map;

public class EWallet extends PaymentStrategy {

    private String walletId;
    private String code;

    @Override
    public Map<String, String> order() {
        return null;
    }

    public EWallet(int amount, String contents, String walletId, String code) {
        super();
        this.walletId = walletId;
        this.code = code;
        payOrderContext = new OrderByEWallet();
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
