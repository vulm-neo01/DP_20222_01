package controller.PaymentMethod;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.payment.CreditCard;
import entity.payment.PaymentCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

public abstract class PaymentMethod {
    protected InterbankInterface interbank;

    protected String getExpirationDate(String date) throws InvalidCardException {
        String[] strs = date.split("/");
        if (strs.length != 2) {
            throw new InvalidCardException();
        }

        String expirationDate = null;
        int month = -1;
        int year = -1;

        try {
            month = Integer.parseInt(strs[0]);
            year = Integer.parseInt(strs[1]);
            if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
                throw new InvalidCardException();
            }
            expirationDate = strs[0] + strs[1];

        } catch (Exception ex) {
            throw new InvalidCardException();
        }

        return expirationDate;
    }
    public abstract Map<String, String> payOrder(int amount, String contents, PaymentCard card);
}
