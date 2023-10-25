package com.example.strategies;

import com.example.payStrategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author diviner16
 * @date 2023年10月08日 9:01
 */
public class PayByCreditCard implements PayStrategy {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("paying " + paymentAmount + "useing creditcard");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {

        try {
            System.out.println(" enter the card number:");
            String number = READER.readLine();
            System.out.println(" enter the card expiration date 'mm/yy' :");
            String date = READER.readLine();
            System.out.println(" enter the card cvv code :");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
            // validate the card number

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
